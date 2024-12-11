package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Cookbook;
import java.util.ArrayList;

/** A class representing a register of cookbooks. */
public class CookbookRegister {
  public ArrayList<Cookbook> cookbooks = new ArrayList<>();

  /**
   * Add a cookbook to the register.
   *
   * @param cookbook the cookbook to add
   */
  public void add(Cookbook cookbook) {
    Cookbook existingCookbook = find(cookbook.name);
    if (existingCookbook != null) {
      throw new IllegalArgumentException("Cookbook already exists");
    }
    cookbooks.add(cookbook);
  }

  /**
   * Find a cookbook by name.
   *
   * @param name the name of the cookbook
   * @return the cookbook, or null if it does not exist
   */
  public Cookbook find(String name) {
    return cookbooks.stream().filter(c -> c.name.equals(name)).findFirst().orElse(null);
  }
}
