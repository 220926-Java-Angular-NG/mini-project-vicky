package org.horrorscope.Models;

public class CurrentUser {
    public static User currentUser;

    private CurrentUser(){

    }
    public CurrentUser(User user){
        currentUser = user;
    }
}
