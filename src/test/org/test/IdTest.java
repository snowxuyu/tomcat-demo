package org.test;

import java.util.Random;

/**
 * date: 2018/10/18 20:21
 * author: snowxuyu
 * describe:
 */
public class IdTest {
    public static void main(String[] args){
        Random random = new Random();
        for (int i=0; i<30; i++) {
            int j = random.nextInt(30);
            System.out.println(j);
        }

    }
}
