package config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static constants.constants.*;

/**
 * This class just contains all the ingredient and menu related information stored in maps for easy access
 */
public class MenuConfig {
    /*
        Coffee - 3 units of coffee, 1 unit of sugar, 1 unit of cream
        Decaf Coffee - 3 units of Decaf Coffee, 1 unit of sugar, 1 unit of cream
        Caffe Latte - 2 units of espresso, 1 unit of steamed milk
        Caffe Americano - 3 units of espresso
        Caffe Mocha - 1 units of Espresso, 1 unit of cocoa, 1 unit of steamed milk, 1 unit of whipped cream
        Cappuccino - 2 units of Espresso, 1 unit of steamed milk, 1 unit of foamed milk

        Coffee $0.75
        Decaf Coffee $0.75
        Sugar $0.25
        Cream $0.25
        Steamed Milk $0.35
        Foamed Milk $0.35
        Espresso $1.10
        Cocoa $0.90
        Whipped Cream $1.00
     */
    static Map<String, Integer> coffeeRecipe;
    static Map<String, Integer> decafCoffeeRecipe;
    static Map<String, Integer> caffeLatteRecipe;
    static Map<String, Integer> caffeAmericanoRecipe;
    static Map<String, Integer> caffeMochaRecipe;
    static Map<String, Integer> cappuccinoRecipe;
    public static Map<String, Map<String, Integer>> menuRecipes;
    public static Map<String, Double> ingredientPrices;

    public static String[] availableMenus = {MENU_COFFEE, MENU_DECAF_COFFEE, MENU_CAFFE_LATTE, MENU_CAFFE_AMERICANO,
                                                MENU_CAFFE_MOCHA, MENU_CAPPUCCINO};

    public static String[] ingredients = {INGREDIENT_COFFEE, INGREDIENT_DECAF_COFFEE, INGREDIENT_SUGAR, INGREDIENT_CREAM,
                                            INGREDIENT_STEAMED_MILK, INGREDIENT_FOAMED_MILK, INGREDIENT_ESPRESSO,
                                            INGREDIENT_COCOA, INGREDIENT_WHIPPED_CREAM};

    static {
        coffeeRecipe = new HashMap<>();
        coffeeRecipe.put(INGREDIENT_COFFEE, 3);
        coffeeRecipe.put(INGREDIENT_SUGAR, 1);
        coffeeRecipe.put(INGREDIENT_CREAM, 1);

        decafCoffeeRecipe = new HashMap<>();
        decafCoffeeRecipe.put(INGREDIENT_DECAF_COFFEE, 3);
        decafCoffeeRecipe.put(INGREDIENT_SUGAR, 1);
        decafCoffeeRecipe.put(INGREDIENT_CREAM, 1);

        caffeLatteRecipe = new HashMap<>();
        caffeLatteRecipe.put(INGREDIENT_ESPRESSO, 2);
        caffeLatteRecipe.put(INGREDIENT_STEAMED_MILK, 1);

        caffeAmericanoRecipe = new HashMap<>();
        caffeAmericanoRecipe.put(INGREDIENT_ESPRESSO, 3);

        caffeMochaRecipe = new HashMap<>();
        caffeMochaRecipe.put(INGREDIENT_ESPRESSO, 1);
        caffeMochaRecipe.put(INGREDIENT_COCOA, 1);
        caffeMochaRecipe.put(INGREDIENT_STEAMED_MILK, 1);
        caffeMochaRecipe.put(INGREDIENT_WHIPPED_CREAM, 1);

        cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(INGREDIENT_ESPRESSO, 2);
        cappuccinoRecipe.put(INGREDIENT_STEAMED_MILK, 1);
        cappuccinoRecipe.put(INGREDIENT_FOAMED_MILK, 1);

        menuRecipes = new HashMap<>();
        menuRecipes.put(MENU_COFFEE, coffeeRecipe);
        menuRecipes.put(MENU_DECAF_COFFEE, decafCoffeeRecipe);
        menuRecipes.put(MENU_CAFFE_LATTE, caffeLatteRecipe);
        menuRecipes.put(MENU_CAFFE_AMERICANO, caffeAmericanoRecipe);
        menuRecipes.put(MENU_CAFFE_MOCHA, caffeMochaRecipe);
        menuRecipes.put(MENU_CAPPUCCINO, cappuccinoRecipe);

        ingredientPrices = new HashMap<>();
        ingredientPrices.put(INGREDIENT_COFFEE, 0.75);
        ingredientPrices.put(INGREDIENT_DECAF_COFFEE, 0.75);
        ingredientPrices.put(INGREDIENT_SUGAR, 0.25);
        ingredientPrices.put(INGREDIENT_CREAM, 0.25);
        ingredientPrices.put(INGREDIENT_STEAMED_MILK, 0.35);
        ingredientPrices.put(INGREDIENT_FOAMED_MILK, 0.35);
        ingredientPrices.put(INGREDIENT_ESPRESSO, 1.10);
        ingredientPrices.put(INGREDIENT_COCOA, 0.90);
        ingredientPrices.put(INGREDIENT_WHIPPED_CREAM, 1.00);

        Arrays.sort(ingredients);
        Arrays.sort(availableMenus);
    }
}
