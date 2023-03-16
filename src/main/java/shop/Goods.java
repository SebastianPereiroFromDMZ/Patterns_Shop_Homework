package shop;

import java.util.HashMap;
import java.util.Map;

public interface Goods {

    Map<Integer, Products> getGoods();

    Map<Integer, Products> filter(Map<Integer, Products> products, Integer maxPrice);

     String toString(HashMap<Integer, Products> goods);
}
