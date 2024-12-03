package edu.ntnu.idi.idatt.registers;

import java.util.ArrayList;

import edu.ntnu.idi.idatt.types.Cookbook;

public class CookbookRegister {
    public ArrayList<Cookbook> cookbooks = new ArrayList<>();

    public CookbookRegister() {}

    public void registerCookbook(Cookbook cookbook) {
        cookbooks.add(cookbook);
    }

    public void removeCookbook(Cookbook cookbook) {
        cookbooks.remove(cookbook);
    }

    public Cookbook searchForCookbook(String name) {
        for (int i = 0; i < cookbooks.size(); i++) {
            if (cookbooks.get(i).name.equals(name)) {
                return cookbooks.get(i);
            }
        }
        return null;
    }
}
