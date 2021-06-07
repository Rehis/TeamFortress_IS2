DROP DATABASE IF EXISTS  apirest;
CREATE DATABASE apirest;
USE apirest;

-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-04-2021 a las 17:06:37
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `apirest`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `precio` double NOT NULL,
  `categoria` varchar(200) NOT NULL,
  `descripcion` varchar(5000) NOT NULL,
  `imagen` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
    `id` int(11) NOT NULL,
    `mail` varchar(200) NOT NULL,
    `password` varchar(200) NOT NULL,
    `admin` bit NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id`, `nombre`, `precio`, `categoria`, `descripcion`, `imagen`) VALUES
(1,     'Botella de agua 500ml',    0.79,   'Comida',   'botella de agua solan de cabras 500ml', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(2,     'Botella de agua 500ml',    0.75,   'Comida',   'botella de agua lanjaron 500ml', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(3,     'Botella de agua 750ml',    1,      'Comida',   'botella de agua lanjaron 750ml', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(4,     'Botella de agua',          0.65,   'Comida',   'botella de agua font vella 500ml', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(5,     'Leche',                    0.79,   'Comida',   'leche de vaca uht 1L', 'https://ep01.epimg.net/elpais/imagenes/2019/12/20/buenavida/1576848685_542543_1576848937_noticia_normal.jpg'),
(6,     'Leche de avena',           0.85,   'Comida',   'leche de avena 1L', 'https://ep01.epimg.net/elpais/imagenes/2019/12/20/buenavida/1576848685_542543_1576848937_noticia_normal.jpg'),
(7,     'Leche de soja',            0.65,   'Comida',   'leche de soja 1L', 'https://ep01.epimg.net/elpais/imagenes/2019/12/20/buenavida/1576848685_542543_1576848937_noticia_normal.jpg'),
(8,     'Pan',                      0.3,    'Comida',   'barra de pan', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(9,     'huevos, media docena',     0.5,    'Comida',   'pack de 6 huevos', 'https://static1.abc.es/media/bienestar/2020/10/11/huevos-colores-kZ1B--620x349@abc.jpg'),
(10,    'huevos, docena',           0.8,    'Comida',   'pack de 12 huevos', 'https://static1.abc.es/media/bienestar/2020/10/11/huevos-colores-kZ1B--620x349@abc.jpg'),
(11,    'plátano de Canarias',      1.79,   'Comida',   'plátano de canarias 1kg', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(12,    'plátano',                  1.4,    'Comida',   'plátano 1kg', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(13,    'mango',                    2,      'Comida',   'mango 1kg', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(14,    'zumo fresa plátano',       1.2,    'Comida',   'zumo sabor fresa plátano 1L', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(15,    'baguette',                 0.5,    'Comida',   'barra de pan baguette', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(16,    'queso',                    2,      'Comida',   'queso semicurado de vaca García Vaquero 500g', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png'),
(17,    'queso de oveja',           1.35,   'Comida',   'queso de oveja 500g', 'https://img.icons8.com/emoji/452/white-question-mark-emoji.png');
--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `usuario`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

ALTER TABLE `usuario`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
