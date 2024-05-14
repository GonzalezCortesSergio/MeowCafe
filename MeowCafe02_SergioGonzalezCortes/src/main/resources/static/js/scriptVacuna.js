let fechaVacuna = document.getElementById("fechaVacuna");
let hoy = new Date().toISOString().split('T')[0];
fechaVacuna.setAttribute('max', hoy);
