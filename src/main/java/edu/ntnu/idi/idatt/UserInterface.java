package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.Utils.Utils;
import edu.ntnu.idi.idatt.registers.*;
import edu.ntnu.idi.idatt.types.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
      addSampleGroceries();
      addSampleRecipes();
      addSampleCookbooks();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private void addSampleGroceries() {
    groceryRegister.add(new Grocery("Milk", "liter", 10, 10, utils.getFutureDate(5)));
    groceryRegister.add(new Grocery("Egg", "pcs", 10, 10, utils.getFutureDate(5)));
    groceryRegister.add(new Grocery("Flour", "kg", 10, 10, utils.getFutureDate(100)));
    groceryRegister.add(new Grocery("Sugar", "kg", 10, 10, utils.getPastDate(3)));
    groceryRegister.add(new Grocery("Butter", "kg", 10, 10, utils.getPastDate(1)));
  }

  private void addSampleRecipes() {
    Ingredient ingredient1 = new Ingredient("Milk", "liter", 1);
    Ingredient ingredient2 = new Ingredient("Egg", "pcs", 2);
    Ingredient ingredient3 = new Ingredient("Flour", "kg", 0.5);
    ArrayList<Ingredient> ingredients1 =
        new ArrayList<>(List.of(ingredient1, ingredient2, ingredient3));
    ArrayList<Ingredient> ingredients2 = new ArrayList<>(List.of(ingredient1, ingredient2));
    ArrayList<Ingredient> ingredients3 = new ArrayList<>(List.of(ingredient1, ingredient3));
    recipeRegister.add(new Recipe("Pancake", "Delicious pancake", "Mix and fry", ingredients1));
    recipeRegister.add(new Recipe("Waffle", "Delicious waffle", "Mix and fry", ingredients2));
    recipeRegister.add(new Recipe("Cake", "Delicious cake", "Mix and bake", ingredients3));
  }

  private void addSampleCookbooks() {
    Cookbook cookbook1 = new Cookbook("Breakfast");
    Cookbook cookbook2 = new Cookbook("Dessert");
    cookbook1.addRecipe(recipeRegister.find("Pancake"));
    cookbook1.addRecipe(recipeRegister.find("Waffle"));
    cookbook2.addRecipe(recipeRegister.find("Cake"));
    cookbookRegister.add(cookbook1);
    cookbookRegister.add(cookbook2);
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
    try {
      Grocery grocery = utils.getGrocery();
      groceryRegister.add(grocery);
      System.out.println("Grocery successfully added");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
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
    Grocery grocery = groceryRegister.find(name);
    if (grocery == null) {
      System.out.println("Grocery not found");
      return;
    }
    grocery.setAmount(grocery.amount + amount);
    if (grocery.amount <= 0) {
      groceryRegister.remove(grocery);
    }
  }

  public void removeGroceryAmount() {
    String name = utils.getString("Enter grocery name: ");
    double amount = utils.getDouble("Enter amount to remove: ");
    Grocery grocery = groceryRegister.find(name);
    if (grocery == null) {
      System.out.println("Grocery not found");
      return;
    }
    grocery.setAmount(grocery.amount - amount);
    if (grocery.amount <= 0) {
      groceryRegister.remove(grocery);
    }
  }

  public void addRecipeToCookbook() {
    Cookbook cookbook = cookbookRegister.find(utils.getString("Enter cookbook name: "));
    if (cookbook == null) {
      System.out.println("Cookbook not found");
      return;
    }
    Recipe recipe = recipeRegister.find(utils.getString("Enter recipe name: "));
    if (recipe == null) {
      System.out.println("Cookbook not found");
      return;
    }
    cookbook.addRecipe(recipe);
  }

  public void searchForGrocery() {
    String name = utils.getString("Enter grocery name: ");
    Grocery grocery = groceryRegister.find(name);
    if (grocery == null) {
      System.out.println("Grocery not found");
    } else {
      System.out.println(grocery.getFormattedString());
    }
  }

  public void listGroceries() {
    groceryRegister.groceries.forEach(g -> System.out.println(g.getFormattedString()));
  }

  public void listRecipes() {
    recipeRegister.recipies.forEach(r -> System.out.println(r.getFormattedString()));
  }

  public void listCookbooks() {
    cookbookRegister.cookbooks.forEach(c -> System.out.println(c.getFormattedString()));
  }

  public void listExpiredGroceries() {
    ArrayList<Grocery> expiredGroceries = groceryRegister.getExpired();
    if (expiredGroceries.isEmpty()) {
      System.out.println("No expired groceries");
      return;
    }
    double totalCost = 0;
    for (Grocery grocery : expiredGroceries) {
      System.out.println(grocery.getFormattedString());
      totalCost += grocery.getPrice();
    }
    System.out.println("Total cost of expired groceries: " + totalCost);
  }

  public void listSortedGroceries() {
    groceryRegister.getSorted().forEach(g -> System.out.println(g.getFormattedString()));
  }

  public void suggestCookbookRecipies() {
    if (groceryRegister.groceries.isEmpty()) {
      System.out.println("No groceries available");
      return;
    }
    if (cookbookRegister.cookbooks.isEmpty()) {
      System.out.println("No cookbooks available");
      return;
    }
    cookbookRegister.cookbooks.forEach(this::suggestRecipies);
  }

  public void suggestRecipies(Cookbook cookbook) {
    boolean containsAtleastOneRecipe = false;
    for (Recipe recipe : cookbook.recipes) {
      boolean containsAllIngredients = groceryRegister.hasSufficientIngredients(recipe.ingredients);
      if (containsAllIngredients) {
        System.out.println(recipe.getFormattedString());
        containsAtleastOneRecipe = true;
      }
    }
    if (!containsAtleastOneRecipe) {
      System.out.println("No recipes available for " + cookbook.name);
    }
  }

  public void checkRecipeIngredients() {
    if (groceryRegister.groceries.isEmpty()) {
      System.out.println("No groceries available");
      return;
    }
    if (recipeRegister.recipies.isEmpty()) {
      System.out.println("No recipes available");
      return;
    }
    Recipe recipe = recipeRegister.find(utils.getString("Enter recipe name: "));
    if (recipe == null) {
      System.out.println("Recipe not found");
      return;
    }
    boolean containsAllIngredients = groceryRegister.hasSufficientIngredients(recipe.ingredients);
    if (containsAllIngredients) {
      System.out.println("All ingredients are available");
    } else {
      System.out.println("Missing ingredients");
    }
  }

  public void listGroceriesBeforeDate() {
    Date date = utils.getDate("Enter date (dd/MM/yyyy): ");
    for (Grocery grocery : groceryRegister.getGroceriesBeforeDate(date)) {
      System.out.println(grocery.getFormattedString());
    }
  }
}
