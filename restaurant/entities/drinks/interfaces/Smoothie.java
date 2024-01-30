package restaurant.entities.drinks.interfaces;

import restaurant.entities.drinks.interfaces.BaseBeverage;

public class Smoothie extends BaseBeverage {
    private static final double PRICE_SMOOTHIE = 4.50;


    public Smoothie(String name, int counter, String brand) {
        super(name, counter,PRICE_SMOOTHIE, brand);
    }
}
