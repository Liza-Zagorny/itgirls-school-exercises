package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingService {
    public void sortByScore(HashMap<String, Double> scores) {
        System.out.println(scores);
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(scores.entrySet());
        System.out.println(list);
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
        System.out.println(list);
    }

    public void sortByAbc(String[] wordsArr, int lowIndex, int highIndex) {
        if (wordsArr.length == 0 || lowIndex >= highIndex) return;
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        String borderWord = wordsArr[middleIndex];
        // 0 + (3-0)/2 ~2
        int i = lowIndex, j = highIndex;
        while (i <= j) {
            while (is1SmallerThan2(wordsArr[i],borderWord)) {
                i++;
            }
            while (!is1SmallerThan2(wordsArr[j],borderWord)) {
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
        int minLength = Math.min(word1.length(), word2.length());

        return true;
    }
}
