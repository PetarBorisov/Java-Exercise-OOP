package restaurant.entities.healthyFoods.interfaces;

import restaurant.entities.healthyFoods.interfaces.Food;

public class VeganBiscuits extends Food {
    private static final double VEGAN_BISCUITS = 205;


    public VeganBiscuits(String name, double price) {
        super(name, VEGAN_BISCUITS, price);
    }
}
