package shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Courier {

    private String name;
    private int rating;

    List<Integer> listRating = new ArrayList<>( Arrays.asList(3, 5, 3, 4, 5));

    public Courier(String name) {
        this.name = name;
        rating = calculatingTheRating();
        listRating = getListRating();
    }

    public Courier() {
    }

    public void addToRating(int estimation, List<Integer> list) {
        if (estimation >= 1 && estimation <= 5) {
            list.add(estimation);
        } else {
            System.out.println("Неккоректная оценка");
        }
    }

    public int calculatingTheRating() {
        int mid;
        int sum = 0;
        for (int i : listRating) {
            sum += i;
        }
        mid = sum / listRating.size();
        return mid;
    }

    public Courier getCourier() {
        return new Courier("Иван");
    }

    @Override
    public String toString() {
        return "[" + name + ", рэйтинг курьера: " + rating + "]";
    }


    public List<Integer> getListRating() {
        return listRating;
    }
}
