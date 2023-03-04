package service;

public class ConsoleOutputService implements OutputService {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
