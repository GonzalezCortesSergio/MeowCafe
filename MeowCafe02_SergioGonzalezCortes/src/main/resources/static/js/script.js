let formularioGato = document.forms.formularioGato;
let datosErroneos = false;

formularioGato.addEventListener("submit", comprobarFormulario);

function comprobarCamposRellenados() {
	
	let todosOk = true;
	
	for(let campo of formularioGato.elements) {
		
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
		
		formularioGato.submit();
	}
}