const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("returnRequestReviewButton").addEventListener("click", requestReviewMenuPageRedirect);
console.log("=================================================================================================")


console.log("====================================================(Get Single Reimbursement Requests Listeners)")
document.getElementById("getSingleMiscellaneousButton").addEventListener("click", getSingleMiscellaneous);
console.log("=================================================================================================")



console.log("===========================================================(Put Reimbursement Requests Listeners)")
document.getElementById("approveMiscellaneousButton").addEventListener("click", approveMiscellaneous);
document.getElementById("denyMiscellaneousButton").addEventListener("click", denyMiscellaneous);
console.log("=================================================================================================")





console.log("===============================================================================(HTML Navigation )")
async function requestReviewMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Approve%20or%20Deny%20Menu.html";
  }   
console.log("=================================================================================================")



console.log("===============================================================(Get Single Reimbursement Requests)")
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
console.log("=================================================================================================")




console.log("===================================================================================(Put Requests)")
async function approveMiscellaneous(){

}
async function denyMiscellaneous(){

}
console.log("=================================================================================================")
