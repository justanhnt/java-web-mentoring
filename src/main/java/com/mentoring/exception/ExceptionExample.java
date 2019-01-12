package com.mentoring.exception;

import java.util.Scanner;
import java.util.logging.Logger;

public class ExceptionExample {

    private static final Logger LOGGER = Logger.getLogger(ExceptionExample.class.getName());

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();

        try {
            calc(inputNumber);
        } catch (BornToBeThrownException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }

        sc.close();

    }

    private static void calc(int i) throws BornToBeThrownException{
        switch (i) {
            case 0x01:
                throw new BornToBeThrownException(i);
            case 0x02:
                throw new BornToBeThrownException(i);
            default:
                System.out.println("WALK THROUGH");
        }
    }
}
