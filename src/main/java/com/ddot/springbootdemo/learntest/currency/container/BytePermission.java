package com.ddot.springbootdemo.learntest.currency.container;

public class BytePermission {
    /**
     * 位运算的角度来完成权限的定义与运算
     */

    public static final int ALLOW_SELECT = 1 << 0;  //0001 1

    public static final int ALLOW_INSERT = 1 << 1;  //0010  2

    public static final int ALLOW_UPDATE = 1 << 0;  //0100   4

    public static final int ALLOW_DELETE = 1 << 0;  //1000   8

    //存储目前用户的权限
    private int flag;

    //设置用户权限
    public void setPer(int per){
        flag = per;
    }

    //增加用户权限
    public void enable(int per){
        flag = flag | per;
    }

    //删除用户的权限
    public void disable(int per){
        flag = flag & per;
    }

    //判定用户权限
    public boolean isAllow(int pre){
        return ( flag & pre) == pre;

    }

    //判定用户没有哪些权限
    public boolean notAllow(int pre){
        return ( flag & pre) == 0;
    }


    public static void main(String[] args) {

        int flag = 15;
        BytePermission permission = new BytePermission();
        permission.setPer(flag);

        permission.disable(ALLOW_DELETE | ALLOW_INSERT);
        System.out.println("select = " + permission.isAllow(ALLOW_SELECT));
        System.out.println("insert = " + permission.isAllow(ALLOW_INSERT));
        System.out.println("update = " + permission.isAllow(ALLOW_UPDATE));
        System.out.println("delete = " + permission.isAllow(ALLOW_DELETE));
    }


}
