'use strict';

let loginButton = document.getElementById("backtowelcome")
loginButton.addEventListener('click', async(event)=>{
    event.preventDefault();
    window.location.replace("./index.html");
})

let registerButton = document.getElementById("register");

registerButton.addEventListener('click', async(event)=>{
    event.preventDefault;

    let firstname = document.getElementById("firstName").value;
    let lastname = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let zodiac = document.getElementById("zodiacSign").value;
    console.log("aqui")
    let userRegInfo = {
        firstName : firstname,
        lastName : lastname,
        email : email,
        userName : username,
        passWord : password,
        zodiac : zodiac
    }

    let json = JSON.stringify(userRegInfo);

    try{
        console.log("here")
        const raw_response = await fetch('http://localhost:8080/register',
        {
            method:"POST",
            body: json
        })
        console.log("here2")
        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }
        console.log("here3")
        raw_response.json().then((data)=>{
            let registered = JSON.stringify(data)
            console.log("Registration Succesful.")
        })
    }catch(error){
        console.log(error);
    }
})