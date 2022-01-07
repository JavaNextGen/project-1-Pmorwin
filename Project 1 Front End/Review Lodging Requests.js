const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
console.log("=================================================================================================")



console.log("====================================================(Get Single Reimbursement Requests Listeners)")
document.getElementById("lodgingSingleButton").addEventListener("click", getSingleLodging);
console.log("=================================================================================================")


console.log("===========================================================(Put Reimbursement Requests Listeners)")
document.getElementById("approveLodgingButton").addEventListener("click", approveLodging);
document.getElementById("denyLodgingButton").addEventListener("click", denyLodging);
console.log("=================================================================================================")






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


console.log("===================================================================================(Put Requests)")
async function approveLodging(){

}
async function denyLodging(){

}
console.log("=================================================================================================")
