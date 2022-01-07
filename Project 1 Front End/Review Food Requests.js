const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
console.log("=================================================================================================")



console.log("====================================================(Get Single Reimbursement Requests Listeners)")
document.getElementById("foodSingleButton").addEventListener("click", getSingleFood);
console.log("=================================================================================================")



console.log("===========================================================(Put Reimbursement Requests Listeners)")
document.getElementById("approveFoodButton").addEventListener("click", approveFood);
document.getElementById("denyFoodButton").addEventListener("click", denyFood);
console.log("=================================================================================================")





console.log("===============================================================(Get Single Reimbursement Requests)")
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
console.log("=================================================================================================")



console.log("===================================================================================(Put Requests)")
async function approveFood(){

}
async function denyFood(){

}
console.log("=================================================================================================")

