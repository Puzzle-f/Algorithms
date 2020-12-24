package sample;

import java.util.Arrays;

public class AlgorithmsJava {
//1.1 Приведите пример алгоритмов и структур данных из жизни.
//    алгоритм: поиск товара в магазине
//    структура данных: раскладка товаров на прилавке магазина

//1.2 Приведите пример алгоритмов и структур данных в программировании.
//    алгоритм: поиск наибольшего значения
//    структура данных: массив, коллекция, базы данных

//    1.3 Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
//    Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.

//    Задание 1.4
//    Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен имитировать простейший поиск перебором.
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
        for (int i=0; i<id.length;i++){
            if(idSearch == id[i]){
                isSearch = true;
                break;
            }
        }
        if(isSearch){
            System.out.println("Товар "+ idSearch + " найден");
        } else System.out.println("Товар "+ idSearch + " не найден");
    }

    }
    public static void main(String[] args) {
        Products product1 = new Products(new int[]{1,2,3});
        product1.getId();
        product1.productSearch(5);
        product1.productSearch(2);
        Products product2 = new Products(new int[]{4,5,6});
        product2.getId();
        product2.productSearch(5);
        product2.productSearch(2);
    }
}
