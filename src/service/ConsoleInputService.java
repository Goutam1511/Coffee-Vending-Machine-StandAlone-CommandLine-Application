package service;

import java.util.Scanner;

public class ConsoleInputService implements InputService{
    Scanner sc;

    ConsoleInputService() {
        sc = new Scanner(System.in);
    }
    @Override
    public String takeInput() {
        String in = sc.nextLine();
        return in;
    }
}
