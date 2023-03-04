package model;

import exception.OutOfStockException;

public class QuitMachineCommand implements command {

    @Override
    public void execute(String input) throws OutOfStockException {
        System.exit(0);
    }
}
