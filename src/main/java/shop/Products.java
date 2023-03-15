package shop;

public class Products {

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

    @Override
    public String toString() {
        return "Products{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", Manufacturer='" + Manufacturer + '\'' +
                '}';
    }
}
