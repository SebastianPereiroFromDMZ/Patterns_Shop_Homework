package shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Goods dairyDepartment = new DairyProducts();
        Goods meatSection = new Meat();
        ShoppingBasket shoppingBasket = new ShoppingBasketImpl();
        OrderSystem orderSystem = new OrderSystem();
        Courier courier = new Courier();


        System.out.println("Добро пожаловать в наш магазин");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер действия : ");
        printAction();
        int numberOfAction = scanner.nextInt();

        Map<Integer, Products> milk = dairyDepartment.getGoods();
        Map<Integer, Products> meat = meatSection.getGoods();
        HashMap<Integer, Products> basket = new HashMap<>();


        while (true) {

            switch (numberOfAction) {
                case 1:
                    System.out.println(dairyDepartment.toString((HashMap<Integer, Products>) milk));
                    System.out.println(meatSection.toString((HashMap<Integer, Products>) meat));
                    break;

                case 2:
                    System.out.println("Какой отдел вы хотите отфильтровать?\n" +
                            "Отделы:\n" +
                            "1 - Молочный отдел\n" +
                            "2 - Мясной отдел\n");
                    int departmentNumber = scanner.nextInt();
                    if (departmentNumber == 1) {
                        printNumberOfFilter();
                        int filter = scanner.nextInt();
                        if (filter == 1) {
                            System.out.println("Укажите максимальную цену для фильтрации");
                            int filterPrice = scanner.nextInt();
                            milk = dairyDepartment.filterPrice(milk, filterPrice);
                            System.out.println("Отсортированный по цене список молочных продуктов: " +
                                    dairyDepartment.toString((HashMap<Integer, Products>) milk));
                            break;
                        } else if (filter == 2) {
                            System.out.println("Укажите какого производиделя вы хотите приобрести молочные продукты");
                            Scanner sc = new Scanner(System.in);
                            String filterManufacturer = sc.nextLine();
                            milk = dairyDepartment.filterManufacturer(milk, filterManufacturer);
                            System.out.println("Отсортированный по производителю список молочных продуктов: " +
                                    dairyDepartment.toString((HashMap<Integer, Products>) milk));
                            break;
                        } else if (filter == 3) {
                            System.out.println("Укажите что именно вы хотите преобрести");
                            Scanner sc = new Scanner(System.in);
                            String filterKeyword = sc.nextLine();
                            milk = dairyDepartment.filterKeyword(milk, filterKeyword);
                            System.out.println("Отсортированный по наименованию список молочных продуктов: " +
                                    dairyDepartment.toString((HashMap<Integer, Products>) milk));
                            break;
                        } else {
                            System.out.println("Неправильный ввод, попробуйте снова\n");
                            continue;
                        }
                    } else if (departmentNumber == 2) {
                        printNumberOfFilter();
                        int filter = scanner.nextInt();
                        if (filter == 1) {
                            System.out.println("Укажите максимальную цену для фильтрации");
                            int filterPrice = scanner.nextInt();
                            meat = meatSection.filterPrice(meat, filterPrice);
                            System.out.println("Отсортированный по цене список мясных продуктов: " +
                                    meatSection.toString((HashMap<Integer, Products>) meat));
                            break;
                        } else if (filter == 2) {
                            System.out.println("Укажите какого производиделя вы хотите приобрести мясные продукты");
                            Scanner sc = new Scanner(System.in);
                            String filterManufacturer = sc.nextLine();
                            meat = meatSection.filterManufacturer(meat, filterManufacturer);
                            System.out.println("Отсортированный по производителю список мясных продуктов: " +
                                    meatSection.toString((HashMap<Integer, Products>) meat));
                            break;
                        } else if (filter == 3) {
                            System.out.println("Укажите что именно вы хотите преобрести");
                            Scanner sc = new Scanner(System.in);
                            String filterKeyword = sc.nextLine();
                            meat = meatSection.filterKeyword(meat, filterKeyword);
                            System.out.println("Отсортированный по наименованию список мясных продуктов: " +
                                    meatSection.toString((HashMap<Integer, Products>) meat));
                            break;
                        } else {
                            System.out.println("Неправильный ввод, попробуйте снова\n");
                            continue;
                        }
                    }
                    break;
                case 3:
                    printShoppingDepartments();
                    int numberDepartments = scanner.nextInt();
                    if (numberDepartments == 1) {
                        System.out.println("Выбирите товары из молочного отдела которые желаете приобрести");
                        int productNumber = scanner.nextInt();
                        System.out.println("Укажите количество этого товара");
                        int count = scanner.nextInt();
                        Map<Integer, Products> selectedProducts;
                        selectedProducts = shoppingBasket.addProduct(milk, productNumber, count);
                        addToBasket(selectedProducts, basket);
                        System.out.println(shoppingBasket.toString(basket));
                        continue;
                    } else if (numberDepartments == 2) {
                        System.out.println("Выбирите товары из мясного отдела которые желаете приобрести");
                        int productNumber = scanner.nextInt();
                        System.out.println("Укажите количество этого товара");
                        int count = scanner.nextInt();
                        Map<Integer, Products> selectedProducts;
                        selectedProducts = shoppingBasket.addProduct(meat, productNumber, count);
                        addToBasket(selectedProducts, basket);
                        System.out.println(shoppingBasket.toString(basket));
                        continue;
                    } else if (numberDepartments == 3) {
                        System.out.println("Выбирите товары которые желаете удалить");
                        int productNumber = scanner.nextInt();
                        basket = (HashMap<Integer, Products>) shoppingBasket.deleteProduct(basket, productNumber);
                        basket = (HashMap<Integer, Products>) sortingBasket(basket);
                        System.out.println(shoppingBasket.toString(basket));
                        continue;
                    } else if (numberDepartments == 0) {
                        System.out.println("Корзина скомплектованна");
                        System.out.println(shoppingBasket.toString(basket));
                        break;
                    } else {
                        System.out.println("Вы ввели неверный индекс, попробуйте еще");
                        continue;
                    }
                case 4:
                    orderSystem.handedOverToTheCourier(basket, courier.getCourier());
                    orderSystem.courierOnTheWayToYou();
                    orderSystem.theOrderHasBeenDelivered();
                    System.out.println("Поставть пожалуйска оценку курьеру от 1 до 5");
                    Scanner sc = new Scanner(System.in);
                    int estimation = sc.nextInt();
                    courier.addToRating(estimation, courier.getListRating() );
                    System.out.println("Обновленный рейтинг курьера: " + courier.calculatingTheRating());
                    break;
                case 5:
                    System.out.println("Возврат заказа, повтороение заказа");
                    break;
                case 6:
                    System.out.println("Система рейтинга для товаров");
                    break;
                case 7:
                    System.out.println("Простая рекомендательная система для покупок");
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
                "Варианты фиитрации:\n" +
                " 1 - По цене\n" +
                " 2 - По производителям \n" +
                " 3 - По ключевым словам\n");
    }

    public static void printShoppingDepartments() {
        System.out.println("Из какого отдела вы хотите купить товары?\n" +
                "1 - Молочный отдел\n" +
                "2 - Мясо\n" +
                "3 - Удалить товары\n" +
                "0 - Завершение покупок\n");
    }

    public static Map<Integer, Products> addToBasket(Map<Integer, Products> productsToBasket, Map<Integer, Products> basket) {
        int key = basket.size() + 1;

        for (Map.Entry<Integer, Products> entry : productsToBasket.entrySet()) {

            Products product = entry.getValue();
            basket.put(key, product);
            key = key + 1;
        }
        return basket;
    }

    public static Map<Integer, Products> sortingBasket(Map<Integer, Products> basket) {

        Map<Integer, Products> sortedBasket = new HashMap<>();
        int key = 1;

        for (Map.Entry<Integer, Products> entry : basket.entrySet()) {
            Products product = entry.getValue();
            sortedBasket.put(key, product);
            key = key + 1;
        }
        return sortedBasket;
    }

}
