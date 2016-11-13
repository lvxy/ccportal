package com.fh.util.mail;

import java.math.BigInteger;

public class test  {

	public static void main(String[] args) {
        //初始
        BigInteger num = new BigInteger("10");
        System.out.println(num);
        num = num.setBit(2);
//        num = num.setBit(1);
//        num = num.setBit(3);
//        num = num.setBit(5);
        System.out.println(num);
        System.out.println(num.testBit(2));
        System.out.println(num.testBit(7));
    }
	
}
