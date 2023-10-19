package solutions;

import util.NumbersUtility;

public class Solution {
    NumbersUtility numbersUtility = new NumbersUtility();

    public void displayExercise1() {

        Thread threadOfOdds = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                if (!numbersUtility.isEvenNumber(i)) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
            }
        });

        Thread threadOfEvens = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                if (numbersUtility.isEvenNumber(i)) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
            }
        });

        threadOfOdds.setName("Thread of odd numbers");
        threadOfEvens.setName("Thread of even numbers");

        threadOfOdds.start();
        threadOfEvens.start();
    }

    public void displayExercise2() {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println("Поток " + Thread.currentThread().getName() + ": число " + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println("Поток " + Thread.currentThread().getName() + ": число " + i);
            }
        });

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
    }

}
