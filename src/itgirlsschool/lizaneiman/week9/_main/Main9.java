package _main;

import entity.Animal;

import java.util.*;
import java.util.stream.Collectors;

public class Main9 {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cow", 1));
        animals.add(new Animal("pig", 2));
        animals.add(new Animal("cat", 3));
        animals.add(new Animal("dog", 4));
        animals.add(new Animal("duck", 5));
        animals.add(new Animal("tiger", 6));
        animals.add(new Animal("zebra", 7));
        animals.add(new Animal("elephant", 8));
        animals.add(new Animal("hippo", 9));
        animals.add(new Animal("horse", 10));

        // 2.Выведите на экран всех животных из коллекции в порядке возрастания их возраста
        System.out.println("Exercise 2:");
        animals.stream()
                .sorted(Comparator.comparingInt(Animal::getAge))
                .forEach(animal -> System.out.println(animal.getName() + ", age " + animal.getAge()));
        System.out.println();
        // 3.Посчитайте сколько животных в коллекции, у которых возраст больше 4
        System.out.println("Exercise 3:");
        long count = animals.stream().filter(animal -> animal.getAge() > 4).count();
        System.out.println("Количество животных, возраст которых больше четырех лет: " + count);
        System.out.println();
        System.out.println("Exercise 4:");
        // 4.Создайте Map из коллекции животных. Ключ - название животного, значение - экземпляр животного.
        // Выведите все пары ключ-значение в консоль
        Map<String, Animal> animalMap = animals.stream()
                .collect(Collectors.toMap(Animal::getName, animal -> animal));
        for (Map.Entry<String, Animal> entry : animalMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
        System.out.println();
        // 5.Выведите названия всех животных одной строкой (используйте reduce())
        System.out.println("Exercise 5:");
        Optional<String> names = animals.stream().map(Animal::getName).reduce((prev, next) -> {
            StringBuilder words = new StringBuilder(prev);
            return String.valueOf(words.append(next));
        });
        System.out.println(names.get());
        System.out.println();
        // 1.Если в коллекции есть лев, то выведите его возраст, если нет - выбросите исключение IllegalArgumentException
        System.out.println("Exercise 1:");
        Optional<Animal> lion = animals.stream().filter(animal -> Objects.equals(animal.getName(), "lion")).findFirst();
        if (lion.isPresent()) {
            System.out.println(lion.get().getAge());
        } else {
            throw new IllegalArgumentException("There is no lion in Animals' list.");
        }
    }
}
