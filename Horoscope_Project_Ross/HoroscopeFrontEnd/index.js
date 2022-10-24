'use strict';

let registerButton = document.getElementById("register");

registerButton.addEventListener('click', (event)=>{
    event.preventDefault();
    console.log("user")
    window.location.replace("./registration.html");
}) 

let loginButton = document.getElementById("signin")
loginButton.addEventListener('click', async(event)=>{
    event.preventDefault();

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let userInfo = {
        userName: username,
        passWord: password
    }

    let json = JSON.stringify(userInfo);

    try{
        const raw_response = await fetch('http://localhost:8080/login',
        {
            method:"POST",
            body: json
        })
        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }
        raw_response.json().then((data)=>{
            let loggedIn = JSON.stringify(data)
            localStorage.setItem("currentUser", loggedIn)
            window.location.replace("./home.html");
        })
    }catch(error){
        console.log(error);
    }
})