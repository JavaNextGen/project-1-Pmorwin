const url = "http://localhost:3000/";

console.log("======================================================================(HTML Navigation Listeners)")
console.log("=================================================================================================")


console.log("=======================================================================(Login Requests Listeners)")
document.getElementById("loginButton").addEventListener("click", loginRequest);
console.log("=================================================================================================")



console.log("==================================================================================(Login Request)")
async function loginRequest(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    let user = {
        employee_username: usern,
        employee_password: userp
    }
    console.log(user);//here is working
    console.log(JSON.stringify(user));
    let response = await fetch (url + "login", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    })
    console.log(response.status);
    if(response.status=== 202){
        document.getElementById("loginRow").innerText="Welcome";
    }
    else{
        document.getElementById("loginRow").innerText="Login Failed. Please Refreash and Try again";
    }
}
console.log("=================================================================================================")



