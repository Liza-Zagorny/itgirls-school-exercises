package service;

import java.util.*;

public class SortingService {
    public void sortByScore(HashMap<String, Double> scores) {
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(scores.entrySet());
        System.out.println("Original list: " + list);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Map.Entry<String, Double> current = list.get(j);
                Map.Entry<String, Double> next = list.get(j + 1);
                Map.Entry<String, Double> temp;
                if (current.getValue() > next.getValue()) {
                    temp = current;
                    list.set(j, next);
                    list.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted list: " + list);
    }

    public void sortByAbc(String[] wordsArr, int lowIndex, int highIndex) {
        if (wordsArr.length == 0 || lowIndex >= highIndex) return;

        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        String borderWord = wordsArr[middleIndex];
        int i = lowIndex, j = highIndex;
        while (i <= j) {
            while (is1SmallerThan2(wordsArr[i], borderWord)) {
                i++;
            }
            while (!is1SmallerThan2(wordsArr[j], borderWord)) {
                j--;
            }
            if (i <= j) {
                String temp = wordsArr[i];
                wordsArr[i] = wordsArr[j];
                wordsArr[j] = temp;
                i++;
                j--;
            }
        }
        if (lowIndex < j) sortByAbc(wordsArr, lowIndex, j);
    }

    private boolean is1SmallerThan2(String word1, String word2) {
        if (Objects.equals(word1, word2)) return false;
        int minLength = Math.min(word1.length(), word2.length());
        boolean result = false;
        for (int i = 0; i < minLength; i++) {
            if (word1.charAt(i) < word2.charAt(i)) {
                result = true;
                break;
            } else if (word1.charAt(i) > word2.charAt(i)) {
                // result is still false
                break;
            }
        }
        return result;
    }

    public String[] mergeSort (String[] arr) {
        String[] buffer1 = Arrays.copyOf(arr, arr.length);
        String[] buffer2 = new String[arr.length];
        return sortByWordLength(buffer1, buffer2, 0, arr.length);
    }
    public String[] sortByWordLength(String[] buffer1, String[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) return buffer1;

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        String[] subArray1 = sortByWordLength(buffer1, buffer2, startIndex, middleIndex);
        String[] subArray2 = sortByWordLength(buffer1, buffer2, middleIndex, endIndex);

        int i1 = startIndex, i2 = middleIndex, destIndex = startIndex;
        String[] result = ((subArray1 == buffer1) ? buffer2 : buffer1);
        while (i1 < middleIndex && i2 < endIndex) {
            if (subArray1[i1].length() < subArray2[i2].length()) {
                result[destIndex] = subArray1[i1];
                i1++;
            } else {
                result[destIndex] = subArray1[i2];
                i2++;
            }
            destIndex++;
        }
        while (i1 < middleIndex) {
            result[destIndex] = subArray1[i1];
            i1++;
            destIndex++;
        }
        while (i2 < endIndex) {
            result[destIndex] = subArray1[i2];
            i2++;
            destIndex++;
        }
        return result;
    }
}
