package restaurant.entities.tables.interfaces;

import restaurant.entities.tables.interfaces.BaseTable;

public class Indoors extends BaseTable {
    private static final double PRICE_PER_PERSON = 3.50;


    public Indoors(int number, int size) {
        super(number, size,PRICE_PER_PERSON);
    }
}