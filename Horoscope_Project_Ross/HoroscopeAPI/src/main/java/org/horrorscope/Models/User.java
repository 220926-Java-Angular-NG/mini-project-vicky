package org.horrorscope.Models;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String passWord;
    private String zodiac;
    private String mood;

    public User(){
    }
    //ALL constructor
    public User(int userId, String firstName, String lastName, String email, String userName, String passWord, String zodiac, String mood){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.zodiac = zodiac;
        this.mood = mood;
    }
    public User(String firstName, String lastName, String userName, String passWord, String zodiac){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.zodiac = zodiac;
    }
    //login
    public User(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }
    public User(int userId){
        this.userId = userId;
    }
    //mood
    public User(int userId, String mood){
        this.userId = userId;
        this.mood = mood;
    }

    //Getters & Setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord(){
        return passWord;
    }
    public void setPassWord(){
        this.passWord = passWord;
    }
    public String getZodiac() {
        return zodiac;
    }
    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }

    public String toString() {
        return "User{" +
                "id=" + userId +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                ", zodiac='" + zodiac + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}
