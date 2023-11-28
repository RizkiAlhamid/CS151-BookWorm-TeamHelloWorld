import Controllers.LoginPageController;
import Controllers.ManageBookPageController;
import Controllers.UserHomePageController;
import Models.User;
import Views.LoginPageView;
import Views.ManageBookPageView;
import Views.UserHomePageView;

public class Main {
    public static void main(String[] args) {
        LoginPageView loginPageView = new LoginPageView();
        LoginPageController loginController = new LoginPageController(loginPageView);
//
//        ManageBookPageView view = new ManageBookPageView();
//        ManageBookPageController controller = new ManageBookPageController(view);

//        ManageUserPageView view = new ManageUserPageView();
//        ManageUserPageController controller = new ManageUserPageController(view);

//        UserHomePageView view = new UserHomePageView(new User());
//        UserHomePageController controller = new UserHomePageController(view, new User());
    }
}