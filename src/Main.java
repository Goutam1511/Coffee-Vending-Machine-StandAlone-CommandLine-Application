import service.vendingMachineService;
import service.vendingMachineServiceImpl;

public class Main {
    public static void main(String[] args) {
        vendingMachineService vendingMachine = new vendingMachineServiceImpl();
        vendingMachine.displayMenu();
    }
}