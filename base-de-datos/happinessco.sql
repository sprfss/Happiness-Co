-- ============================================================
--                      HAPPINESS & CO 
-- ============================================================

-- CREAMOS BASE DE DATOS Y CODIFICACIÓN 

CREATE DATABASE IF NOT EXISTS happinessco
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE happinessco;

-- ========================================================================
-- TABLAS: USUARIOS, EVENTOS, GALERÍAS, IMAGENES_GALERIAS Y FAVORITOS
-- ========================================================================

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario             INT AUTO_INCREMENT,
    nombre   		       VARCHAR(100) NOT NULL,
    email    		       VARCHAR(150) NOT NULL UNIQUE,
    `password`  		   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY(id_usuario)
);

CREATE TABLE IF NOT EXISTS eventos (
    id_evento             INT AUTO_INCREMENT,
    fecha       		  DATE NOT NULL,
    titulo      		  VARCHAR(200) NOT NULL,
    ubicacion   		  VARCHAR(200) NOT NULL,
    descripcion 		  TEXT NOT NULL,
    CONSTRAINT pk_eventos PRIMARY KEY(id_evento)
);

CREATE TABLE IF NOT EXISTS galerias (
    id_galeria             INT AUTO_INCREMENT,
    titulo      		   VARCHAR(200) NOT NULL,
    id_evento   		   INT NOT NULL,
    CONSTRAINT pk_galerias PRIMARY KEY (id_galeria),
    CONSTRAINT fk_galeven  FOREIGN KEY(id_evento) REFERENCES eventos(id_evento) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS imagenes_galerias (
    id_imagenes          INT AUTO_INCREMENT,
    titulo				 VARCHAR(200) NOT NULL,
    imagen               VARCHAR(500) NOT NULL,
    id_galeria          INT NOT NULL,
    CONSTRAINT pk_imagenes_galerias PRIMARY KEY (id_imagenes),
    CONSTRAINT fk_imagal FOREIGN KEY(id_galeria) REFERENCES galerias(id_galeria) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS favoritos (
    id_usuario  			INT NOT NULL,
    id_evento   			INT NOT NULL,
    CONSTRAINT pk_favoritos PRIMARY KEY(id_usuario, id_evento),
    CONSTRAINT fk_favusuar  FOREIGN KEY(id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_favevent  FOREIGN KEY(id_evento) REFERENCES eventos(id_evento) ON DELETE CASCADE
);

-- ============================================================
-- INSERCIÓN DE DATOS: USUARIOS
-- ============================================================

INSERT INTO usuarios (nombre, email, `password`) VALUES
('Johnny Ramírez', 'johnny.ramirez@gmail.com', 'mylittlepony'),
('Delio Toliva',   'delio.toliva@gmail.com',   'amoeclipse'),
('Mario Álvarez',  'mario.alvarez@gmail.com',  'soyhacker');

-- ============================================================
-- INSERCIÓN DE DATOS: EVENTOS
-- Fechas obligatorias :
--   Historial: 01-01-2026, 12-01-2026, 24-01-2026
--   Próximos:  05-06-2026, 15-06-2026, 25-06-2026
-- Fechas libres (usadas para eventos musicales):
--   Historial: 25-08-2025
--   Próximo:   24-10-2026
-- ============================================================

INSERT INTO eventos (fecha, titulo, ubicacion, descripcion) VALUES
-- Eventos del historial (pasados, fecha corte 01-05-2026)
('2026-01-01', 'Azulejos, Vaques y el Nano - The Tile Project',
 'Oviedo, Espacio 451',
 'Exposición con azulejos sobre temáticas asturianas'),

('2026-01-12', 'Prision IA - El Circo de los Horrores',
 'Gijón, Parque Hermanos Castro',
 'Show que combina teatro, circo y efectos especiales'),

('2026-01-24', 'Final Four - Basketball Champions League',
 'Badalona, Olimpic Arena',
 'Final del mejor baloncesto europeo'),

('2025-08-25', 'Mañana será bonito tour - Karol G',
 'Madrid, Santiago Bernabéu',
 'Gira de conciertos de la Bichota Season'),

-- Eventos próximos (futuros, fecha corte 01-05-2026)
('2026-06-05', 'Cleopatra, la exposición inmersiva',
 'MAD (Madrid Artes Digitales)',
 'Viaje multisensorial al corazón de la historia de la última reina del Antiguo Egipto'),

('2026-06-15', 'Especial Hannah Montana 20 Aniversario',
 'Disney+',
 'Docureality de la serie que marcó una generación y se convirtió en un icono de la cultura pop'),

('2026-06-25', 'Salmon Trail Cornellana',
 'Salas, Asturias',
 'Prueba deportiva de trail running (carrera de montaña)'),

('2026-10-24', '#NTKTOUR2026 - Anastacia',
 'Gijón Arena',
 'Gira europea celebrando los 25 años de su álbum debut Not That Kind');

-- ===================================================================================================
-- INSERCIÓN DE DATOS: GALERÍAS (solo eventos del historial)
-- id_evento: 1 = The Tile Project, 2  Prision IA, 3 = Final Four BCL, 4 = Mañana será bonito tour
-- ===================================================================================================

INSERT INTO galerias (titulo, id_evento) VALUES
('Galería: The Tile Project',              1),
('Galería: Prisión IA',  				   2),
('Galería: Final Four BCL',                3),
('Galería: Mañana será bonito tour',       4);

-- ============================================================
-- INSERCIÓN DE DATOS: IMÁGENES DE GALERÍAS
-- id_galeria: 1=Tile, 2=Prision, 3=Final, 4=Karol
-- ============================================================

INSERT INTO imagenes_galerias (titulo, imagen, id_galeria) VALUES
-- Galería Tile (id_galeria = 1)
('Azulejos, Vaques y el Nano', 'assets/images/galerias-historial/galeria-tile/azulejos.webp', 1),
('Baquetas', 'assets/images/galerias-historial/galeria-tile/baquetas.webp', 1),
('Prestame po la vida', 'assets/images/galerias-historial/galeria-tile/prestame-po-la-vida.webp', 1),
('Magic Alonso', 'assets/images/galerias-historial/galeria-tile/magic-alonso.webp', 1),
('Ye lo que hay', 'assets/images/galerias-historial/galeria-tile/ye-lo-que-hay.webp', 1),


-- Galería Prisión IA (id_galeria = 2)
('Actuación inicial', 'assets/images/galerias-historial/galeria-prision/act.webp', 2),
('Acrobacias', 'assets/images/galerias-historial/galeria-prision/gym.webp', 2),
('Jaula', 'assets/images/galerias-historial/galeria-prision/jail.webp', 2),
('Salto de motos', 'assets/images/galerias-historial/galeria-prision/motos.webp', 2),
('Juego de Espejos', 'assets/images/galerias-historial/galeria-prision/mirror.webp', 2),

-- Galería Final Four (id_galeria = 3)
('A punto de encestar', 'assets/images/galerias-historial/galeria-final/boca.webp', 3),
('Coraje', 'assets/images/galerias-historial/galeria-final/grito.webp', 3),
('Rotura de cadera', 'assets/images/galerias-historial/galeria-final/regate.webp', 3),
('Ganadores', 'assets/images/galerias-historial/galeria-final/final.webp', 3),
('Desde la grada', 'assets/images/galerias-historial/galeria-final/pista.webp', 3),

-- Galería Karol G (id_galeria = 4)
('Letras Bichota Season', 'assets/images/galerias-historial/galeria-karolg/bichota.webp', 4),
('Plano del escenario', 'assets/images/galerias-historial/galeria-karolg/escenario.webp', 4),
('Plano aéreo del show', 'assets/images/galerias-historial/galeria-karolg/espacial.webp', 4),
('Karol despidiéndose', 'assets/images/galerias-historial/galeria-karolg/karol.webp', 4),
('Coreografía', 'assets/images/galerias-historial/galeria-karolg/karol2.webp', 4);

-- ============================================================
-- DATOS: FAVORITOS
-- Usuarios: 1=Johnny, 2=Delio, 3=Mario
-- Eventos:  1=Tile, 2=Prision, 3=Final, 4=Karol,
--           5=Cleopatra, 6=Hannah, 7=Salmon, 8=Anastacia
--
-- Johnny → Hannah(6), Tile(1), Karol(4)
-- Delio  → Salmon(7), Prision(2), Final(3)
-- Mario  → Karol(4), Tile(1), Cleopatra(5)
-- ============================================================

INSERT INTO favoritos (id_usuario, id_evento) VALUES
-- Johnny: 2 historial (Tile, Karol) + 1 futuro (Hannah) 
(1, 1),
(1, 4),
(1, 6),

-- Delio: 2 historial (Prision, Final) + 1 futuro (Salmon) 
(2, 2),
(2, 3),
(2, 7),

-- Mario: 2 historial (Tile, Karol) + 1 futuro (Cleopatra) 
(3, 1),
(3, 4),
(3, 5);

-- ============================================================
-- VISTAS
-- Fecha de referencia del enunciado: 28-02-2026
-- ============================================================

-- Vista 1: Galerías anteriores al 28-02-2026
-- (eventos cuya fecha es anterior a 28-02-2026)

CREATE VIEW galerias_anteriores_fecha_actual AS
    SELECT galerias.*
    FROM galerias, eventos
    WHERE (eventos.fecha) < '2026-02-28' and (galerias.id_evento = eventos.id_evento);

-- Visualizamos la vista
SELECT * FROM galerias_anteriores_fecha_actual;

-- Vista 2: Eventos favoritos del usuario 1 (Jhonny Ramírez)
CREATE VIEW vista_favoritos_usuario1 AS
    SELECT eventos.*
    FROM eventos, favoritos
    WHERE (id_usuario = 1) and (eventos.id_evento = favoritos.id_evento);
    
-- Visualizamos la vista
SELECT * FROM vista_favoritos_usuario1;
    
-- Vista 3: Imágenes de la galería del evento del 12-01-2026
-- El evento del 12-01-2026 tiene id = 2 (Prision IA)
-- La galería de ese evento tiene id = 2

CREATE VIEW vista_imagenes_galeria_prision AS
    SELECT imagenes_galerias.*
    FROM imagenes_galerias, galerias
    WHERE (galerias.id_evento = 2) and (imagenes_galerias.id_galeria = galerias.id_galeria);

-- Visualizamos la vista
SELECT * FROM vista_imagenes_galeria_prision;

-- Vista 4: Eventos favoritos del usuario 2 (Delio Toliva) posteriores al 28-02-2026
CREATE VIEW vista_favoritos_usuario2_futuros AS
    SELECT eventos.*
    FROM eventos, favoritos
    WHERE (favoritos.id_usuario = 2) and (eventos.fecha > '2026-02-28') and (eventos.id_evento = favoritos.id_evento);
    
-- Visualizamos la vista
SELECT * FROM vista_favoritos_usuario2_futuros;

      
      
      
      