package com.ddot.springbootdemo.learntest.currency.thread.forkjoin.sum;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FindDirFiles extends RecursiveAction {
    private File path;

    public FindDirFiles(File file){
        this.path = file;
    }

    public static void main(String[] args) {
        //用一个forkjoin调度总任务
        ForkJoinPool pool = new ForkJoinPool();

        FindDirFiles task = new FindDirFiles(new File("/"));

        pool.execute(task); //异步方法  不要求返回值
        //同步的话使用invoke()方法
    }

    @Override
    protected void compute(){
        List<FindDirFiles> subTasks = new ArrayList<>();
        File[] files = path.listFiles();
        if (files != null){
            for (File file : files) {
                if(file.isDirectory()){
                    subTasks.add(new FindDirFiles(file));

                }else {
                    //是文件 检查
                    if (file.getAbsolutePath().endsWith("txt")){
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
            if (!subTasks.isEmpty()){
                for (FindDirFiles subTask:invokeAll(subTasks)){
                    subTask.join(); //等待任务执行完成

                }
            }
        }
    }
}
