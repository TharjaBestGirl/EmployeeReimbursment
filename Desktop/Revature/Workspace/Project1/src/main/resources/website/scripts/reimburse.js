var url = 'http://localhost:8080/reim';
var url2 = 'http://localhost:8080/reimid';
var url3 = 'http://localhost:8080/addreim';
var url4 = 'http://localhost:8080/updatereim';

function getAllReimbursements() {
    console.log("it works");
    fetch(url)
    .then(response => response.json())  // convert to json
    .then(json => displayData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}

function getReimbursementsById() {
    console.log("it works 2");
    fetch(url2)
    .then(response => response.json())  // convert to json
    .then(json => displayData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}

function displayData(response) {
    var dataSection = document.getElementById('flyingTunaFish');
    
   console.log(response.length)
   var list=document.createElement("ul");
   
const table = document.getElementById("flyingTunaFish");

for (var i=0; i < response.length; i++) {
    var tr = document.createElement('tr');
    var s = response[i];
    console.log("test");

    var td = document.createElement('td');
    td.innerHTML = s.id;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.employee_id;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.manager_id;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.type;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.amount;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.description;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.submit;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.resolve;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.resolved;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.accepted;
    tr.appendChild(td);

    table.appendChild(tr);
   dataSection.appendChild(list);
	}
}

function checkMan() {
	console.log("Hacker voice: I'm in")
    getAllReimbursements()
}

async function resolveFunction(id, accepted) {
    let username1 = { id: id, accepted: accepted};
    let response = await fetch(url4 , {
        method: 'PUT',
        redirect: 'follow',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(username1)
        });
        
    let result = await response.text();
    
    var dataSection = document.getElementById('flyingTunaFish');
    dataSection.innerHTML="";
    
    getAllReimbursements();
    
    window.location.href="/mytable1.html";
}

function resolveReimbursement() {
    console.log("Tuna")
    let id = document.getElementById("caseid").value
    if(document.getElementById('accepted').checked){
		console.log(id , true)
    	resolveFunction(id, true);
	}
	else {
		console.log(id , false)
		resolveFunction(id, false);
	}
    
    
}

async function addFunction(type, amount, description) {
    let username1 = { type: type, amount: amount, description: description};
    let response = await fetch(url3 , {
        method: 'POST',
        redirect: 'follow',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(username1)
        });
        
    let result = await response.text();
    
    var dataSection = document.getElementById('flyingTunaFish');
    dataSection.innerHTML="";
    
    getReimbursementsById();
    
    window.location.href="/mytable2.html";
}

function addReimbursement() {
    console.log("Tuna")
    let type = document.getElementById("type").value
    let amount = document.getElementById("amt").value
    let description = document.getElementById("desc").value
    addFunction(type, amount, description);
}