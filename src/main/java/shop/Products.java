package shop;

import java.util.HashMap;
import java.util.Map;

public class Products implements Goods {

    protected String title;
    protected int count;
    protected String Manufacturer;

    public Products(String title, int count, String manufacturer) {
        this.title = title;
        this.count = count;
        Manufacturer = manufacturer;
    }



    public Products(){
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public String getManufacturer() {
        return Manufacturer;
    }


    public String toString(HashMap<Integer, Products> products) {
        StringBuilder sb = new StringBuilder("Продукты : \n");
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

    @Override
    public Map<Integer, Products> getGoods() {
        return null;
    }

    @Override
    public Map<Integer, Products> filter(Map<Integer, Products> products, Integer maxPrice) {
        return null;
    }
}
