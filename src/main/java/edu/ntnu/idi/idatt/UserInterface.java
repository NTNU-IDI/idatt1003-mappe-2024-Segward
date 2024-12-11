package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.Utils.Utils;
import edu.ntnu.idi.idatt.registers.*;
import edu.ntnu.idi.idatt.types.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The user interface of the application.
 *
 * <p>This class is responsible for handling user input and displaying information to the user.
 */
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
  private final int SUGGEST_COOKBOOK_RECIPES = 14;
  private final int CHECK_RECIPE_INGREDIENTS = 15;
  private final int EXIT = 16;
  private Utils utils = new Utils();
  public GroceryRegister groceryRegister;
  public CookbookRegister cookbookRegister;
  public RecipeRegister recipeRegister;

  /**
   * Initializes the user interface.
   *
   * <p>Initializes the grocery, cookbook, and recipe registers and adds sample groceries, recipes,
   * and cookbooks.
   *
   * @throws Exception if an error occurs
   */
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

  /**
   * Starts the user interface.
   *
   * <p>Displays the main menu and handles user input. Stops when the user chooses to exit.
   */
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

        case SUGGEST_COOKBOOK_RECIPES:
          suggestCookbookRecipes();
          break;

        case CHECK_RECIPE_INGREDIENTS:
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

  /** Creates and adds sample groceries to the grocery register. */
  public void addSampleGroceries() {
    groceryRegister.add(new Grocery("Milk", "liter", 10, 10, utils.getFutureDate(5)));
    groceryRegister.add(new Grocery("Egg", "pcs", 10, 10, utils.getFutureDate(5)));
    groceryRegister.add(new Grocery("Flour", "kg", 10, 10, utils.getFutureDate(100)));
    groceryRegister.add(new Grocery("Sugar", "kg", 10, 10, utils.getPastDate(3)));
    groceryRegister.add(new Grocery("Butter", "kg", 10, 10, utils.getPastDate(1)));
  }

  /** Creates and adds sample recipes to the recipe register. */
  public void addSampleRecipes() {
    Ingredient ingredient1 = new Ingredient("Milk", "liter", 1);
    Ingredient ingredient2 = new Ingredient("Egg", "pcs", 2);
    Ingredient ingredient3 = new Ingredient("Flour", "kg", 0.5);
    ArrayList<Ingredient> ingredients1 =
        new ArrayList<>(List.of(ingredient1, ingredient2, ingredient3));
    ArrayList<Ingredient> ingredients2 = new ArrayList<>(List.of(ingredient1, ingredient2));
    ArrayList<Ingredient> ingredients3 = new ArrayList<>(List.of(ingredient1, ingredient3));
    ArrayList<String> authors = new ArrayList<>(List.of("John Doe", "Jane Doe", "Jack Doe", "Jill Doe"));
    recipeRegister.add(new Recipe("Pancake", "Delicious pancake", "Mix and fry", ingredients1, authors));
    recipeRegister.add(new Recipe("Waffle", "Delicious waffle", "Mix and fry", ingredients2, authors));
    recipeRegister.add(new Recipe("Cake", "Delicious cake", "Mix and bake", ingredients3, authors));
  }

  /** Creates and adds sample cookbooks to the cookbook register. */
  public void addSampleCookbooks() {
    Cookbook cookbook1 = new Cookbook("Breakfast");
    Cookbook cookbook2 = new Cookbook("Dessert");
    cookbook1.add(recipeRegister.find("Pancake"));
    cookbook1.add(recipeRegister.find("Waffle"));
    cookbook2.add(recipeRegister.find("Cake"));
    cookbookRegister.add(cookbook1);
    cookbookRegister.add(cookbook2);
  }

  /**
   * Registers a grocery.
   *
   * <p>Gets grocery information from the user and adds it to the grocery register.
   *
   * @throws Exception if an error occurs
   */
  private void registerGrocery() {
    try {
      Grocery grocery = utils.getGrocery();
      groceryRegister.add(grocery);
      System.out.println("Grocery successfully added");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Registers a recipe.
   *
   * <p>Gets recipe information from the user and adds it to the recipe register.
   *
   * @throws Exception if an error occurs
   */
  private void registerRecipe() {
    try {
      Recipe recipe = utils.getRecipe();
      recipeRegister.add(recipe);
      System.out.println("Recipe successfully added");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Registers a cookbook.
   *
   * <p>Gets cookbook information from the user and adds it to the cookbook register.
   *
   * @throws Exception if an error occurs
   */
  private void registerCookbook() {
    try {
      Cookbook cookbook = utils.getCookbook();
      cookbookRegister.add(cookbook);
      System.out.println("Cookbook successfully added");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Adds amount to a grocery.
   *
   * <p>Gets grocery name and amount from the user and adds the amount to the grocery.
   */
  private void addGroceryAmount() {
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

  /**
   * Removes amount from a grocery.
   *
   * <p>Gets grocery name and amount from the user and removes the amount from the grocery. If the
   * grocery amount is less than or equal to 0, the grocery is removed from the grocery register.
   */
  private void removeGroceryAmount() {
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

  /**
   * Adds a recipe to a cookbook.
   *
   * <p>Gets cookbook name and recipe name from the user and adds the recipe to the cookbook.
   */
  private void addRecipeToCookbook() {
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
    cookbook.add(recipe);
  }

  /** Searches for a grocery by name using the grocery registers find method. */
  private void searchForGrocery() {
    String name = utils.getString("Enter grocery name: ");
    Grocery grocery = groceryRegister.find(name);
    if (grocery == null) {
      System.out.println("Grocery not found");
    } else {
      System.out.println(grocery.getFormattedString());
    }
  }

  /** Lists all groceries in the grocery register. */
  private void listGroceries() {
    groceryRegister.groceries.forEach(g -> System.out.println(g.getFormattedString()));
  }

  /** Lists all recipes in the recipe register. */
  private void listRecipes() {
    recipeRegister.recipes.forEach(r -> System.out.println(r.getFormattedString()));
  }

  /** Lists all cookbooks in the cookbook register. */
  private void listCookbooks() {
    cookbookRegister.cookbooks.forEach(c -> System.out.println(c.getFormattedString()));
  }

  /** Lists all groceries in the grocery register sorted by name. */
  private void listSortedGroceries() {
    groceryRegister.getSorted().forEach(g -> System.out.println(g.getFormattedString()));
  }

  /** Lists all expired groceries in the grocery register. */
  private void listExpiredGroceries() {
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
    System.out.println("\nTotal cost of expired groceries: " + totalCost);
  }

  /**
   * Suggests recipes from cookbooks based on available groceries.
   *
   * <p>Iterates over all cookbooks and calls suggestRecipes for each cookbook.
   */
  private void suggestCookbookRecipes() {
    if (groceryRegister.groceries.isEmpty()) {
      System.out.println("No groceries available");
      return;
    }
    if (cookbookRegister.cookbooks.isEmpty()) {
      System.out.println("No cookbooks available");
      return;
    }
    cookbookRegister.cookbooks.forEach(this::suggestRecipes);
  }

  /**
   * Suggests recipes from a cookbook based on available groceries in the grocery register.
   *
   * @param cookbook the cookbook used when suggesting recipes
   */
  private void suggestRecipes(Cookbook cookbook) {
    boolean containsAtleastOneRecipe = false;
    System.out.println("\nSuggested recipes for " + cookbook.name);
    for (Recipe recipe : cookbook.recipes) {
      boolean containsAllIngredients = groceryRegister.hasSufficientIngredients(recipe.ingredients);
      if (containsAllIngredients) {
        System.out.println(recipe.getFormattedString());
        containsAtleastOneRecipe = true;
      }
    }
    if (!containsAtleastOneRecipe) {
      System.out.println("\nNo recipes available for " + cookbook.name);
    }
  }

  /** Checks if a recipe can be made based on available groceries in the grocery register. */
  private void checkRecipeIngredients() {
    if (groceryRegister.groceries.isEmpty()) {
      System.out.println("No groceries available");
      return;
    }
    if (recipeRegister.recipes.isEmpty()) {
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

  /** Lists all groceries in the grocery register that expire before a given date. */
  private void listGroceriesBeforeDate() {
    Date date = utils.getDate("Enter date (dd/MM/yyyy): ");
    for (Grocery grocery : groceryRegister.getGroceriesBeforeDate(date)) {
      System.out.println(grocery.getFormattedString());
    }
  }
}
