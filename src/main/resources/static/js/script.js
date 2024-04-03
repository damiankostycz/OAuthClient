const login = document.getElementById("login-button");
const modal = document.getElementById("modal-login");
const close = document.getElementById("close-modal");

login.onclick = function (){
    modal.style.display = 'block';
}
close.onclick = function (){
    modal.style.display = 'none';
}
