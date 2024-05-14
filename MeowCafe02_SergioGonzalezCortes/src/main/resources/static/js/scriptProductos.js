let formularioProducto = document.forms.formularioProducto;

let datosErroneos = false;


formularioProducto.addEventListener("submit", comprobar);

function caracterMaximoPrecio() {

   let precioProducto = formularioProducto.elements.precioProducto.value;

   if (precioProducto >= 999) {

    datosErroneos = true;

    let mensajeError = formularioProducto.elements.precioProducto.nextElementSibling;

    mensajeError.classList.add("bg-danger");

    mensajeError.innerHTML = "El precio del producto no puede exceder los 999€";
   }

   if (isNaN(precioProducto)) {

    datosErroneos = true;

    let mensajeError = formularioProducto.elements.precioProducto.nextElementSibling;
    mensajeError.classList.add("bg-danger");

    mensajeError.innerHTML = "El precio no puede ser una cadena de caracteres";
   }

}

function comprobar(evento) {

    evento.preventDefault();

    datosErroneos = false;

    caracterMaximoPrecio();

    if (!datosErroneos) {

        this.submit();
    }

}