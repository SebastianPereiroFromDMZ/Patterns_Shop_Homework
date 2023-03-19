package shop;

import java.util.HashMap;
import java.util.Map;

public interface ShoppingBasket {

    Map<Integer, Products> addProduct(Map<Integer, Products> products, int numberProduct, int count);

    Map<Integer, Products> deleteProduct(Map<Integer, Products> products, int numberProduct);
    String toString(HashMap<Integer, Products> goodsToBuy);

}
