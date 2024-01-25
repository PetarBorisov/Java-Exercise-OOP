
package restaurant.core;

import restaurant.common.enums.BeveragesType;
import restaurant.common.enums.HealthyFoodType;
import restaurant.common.enums.TableType;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private BeverageRepository<Beverages> beverageRepository;
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private TableRepository<Table> tableRepository;
    private double finalBill;

   public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.beverageRepository = beverageRepository;
        this.healthFoodRepository = healthFoodRepository;
        this.tableRepository = tableRepository;
        finalBill=0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood healthyFood = null;
        if (!(healthyFood == null)) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST,name));
        }
        switch (type) {
            case "Salad":
                healthyFood = new Salad(name, price);
                break;
            case "VeganBiscuits":
                healthyFood = new VeganBiscuits(name, price);
                break;

        }
                this.healthFoodRepository.add(healthyFood);
                return String.format(FOOD_ADDED, name);
        }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverages = null;
        if (beverages != null)
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));

       switch (type) {
           case "Fresh":
               beverages = new Fresh(name, counter, brand);
               break;
           case "Smoothie":
               beverages = new Smoothie(name, counter, brand);
               break;
       }

        this.beverageRepository.add(beverages);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        if (table != null)
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
         switch (type) {
             case "Indoors":
                 table = new Indoors(tableNumber,capacity);
                 break;
             case "InGarden":
                 table = new InGarden(tableNumber,capacity);
                 break;
         }


        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {

        for (Table table : this.tableRepository.getAllEntities()) {
            if (!table.isReservedTable() && table.getSize() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        HealthyFood healthyFood = healthFoodRepository.foodByName(healthyFoodName);
        if (table == null)
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        if (healthyFood == null)
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);

        table.orderHealthy(healthyFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverages = beverageRepository.beverageByName(name, brand);
        if (table == null)
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        if (beverages == null)
            return String.format(NON_EXISTENT_DRINK, name, brand);

        table.orderBeverages(beverages);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = this.tableRepository
                .byNumber(tableNumber);
        double bill = table.bill();
        finalBill+=bill;
        table.clear();
        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY,finalBill);
    }
}