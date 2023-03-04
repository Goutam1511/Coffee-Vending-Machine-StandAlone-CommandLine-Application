package service;

import exception.OutOfStockException;

/**
 * CoffeeMaker for CoffeeCommand
 */
public interface CoffeeMaker {
    public void useIngredients(String ingredient, int units) throws OutOfStockException;
    public void checkIfIngredientAvailable(String ingredient, int units) throws OutOfStockException;
}
