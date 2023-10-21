package solutions;

import util.NumbersUtility;

import java.util.ArrayList;
import java.util.Optional;

public class Solution {
    NumbersUtility numbersUtility = new NumbersUtility();

    private int counter = 0;
    private Optional<String> winnerName = Optional.empty();
    private final ArrayList<Integer> squaredIntegersList = new ArrayList<>();

    private synchronized int incrementAndCalculate() {
        counter = counter + 1;
        return numbersUtility.intSquared(counter);
    }

    private synchronized void addToList(int number, int limit) {
        if (squaredIntegersList.size() < limit)
            squaredIntegersList.add(number);
    }

    private synchronized void setWinnerName(String name) {
        if (winnerName.isEmpty()) {
            winnerName = Optional.ofNullable(name);
        }
    }

    public void displayExercise1() {
        System.out.println("Exercise 1:");
        System.out.println();
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
        System.out.println("Exercise 2:");
        System.out.println();
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

    public void displayExercise3(int N) {
        System.out.println("Exercise 3:");
        System.out.println();
        Thread thread3 = new Thread(() -> {
            while (counter < N) {
                addToList(incrementAndCalculate(), N);
            }
        });
        Thread thread4 = new Thread(() -> {
            while (counter < N) {
                addToList(incrementAndCalculate(), N);
            }
        });
        thread3.start();
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread thread5 = new Thread(() -> {
            System.out.println("List of squared 1-" + N);
            System.out.println(squaredIntegersList);
            Optional<Integer> sum = numbersUtility.sumFromList(squaredIntegersList);
            System.out.println("Сумма квадратов чисел от 1 до " + N + ":");
            sum.ifPresent(System.out::println);
        });
        thread5.start();
    }

    public void displayExercise4(int raceDistance, int minMPS, int maxMPS) {
        System.out.println("Exercise 4:");
        System.out.println();

        Thread car1 = new Thread(() -> {
            int distanceRaced = 0;
            while (distanceRaced < raceDistance) {
                int currentDistance = numbersUtility.chooseRandomSpeedMPS(minMPS, maxMPS);
                System.out.println(Thread.currentThread().getName() + " проехала расстояние " + currentDistance + " метров");
                distanceRaced += currentDistance;
                if (distanceRaced >= raceDistance) {
                    setWinnerName(Thread.currentThread().getName());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " закончила гонку проехав расстояние " + distanceRaced);
        });
        Thread car2 = new Thread(() -> {
            int distanceRaced = 0;
            while (distanceRaced < raceDistance) {
                int currentDistance = numbersUtility.chooseRandomSpeedMPS(minMPS, maxMPS);
                System.out.println(Thread.currentThread().getName() + " проехала расстояние " + currentDistance + " метров");
                distanceRaced += currentDistance;
                if (distanceRaced >= raceDistance) {
                    setWinnerName(Thread.currentThread().getName());

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " закончила гонку проехав расстояние " + distanceRaced);

        });

        car1.setName("Машина №1");
        car2.setName("Машина №2");
        car1.start();
        car2.start();

        try {
            car1.join();
            car2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Победитель: " + winnerName.get());
    }

    public void displayExercise5() {
        System.out.println("Exercise 5:");
        System.out.println();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                    // In order to guarantee that this thread will finish last,
                    // let's generate a random 50% chance to sleep for additional 1000ms.
                    if( numbersUtility.chooseRandomSpeedMPS(1,10) >=5) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.setName("Поток 1");
        thread1.start();
        thread2.setName("Поток 2");
        thread2.start();


    }
}
