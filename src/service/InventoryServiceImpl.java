package service;

import exception.OutOfStockException;
import repository.IngredientRepository;

import static constants.constants.INGREDIENT_RESTOCK_UNITS;

/**
 * Inventory Management Service that manages in-memory inventory
 */
public class InventoryServiceImpl implements InventoryService {
    @Override
    public int getIngredientUnits(String ingredient) {
        return IngredientRepository.inventory.getOrDefault(ingredient, 0);
    }

    @Override
    public void restockIngredients() {
        IngredientRepository.restock(INGREDIENT_RESTOCK_UNITS);
    }

    @Override
    public void decrementIngredients(String ingredient, int units) throws OutOfStockException {
        IngredientRepository.inventory.put(ingredient, IngredientRepository.inventory.getOrDefault(ingredient, 0) - units);
    }
}
