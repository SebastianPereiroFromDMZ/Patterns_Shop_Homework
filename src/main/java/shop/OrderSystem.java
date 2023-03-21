package shop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderSystem {

    Date dateNow = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss  yyyy.MM.dd");
    ShoppingBasket shoppingBasket = new ShoppingBasketImpl();

    public void handedOverToTheCourier(Map<Integer, Products> basket, Courier courier) throws InterruptedException {

        System.out.println("Ваш заказ:\n"
                + shoppingBasket.toString((HashMap<Integer, Products>) basket) +
                "Был передан курьеру :  " + courier + " В " + formatForDateNow.format(dateNow) + "\n");
        //Thread.sleep(10000);
    }

    public void courierOnTheWayToYou() throws InterruptedException {
        System.out.println("Курьер уже на пути к вам " + formatForDateNow.format(dateNow) + "\n");
        //Thread.sleep(10000);
    }

    public void theOrderHasBeenDelivered() throws InterruptedException {
        System.out.println("Заказ доставлен " + formatForDateNow.format(dateNow) + "\n");
        //Thread.sleep(5000);
    }
}
