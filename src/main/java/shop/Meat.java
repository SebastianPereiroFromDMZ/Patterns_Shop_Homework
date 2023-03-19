package shop;

import java.util.*;

public class Meat extends Products implements Goods{

    private String title;
    private int count;
    private String manufacturer;

    List<String> listMeatProduct = Arrays.asList("Курица", "Индейка", "Свинина", "Говядина", "Баранина", "Кролик", "Утка");
    List<String> listManufacturer = Arrays.asList("Дымов", "Мираторг", "Микоян", "Село", "Фермерское");

    public Meat(String title, int count, String manufacturer) {
        this.title = title;
        this.count = count;
        this.manufacturer = manufacturer;
    }

    public Meat(){
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public Map<Integer, Products> getGoods() {

        Map<Integer, Products> productsCollections = new HashMap<>();
        for (int i = 0; i < listMeatProduct.size(); i++) {
            productsCollections.put(i + 1, new Meat(
                    listMeatProduct.get(new Random().nextInt(listMeatProduct.size())),
                    new Random().nextInt(500),
                    listManufacturer.get(new Random().nextInt(listManufacturer.size()))
            ));
        }
        return productsCollections;
    }

    @Override
    public Map<Integer, Products> filterPrice(Map<Integer, Products> products, Integer maxPrice) {
        return super.filterPrice(products, maxPrice);
    }

    @Override
    public Map<Integer, Products> filterManufacturer(Map<Integer, Products> products, String manufacturer) {
        return super.filterManufacturer(products, manufacturer);
    }

    @Override
    public Map<Integer, Products> filterKeyword(Map<Integer, Products> products, String keyword) {
        return super.filterKeyword(products, keyword);
    }

    @Override
    public String toString(HashMap<Integer, Products> products) {
        StringBuilder sb = new StringBuilder("Мясной отдел : \n");
        for (Map.Entry<Integer, Products> entry : products.entrySet()) {
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
