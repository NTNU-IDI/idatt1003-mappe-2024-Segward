package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.Utils.Utils;
import edu.ntnu.idi.idatt.registers.*;
import edu.ntnu.idi.idatt.types.*;
import java.util.ArrayList;
import java.util.Date;

public class UserInterface {
  private final int REGISTER_GROCERY = 1;
  private final int REGISTER_RECIPE = 2;
  private final int REGISTER_COOKBOOK = 3;
  private final int ADD_GROCERY_AMOUNT = 4;
  private final int REMOVE_GROCERY_AMOUNT = 5;
  private final int ADD_RECIPE_TO_COOKBOOK = 6;
  private final int SEARCH_FOR_GROCERY = 7;
  private final int LIST_GROCERIES = 8;
  private final int LIST_RECIPES = 9;
  private final int LIST_COOKBOOKS = 10;
  private final int LIST_EXPIRED_GROCERIES = 11;
  private final int LIST_SORTED_GROCERIES = 12;
  private final int LIST_GROCERIES_BEFORE_DATE = 13;
  private final int SUGGEST_COOKBOOK_RECIPIES = 14;
  private final int CHECK_RECIPIE_INGREDIENTS = 15;
  private final int EXIT = 16;
  private GroceryRegister groceryRegister;
  private CookbookRegister cookbookRegister;
  private RecipeRegister recipeRegister;
  private Utils utils = new Utils();

