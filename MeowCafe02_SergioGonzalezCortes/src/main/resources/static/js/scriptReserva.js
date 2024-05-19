let fechaVacuna = document.getElementById("fechaReserva");
let hoy = new Date().toISOString().split('T')[0];
fechaVacuna.setAttribute('min', hoy);