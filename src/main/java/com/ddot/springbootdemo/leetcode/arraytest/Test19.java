package com.ddot.springbootdemo.leetcode.arraytest;


public class Test19 {
    public int singleNumber(int[] nums) {
        int[] bitArray = new int[32];

        for (int num : nums) {

            int bitmark = 1;
            for (int i = 32; i > 1; i--) {
                if ((num & bitmark) == bitmark){
                    bitArray[i]++;
                }
                bitmark = bitmark << 1;
            }

        }

        int res = 0;
        for(int i=0;i<32;i++){//这种做法使得本算法同样适用于负数的情况
            res=res<<1;
            res+=bitArray[i]%3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;




    }

}
