package _main;

import solutions.Solution;
import util.NumbersUtility;

public class Main11 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        //solution.displayExercise1();
        //solution.displayExercise2();
        solution.displayExercise3(16);


//        Thread thread1 = new Thread(() -> {
//            for (int i = 1; i < 11; i++) {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 1; i < 11; i++) {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        thread1.setName("Поток 1");
//        thread1.start();
//        thread2.setName("Поток 2");
//        thread2.start();
//
//        try {
//            thread1.wait(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