  public void init() {
    try {
      groceryRegister = new GroceryRegister();
      cookbookRegister = new CookbookRegister();
      recipeRegister = new RecipeRegister();
      Grocery grocery1 = new Grocery("Milk", "liter", 10, 10, utils.getDateDaysFromToday(5));
      Grocery grocery2 = new Grocery("Egg", "pcs", 10, 10, utils.getDateDaysFromToday(5));
      Grocery grocery3 = new Grocery("Flour", "kg", 10, 10, utils.getDateDaysFromToday(100));
      groceryRegister.add(grocery1);
      groceryRegister.add(grocery2);
      groceryRegister.add(grocery3);
      Ingredient ingredient1 = new Ingredient("Milk", "liter", 1);
      Ingredient ingredient2 = new Ingredient("Egg", "pcs", 2);
      Ingredient ingredient3 = new Ingredient("Flour", "kg", 0.5);
      ArrayList<Ingredient> ingredients1 = new ArrayList<>();
      ArrayList<Ingredient> ingredients3 = new ArrayList<>();
      ArrayList<Ingredient> ingredients2 = new ArrayList<>();
      ingredients1.add(ingredient1);
      ingredients1.add(ingredient2);
      ingredients1.add(ingredient3);
      ingredients2.add(ingredient1);
      ingredients2.add(ingredient2);
      ingredients3.add(ingredient1);
      ingredients3.add(ingredient3);
      Recipe recipe1 = new Recipe("Pancake", "Delicious pancake", "Mix and fry", ingredients1);
      Recipe recipe2 = new Recipe("Waffle", "Delicious waffle", "Mix and fry", ingredients2);
      Recipe recipe3 = new Recipe("Cake", "Delicious cake", "Mix and bake", ingredients3);
      recipeRegister.add(recipe1);
      recipeRegister.add(recipe2);
      recipeRegister.add(recipe3);
      Cookbook cookbook1 = new Cookbook("Breakfast");
      Cookbook cookbook2 = new Cookbook("Dessert");
      cookbook1.addRecipe(recipe1);
      cookbook1.addRecipe(recipe2);
      cookbook2.addRecipe(recipe3);
      cookbookRegister.add(cookbook1);
      cookbookRegister.add(cookbook2);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void start() {
    boolean isRunning = true;
    while (isRunning) {

      switch (utils.getUserInputOption()) {
        case REGISTER_GROCERY:
          registerGrocery();
          break;

        case REGISTER_RECIPE:
          registerRecipe();
          break;

        case REGISTER_COOKBOOK:
          registerCookbook();
          break;

        case ADD_GROCERY_AMOUNT:
          addGroceryAmount();
          break;

        case REMOVE_GROCERY_AMOUNT:
          removeGroceryAmount();
          break;

        case ADD_RECIPE_TO_COOKBOOK:
          addRecipeToCookbook();
          break;

        case SEARCH_FOR_GROCERY:
          searchForGrocery();
          break;

        case LIST_GROCERIES:
          listGroceries();
          break;

        case LIST_RECIPES:
          listRecipes();
          break;

        case LIST_COOKBOOKS:
          listCookbooks();
          break;

        case LIST_EXPIRED_GROCERIES:
          listExpiredGroceries();
          break;

        case LIST_SORTED_GROCERIES:
          listSortedGroceries();
          break;

        case SUGGEST_COOKBOOK_RECIPIES:
          suggestCookbookRecipies();
          break;

        case CHECK_RECIPIE_INGREDIENTS:
          checkRecipeIngredients();
          break;

        case LIST_GROCERIES_BEFORE_DATE:
          listGroceriesBeforeDate();
          break;

        case EXIT:
          utils.closeScanner();
          isRunning = false;
          break;
        default:
          break;
      }
    }
  }

  public void registerGrocery() {
    Grocery grocery = utils.getGrocery();
    groceryRegister.add(grocery);
    System.out.println("Grocery successfully added");
  }

  public void registerRecipe() {
    try {
      Recipe recipe = utils.getRecipe();
      recipeRegister.add(recipe);
      System.out.println("Recipe successfully added");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void registerCookbook() {
    try {
      Cookbook cookbook = utils.getCookbook();
      cookbookRegister.add(cookbook);
      System.out.println("Cookbook successfully added");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void addGroceryAmount() {
    String name = utils.getString("Enter grocery name: ");
    double amount = utils.getDouble("Enter amount to add: ");
    try {
      groceryRegister.addAmount(name, amount);
      System.out.println("Grocery amount successfully added");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void removeGroceryAmount() {
    String name = utils.getString("Enter grocery name: ");
    double amount = utils.getDouble("Enter amount to remove: ");
    try {
      groceryRegister.removeAmount(name, amount);
      System.out.println("Grocery amount successfully removed");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void addRecipeToCookbook() {
    try {
      Cookbook cookbook =
          cookbookRegister.searchForCookbook(utils.getString("Enter cookbook name: "));
      if (cookbook == null) {
        throw new Exception("Cookbook not found");
      }
      Recipe recipe = recipeRegister.searchForRecipe(utils.getString("Enter recipe name: "));
      if (recipe == null) {
        throw new Exception("Recipe not found");
      }
      cookbook.addRecipe(recipe);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void searchForGrocery() {
    try {
      String name = utils.getString("Enter grocery name: ");
      Grocery grocery = groceryRegister.searchForGrocery(name);
      if (grocery == null) {
        throw new Exception("Grocery not found");
      }
      System.out.println("Found grocery:\n" + grocery.getFormattedString() + "\n");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void listGroceries() {
    for (Grocery grocery : groceryRegister.groceries) {
      System.out.println("\n" + grocery.getFormattedString());
    }
  }

  public void listRecipes() {
    for (Recipe recipe : recipeRegister.recipies) {
      System.out.println("\n" + recipe.getFormattedString());
    }
  }

  public void listCookbooks() {
    for (Cookbook cookbook : cookbookRegister.cookbooks) {
      System.out.println("\n" + cookbook.getFormattedString());
    }
  }

  public void listExpiredGroceries() {
    for (Grocery grocery : groceryRegister.getExpired()) {
      System.out.println("\n" + grocery.getFormattedString());
    }
  }

  public void listSortedGroceries() {
    for (Grocery grocery : groceryRegister.getSorted()) {
      System.out.println("\n" + grocery.getFormattedString());
    }
  }

  public void suggestCookbookRecipies() {
    try {
      Cookbook cookbook =
          cookbookRegister.searchForCookbook(utils.getString("Enter cookbook name: "));
      if (cookbook == null) {
        throw new Exception("Cookbook not found");
      }
      for (Recipe recipe : cookbook.recipes) {
        if (groceryRegister.containsRecipe(recipe)) {
          System.out.println(recipe.getFormattedString());
        } else {
          System.out.println("Missing ingredients for recipe: " + recipe.name);
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void checkRecipeIngredients() {
    try {
      String recipeName = utils.getString("Enter recipe name: ");
      Recipe recipe = recipeRegister.searchForRecipe(recipeName);
      if (recipe == null) {
        throw new Exception("Recipe not found");
      }
      boolean containsAllIngredients = groceryRegister.containsRecipe(recipe);
      if (containsAllIngredients) {
        System.out.println("All ingredients are available");
      } else {
        System.out.println("Missing ingredients");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void listGroceriesBeforeDate() {
    try {
      Date date = utils.getDate("Enter date (dd/MM/yyyy): ");
      for (Grocery grocery : groceryRegister.getGroceriesBeforeDate(date)) {
        System.out.println(grocery.getFormattedString());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
