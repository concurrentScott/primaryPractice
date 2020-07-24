package com.ddot.springbootdemo.learntest.currency.lock.readwritelock;

import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

public class UseSyn implements GoodsService{

    private GoodsInfo goodsInfo;

    public UseSyn(GoodsInfo goodsInfo){
        this.goodsInfo = goodsInfo;
    }

    @Override
    public synchronized GoodsInfo getNum() {
        SleepTools.sm(5);
        return this.goodsInfo;

    }

    @Override
    public void setNum(int num) {
        SleepTools.sm(5);
        goodsInfo.changeNumber(num);

    }
}
