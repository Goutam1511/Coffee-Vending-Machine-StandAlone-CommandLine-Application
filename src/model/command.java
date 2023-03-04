package model;

import exception.OutOfStockException;

/**
 * Command pattern
 * - implements CoffeeCommand to make coffee
 * - implements RestockCommand to restock ingredients
 * - implements QuitCommand to quit the application
 */
public interface command {
    public void execute(String input) throws OutOfStockException;
}
