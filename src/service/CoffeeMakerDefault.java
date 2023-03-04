package service;

import exception.OutOfStockException;
import repository.IngredientRepository;

/**
 * Implementation of CoffeeMaker that is used by CoffeeCommand to make coffee
 * or check if making coffee is possible with available ingredients
 */
public class CoffeeMakerDefault implements CoffeeMaker {
    InventoryService inventoryService;
    CoffeeMakerDefault(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @Override
    public void useIngredients(String ingredient, int units) throws OutOfStockException {
        checkIfIngredientAvailable(ingredient, units);
        inventoryService.decrementIngredients(ingredient, units);
    }

    @Override
    public void checkIfIngredientAvailable(String ingredient, int units) throws OutOfStockException {
        if (IngredientRepository.inventory.getOrDefault(ingredient, 0) < units) {
            throw new OutOfStockException(ingredient + " out of stock");
        }
    }
}
