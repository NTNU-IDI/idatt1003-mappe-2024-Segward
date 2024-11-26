package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.models.UserInterface;

/**
 * @author Gustav Skyberg
 * @version 1.1
 * @since 1.0
 */
public class Main {
  public static void main(String[] args) {
    UserInterface userInterface = new UserInterface();
    userInterface.init();
    userInterface.start();
  }
}
