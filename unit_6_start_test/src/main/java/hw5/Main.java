package hw5;

import hw5.controller.ClientController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new ClientController().start();
    }
}
