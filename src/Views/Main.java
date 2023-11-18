package Views;

import Controllers.LoginController;

public class Main {
    public static void main(String[] args) {
        LoginPageView loginPageView = new LoginPageView();
        LoginController loginController = new LoginController(loginPageView);
    }
}