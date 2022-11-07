package krg.petr.otusjava;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long startTime;
        long endTime;
        int testArrayLength = 10000;
        int[] testBubbleArray = new int[testArrayLength];
        int[] testSelectArray = new int[testArrayLength];
        int[] testDefaultArray = new int[testArrayLength];

        for (int i = 0; i < testArrayLength; i++){
            int valueRandom = (int) ((Math.random() * testArrayLength) - (testArrayLength / 2))  ;
            testBubbleArray[i]  = valueRandom;
            testSelectArray[i]  = valueRandom;
            testDefaultArray[i] = valueRandom;
        }

        System.out.println("== Сортировка пузырьком      =============================================================");
        System.out.println("Исходный массив: " + Arrays.toString(testBubbleArray));
        startTime = System.currentTimeMillis();
        SortBubble.sortBubble(testBubbleArray);
        endTime = System.currentTimeMillis();
        System.out.println("Отсортирован: " + Arrays.toString(testBubbleArray));
        System.out.println("Время сортировки: " + (endTime - startTime) + " ms");
        System.out.println("=========================================================================================\n");

        System.out.println("== Сортировка выбором     ===============================================================");
        System.out.println("Исходный массив: " + Arrays.toString(testSelectArray));
        startTime = System.currentTimeMillis();
        SortSelect.sortSelect(testSelectArray);
        endTime = System.currentTimeMillis();
        System.out.println("Отсортирован: " + Arrays.toString(testSelectArray));
        System.out.println("Время сортировки: " + (endTime - startTime) + " ms");
        System.out.println("=========================================================================================\n");

        System.out.println("== Сортировка по умолчанию ==============================================================");
        System.out.println("Исходный массив: " + Arrays.toString(testDefaultArray));
        startTime = System.currentTimeMillis();
        Arrays.sort(testDefaultArray);
        endTime = System.currentTimeMillis();
        System.out.println("Отсортирован: " + Arrays.toString(testDefaultArray));
        System.out.println("Время сортировки: " + (endTime - startTime) + " ms");
        System.out.println("=========================================================================================\n");

    }



}