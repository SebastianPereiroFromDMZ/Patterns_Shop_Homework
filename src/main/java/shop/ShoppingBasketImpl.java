package shop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasketImpl implements ShoppingBasket {
    @Override
    public Map<Integer, Products> addProduct(Map<Integer, Products> products, int numberProduct, int count) {

        int key = 1;
        Map<Integer, Products> goodsToBuy = new HashMap<>();

        Products product = products.get(numberProduct);

        for (int i = 0; i < count; i++) {
            goodsToBuy.put(key, product);
            key = key + 1;
        }
        return goodsToBuy;
    }


    @Override
    public Map<Integer, Products> deleteProduct(Map<Integer, Products> products, int numberProduct) {
        return null;
    }

    @Override
    public String toString(HashMap<Integer, Products> goodsToBuy) {
        StringBuilder sb = new StringBuilder("Товары в вашей корзине : \n");
        for (Map.Entry<Integer, Products> entry : goodsToBuy.entrySet()) {
            Integer key = entry.getKey();
            Products value = entry.getValue();

            sb
                    .append("[ ")
                    .append("Номер продукта: ").append(key).append("\t")
                    .append("Наименование: ").append(value.getTitle()).append("\t")
                    .append("Цена: ").append(value.getCount()).append("\t")
                    .append("Производитель товара: ").append(value.getManufacturer())
                    .append(" ]")
                    .append("\n");
        }
        return sb.toString();
    }
}
