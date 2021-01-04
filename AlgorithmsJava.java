package sample;

import java.util.*;
import java.util.Collections;

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
        Products product1 = new Products(new int[]{1,2,3});

//        product1.getId();
        product1.productSearch(5);
        product1.getId();
//        product1.productSearch(2);
        Products product2 = new Products(new int[]{4,5,6});
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

////    Задание 2.2
//        product3.productSearch(12);
//        product3.productSearchBinary(12);
////    Задание 2.3
//        int[] array400Elements = createArray(400);
//        mySort(array400Elements);
////    Задание 2.4
//        mySortBubble(array400Elements);
////    Задание 2.5
//        mySortChoice(array400Elements);
////    Задание 2.6
//        mySortInsert(array400Elements);

        //    Задание 3.1
        ArrayList<Integer> arrayList = new ArrayList<>();
        long timeStart = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        long timeResult = System.nanoTime() - timeStart;
        System.out.println("время добавления элементов в ArrayList " + timeResult + " мс");

        LinkedList<Integer> linkedList = new LinkedList<>();
        long timeStart2 = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            linkedList.add(array[i]);
        }
        long timeResult2 = System.nanoTime() - timeStart2;
        System.out.println("время добавления элементов в linkedList " + timeResult2 + " мс");

        //    Задание 3.2
        long timeStart3 = System.nanoTime();
        arrayList.add(7);
        long timeResult3 = System.nanoTime() - timeStart3;
        System.out.println("время добавления элемента в коллекцию " + timeResult3 + " мс");

        long timeStart4 = System.nanoTime();
        arrayList.remove(7);
        long timeResult4 = System.nanoTime() - timeStart4;
        System.out.println("время удаления элемента из коллекции " + timeResult4 + " мс");

        long timeStart5 = System.nanoTime();
        arrayList.get(5);
        long timeResult5 = System.nanoTime() - timeStart5;
        System.out.println("время получения элемента по индексу " + timeResult5 + " мс");

        //    Задание 3.4
        System.out.println(linkedList);
        linkedList.add(12);
        linkedList.add(2, 43);
        System.out.println(linkedList);
        linkedList.addFirst(12);
        linkedList.remove(5);

        LinkedList<Products> productsLinkedList = new LinkedList<>();
        productsLinkedList.add(product1);
        productsLinkedList.add(product2);
        productsLinkedList.add(product3);

        //    Задание 3.5
ListIterator<Products> iterator1 = productsLinkedList.listIterator();
ListIterator<Products> iterator2 = productsLinkedList.listIterator();

Products products;
    while(iterator1.hasPrevious()){
        products = iterator1.previous();
        System.out.println(products.getId());
    }

    while(iterator2.hasNext()){
        System.out.println(iterator2.next().getId());
    }
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



//    Задание 3.1
//    На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
//    Оцените время выполнения преобразования.
//    Задание 3.2
//    На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
//    Оценить выполненные методы с помощью базового класса System.nanoTime().
//    Задание 3.3
//    Реализуйте простой односвязный список и его базовые методы.
//    Задание 3.4
//    На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
//    Реализуйте список заполненный объектами из вашего класса из задания 1.3
//    Задание 3.5
//    Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
//    Оцените время выполнения операций с помощью базового метода System.nanoTime()






























}
