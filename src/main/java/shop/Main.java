package shop;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        DairyProducts products = new DairyProducts();


        System.out.println("Добро пожаловать в наш магазин");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер действия : ");
        printAction();
        int numberOfAction = scanner.nextInt();

        while (true){

            switch (numberOfAction){
                case 1:

                    System.out.println(products.toString((HashMap<Integer, Products>) products.getProduct()));
                    break;
                case 2:
                    System.out.println();
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


    public static void printAction(){
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
