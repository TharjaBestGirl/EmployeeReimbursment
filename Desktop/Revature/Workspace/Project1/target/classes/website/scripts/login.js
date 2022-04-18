var url = "http://localhost:8080/"

async function loginFunction(username, pass) {
    let username1 = { username: username, password: pass};
    console.log(username1)
    console.log("Hacker voice: I'm in")
    let response = await fetch(url + 'login', {
        method: 'POST',
        redirect: 'follow',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(username1)
        });
        
    let result = await response.json();
    console.log(result.username);
    console.log(result.password);
    if (result.username === null) {
        alert("Incorrect username or password. Try again.")
        window.location.href="/login.html";
    } 
    else {
        if (result.manager == true) {
			console.log("Boys Man Man")
            window.location.href="/index1.html";
        } else {
			console.log("Dont Stop me now")
            window.location.href="/index2.html";
        }
    }
}
console.log("Hacker voice: I'm out")

function getInput() {
    console.log("Tuna")
    let username = document.getElementById("user").value
    let pass = document.getElementById("pass").value
    console.log(username , pass)
    loginFunction(username, pass);
}