let fechaVacuna = document.getElementById("fechaReserva");
let hoy = new Date().toISOString().split('T')[0];
fechaVacuna.setAttribute('min', hoy);

let gato1 = document.getElementById("gato1");
let gato2 = document.getElementById("gato2");
let gato3 = document.getElementById("gato3");
let gato4 = document.getElementById("gato4");

let reserva = document.forms.reserva;

reserva.addEventListener("submit", comprobarGatos);

function comprobarGatos(evento) {
if (gato1 !== null) {
    evento.preventDefault();

    let todoOk = true;


    if (gato1.value != -1 && gato1.value == gato2.value) {

        todoOk = false;

        let mensajeError = this.nextElementSibling;

        mensajeError.classList.add("bg-danger");
        mensajeError.innerHTML = "No puedes seleccionar varias veces al mismo gato";
    }
    if (gato1.value != -1 &&  gato1.value == gato3.value) {

            todoOk = false;

            let mensajeError = this.nextElementSibling;

            mensajeError.classList.add("bg-danger");
            mensajeError.innerHTML = "No puedes seleccionar varias veces al mismo gato";
    }
    if (gato1.value != -1 &&  gato1.value == gato4.value) {

            todoOk = false;

            let mensajeError = this.nextElementSibling;

            mensajeError.classList.add("bg-danger");
            mensajeError.innerHTML = "No puedes seleccionar varias veces al mismo gato";
    }
    if (gato2.value != -1 &&  gato2.value == gato3.value) {

            todoOk = false;

            let mensajeError = this.nextElementSibling;

            mensajeError.classList.add("bg-danger");
            mensajeError.innerHTML = "No puedes seleccionar varias veces al mismo gato";
    }
    if (gato2.value != -1 &&  gato2.value == gato4.value) {

            todoOk = false;

            let mensajeError = this.nextElementSibling;

            mensajeError.classList.add("bg-danger");
            mensajeError.innerHTML = "No puedes seleccionar varias veces al mismo gato";
    }
    if (gato3.value != -1 &&  gato3.value == gato4.value) {

                todoOk = false;

                let mensajeError = this.nextElementSibling;

                mensajeError.classList.add("bg-danger");
                mensajeError.innerHTML = "No puedes seleccionar varias veces al mismo gato";
    }


    if(todoOk) {
        this.submit();
    }

}
}