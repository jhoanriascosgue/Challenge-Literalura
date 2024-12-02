package com.literalura.service.menu;

public enum MenuOption {
    SEARCH_BOOK(1, "Buscar libro por título"),
    LIST_BOOKS(2, "Listar todos los libros"),
    LIST_AUTHORS(3, "Listar todos los autores"),
    LIST_AUTHORS_BY_YEAR(4, "Listar autores vivos en un año específico"),
    LIST_BOOKS_BY_LANGUAGE(5, "Listar libros por idioma"),
    EXIT(0, "Salir");

    private final int value;
    private final String description;

    MenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromValue(int value) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + value);
    }
}