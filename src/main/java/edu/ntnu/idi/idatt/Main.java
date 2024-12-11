package edu.ntnu.idi.idatt;

/**
 * The main class of the application.
 *
 * <p>This class is responsible for initializing and starting the user interface.
 */
public class Main {

  /**
   * The main method of the application.
   *
   * <p>This method initializes and starts the user interface.
   */
  public static void main(String[] args) {
    UserInterface userInterface = new UserInterface();
    userInterface.init();
    userInterface.start();
  }
}
