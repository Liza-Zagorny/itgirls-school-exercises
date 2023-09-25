package _main;

import service.SortingService;
import java.util.Arrays;
import java.util.HashMap;


public class Main8 {
    public static void main(String[] args) {
        SortingService solution = new SortingService();
        // Exercise 1 - Bobble Sort
        System.out.println("Exercise 1 - Bobble Sort");
        HashMap<String, Double> scores = new HashMap<>();
        scores.put("Иванов", 4.5);
        scores.put("Петров", 3.7);
        scores.put("Сидоров", 4.2);
        scores.put("Козлов", 5.0);
        scores.put("Смирнов", 3.9);
        solution.sortByScore(scores);
        // Exercise 2 - Quick Sort
        System.out.println("Exercise 2 - Quick Sort");
        String[] fruits = {"apple", "orange", "grape", "banana"};
        System.out.println("Original array: " + Arrays.toString(fruits));
        solution.sortByAbc(fruits, 0, fruits.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(fruits));
        // Exercise 3 - Merge Sort
        System.out.println("Exercise 3 - Merge Sort");
        String[] objects = {"cat", "orange", "elephant", "bird"};
        System.out.println("Original array: " + Arrays.toString(objects));
        String[] result = solution.mergeSort(objects);
        System.out.println("Sorted array: " + Arrays.toString(result));
        // Exercise 4 - Insertion sort
        // Exercise 5 - Selection Sort
        String[] formulas = {"5+6+32=43", "1+1=2", "(3+5)*4*21=483", "((21-20)*(32-30))/2=1"};
    }
}
