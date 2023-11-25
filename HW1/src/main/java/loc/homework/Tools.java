package loc.homework;

import java.util.List;

public class Tools {


    /**
     * Подсчет среднего занчения всех четных чисел в массиве
     *
     * @param numberList
     * @return вернет среднее арифметическое всех четных чисел в массиве, 0.0 если четных нет
     * или null, если если в качестве аргумента пришел null или пустой список
     */
    public static Double getAverageEvenNumbers(List<Integer> numberList) {
        if (numberList==null || numberList.isEmpty())return null;
        return numberList.stream().mapToInt(Integer.class::cast)
                .filter(i -> i % 2 == 0)
                .average().orElse(0);
    }

    /**
     * Вывод массива на печать в виде [E0, E1, E2, ... En] без замыкающего \n
     *
     * @param numberList
     * @param <E>
     */
    public static <E> void printList(List<E> numberList) {
        if (numberList == null || numberList.isEmpty()) {
            System.out.print("[]");
            return;
        }

        System.out.print("[");
        numberList.stream()
                .limit(numberList.size() - 1)
                .forEach(e -> System.out.print(e + ", "));
        numberList.stream()
                .skip(numberList.size() - 1)
                .forEach(e -> System.out.print(e + "]"));
    }

    /**
     * Вывод массива на печать в виде [E0, E1, E2, ... En] с замыкающим \n
     *
     * @param numberList
     * @param <E>
     */
    public static <E> void printlnList(List<E> numberList) {
        printList(numberList);
        System.out.println();
    }
}
