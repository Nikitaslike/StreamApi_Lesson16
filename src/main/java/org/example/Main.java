package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Введіть кількість чисел, скільки ви хочете протестувати: ");
        int count = scanner.nextInt();
        for (int i = count; i > 0; i--) {
            System.out.print("Введіть число: ");
            int number = scanner.nextInt();
            numbers.add(number);
        }
        scanner.close();
        bubbleSort(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + "; ");
        }
        System.out.println("Аналіз: ");
        int sumOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сума парних чисел: " + sumOfEvenNumbers);

        List<Integer> multipliedByTwo = numbers.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        System.out.println("Кожне число, помножене на 2: " + multipliedByTwo);

        int maxNumber = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("Максимальне число: " + maxNumber);

        String oddNumbersAsString = numbers.stream()
                .filter(num -> num % 2 != 0)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Непарні числа: " + oddNumbersAsString);

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
        System.out.println("Середнє арифметичне: " + average);
    }
    public static void bubbleSort(List<Integer> numbers) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }
}