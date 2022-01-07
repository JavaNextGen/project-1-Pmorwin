const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
console.log("=================================================================================================") 



console.log("=============================================(Get Reimbursement Requests By Employee ID Listener)")
document.getElementById("getAdminEmployeeRequestsButton").addEventListener("click", getEmployeeRequests);
console.log("=================================================================================================")



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


