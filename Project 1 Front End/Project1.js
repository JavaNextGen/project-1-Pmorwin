const url = "http://localhost:3000/";

//document.getElementById("loginButton").addEventListener("click", login);
//document.getElementById("loginButton").onclick = login;
document.getElementById("lodgingButton").addEventListener("click", getLodging)


async function getLodging() {
    let response = await fetch(url + "lodging");

    if(response.status === 200){
        let data = await response.json();
        
        for(let lodging of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = lodging.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = lodging.lodging_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = lodging.lodging_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = lodging.status;
            row.appendChild(cell5);

            document.getElementById("lodgingBody").appendChild(row);
        }
    }  
}
async function getTravel() {
    let response = await fetch(url + "travel");

    if(response.status === 200){
        let data = await response.json();
        
        for(let travel of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = travel.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = travel.travel_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = travel.travel_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = travel.status;
            row.appendChild(cell5);

            document.getElementById("travelBody").appendChild(row);
        }
    }  
}
async function getFood() {
    let response = await fetch(url + "food");

    if(response.status === 200){
        let data = await response.json();food
        
        for(let food of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = food.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = food.food_cost;
            row.appendChild(cell2);
food
            let cell3 = document.createElement("td");
            cell3.innerHTML = food.food_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = food.status;
            row.appendChild(cell5);

            document.getElementById("foodBody").appendChild(row);
        }
    }  
}
async function getMiscellaneous() {
    let response = await fetch(url + "misc");

    if(response.status === 200){
        let data = await response.json();
        
        for(let misc of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = misc.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = misc.misc_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = lodging.misc_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = misc.status;
            row.appendChild(cell5);

            document.getElementById("miscBody").appendChild(row);
        }
    }  
}



