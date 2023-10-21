package util;

import java.util.ArrayList;
import java.util.Optional;

public class NumbersUtility {

    public boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public int intSquared(int number) {
        return (int) Math.pow(number, 2);
    }

    public Optional<Integer> sumFromList(ArrayList<Integer> list) {
        return list.stream().reduce(Integer::sum);
    }

    public int chooseRandomSpeedMPS ( int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
}
