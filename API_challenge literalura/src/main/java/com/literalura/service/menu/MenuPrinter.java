package com.literalura.service.menu;

public class MenuPrinter {
    public static void printMenu() {
        System.out.println("\n=== LiterAlura - Catálogo de Libros ===");
        for (MenuOption option : MenuOption.values()) {
            System.out.printf("%d. %s%n", option.getValue(), option.getDescription());
        }
        System.out.print("Seleccione una opción: ");
    }
}