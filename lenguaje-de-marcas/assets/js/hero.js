/* ============================================================
   HAPPINESS & CO — Hero carrusel dinámico
   Archivo: assets/js/hero.js
   Descripción: Gestiona el carrusel de eventos del hero
                Rota automáticamente cada 5 segundos
                Permite navegación manual con botones y puntos
   ============================================================ */

/* Esperamos a que el HTML esté completamente cargado */
document.addEventListener('DOMContentLoaded', function () {

  /* ---- REFERENCIAS A ELEMENTOS DEL HTML ---- */
  /* Todos los slides del carrusel */
  const slides = document.querySelectorAll('.hero-slide');

  /* Contenedor de los puntos indicadores */
  const contenedorPuntos = document.getElementById('hero-puntos');

  /* Botones de navegación */
  const btnAnterior = document.getElementById('hero-anterior');
  const btnSiguiente = document.getElementById('hero-siguiente');

  /* ---- VARIABLES DE CONTROL ---- */
  let indiceActual = 0;   /* Slide que se está mostrando ahora */
  let temporizador;       /* Guarda el intervalo automático */

  /* ---- CREAR LOS PUNTOS INDICADORES ---- */
  /* Un punto por cada slide */
  slides.forEach(function (slide, indice) {
    const punto = document.createElement('button');
    punto.classList.add('hero-dot');
    punto.setAttribute('aria-label', 'Ir al evento ' + (indice + 1));

    /* Al hacer clic en un punto, ir a ese slide */
    punto.addEventListener('click', function () {
      irASlide(indice);
    });

    contenedorPuntos.appendChild(punto);
  });

  /* ---- FUNCIÓN PRINCIPAL: IR A UN SLIDE ---- */
  function irASlide(nuevoIndice) {

    /* Ocultamos el slide actual */
    slides[indiceActual].classList.add('hidden');

    /* Quitamos el estilo activo del punto actual */
    contenedorPuntos.children[indiceActual].classList.remove('activo');

    /* Calculamos el nuevo índice (circular: después del último va el primero) */
    indiceActual = (nuevoIndice + slides.length) % slides.length;

    /* Mostramos el nuevo slide */
    slides[indiceActual].classList.remove('hidden');

    /* Marcamos el punto correspondiente como activo */
    contenedorPuntos.children[indiceActual].classList.add('activo');

    /* Reiniciamos el temporizador automático */
    reiniciarTemporizador();
  }

  /* ---- TEMPORIZADOR AUTOMÁTICO ---- */
  /* Avanza al siguiente slide cada 5 segundos */
  function reiniciarTemporizador() {
    clearInterval(temporizador);
    temporizador = setInterval(function () {
      irASlide(indiceActual + 1);
    }, 5000);
  }

  /* ---- BOTONES DE NAVEGACIÓN ---- */
  btnAnterior.addEventListener('click', function () {
    irASlide(indiceActual - 1);
  });

  btnSiguiente.addEventListener('click', function () {
    irASlide(indiceActual + 1);
  });

  /* ---- INICIALIZACIÓN ---- */
  /* Mostramos el primer slide y su punto como activos */
  slides[0].classList.remove('hidden');
  contenedorPuntos.children[0].classList.add('activo');

  /* Arrancamos el temporizador */
  reiniciarTemporizador();

});


