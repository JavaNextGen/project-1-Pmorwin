const url = "http://localhost:3000/";


console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("returnEmployeeButton").addEventListener("click", employeeMenuPageRedirect);
console.log("=================================================================================================")


console.log("==========================================================(Create Reimbursement Request Listener)")
document.getElementById("submitRequestButton").addEventListener("click", submitRequest);
console.log("=================================================================================================")







console.log("================================================================================(HTML Navigation)")
async function employeeMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Employee%20Menu.html";
  }   
console.log("=================================================================================================")

console.log("===================================================================(Create Reimbursement Request)")
async function submitRequest(){
    
}
console.log("=================================================================================================")