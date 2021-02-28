package com.reiser;

import java.util.Scanner;

/**
 * @author: reiserx
 * Date:2021/2/28
 * Des:
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
    }
}
