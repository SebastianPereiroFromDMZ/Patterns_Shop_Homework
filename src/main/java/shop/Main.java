package shop;

import jdk.jfr.consumer.RecordedFrame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Goods dairyDepartment = new DairyProducts();
        Goods meet = new Meet();


        System.out.println("Добро пожаловать в наш магазин");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер действия : ");
        printAction();
        int numberOfAction = scanner.nextInt();

        Map<Integer, Products> milk = dairyDepartment.getGoods();
        Map<Integer, Products> meeet = meet.getGoods();

        while (true) {

            switch (numberOfAction) {
                case 1:
                    System.out.println(dairyDepartment.toString((HashMap<Integer, Products>) milk));
                    System.out.println(meet.toString((HashMap<Integer, Products>) (meet).getGoods()));
                    break;
                case 2:
                    System.out.println("Какой отдел вы хотите отфильтровать?\n" +
                            "Отделы:\n" +
                            "1 - Молочный отдел\n" +
                            "2 - Мясной отдел\n" +
                            "3 - Бытовая химия\n");
                    int departmentNumber = scanner.nextInt();
                    if (departmentNumber == 1) {
                        printNumberOfFilter();


                    }

                    milk = dairyDepartment.filter(milk, 50);
                    System.out.println(dairyDepartment.toString((HashMap<Integer, Products>) milk));


                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Спасибо за покупки");
                    System.exit(0);
                default:
                    System.out.println("Вы указали несуществующий номер, попробуйте еще \n");
                    break;
            }
            System.out.println("Введите номер действия : ");
            printAction();
            numberOfAction = scanner.nextInt();
        }


    }


    public static void printAction() {
        System.out.println("\n" +
                "1 - Вывод доступных для покупки товаров\n" +
                "2 - Фильтрация товаров по ключевым словам, ценам, производителям\n" +
                "3 - Составление продуктовой корзины пользователя\n" +
                "4 - Трекинг заказа в системе доставки\n" +
                "5 - Возврат заказа, повтороение заказа\n" +
                "6 - Система рейтинга для товаров\n" +
                "7 - Простая рекомендательная система для покупок \n" +
                "0 - Для выхода из магазина");
    }

    public static void printNumberOfFilter() {
        System.out.println("Как вы хотите отфильтровать товары?\n " +
                "варианты фиитрации:\n " +
                "1 - По цене\n" +
                " 2 - По ключевым словам \n" +
                " 3 - По производителям\n");
    }
}
