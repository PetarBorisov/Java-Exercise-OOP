package restaurant.entities.healthyFoods.interfaces;

import restaurant.entities.healthyFoods.interfaces.Food;

public class Salad extends Food {
    private static final double SALAD_PORTION = 150;


    public Salad(String name, double price) {
        super(name, SALAD_PORTION, price);
    }
}
