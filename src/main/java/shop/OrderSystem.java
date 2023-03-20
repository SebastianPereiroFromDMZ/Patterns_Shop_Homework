package shop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderSystem {

    Date dateNow = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd 'и время' hh:mm:ss");
    ShoppingBasket shoppingBasket = new ShoppingBasketImpl();

    public void handedOverToTheCourier(Map<Integer, Products> basket){

        System.out.println("Ваш заказ:\n"
                + shoppingBasket.toString((HashMap<Integer, Products>) basket) +
                "был передан курьеру  " + formatForDateNow.format(dateNow) + "\n");
    }

    public void courierOnTheWayToYou(){
        System.out.println("Курьер уже на пути к вам " + formatForDateNow.format(dateNow) + "\n");
    }
}
