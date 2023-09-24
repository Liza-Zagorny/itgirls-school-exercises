package _main;

import service.SortingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main8 {
    public static void main(String[] args) {
        SortingService solution = new SortingService();
        // Exercise 1 - Bobble Sort
        ArrayList<Map.Entry<String,Double>> a = new ArrayList<>();
        HashMap<String, Double> scores = new HashMap<>();
        scores.put("Иванов", 4.5);
        scores.put("Петров", 3.7);
        scores.put("Сидоров", 4.2);
        scores.put("Козлов", 5.0);
        scores.put("Смирнов", 3.9);
        solution.sortByScore(scores);

        // Exercise 2 - Quick Sort
        String[] fruits = {"apple", "orange", "grape", "banana"};
        // Exercise 3 - Merge Sort
        String[] objects = {"cat", "orange", "elephant", "bird"};
        // Exercise 4 - Insertion sort
        // Exercise 5 - Selection Sort
        String[] formulas = {"5+6+32=43", "1+1=2", "(3+5)*4*21=483", "((21-20)*(32-30))/2=1"};
    }
}
