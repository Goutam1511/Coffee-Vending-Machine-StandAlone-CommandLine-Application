package model;

import config.MenuConfig;
import exception.OutOfStockException;
import service.CoffeeMaker;

import java.util.Map;

/**
 * Using command pattern here to create coffee where we take coffeeType and use CoffeeMaker to make coffee
 * using ingredients via ingredientService. Command uses the coffeeType to fetch recipe from MenuConfig
 */
public class CoffeeCommand implements command {

    CoffeeMaker coffeeMaker;

    public CoffeeCommand(CoffeeMaker maker) {
        this.coffeeMaker = maker;
    }
    @Override
    public void execute(String coffeeType) throws OutOfStockException {
        Map<String, Integer> coffeeRecipe = MenuConfig.menuRecipes.get(coffeeType);
        for (Map.Entry<String, Integer> item : coffeeRecipe.entrySet()) {
            coffeeMaker.useIngredients(item.getKey(), item.getValue());
        }
    }
    public void checkIfCoffeePossible(String coffeeType) throws OutOfStockException {
        Map<String, Integer> coffeeRecipe = MenuConfig.menuRecipes.get(coffeeType);
        for (Map.Entry<String, Integer> item : coffeeRecipe.entrySet()) {
            coffeeMaker.checkIfIngredientAvailable(item.getKey(), item.getValue());
        }
    }
}
