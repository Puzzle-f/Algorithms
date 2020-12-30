package sample;

import java.util.Arrays;
import java.util.Random;

public class AlgorithmsJava {
//1.1 Приведите пример алгоритмов и структур данных из жизни.
//    алгоритм: поиск товара в магазине
//    структура данных: раскладка товаров на прилавке магазина

//1.2 Приведите пример алгоритмов и структур данных в программировании.
//    алгоритм: поиск наибольшего значения
//    структура данных: массив, коллекция, базы данных

//    1.3 Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
//    Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.


    public static class Products {
    private  int[] id;
        public Products(int[] id){
            this.id = id;
        }
    public int[] getId(){
        System.out.println("id " + Arrays.toString(id));
        return id;
    }

    public void productSearch(int idSearch){
             boolean isSearch = false;
        long timeStart = System.nanoTime();
        for (int i=0; i<id.length;i++){
            if(idSearch == id[i]){
                isSearch = true;
                break;
            }
        }
        if(isSearch){
            long timeResult = System.nanoTime() - timeStart;
            System.out.println("Товар "+ idSearch + " найден, время поиска " + timeResult);
        } else  {
            long timeResult = System.nanoTime() - timeStart;
            System.out.println("Товар "+ idSearch + " не найден, время поиска " + timeResult);
        }
    }

    public int productSearchBinary(int idSearch){
            long timeStart = System.nanoTime();
            Arrays.sort(id);
            int firstIndex = 0;
            int lastIndex = id.length - 1;
            int middleIndex;
            while(firstIndex <= lastIndex){
                middleIndex = (firstIndex + lastIndex)/2;
                    if(id[middleIndex] == idSearch){
                        long timeResult = System.nanoTime() - timeStart;
                        System.out.println("Товар найден на позиции: " + middleIndex + " время поиска " + timeResult);
                        System.out.println(Arrays.toString(id));
                        return middleIndex;
                    } else if (id[middleIndex] < idSearch){
                        firstIndex = middleIndex + 1;
                    } else if (id[middleIndex] > idSearch){
                        lastIndex = middleIndex - 1;
                    }
            }
        long timeResult = System.nanoTime() - timeStart;
        System.out.println("товар "+ idSearch + " не найден, время поиска " + timeResult);
        return -1;
    }

    }

    public static void main(String[] args) {
//        Products product1 = new Products(new int[]{1,2,3});
//        product1.getId();
//        product1.productSearch(5);
//        product1.productSearch(2);
//        Products product2 = new Products(new int[]{4,5,6});
//        product2.getId();
//        product2.productSearch(5);
//        product2.productSearch(2);

//            Задание 2.1
        int[] array = createArray(10);
        System.out.println(Arrays.toString(array));
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        boolean isArraysEquals = Arrays.equals(array, arrayCopy);
        System.out.println(isArraysEquals);
        Products product3 = new Products(array);
        mySort(array);

//    Задание 2.2
        product3.productSearch(12);
        product3.productSearchBinary(12);
//    Задание 2.3
        int[] array400Elements = createArray(400);
        mySort(array400Elements);
//    Задание 2.4
        mySortBubble(array400Elements);
//    Задание 2.5
        mySortChoice(array400Elements);
//    Задание 2.6
        mySortInsert(array400Elements);




    }

    public static int[] mySort(int[] array){
        long timeStart = System.nanoTime();
        Arrays.sort(array);
        long timeResult = System.nanoTime() - timeStart;
        System.out.println("время выполнения быстрой сортировки " + timeResult);
        return array;
    }

    public static int[] mySortInsert(int[] array){
        long timeStart = System.nanoTime();
        int index;
        for (int i = 1; i < array.length; i++) {
            int buff = array[i];
            index = i;
            while(index>0 && array[i-1]>=buff){
                array[index] = array[index -1];
                index--;
            }
            array[index] = buff;
        }
        long timeResult = System.nanoTime() - timeStart;
        System.out.println("время выполнения сортировки вставкой " + timeResult);
        return array;
    }

    public static int[] mySortChoice(int[] array){
        long timeStart = System.nanoTime();
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[i]<array[j]){
                    min = j;
                }
            }
            int buff = array[i];
            array[i] = array[min];
            array[min] = buff;
        }
        long timeResult = System.nanoTime() - timeStart;
        System.out.println("время выполнения сортировки выбором " + timeResult);
        return array;
    }

    public static int[] mySortBubble(int[] array){
        long timeStart = System.nanoTime();
        int buff;
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i+1]){
                    sorted = false;
                    buff = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buff;
                }
            }
        }
        long timeResult = System.nanoTime() - timeStart;
        System.out.println("время выполнения сортировки пузырьком " + timeResult);
        return array;
    }

public static int[] createArray(int elements){
    Random rand = new Random();
    int[] array = new  int[elements];
    for (int i = 0; i < array.length; i++) {
        array[i] = rand.nextInt(5);
    }
    return array;
}
//    Задание 2.1
//    На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
//    Выполните обращение к массиву и базовые операции класса Arrays.
//    Оценить выполненные методы с помощью базового класса System.nanoTime().
//    Задание 2.2
//    На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
//    Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(),
//    при необходимости расширьте уже существующий массив данных.
//    Задание 2.3
//    Создайте массив размером 400 элементов.
//    Выполните сортировку с помощью метода sort().
//    Оцените сортировку с помощью базового класса System.nanoTime().
//    Задание 2.4
//    На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
//    Оцените сортировку с помощью базового класса System.nanoTime().
//    Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
//    Задание 2.5
//    На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
//    Оцените сортировку с помощью базового класса System.nanoTime().
//    Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
//    Задание 2.6
//    На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
//    Оцените сортировку с помощью базового класса System.nanoTime().
//    Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.

}
