let formularioRegistro = document.forms.formularioRegistro;
let datosErroneos = false;

formularioRegistro.addEventListener("submit", comprobarFormulario);

for (campo of formularioRegistro) {

    if (campo.type === 'password') {

        campo.nextElementSibling.addEventListener("pointerover", verContrasena);
        campo.nextElementSibling.addEventListener("pointerout", ocultarContrasena);
    }
}

function verContrasena(evento) {

    this.previousElementSibling.type = "text";
}


function ocultarContrasena(evento) {

    this.previousElementSibling.type = "password";
}
function comprobarCamposRellenados() {

	let todosOk = true;

	for(let campo of formularioRegistro.elements) {

		if(campo.type === "text" && campo.value === "") {

			todosOk = false
		}
	}

	if (!todosOk) {

		let mensajeError = formularioGato.nextElementSibling;

		mensajeError.classList.add("bg-danger");

		mensajeError.innerHTML = "No se puede enviar el formulario con los datos vacíos";

		datosErroneos = true;
	}
}


function comprobarFormulario (evento) {

	evento.preventDefault();

	datosErroneos = false;

	comprobarCamposRellenados();

	if (!datosErroneos) {

		formularioRegistro.submit();
	}
}