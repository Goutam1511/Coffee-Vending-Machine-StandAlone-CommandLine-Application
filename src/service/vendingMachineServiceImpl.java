package service;

import config.MenuConfig;
import exception.InvalidCommandException;
import exception.OutOfStockException;
import model.CoffeeCommand;
import model.QuitMachineCommand;
import model.RestockCommand;
import model.command;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static config.MenuConfig.availableMenus;
import static config.MenuConfig.ingredients;
import static constants.constants.*;

public class vendingMachineServiceImpl implements vendingMachineService {
    InventoryService inventoryService;
    CoffeeMaker coffeeMaker;
    OutputService outputService;
    InputService inputService;
    Map<String, command> allCommands;
    DecimalFormat df = new DecimalFormat();

    /**
     * Constructor to setup and inject all dependencies - Dependency Injection - SOLID
     * Also sets up the available commands to use Command Pattern
     */
    public vendingMachineServiceImpl() {
        inventoryService = new InventoryServiceImpl();
        coffeeMaker = new CoffeeMakerDefault(inventoryService);
        outputService = new ConsoleOutputService();
        inputService = new ConsoleInputService();
        allCommands = new HashMap<>();
        allCommands.put(COFFEE_COMMAND, new CoffeeCommand(coffeeMaker));
        allCommands.put(RESTOCK_COMMAND, new RestockCommand(inventoryService));
        allCommands.put(QUIT_COMMAND, new QuitMachineCommand());
    }

    /**
     * Displays the menu recursively and accepts input command
     */
    @Override
    public void displayMenu() {
        outputService.log("Ingredients:");
        for (String ingredient : ingredients) {
            outputService.log(ingredient + "," + inventoryService.getIngredientUnits(ingredient));
        }
        outputService.log("Menu:");
        for (int i = 0; i < availableMenus.length; i++) {
            String item = availableMenus[i];
            double itemCost = calculateCost(item);
            boolean inStock = true;

            try {
                CoffeeCommand coffeeCommand = (CoffeeCommand) allCommands.get(COFFEE_COMMAND);
                coffeeCommand.checkIfCoffeePossible(item);
            } catch (OutOfStockException e) {
                inStock = false;
            }
            outputService.log((i + 1) + "," + item + "," + CURRENCY + String.format("%.2f", itemCost) + "," + inStock);
        }
        acceptCommand();
        displayMenu();
    }

    private double calculateCost(String coffeeType) {
        double cost = 0;
        Map<String, Integer> recipe = MenuConfig.menuRecipes.get(coffeeType);
        for (Map.Entry<String, Integer> ingredientEntry : recipe.entrySet()) {
            cost += (ingredientEntry.getValue() * MenuConfig.ingredientPrices.get(ingredientEntry.getKey()));
        }
        return cost;
    }

    /**
     * Accepts user input using inputService - for now console and executes the relevant command
     */
    @Override
    public void acceptCommand() {
        String input = inputService.takeInput().toLowerCase();
        String itemOrdered = "";
        try {
            if (allCommands.containsKey(input)) { // If command is either RESTOCK_COMMAND / QUIT_COMMAND
                allCommands.get(input).execute(input);
            } else { // Either an invalid command or maybe a COFFEE_COMMAND
                String coffeeType = getCoffeeType(input);
                allCommands.get(COFFEE_COMMAND).execute(coffeeType);
                outputService.log("Dispensing Coffee: " + coffeeType);
            }
        } catch (OutOfStockException e) {
            outputService.log("Out of Stock: " + itemOrdered);
        } catch (InvalidCommandException e) {
            outputService.log(e.getMessage());
        }
    }

    /**
     *
     * @param input - input of user
     * @return Coffee Item if input is valid
     * @throws InvalidCommandException
     */
    private String getCoffeeType(String input) throws InvalidCommandException {
        if (input == null) {
            throw new InvalidCommandException("Invalid selection: " + null);
        }
        try {
            int d = Integer.parseInt(input);
            if (d > availableMenus.length || d == 0) {
                throw new InvalidCommandException("Invalid selection: " + input);
            }
            return MenuConfig.availableMenus[d - 1];
        } catch (NumberFormatException nfe) {
            throw new InvalidCommandException("Invalid selection: " + input);
        }
    }
}
