package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.models.UserInterface;

public class Kitchen {
  public static void main(String[] args) {
    UserInterface userInterface = new UserInterface();
    userInterface.init();
    userInterface.start();
  }
}
