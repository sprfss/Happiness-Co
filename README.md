<p align="center">
  <img src="./lenguaje-de-marcas/assets/images/logo/logo-rosa.jpg" width="100%">
</p>

## **HAPPINESS&Co 🎭🎵**

> ### **Proyecto final 1er Curso DAW**
>
> Agenda cultural de eventos de música, teatro, cine, exposiciones y deportes, entre otros.

    El proyecto se divide entre algunas de las asignaturas cursadas durante el año. No tiene API ni hosting web.

---

## 📁 Estructura del proyecto

```
Happiness-Co/
├── lenguaje-de-marcas/         	# Sitio web completo
│   ├── index.html              	# Página principal con hero carrusel
│   ├── eventos.html            	# Próximos eventos con filtro por categoría
│   ├── historial.html          	# Historial de eventos pasados con filtro
│   ├── about-us.html           	# Sobre nosotros y equipo
│   ├── contacto.html           	# Formulario de contacto
│   ├── fuentes.html            	# Fuentes y referencias
│   ├── karolg.html             	# Evento: Karol G — Mañana Será Bonito Tour
│   ├── prision-ia.html         	# Evento: Prisión IA — El Circo de los Horrores
│   ├── finalfour.html          	# Evento: Final Four BCL
│   ├── tileproject.html        	# Evento: The Tile Project
│   ├── cleopatra.html          	# Evento: Cleopatra, la exposición inmersiva
│   ├── hannah.html             	# Evento: Hannah Montana 20 Aniversario
│   ├── salmon.html             	# Evento: Salmon Trail Cornellana
│   ├── anastacia.html          	# Evento: Anastacia #NTKTOUR2026
│   └── assets/
│       ├── css/
│       │   └── styles.css      	# Estilos propios + clases personalizadas
│       ├── js/
│       │   └── hero.js         	# Carrusel dinámico del hero
│       └── images/
│           ├── logo/			# Logotipos corporativos
|           ├── team/           	# Fotos del equipo
│           ├── galerias-historial/ 	# Galerías de eventos pasados
│           │   ├── galeria-karolg/	# Galería Karol G
│           │   ├── galeria-prision/	# Galería Prision IA
│           │   ├── galeria-final/	# Galería Final Four
│           │   └── galeria-tile/	# Galería The Tile Project
│           └── [carteles de cada evento]
│
├── rss/
│   └── eventos.rss             # Feed RSS con los próximos eventos
│
├── base-de-datos/              # Script SQL con tablas, datos y vistas
│
├── programacion/               # Clases Java con menú de gestión
│
├── informe.pdf                 # Documentación completa del proyecto
├── .gitignore
└── README.md
```

---

## **🔖**Lenguaje de marcas

### Stack tecnológico

- **HTML5** con etiquetas semánticas (`nav`, `main`, `section`, `article`, `aside`, `footer`)
- **Tailwind CSS** vía CDN — más del 80% del CSS total
- **CSS propio** (`styles.css`) — clases personalizadas del proyecto
- **JavaScript vanilla** — sin frameworks

### Características del sitio

- Hero carrusel dinámico con 8 eventos, rotación automática cada 5 segundos, navegación manual con flechas y puntos indicadores
- Filtro de eventos por categoría en `eventos.html` e `historial.html`
- Cards de eventos con imagen, badge de categoría y barra de color inferior
- Sidebar de recomendados con diseño de caja redondeada
- Diseño responsive — móvil y desktop
- Animación de entrada del texto del hero con `@keyframes`

### Colores corporativos

| Categoría    | Color   | Hex                                                                                   |
| ------------- | ------- | ------------------------------------------------------------------------------------- |
| Música       | Rosa    | ![](https://img.shields.io/badge/COLOR-%23ba007c?style=for-the-badge&color=ba007c)      |
| Cine / Teatro | Azul    | ![Color](https://img.shields.io/badge/COLOR-%23ba007c?style=for-the-badge&color=009bdb) |
| Exposiciones  | Naranja | ![Color](https://img.shields.io/badge/COLOR-%23ba007c?style=for-the-badge&color=ff7b00) |
| Deporte       | Gris    | ![Color](https://img.shields.io/badge/COLOR-%23ba007c?style=for-the-badge&color=555555) |

### Tipografía

**Montserrat** (Google Fonts) — pesos 300 a 900

### Fecha de corte eventos pasados / futuros

`01-05-2026` — los eventos anteriores a esta fecha muestran galería de imágenes

---

## 📡 RSS

Feed RSS con los próximos eventos de la página `eventos.html`:

- Cleopatra, la exposición inmersiva — 05 jun 2026
- Hannah Montana 20 Aniversario — 15 jun 2026
- Salmon Trail Cornellana — 25 jun 2026
- \#NTKTOUR2026 Anastacia — 24 oct 2026

---

## **🗃️**Base de datos

Base de datos SQL con las siguientes tablas y relaciones:

| Tabla                 | Descripción                                |
| --------------------- | ------------------------------------------- |
| `usuarios`          | id, nombre, email (único), password        |
| `eventos`           | id, fecha, titulo, ubicación, descripción |
| `galerias`          | id, título, id_evento                      |
| `imagenes_galerias` | id, título, imagen, id_galeria             |
| `favoritos`         | id_usuario, id_evento                       |

**Vistas creadas:**

- Galerías anteriores al 28-02-2026
- Eventos favoritos del usuario 1
- Imágenes de la galería del evento del 12-01-2026
- Eventos favoritos del usuario 2 posteriores al 28-02-2026

---

## **☕**Programación

Clases Java con constructor, getters, setters y toString:

- `Usuarios` — nombre, email, password
- `Eventos` — id, fecha, titulo, ubicación, descripción, ArrayList de galerías
- `Galerias` — id, título, id_evento
- `Favoritos` — correo_usuario, id_evento

**Clase principal** con menú do-while que permite:

1. Añadir / eliminar usuario
2. Añadir / eliminar evento
3. Añadir / eliminar galería
4. Añadir / eliminar favorito
5. Salir

---

## 📄 Informe

El archivo `informe.pdf` documenta todas las partes del proyecto con capturas de pantalla, ejemplos de código, decisiones de diseño, tecnologías utilizadas y enlace al repositorio.

---

## **👩🏻‍💻**Autora**Sara Pérez Rodríguez**

FP Superior DAW — 2025/2026
[github.com/sprfss](https://github.com/sprfss)
