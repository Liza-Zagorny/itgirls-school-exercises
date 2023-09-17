package _main;

import java.util.*;

public class Solution {
    public int[] removeDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer element : nums) {
            if (result.contains(element)) {
                continue;
            } else {
                result.add(element);
            }
        }
        int[] array = result.stream().mapToInt(Integer::intValue).toArray();
        int[] resultArray = new int[nums.length];
        System.arraycopy(array, 0, resultArray, 0, array.length);
        return resultArray;
    }

    public boolean checkBracketsSequence(String brackets) {
        char[] chars = brackets.toCharArray();
        Stack<Character> charsStack = new Stack<>();
        boolean result = true;
        for (char j : chars) {
            if (!result) {
                break;
            }
            if (charsStack.empty()) {
                if (j == '{' || j == '[' || j == '(') {
                    charsStack.push(j);
                } else {
                    result = false;
                    break;
                }
            } else {
                switch (charsStack.peek()) {
                    case '{' -> {
                        if (j != '}') {
                            result = false;
                            break;
                        }
                        charsStack.push(j);
                    }
                    case '[' -> {
                        if (j != ']') {
                            result = false;
                            break;
                        }
                        charsStack.push(j);
                    }
                    case '(' -> {
                        if (j != ')') {
                            result = false;
                            break;
                        }
                        charsStack.push(j);
                    }
                    case ')', '}', ']' -> {
                        if (j == '{' || j == '[' || j == '(') {
                            charsStack.push(j);
                        } else {
                            result = false;
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + charsStack.peek());
                }
            }

        }
        return result;
    }

    public void printCharSequenceCounting(String sentence) {
        char[] chars = sentence.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char j : chars) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                int counting = map.get(j) + 1;
                map.put(j, counting);
            }
        }
        for (Map.Entry<Character, Integer> element : map.entrySet()) {
            System.out.println(element);
        }
    }

    public void deleteEvenNumbers(LinkedList<Integer> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            int item = linkedList.get(i);
            if (item % 2 == 0) {
                linkedList.remove(i);
                i--;
                size--;
            }
        }
        System.out.println("Связаный список без четных чисел:" + linkedList.toString());
    }

    ;
}
