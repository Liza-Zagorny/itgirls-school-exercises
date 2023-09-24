package _main;

import service.Solution;

import java.util.Arrays;
import java.util.LinkedList;

public class Main7 {
    public static void main(String[] args) {
        System.out.println("Exercise 1");
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4, 0, 0, 0, 0, 0};

        Solution solution = new Solution();
        int[] result = solution.removeDuplicates(nums);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.equals(result, expectedNums));

        System.out.println("Exercise 2");
        String brackets1 = "[](){}";
        String brackets2 = "[([)]";
        String brackets3 = "]()";
        System.out.println(solution.checkBracketsSequence(brackets1));

        System.out.println("Exercise 3");
        String sentence = "hello world";
        solution.printCharSequenceCounting(sentence);

        System.out.println("Exercise 4");
        LinkedList<Integer> numsList = new LinkedList<>();
        do {
            numsList.add((int) Math.floor(Math.random() * 100));
        } while (numsList.size() < 6);
        System.out.println(numsList);
        solution.deleteEvenNumbers(numsList);
    }
}