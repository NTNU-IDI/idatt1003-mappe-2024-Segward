package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.Utils.Utils;
import edu.ntnu.idi.idatt.registers.*;
import edu.ntnu.idi.idatt.types.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * The user interface of the application.
 *
 * <p>This class is responsible for handling user input and displaying information to the user.
 */
public class UserInterface {
  private Utils utils = new Utils();
  public GroceryRegister groceryRegister;
  public CookbookRegister cookbookRegister;
  public RecipeRegister recipeRegister;

  /**
   * Initializes the user interface.
   *
   * <p>Initializes the grocery, cookbook, and recipe registers and adds sample groceries, recipes,
   * and cookbooks.
   */
  public void init() {
    groceryRegister = new GroceryRegister();
    cookbookRegister = new CookbookRegister();
    recipeRegister = new RecipeRegister();
    addSampleGroceries();
    addSampleRecipes();
    addSampleCookbooks();
  }

  /**
   * Starts the user interface.
   *
   * <p>Displays the main menu and handles user input. Stops when the user chooses to exit.
   */

  /**
   * 1. Register grocery 2. Register recipe 3. Register cookbook 4. Add grocery amount 5. Remove
   * grocery amount 6. Add recipe to cookbook 7. Search for grocery 8. List groceries 9. List
   * recipes 10. List cookbooks 11. List expired groceries 12. List sorted groceries 13. List
   * groceries before date 14. Suggest cookbook recipes 15. Check recipe ingredients 16. Exit
   */
  public void start() {
    boolean isRunning = true;
    while (isRunning) {
      switch (utils.getUserInputOption()) {
        case 1 -> registerGrocery();
        case 2 -> registerRecipe();
        case 3 -> registerCookbook();
        case 4 -> addGroceryAmount();
        case 5 -> removeGroceryAmount();
        case 6 -> addRecipeToCookbook();
        case 7 -> searchForGrocery();
        case 8 -> listGroceries();
        case 9 -> listRecipes();
        case 10 -> listCookbooks();
        case 11 -> listExpiredGroceries();
        case 12 -> listSortedGroceries();
        case 13 -> listGroceriesBeforeDate();
        case 14 -> suggestCookbookRecipes();
        case 15 -> checkRecipeIngredients();
        case 16 -> {
          utils.closeScanner();
          isRunning = false;
        }
        default -> {
          System.out.println("Invalid choice");
        }
      }
    }
  }

  /** Creates and adds sample groceries to the grocery register. */
  public void addSampleGroceries() {
    groceryRegister.add(new Grocery("Milk", "liter", 3, 10, utils.getFutureDate(5)));
    groceryRegister.add(new Grocery("Egg", "pcs", 12, 10, utils.getFutureDate(5)));
    groceryRegister.add(new Grocery("Flour", "kg", 3004, 10, utils.getFutureDate(100)));
    groceryRegister.add(new Grocery("Sugar", "kg", 10, 10, utils.getPastDate(3)));
    groceryRegister.add(new Grocery("Butter", "kg", 8, 10, utils.getPastDate(1)));
    groceryRegister.add(new Grocery("Salt", "kg", 4, 10, utils.getFutureDate(10)));
    groceryRegister.add(new Grocery("Pepper", "kg", 99, 10, utils.getFutureDate(10)));
    groceryRegister.add(new Grocery("Vanilla sugar", "kg", 2, 10, utils.getFutureDate(10)));
    groceryRegister.add(new Grocery("Baking powder", "kg", 1, 10, utils.getFutureDate(10)));
  }

  /** Creates and adds sample recipes to the recipe register. */
  public void addSampleRecipes() {
    Ingredient ingredient1 = new Ingredient("Milk", "liter", 3);
    Ingredient ingredient2 = new Ingredient("Egg", "pcs", 5);
    Ingredient ingredient3 = new Ingredient("Flour", "kg", 8);
    Ingredient ingredient4 = new Ingredient("Sugar", "kg", 4);
    Ingredient ingredient5 = new Ingredient("Butter", "kg", 3);
    Ingredient ingredient6 = new Ingredient("Salt", "kg", 19);

    ArrayList<Ingredient> ingredients1 = new ArrayList<>();
    ingredients1.add(ingredient1);
    ingredients1.add(ingredient2);
    ingredients1.add(ingredient3);
    ingredients1.add(ingredient4);

    ArrayList<Ingredient> ingredients2 = new ArrayList<>();
    ingredients2.add(ingredient1);
    ingredients2.add(ingredient2);
    ingredients2.add(ingredient3);
    ingredients2.add(ingredient4);
    ingredients2.add(ingredient6);

    ArrayList<Ingredient> ingredients3 = new ArrayList<>();
    ingredients3.add(ingredient1);
    ingredients3.add(ingredient2);
    ingredients3.add(ingredient3);
    ingredients3.add(ingredient4);
    ingredients3.add(ingredient5);

    recipeRegister.add(new Recipe("Pancake", "Delicious pancake", "Mix and fry", 4, ingredients1));
    recipeRegister.add(new Recipe("Waffle", "Delicious waffle", "Mix and fry", 3, ingredients2));
    recipeRegister.add(new Recipe("Cake", "Delicious cake", "Mix and bake", 4, ingredients3));
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
   * <p>Gets grocery name and amount from the user and adds the amount to the grocery. If the user
   * adds a negative amount and the grocery amount is less than or equal to 0, the grocery is
   * removed.
   */
  private void addGroceryAmount() {
    String name = utils.getString("Enter grocery name: ");
    double amount = utils.getDouble("Enter amount to add: ");
    try {
      groceryRegister.addAmount(name, amount);
    } catch (Exception e) {
      System.out.println(e.getMessage());
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
    try {
      groceryRegister.removeAmount(name, amount);
    } catch (Exception e) {
      System.out.println(e.getMessage());
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

    System.out.println("Total cost of expired groceries: " + totalCost);
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
    System.out.println("Cookbook: " + cookbook.name);
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
