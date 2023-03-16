package shop;

import java.util.*;

public class Meet extends Products implements Goods{

    public Meet(String title, int count, String manufacturer) {
        super(title, count, manufacturer);
    }

    public Meet(){

    }

    @Override
    public Map<Integer, Products> getGoods() {
        List<String> title = Arrays.asList("Курица", "Индейка", "Свинина", "Говядина", "Баранина", "Кролик", "Утка  ");
        List<String> manufacturer = Arrays.asList("Дымов", "Мираторг", "Микоян", "Село", "Фермерское");

        Map<Integer, Products> productsCollections = new HashMap<>();
        for (int i = 0; i < title.size(); i++) {
            productsCollections.put(i + 1, new DairyProducts(
                    title.get(new Random().nextInt(title.size())),
                    new Random().nextInt(500),
                    manufacturer.get(new Random().nextInt(manufacturer.size()))
            ));
        }
        return productsCollections;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
