package shop;

import java.util.*;

public class DairyProducts extends Products implements Goods {


    public DairyProducts(String title, int count, String manufacturer) {
        super(title, count, manufacturer);


    }

    public DairyProducts() {
    }
    @Override
    public Map<Integer, Products> getGoods() {
        List<String> title = Arrays.asList("Молоко", "Творог", "Кефир ", "Сметана", "Масло ", "Ряженка", "Сливки");
        List<String> manufacturer = Arrays.asList("Простоквашино", "Домик в деревне", "Вкуснотеево", "Село", "Фермерское");

        Map<Integer, Products> productsCollections = new HashMap<>();
        for (int i = 0; i < title.size(); i++) {
            productsCollections.put(i + 1, new DairyProducts(
                    title.get(new Random().nextInt(title.size())),
                    new Random().nextInt(200),
                    manufacturer.get(new Random().nextInt(manufacturer.size()))
            ));
        }
        return productsCollections;
    }

    @Override
    public Map<Integer, Products> filter(Map<Integer, Products> products, Integer maxPrice) {
        Map<Integer, Products> filterProducts = new HashMap<>();
        for (Map.Entry<Integer, Products> entry : products.entrySet()){
            Integer key = entry.getKey();
            Products product = entry.getValue();
            int value = entry.getValue().getCount();
            if (value < maxPrice){
                filterProducts.put(key, product);
            }
        }
        return filterProducts;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
