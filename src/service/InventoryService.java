package service;

import exception.OutOfStockException;

public interface InventoryService {
    public int getIngredientUnits(String ingredient);

    public void restockIngredients();

    public void decrementIngredients(String ingredient, int units) throws OutOfStockException;
}
