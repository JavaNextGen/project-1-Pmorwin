const url = "http://localhost:3000/";


console.log("======================================================================(HTML Navigation Listeners)")
document.getElementById("adminMenuButton").addEventListener("click", adminMenuPageRedirect);
console.log("=================================================================================================")

console.log("==========================================================(Create Reimbursement Request Listener)")
document.getElementById("submitRequestButton").addEventListener("click", submitRequest);
console.log("=================================================================================================")







console.log("================================================================================(HTML Navigation)")
async function adminMenuPageRedirect() {
    window.location.href = "file:///C:/Users/Desktop/Desktop/Work/VS%20Code/Project%201%20Front%20End/Admin%20Menu.html";
  }   
console.log("=================================================================================================")

console.log("===================================================================(Create Reimbursement Request)")
async function submitRequest(){

}
console.log("=================================================================================================")