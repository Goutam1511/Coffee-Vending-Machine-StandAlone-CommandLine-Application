package repository;

import config.MenuConfig;

import java.util.HashMap;
import java.util.Map;

import static constants.constants.INGREDIENT_RESTOCK_UNITS;

/**
 * In memory inventory
 */
public class IngredientRepository {
    public static Map<String, Integer> inventory;

    static {
        restock(INGREDIENT_RESTOCK_UNITS);
    }

    public static void restock(int units) {
        inventory = new HashMap<>();
        for (String ingredient : MenuConfig.ingredients) {
            inventory.put(ingredient, units);
        }
    }
}
