package org.horrorscope.Repos;

import org.horrorscope.Models.User;
import org.horrorscope.Utils.ConnectionManager;
import java.sql.*;

public class UserRepo{
    Connection conn;

    public UserRepo(){
        try{
            conn = ConnectionManager.getConnection();
            System.out.println(conn.getSchema());
        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }

    public int createUser(User user){
        try{
            String sql = "INSERT INTO users (user_id, first_name, last_name, email, user_name, pass_word, zodiac) VALUES (default, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserName());
            pstmt.setString(5, user.getPassWord());
            pstmt.setString(6, user.getZodiac());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt("user_id");
        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }
    public User userLogin(User user) {
        try{
            String sql = "SELECT * FROM users WHERE user_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("user_name").equals(user.getUserName()) && rs.getString("pass_word").equals(user.getPassWord())){
                return new User(rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("user_name"),
                        rs.getString("pass_word"),
                        rs.getString("zodiac"),
                        rs.getString("mood"));
            }
        }catch(Exception e){
            System.out.println("This is the userDAO: " + e.getMessage());
        }
        return null;
    }

    public User getById(int id) {
        try{
            String sql = "SELECT * FROM users WHERE user_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    public User getUserByUserName(String userName){
        try {
            String sql = "SELECT * FROM users WHERE user_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                return new User(rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("user_name"),
                        rs.getString("pass_word"),
                        rs.getString("zodiac"),
                        rs.getString("mood"));
            }
        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    public User updateMood(User user){
        try {
            String sql = "UPDATE users SET mood = ? WHERE user_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getMood());
            pstmt.setString(2, user.getUserName());
            pstmt.executeUpdate();
            return user;
        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return null;
    }
}
