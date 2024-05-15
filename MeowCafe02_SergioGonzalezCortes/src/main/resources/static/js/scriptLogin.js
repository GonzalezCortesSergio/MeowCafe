let formularioLogin = document.forms.formularioLogin;

let password = formularioLogin.elements.password;

password.nextElementSibling.addEventListener("pointerover", mostrarContrasena);
password.nextElementSibling.addEventListener("pointerout", ocultarContrasena);


function mostrarContrasena() {

    this.previousElementSibling.type = "text";
}

function ocultarContrasena() {

    this.previousElementSibling.type = "password";
}