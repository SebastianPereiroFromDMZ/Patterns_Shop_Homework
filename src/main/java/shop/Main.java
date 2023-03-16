package shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Goods milk = new DairyProducts();
        Goods meet = new Meet();


        System.out.println("Добро пожаловать в наш магазин");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер действия : ");
        printAction();
        int numberOfAction = scanner.nextInt();

        Map<Integer, Products> miiilk = milk.getGoods();

        while (true) {

            switch (numberOfAction) {
                case 1:
                    System.out.println(milk.toString((HashMap<Integer, Products>) miiilk));
                    System.out.println(meet.toString((HashMap<Integer, Products>) (meet).getGoods()));
                    break;
                case 2:
                    milk.filter(miiilk, 20);
                    System.out.println(milk.filter(miiilk, 20));

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
}
