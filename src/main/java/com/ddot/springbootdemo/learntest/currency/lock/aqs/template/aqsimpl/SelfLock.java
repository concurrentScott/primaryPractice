package com.ddot.springbootdemo.learntest.currency.lock.aqs.template.aqsimpl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现自己的同步锁 reenetreLock
 */
public class SelfLock implements Lock {

    //state 表示获取锁 state=1表示获取 state=0表示当前没有线程拿到
    private static class Sync extends AbstractQueuedSynchronizer{   //同步器

        @Override   //判断当前锁是否独占
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0){   //释放锁时必须为1 若为0 抛出异常
                throw new UnsupportedOperationException();
            }
            setExclusiveOwnerThread(null);
            setState(0);    //只有拿到锁的线程才有释放的的方法 不会有多个线程竞争
            return true;
        }
        Condition newCondition(){
            return new ConditionObject();
        }


    }

    private final Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);

    }

    @Override   //对应tryAcquire
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
         sync.release(1);

    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
