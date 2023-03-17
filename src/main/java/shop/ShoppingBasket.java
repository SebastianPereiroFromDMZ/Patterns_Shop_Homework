package shop;

import java.util.Map;

public interface ShoppingBasket {

    Map<Integer, Products> addProduct(Map<Integer, Products> products, Integer numberProduct);
}
