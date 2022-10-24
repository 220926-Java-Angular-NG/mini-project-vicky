package org.horrorscope;
import org.horrorscope.Controllers.UserController;
import org.horrorscope.Models.User;
import org.horrorscope.Models.CurrentUser;
import org.horrorscope.Repos.UserRepo;
import org.horrorscope.Services.UserService;
import org.horrorscope.Utils.ConnectionManager;
import io.javalin.Javalin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Driver {
    public static void main(String[] args){
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        }).start(8080);

    UserService userService = new UserService();
        UserController userController = new UserController();

        app.post("/register", userController.createNewUser);
        app.post("/login", userController.userLogin);
        app.put("/user", userController.updateMood);
    }
}
