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
    id_usuarios            INT AUTO_INCREMENT,
    nombre   		       VARCHAR(100) NOT NULL,
    email    		       VARCHAR(150) NOT NULL UNIQUE,
    password_hash		   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY(id_usuarios)
);

CREATE TABLE IF NOT EXISTS eventos (
    id_eventos            INT AUTO_INCREMENT,
    fecha       		  DATE NOT NULL,
    titulo      		  VARCHAR(200) NOT NULL,
    ubicacion   		  VARCHAR(200) NOT NULL,
    descripcion 		  TEXT NOT NULL,
    CONSTRAINT pk_eventos PRIMARY KEY(id_eventos)
);

CREATE TABLE IF NOT EXISTS galerias (
    id_galerias            INT AUTO_INCREMENT,
    titulo      		   VARCHAR(200) NOT NULL,
    id_evento   		   INT NOT NULL,
    CONSTRAINT pk_galerias PRIMARY KEY (id_galerias),
    CONSTRAINT fk_galeven FOREIGN KEY (id_evento) REFERENCES eventos(id_eventos) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS imagenes_galerias (
    id_imagenes          INT AUTO_INCREMENT,
    titulo      VARCHAR(200) NOT NULL,
    imagen      VARCHAR(500) NOT NULL,
    id_galeria  INT NOT NULL,
    FOREIGN KEY (id_galeria) REFERENCES Galerias(id)
        ON DELETE CASCADE
);

CREATE TABLE favoritos (
    id_usuarios  INT NOT NULL,
    id_eventos   INT NOT NULL,
    
);

-- ============================================================
-- DATOS: EVENTOS
-- Fechas obligatorias del enunciado:
--   Historial: 01-01-2026, 12-01-2026, 24-01-2026
--   Próximos:  05-06-2026, 15-06-2026, 25-06-2026
-- Fechas libres (eventos musicales):
--   Historial: 25-08-2025
--   Próximo:   24-10-2026
-- ============================================================

INSERT INTO Eventos (fecha, titulo, ubicacion, descripcion) VALUES
-- Eventos del historial (pasados, fecha corte 01-05-2026)
('2026-01-01', 'Azulejos, Vaques y el Nano - The Tile Project',
 'Oviedo, Espacio 451',
 'Exposición con azulejos sobre temáticas asturianas'),

('2026-01-12', 'Prision IA - El Circo de los Horrores',
 'Gijón, Parque Hermanos Castro',
 'Show que combina teatro, circo y efectos especiales'),

('2026-01-24', 'Final Four - Basketball Champions League',
 'Badalona, Olímpic Arena',
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

-- ============================================================
-- DATOS: USUARIOS
-- ============================================================

INSERT INTO Usuarios (nombre, email, password) VALUES
('Jhonny Ramírez', 'jhonny.ramirez@email.com', 'pass1234'),
('Delio Toliva',   'delio.toliva@email.com',   'pass5678'),
('Mario Álvarez',  'mario.alvarez@email.com',  'pass9012');

-- ============================================================
-- DATOS: GALERÍAS (solo eventos del historial)
-- id_evento: 1=Tile, 2=Prision, 3=Final, 4=Karol
-- ============================================================

INSERT INTO Galerias (titulo, id_evento) VALUES
('Galería The Tile Project',              1),
('Galería Prisión IA Circo de Horrores',  2),
('Galería Final Four BCL',                3),
('Galería Mañana será bonito tour',       4);

-- ============================================================
-- DATOS: IMÁGENES DE GALERÍAS
-- id_galeria: 1=Tile, 2=Prision, 3=Final, 4=Karol
-- ============================================================

INSERT INTO Imagenes_Galerias (titulo, imagen, id_galeria) VALUES
-- Galería Tile (id_galeria = 1)
('Azulejos asturianos I',   'assets/images/galerias-historial/galeria-tile/img1.jpg',   1),
('Azulejos asturianos II',  'assets/images/galerias-historial/galeria-tile/img2.jpg',   1),
('Azulejos asturianos III', 'assets/images/galerias-historial/galeria-tile/img3.jpg',   1),

-- Galería Prisión IA (id_galeria = 2)
('Circo de los Horrores I',   'assets/images/galerias-historial/galeria-prision/img1.jpg', 2),
('Circo de los Horrores II',  'assets/images/galerias-historial/galeria-prision/img2.jpg', 2),
('Circo de los Horrores III', 'assets/images/galerias-historial/galeria-prision/img3.jpg', 2),

-- Galería Final Four (id_galeria = 3)
('Final Four BCL I',   'assets/images/galerias-historial/galeria-final/img1.jpg', 3),
('Final Four BCL II',  'assets/images/galerias-historial/galeria-final/img2.jpg', 3),
('Final Four BCL III', 'assets/images/galerias-historial/galeria-final/img3.jpg', 3),

-- Galería Karol G (id_galeria = 4)
('Mañana será bonito I',   'assets/images/galerias-historial/galeria-karol/img1.jpg', 4),
('Mañana será bonito II',  'assets/images/galerias-historial/galeria-karol/img2.jpg', 4),
('Mañana será bonito III', 'assets/images/galerias-historial/galeria-karol/img3.jpg', 4);

-- ============================================================
-- DATOS: FAVORITOS
-- Usuarios: 1=Jhonny, 2=Delio, 3=Mario
-- Eventos:  1=Tile, 2=Prision, 3=Final, 4=Karol,
--           5=Cleopatra, 6=Hannah, 7=Salmon, 8=Anastacia
--
-- Jhonny → Hannah(6), Tile(1), Karol(4)
-- Delio  → Salmon(7), Prision(2), Final(3)
-- Mario  → Karol(4), Tile(1), Cleopatra(5)
-- ============================================================

INSERT INTO Favoritos (id_usuario, id_evento) VALUES
-- Jhonny: 2 historial (Tile, Karol) + 1 futuro (Hannah) ✓
(1, 6),
(1, 1),
(1, 4),
-- Delio: 2 historial (Prision, Final) + 1 futuro (Salmon) ✓
(2, 7),
(2, 2),
(2, 3),
-- Mario: 2 historial (Karol, Tile) + 1 futuro (Cleopatra) ✓
(3, 4),
(3, 1),
(3, 5);

-- ============================================================
-- VISTAS
-- Fecha de referencia del enunciado: 28-02-2026
-- ============================================================

-- Vista 1: Galerías anteriores al 28-02-2026
-- (eventos cuya fecha es anterior a 28-02-2026)
CREATE VIEW vista_galerias_anteriores AS
    SELECT g.id, g.titulo, g.id_evento, e.fecha, e.titulo AS titulo_evento
    FROM Galerias g
    JOIN Eventos e ON g.id_evento = e.id
    WHERE e.fecha < '2026-02-28';

-- Vista 2: Eventos favoritos del usuario 1 (Jhonny Ramírez)
CREATE VIEW vista_favoritos_usuario1 AS
    SELECT e.id, e.fecha, e.titulo, e.ubicacion, e.descripcion
    FROM Favoritos f
    JOIN Eventos e ON f.id_evento = e.id
    WHERE f.id_usuario = 1;

-- Vista 3: Imágenes de la galería del evento del 12-01-2026
-- El evento del 12-01-2026 tiene id = 2 (Prision IA)
-- La galería de ese evento tiene id = 2
CREATE VIEW vista_imagenes_galeria_prision AS
    SELECT ig.id, ig.titulo, ig.imagen, ig.id_galeria
    FROM Imagenes_Galerias ig
    WHERE ig.id_galeria = 2;

-- Vista 4: Eventos favoritos del usuario 2 (Delio Toliva) posteriores al 28-02-2026
CREATE VIEW vista_favoritos_usuario2_futuros AS
    SELECT e.id, e.fecha, e.titulo, e.ubicacion, e.descripcion
    FROM Favoritos f
    JOIN Eventos e ON f.id_evento = e.id
    WHERE f.id_usuario = 2
      AND e.fecha > '2026-02-28';