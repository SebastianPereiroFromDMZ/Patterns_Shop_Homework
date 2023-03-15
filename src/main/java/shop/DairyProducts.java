package shop;

import java.util.*;

public class DairyProducts extends Products {


    public DairyProducts(String title, int count, String manufacturer) {
        super(title, count, manufacturer);


    }

    public DairyProducts() {
    }

    public Map<Integer, Products> getProduct() {
        List<String> title = Arrays.asList("Молоко", "Творог", "Кефир", "Сметана", "Масло", "Ряженка", "Сливки");
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


    public String toString(HashMap<Integer, Products> productsHashMap) {
        StringBuilder sb = new StringBuilder("Молочный отдел : \n");
        for (Map.Entry<Integer, Products> entry : productsHashMap.entrySet()) {
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
