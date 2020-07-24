package com.ddot.springbootdemo.learntest.currency.lock.readwritelock;

public class GoodsInfo {
    private final String name;
    private double totalMoney;  //总销售额
    private int storeNum;       //库存数

    public GoodsInfo(String name, double totalMoney, int storeNum) {
        this.name = name;
        this.totalMoney = totalMoney;
        this.storeNum = storeNum;
    }

    public double getTotalMoney() {
        return totalMoney;
    }


    public int getStoreNum() {
        return storeNum;
    }

    public void changeNumber(int sellNumber){
        this.totalMoney += totalMoney * 25;
        this.storeNum -= sellNumber;
    }
}
