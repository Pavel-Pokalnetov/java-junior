package loc.homework;
/* Напишите программу, которая использует Stream API для обработки списка чисел.
 *  Программа должна вывести на экран среднее значение всех четных чисел в списке. */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Генерация массива
        Random rnd = new Random();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) numberList.add(rnd.nextInt(10));
        //Вывод исходного массива
        System.out.print("Исходный массив: ");
        printlnList(numberList);
        //Вывод четных чисел
        System.out.print("Четные числа массива: ");
        printlnList(numberList.stream().filter(i-> i%2==0).collect(Collectors.toList()));
        //Подсчет четных чисел
        System.out.println("Число четных чисел: "+ getCountEvenNumbers(numberList));

    }

    /** Подсчет четных чисел в массиве
     * @param numberList
     * @return
     */
    private static long getCountEvenNumbers(List<Integer> numberList) {
        return numberList.stream().filter(i -> i % 2 == 0).count();
    }

    /** Вывод массива на печать в виде [E0, E1, E2, ... En] без замыкающего \n
     * @param numberList
     * @param <E>
     */
    private static <E> void printList(List<E> numberList){
        System.out.print("[");
        for (int i = 0; i < numberList.size()-1; i++) {
            System.out.print(numberList.get(i)+", ");
        }
        System.out.print(numberList.get(numberList.size()-1)+"]");
    }

    /** Вывод массива на печать в виде [E0, E1, E2, ... En] с замыкающим \n
     * @param numberList
     * @param <E>
     */
    private static <E> void printlnList(List<E> numberList){
        printList(numberList);
        System.out.println();
    }
}