package model;

import exception.OutOfStockException;
import service.InventoryService;

public class RestockCommand implements command {
    InventoryService inventoryService;

    public RestockCommand(InventoryService s) {
        inventoryService = s;
    }
    @Override
    public void execute(String input) throws OutOfStockException {
        inventoryService.restockIngredients();
    }
}
