const url = "http://localhost:3000/";

console.log("=========================================================================(Get Requests Listeners)")
console.log("===========================================================(Get Reimbursement Requests Listeners)")
document.getElementById("getLodgingButton").addEventListener("click", getLodging)
document.getElementById("getTravelButton").addEventListener("click", getTravel)
document.getElementById("getFoodButton").addEventListener("click", getFood);
document.getElementById("getMiscellaneousButton").addEventListener("click", getMiscellaneous);
console.log("====================================================(Get Single Reimbursement Requests Listeners)")
document.getElementById("getSingleLodgingButton").addEventListener("click", getSingleLodging)
document.getElementById("getSingleTravelButton").addEventListener("click", getSingleTravel)
document.getElementById("getSingleFoodButton").addEventListener("click", getSingleFood);
document.getElementById("getSingleMiscellaneousButton").addEventListener("click", getSingleMiscellaneous);
console.log("=============================================(Get Reimbursement Requests By Employee ID Listener)")
document.getElementById("getEmployeeRequestsButton").addEventListener("click", getEmployeeRequests);
console.log("=================================================================================================")

console.log("========================================================================(Post Requests Listeners)")
console.log("=================================================================================================")


console.log("===========================================================(Put Reimbursement Requests Listeners)")
document.getElementById("approveLodgingButton").addEventListener("click", approveLodging)
document.getElementById("approveTravelButton").addEventListener("click", approveTravel)
document.getElementById("approveFoodButton").addEventListener("click", approveFood);
document.getElementById("approveMiscellaneousButton").addEventListener("click", approveMiscellaneous);
document.getElementById("denyLodgingButton").addEventListener("click", denyLodging)
document.getElementById("denyTravelButton").addEventListener("click", denyTravel)
document.getElementById("denyFoodButton").addEventListener("click", denyFood);
document.getElementById("denyMiscellaneousButton").addEventListener("click", denyMiscellaneous);
console.log("=================================================================================================")

















console.log("===================================================================================(Get Requests)")
console.log("=====================================================================(Get Reimbursement Requests)")
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

            document.getElementById("reimbursementBody").appendChild(row);
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

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
async function getFood() {
    let response = await fetch(url + "food");

    if(response.status === 200){
        let data = await response.json();
        
        for(let food of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = food.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = food.food_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = food.food_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = food.status;
            row.appendChild(cell5);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
async function getMiscellaneous() {
    let response = await fetch(url + "miscellaneous");

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
            cell3.innerHTML = misc.misc_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = misc.status;
            row.appendChild(cell5);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
console.log("===============================================================(Get Single Reimbursement Requests)")
async function getSingleLodging() {
    let response = await fetch(url + "lodging_status");

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

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
async function getSingleTravel() {
    let response = await fetch(url + "travel_status");

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

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
async function getSingleFood() {
    let response = await fetch(url + "food_status");

    if(response.status === 200){
        let data = await response.json();
        
        for(let food of data){
            let row = document.createElement("tr");
          
            let cell = document.createElement("td");
            cell.innerHTML = food.e_id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = food.food_cost;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = food.food_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = food.status;
            row.appendChild(cell5);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
async function getSingleMiscellaneous() {
    let response = await fetch(url + "miscellaneous_status");

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
            cell3.innerHTML = misc.misc_info;
            row.appendChild(cell3);

            let cell5 = document.createElement("td");
            cell5.innerHTML = misc.status;
            row.appendChild(cell5);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
}
console.log("=======================================================(Get Reimbursement Requests By Employee ID)")
async function getEmployeeRequests(){
    let userInput = document.getElementById("employee_id").value;

    let response = await fetch(url + "employee/" + userInput); 

    if(response.status === 200){
        let data = await response.json();
        
        for(let lodging of data){
           //ask ben how to do this :)
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

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }  
};
console.log("=================================================================================================")


console.log("==================================================================================(Post Requests)")
console.log("===================================================================(Create Reimbursement Request)")


console.log("==========================================~~~~~~~~~~~~~=========================(Create Employee)")
console.log("=================================================================================================")




console.log("===================================================================================(Put Requests)")
async function approveLodging(){

}
async function approveTravel(){

}
async function approveFood(){

}
async function approveMiscellaneous(){

}
async function denyLodging(){

}
async function denyTravel(){

}
async function denyFood(){

}
async function denyMiscellaneous(){

}
console.log("=================================================================================================")
