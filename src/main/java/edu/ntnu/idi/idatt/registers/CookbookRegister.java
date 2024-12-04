package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Cookbook;
import java.util.ArrayList;

public class CookbookRegister {
  public ArrayList<Cookbook> cookbooks = new ArrayList<>();

  public void add(Cookbook cookbook) {
    Cookbook existingCookbook = find(cookbook.name);
    if (existingCookbook != null) {
      throw new IllegalArgumentException("Cookbook already exists");
    }
    cookbooks.add(cookbook);
  }

  public void remove(Cookbook cookbook) {
    Cookbook existingCookbook = find(cookbook.name);
    if (existingCookbook != null) {
      throw new IllegalArgumentException("Cookbook doesnt exist");
    }
    cookbooks.remove(cookbook);
  }

  public Cookbook find(String name) {
    return cookbooks.stream().filter(c -> c.name.equals(name)).findFirst().orElse(null);
  }
}
