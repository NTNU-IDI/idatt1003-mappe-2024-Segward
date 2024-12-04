package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Cookbook;
import java.util.ArrayList;

public class CookbookRegister {
  public ArrayList<Cookbook> cookbooks = new ArrayList<>();

  public void add(Cookbook cookbook) {
    Cookbook existingCookbook = searchForCookbook(cookbook.name);
    if (existingCookbook != null) {
      throw new IllegalArgumentException("Cookbook already exists");
    }
    cookbooks.add(cookbook);
  }

  public void remove(Cookbook cookbook) {
    Cookbook existingCookbook = searchForCookbook(cookbook.name);
    if (existingCookbook != null) {
      throw new IllegalArgumentException("Cookbook doesnt exist");
    }
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
