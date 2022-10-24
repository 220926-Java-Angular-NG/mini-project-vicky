'use strict';
let signout = document.getElementById("signout")
signout.addEventListener('click', async(event)=>{
    event.preventDefault();
    window.location.replace("./index.html");
})

let currentUser = localStorage.getItem("currentUser");
currentUser = JSON.parse(currentUser);
console.log(currentUser);
//get first name
let firstName = document.getElementById("firstName");
firstName.innerHTML = `${currentUser.firstName}`
//get sun sign
let zodiac = document.getElementById("zodiac");
zodiac.innerHTML = `${currentUser.zodiac}`

let horoButton = document.getElementById("dailyVibe");
horoButton.addEventListener('click', async()=>{
    let input = currentUser.zodiac;
    try{
        const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${input}/today`);
        if(!raw_response.ok){
            alert(`Error: ${raw_response.status}`)
        }
        const json_data = await raw_response.json();
        console.log(json_data);
        printToPage(json_data);
        currentUser.mood = json_data.meta.mood;
        console.log(currentUser);
        updateMood();
    }
    catch(error){
        console.log(error);
    }
});

function printToPage(json_data){
    var input = document.getElementById("horrorscope");
    var horrorscope = document.createElement('h4');
    input.innerHTML = '';
    horrorscope.innerHTML = `${json_data.horoscope}`
    input.append(horrorscope);
    var br = document.createElement('br');
    input.append(br);
}

async function updateMood(){
    
    let json = JSON.stringify(currentUser);
    console.log(json)
    try{
        const raw_response = await fetch('http://localhost:8080/user',
        {
            method:"PUT",
            body: json
        })
        if(!raw_response.ok){
            throw new Error(raw_response.status);
        }
        raw_response.json().then((data)=>{
            let loggedIn = JSON.stringify(data);
            localStorage.setItem("currentUser", loggedIn);
        })
    }catch(error){
        console.log(error);
    }
}

let moody = document.getElementById("getMood");
getMood.addEventListener('click',async ()=>{
    printMood();
});

function printMood(){
    var moods = document.getElementById("yourMood");
    var yourMood = document.createElement('h4');
    moods.innerHTML = '';
    yourMood.innerHTML = `${currentUser.mood}`
    moods.append(yourMood);
    var hr = document.createElement('hr');
    moods.append(hr);
}