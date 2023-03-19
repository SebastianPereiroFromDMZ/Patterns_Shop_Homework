package shop;

import java.util.HashMap;
import java.util.Map;

public abstract class Products  {

    private String title;
    private int count;
    private String manufacturer;



    public abstract String getTitle();

    public abstract int getCount();

    public abstract String getManufacturer();

    public abstract void setTitle(String title);


    public abstract void setCount(int count);

    public abstract void setManufacturer(String manufacturer);

    public Map<Integer, Products> filterPrice(Map<Integer, Products> products, Integer maxPrice) {

        Map<Integer, Products> filterProducts = new HashMap<>();

        for (Map.Entry<Integer, Products> entry : products.entrySet()) {
            Integer key = entry.getKey();
            Products product = entry.getValue();
            int value = entry.getValue().getCount();
            if (value < maxPrice) {
                filterProducts.put(key, product);
            }
        }
        return filterProducts;
    }


    public Map<Integer, Products> filterManufacturer(Map<Integer, Products> products, String manufacturer) {

        int key = 1;

        Map<Integer, Products> filterProducts = new HashMap<>();

        for (Map.Entry<Integer, Products> entry : products.entrySet()) {
            Products product = entry.getValue();
            String value = entry.getValue().getManufacturer();
            if (manufacturer.equalsIgnoreCase(value)) {
                filterProducts.put(key, product);
                key = key + 1;
            }
        }
        return filterProducts;
    }

    public Map<Integer, Products> filterKeyword(Map<Integer, Products> products, String keyword) {

        int key = 1;

        Map<Integer, Products> filterProducts = new HashMap<>();

        for (Map.Entry<Integer, Products> entry : products.entrySet()) {
            Products product = entry.getValue();
            String value = entry.getValue().getTitle();
            if (keyword.equalsIgnoreCase(value)) {
                filterProducts.put(key, product);
                key = key + 1;

            }
        }
        return filterProducts;
    }
}






