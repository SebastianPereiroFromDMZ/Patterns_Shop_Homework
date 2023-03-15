package shop;

import java.util.*;

public class DairyProducts extends Products {


    public DairyProducts(String title, int count, String manufacturer) {
        super(title, count, manufacturer);


    }

    public DairyProducts(){

    }

    public Collection<Products> getProduct() {
        List<String> title = Arrays.asList("Молоко", "Творог", "Кефир", "Сметана");
        List<String> manufacturer = Arrays.asList("Простоквашино", "Домик в деревне", "Вкуснотеево", "Село", "Фермерское");

        Collection<Products> productsCollections = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            productsCollections.add(new DairyProducts(
                    title.get(new Random().nextInt(title.size())),
                    new Random().nextInt(200),
                    manufacturer.get(new Random().nextInt(manufacturer.size()))
            ));
        }
        return productsCollections;
    }

    @Override
    public String toString() {
        return "{" + title + '\'' +
                ", цена=" + count +
                ", производитель='" + Manufacturer + '\'' +
                '}' + "\n";
    }
}
