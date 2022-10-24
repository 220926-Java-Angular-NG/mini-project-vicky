package org.horrorscope.Controllers;

import org.horrorscope.Models.CurrentUser;
import org.horrorscope.Models.User;
import org.horrorscope.Services.UserService;
import io.javalin.http.Handler;

public class UserController {
    UserService userService;

    public UserController() {userService = new UserService();}

    public Handler userLogin = context -> {
        User user = context.bodyAsClass(User.class);
        CurrentUser.currentUser = userService.userLogin(user);
        System.out.println(CurrentUser.currentUser.toString());
        if(CurrentUser.currentUser != null){
            context.json(CurrentUser.currentUser).status(202);
        }else{
            context.result("Unable to find user.").status(400);
        }
    };

    public Handler createNewUser = context -> {
        User user = context.bodyAsClass(User.class);
        int userId = userService.createUser(user);
        System.out.println(user.toString());
        if(userId > 0){
            user.setUserId(userId);
            context.json(userId).status(200);
        }else{
            context.result("Unable to create user.").status(400);
        }
    };

    public Handler getUserId = context -> {
        String param = context.pathParam("user_id");
        try{
            int userId = Integer.parseInt(param);
            User user = userService.getById(userId);
            if(user != null){
                context.json(user).result("User obtained.").status(202);
            }else{
                context.result("Unable to find user.").status(400);
            }
        }catch(NumberFormatException nFException){
            System.out.println(nFException.getMessage());
        }
    };

    public Handler updateMood = context -> {
        User user = context.bodyAsClass(User.class);
        if(user!=null){
            System.out.println(user);
            User horoValidation = userService.updateMood(user);
            System.out.println(horoValidation);
            if(horoValidation!=null){
                context.json(user).status(200);
            }else{
                context.result("Are you sure you exist?").status(404);
            }
        }else{
            context.result("Couldn't find your mood").status(400);
        }
    };
}
