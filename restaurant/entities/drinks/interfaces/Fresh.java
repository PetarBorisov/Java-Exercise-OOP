package restaurant.entities.drinks.interfaces;

import restaurant.entities.drinks.interfaces.BaseBeverage;

public class Fresh extends BaseBeverage {
    private static final double PRICE_FRESH = 3.50;


    public Fresh(String name, int counter, String brand) {
        super(name, counter, PRICE_FRESH, brand);
    }
}
