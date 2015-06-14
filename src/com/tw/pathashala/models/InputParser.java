package com.tw.pathashala.models;

import com.tw.pathashala.menu.BooksList;
import com.tw.pathashala.menu.InvalidOption;
import com.tw.pathashala.menu.MenuAction;
import com.tw.pathashala.menu.Quit;

import java.util.HashMap;
import java.util.Map;

public class InputParser {
    private Map<String, MenuAction> menuList = new HashMap<String, MenuAction>();
    private Library library;
    private MenuAction invalidOption;

    public InputParser(Library library, BooksList bookList, Quit quit, InvalidOption invalidOption) {
        this.library = library;
        this.invalidOption = invalidOption;
        menuList.put("List Books", bookList);
        menuList.put("Quit", quit);
    }

    public void addOption(String menuOption, MenuAction action) {
        menuList.put(menuOption, action);
    }

    public Map<String, MenuAction> menuList() {
        return menuList;
    }

    public MenuAction chooseOption(String menuOption) {
        if(menuList.containsKey(menuOption))
            return menuList.get(menuOption);
        return invalidOption;
    }

    @Override
    public String toString() {
        String output = "";
        int serial = 1;
        for (String menu : menuList.keySet()) {
            output = output + "\n" + serial + ") " + menu;
            serial++;
        }
        return output;
    }
}
