package org.horrorscope.Services;
import org.horrorscope.Models.User;
import org.horrorscope.Repos.UserRepo;
import java.util.List;

public class UserService {
    private UserRepo userRepo;
    public UserService(){userRepo = new UserRepo();}
    public int createUser(User user){return userRepo.createUser(user);}
    public User userLogin(User user){return userRepo.userLogin(user);}
    public User getById(int id){return userRepo.getById(id);}
    public User getUserByUsername(String userName){return userRepo.getUserByUserName(userName);}
    public User updateMood(User user){return userRepo.updateMood(user);}
}
