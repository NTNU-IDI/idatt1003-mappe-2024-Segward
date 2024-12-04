package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.registers.*;
import edu.ntnu.idi.idatt.types.*;
import edu.ntnu.idi.idatt.util.DateUtil;
import edu.ntnu.idi.idatt.util.UserInputUtil;
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
  private final int LIST_AVAILABLE_RECIPIES = 13;
  private final int CHECK_RECIPE_GROCERIES = 14;
  private final int LIST_EXPIRED_GROCERIES_BEFORE_GIVEN_DATE = 15;
  private final int EXIT = 16;
  private UserInputUtil userInputUtil = new UserInputUtil();
  private DateUtil dateUtil = new DateUtil();
  private GroceryRegister groceryRegister = new GroceryRegister();
  private CookbookRegister cookbookRegister = new CookbookRegister();
  private RecipeRegister recipeRegister = new RecipeRegister();

  public void init() {
    try {
      groceryRegister.add(new Grocery("Egg", "pcs", 10, 5.5, dateUtil.addDays(new Date(), 10)));
      groceryRegister.add(new Grocery("Milk", "l", 2, 15.5, dateUtil.addDays(new Date(), 5)));
      groceryRegister.add(new Grocery("Bread", "pcs", 5, 20.5, dateUtil.addDays(new Date(), 2)));
      groceryRegister.add(new Grocery("Butter", "g", 500, 30.5, dateUtil.addDays(new Date(), 7)));
      groceryRegister.add(new Grocery("Cheese", "g", 1000, 40.5, dateUtil.addDays(new Date(), 3)));
      Recipe scrambledEggs =
          new Recipe(
              "Scrambled eggs",
              "Delicious scrambled eggs",
              "This is a test instruction",
              new ArrayList<Ingredient>() {
                {
                  add(new Ingredient("Egg", "pcs", 2));
                  add(new Ingredient("Butter", "g", 10));
                }
              });
      Recipe sandwich =
          new Recipe(
              "Sandwich",
              "Delicious sandwich",
              "This is a test instruction",
              new ArrayList<Ingredient>() {
                {
                  add(new Ingredient("Bread", "pcs", 2));
                  add(new Ingredient("Cheese", "g", 10));
                }
              });
      Recipe omelette =
          new Recipe(
              "Omelette",
              "Delicious omelette",
              "This is a test instruction",
              new ArrayList<Ingredient>() {
                {
                  add(new Ingredient("Egg", "pcs", 2));
                  add(new Ingredient("Butter", "g", 10));
                }
              });
      recipeRegister.add(scrambledEggs);
      recipeRegister.add(sandwich);
      recipeRegister.add(omelette);
      Cookbook breakfastCookbook = new Cookbook("Breakfast");
      breakfastCookbook.addRecipe(scrambledEggs);
      breakfastCookbook.addRecipe(sandwich);
      cookbookRegister.add(breakfastCookbook);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void start() {
    boolean isRunning = true;
    while (isRunning) {

      switch (userInputUtil.getUserInputOption()) {
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

        case LIST_AVAILABLE_RECIPIES:
          listAvailableRecipes();
          break;

        case CHECK_RECIPE_GROCERIES:
          checkRecipeGroceries();
          break;

        case LIST_EXPIRED_GROCERIES_BEFORE_GIVEN_DATE:
          listExpiredGroceriesBeforeGivenDate();
          break;

        case EXIT:
          userInputUtil.closeScanner();
          isRunning = false;
          break;
        default:
          break;
      }
    }
  }

  public void registerGrocery() {
    try {
      Grocery grocery = userInputUtil.getGrocery();
      groceryRegister.add(grocery);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void registerRecipe() {
    try {
      Recipe recipe = userInputUtil.getRecipe();
      recipeRegister.add(recipe);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void registerCookbook() {
    try {
      Cookbook cookbook = userInputUtil.getCookbook();
      cookbookRegister.add(cookbook);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void addGroceryAmount() {
    try {
      String name = userInputUtil.getString("Enter grocery name: ");
      int amount = userInputUtil.getInt("Enter amount to add: ");
      groceryRegister.addAmount(name, amount);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void removeGroceryAmount() {
    try {
      String name = userInputUtil.getString("Enter grocery name: ");
      int amount = userInputUtil.getInt("Enter amount to remove: ");
      groceryRegister.removeAmount(name, amount);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void addRecipeToCookbook() {
    try {
      listCookbooks();
      String cookbookName = userInputUtil.getString("Enter cookbook name: ");
      Cookbook cookbook = cookbookRegister.searchForCookbook(cookbookName);
      if (cookbook == null) {
        System.out.println("Cookbook not found");
        return;
      }
      listRecipes();
      ArrayList<String> recipies =
          userInputUtil.getSeperatedString("Enter recipe names seperated by comma (,): ");
      for (String recipeName : recipies) {
        Recipe recipe = recipeRegister.searchForRecipe(recipeName);
        if (recipe != null) {
          cookbook.addRecipe(recipe);
        } else {
          System.out.println("Recipe not found: " + recipeName);
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void searchForGrocery() {
    try {
      String name = userInputUtil.getString("Enter grocery name: ");
      Grocery grocery = groceryRegister.searchForGrocery(name);
      if (grocery != null) {
        System.out.println(grocery);
      } else {
        System.out.println("Grocery not found");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void listGroceries() {
    groceryRegister.list();
  }

  public void listRecipes() {
    recipeRegister.list();
  }

  public void listCookbooks() {
    cookbookRegister.list();
  }

  public void listExpiredGroceries() {
    groceryRegister.listExpired();
  }

  public void listSortedGroceries() {
    groceryRegister.listSorted();
  }

  public void listAvailableRecipes() {
    try {
      String cookbookName = userInputUtil.getString("Enter cookbook name: ");
      Cookbook cookbook = cookbookRegister.searchForCookbook(cookbookName);
      if (cookbook != null) {
        groceryRegister.suggestRecipies(cookbook);
      } else {
        System.out.println("Cookbook not found");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void checkRecipeGroceries() {
    try {
      String recipeName = userInputUtil.getString("Enter recipe name: ");
      Recipe recipe = recipeRegister.searchForRecipe(recipeName);
      if (recipe != null) {
        groceryRegister.containsRecipe(recipe);
      } else {
        System.out.println("Recipe not found");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void listExpiredGroceriesBeforeGivenDate() {
    try {
      Date date = userInputUtil.getDate("Enter date (dd/MM/yyyy): ");
      groceryRegister.listExpiredBeforeDate(date);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
