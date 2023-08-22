DROP DATABASE IF EXISTS estancias_exterior;
CREATE DATABASE IF NOT EXISTS estancias_exterior;
USE estancias_exterior;

CREATE TABLE clientes (
  id_cliente INT UNSIGNED AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  calle VARCHAR(50) DEFAULT NULL,
  numero INT NOT NULL,
  codigo_postal VARCHAR(10) DEFAULT NULL,
  ciudad VARCHAR(50) NOT NULL,
  pais VARCHAR(50) NOT NULL,
  email VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id_cliente)
)ENGINE=INNODB;

INSERT INTO clientes VALUES(1, 'Juan Gutierrez','Moliner',50,'46100','Valencia','España','Juan.Gutierrez@uv.es');
INSERT INTO clientes VALUES(2, 'Esther Menendez','Pidal',9,'46009','Valencia','España','Esther.Deves@uv.es');
INSERT INTO clientes VALUES(3, 'Elena Diaz','Moliner',50,'46009','Burjassot','España','Elena.Diaz@uv.es');
INSERT INTO clientes VALUES(4, 'Miguel Martinez','Altea',5,'56789','Madrid','España','Mima@hotmail.com');
INSERT INTO clientes VALUES(5, 'Juan Gonzalez','Cuenca',50,'45320','Barcelona','España','Jugo@hotmail.com');
INSERT INTO clientes VALUES(6, 'Juan Jose Lopez','Galdos',9,'26040','Almansa','España','julo@retevision.com');
INSERT INTO clientes VALUES(7, 'Rosario Alcocer','Rambla de la Mancha',10,'26100','Albacete','España','Roal@upv.es');

 
CREATE TABLE casas (
  id_casa INT UNSIGNED AUTO_INCREMENT NOT NULL,
  calle VARCHAR(50) DEFAULT NULL,
  numero INT NOT NULL,
  codigo_postal VARCHAR(10) DEFAULT NULL,
  ciudad VARCHAR(50) NOT NULL,
  pais VARCHAR(50) NOT NULL,
  fecha_desde date NOT NULL,
  fecha_hasta date NOT NULL,
  tiempo_minimo INT NOT NULL,
  tiempo_maximo INT NOT NULL,
  precio_habitacion NUMERIC(15,2) NOT NULL,
  tipo_vivienda VARCHAR(30) NOT NULL,
  PRIMARY KEY (id_casa)
)ENGINE=INNODB;

INSERT INTO casas VALUES(1, 'Cow Gate',3,'456789','Edinmburg','Reino Unido','2020-06-01','2021-06-01',2,20,50,'Casa');
INSERT INTO casas VALUES(2, 'Royal Mile',10,'12345','Edinmburg','Reino Unido','2020-05-01','2021-05-01',2,15,45.50,'Duplex');
INSERT INTO casas VALUES(3, 'Bath',3,'98987','Bath','Reino Unido','2020-08-01','2020-08-31',1,30,60,'Piso');
INSERT INTO casas VALUES(4, 'Station Road',3,'567827','York','Reino Unido','2020-07-01','2020-10-15',2,20,45,'Piso');
INSERT INTO casas VALUES(5, 'Minster Road',5,'234','Bristol','Reino Unido','2020-06-01','2020-09-15',5,30,50,'Duplex');
INSERT INTO casas VALUES(6, 'St. Andrews',3,'345','London','Reino Unido','2020-08-01','2020-08-31',1,15,50,'Piso');
INSERT INTO casas VALUES(7, 'Londo',10,'345','Dublin','Irlanda','2020-06-01','2020-09-30',2,15,60,'Chalet');
INSERT INTO casas VALUES(8, 'Tulipanes',6,'89889','Amsterdan','Holanda','2020-08-01','2020-08-31',2,30,75,'Chalet');

CREATE TABLE familias (
  id_familia INT UNSIGNED AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  edad_minima INT NOT NULL,
  edad_maxima INT NOT NULL,
  num_hijos INT NOT NULL,
  email VARCHAR(50) NOT NULL,
  id_casa_familia INT UNSIGNED NOT NULL,
  PRIMARY KEY (id_familia),
  FOREIGN KEY (id_casa_familia) REFERENCES casas (id_casa)
)ENGINE=INNODB;
 
INSERT INTO familias VALUES(1, 'Marshal',3,8,3,'c.Marshall@idk.ij.uk',1);
INSERT INTO familias VALUES(2, 'Robinson',0,0,0,'t.robinson@hotmail.com',2);
INSERT INTO familias VALUES(3, 'Buch',2,7,2,'r.busch@hotmail.com',3);
INSERT INTO familias VALUES(4, 'Martinez',3,5,3,'mm@con.ii.uk',4);
INSERT INTO familias VALUES(5, 'Sullivan',5,8,3,'sulli@hotmail.com',5);
INSERT INTO familias VALUES(6, 'Murphy',1,3,2,'murphy@msn.com',6);
INSERT INTO familias VALUES(7, 'Smith',1,7,3,'J.Smith@hotmail.com',7);
INSERT INTO familias VALUES(8, 'Kennedy',2,8,2,'A.Ken@hotmail.com',8);

CREATE TABLE estancias (
  id_estancia  INT UNSIGNED AUTO_INCREMENT NOT NULL,
  id_cliente INT UNSIGNED NOT NULL,
  id_casa INT UNSIGNED NOT NULL,
  nombre_huesped VARCHAR(70) NOT NULL,
  fecha_desde date NOT NULL,
  fecha_hasta date NOT NULL,
  PRIMARY KEY (id_estancia),
  FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
  FOREIGN KEY (id_casa) REFERENCES casas (id_casa)
)ENGINE=INNODB;

INSERT INTO estancias VALUES(1,1,1,'Juan Gutierrez','2020-07-01','2020-07-31');
INSERT INTO estancias VALUES(2,2,1,'Esther Menendez','2020-08-01','2020-08-31');
INSERT INTO estancias VALUES(3,3,2,'Elena Diaz','2020-08-01','2020-08-31');
INSERT INTO estancias VALUES(4,4,3,'Miguel Martinez','2020-07-01','2020-07-31');
INSERT INTO estancias VALUES(6,5,5,'Juan Gonzalez','2020-08-01','2020-09-15');
INSERT INTO estancias VALUES(7,6,4,'Juan Jose Lopez','2020-07-01','2020-07-31');
INSERT INTO estancias VALUES(8,7,6,'Rosario Alcocer','2020-07-01','2020-08-31');


CREATE TABLE comentarios (
  id_comentario INT UNSIGNED AUTO_INCREMENT NOT NULL,
  id_casa INT UNSIGNED NOT NULL,
  comentario VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id_comentario),
  FOREIGN KEY (id_casa) REFERENCES casas (id_casa)
)ENGINE=INNODB;

INSERT INTO comentarios VALUES(1,1,'Casa muy limpia, todo perfecto, quizás un poco pequeña');
INSERT INTO comentarios VALUES(2,1,'Casa muy ordenada, limpia, muy bien decorada. Buen ambiente');
INSERT INTO comentarios VALUES(3,2,'Ambiente muy ingles, muy formal, horarios muy estrictos, comida excelente');
INSERT INTO comentarios VALUES(4,2,'Si quieres encontrar un ambiente ingles auténtico, esta es tu casa');
INSERT INTO comentarios VALUES(5,3,'Si vienes a divertirte, y te gusta la libertad, has encontrado el lugar indicado. Horarios muy flexibles');
INSERT INTO comentarios VALUES(6,3,'Si quieres que no te hagan caso, con esta familia estás de suerte. Ningun tipo de contacto con ellos');
INSERT INTO comentarios VALUES(7,4,'Una familia adorable, buen trato, mucha comunicación, cuando vuelvas hablarás inglés por los codos de tanto practicar');

/*1. familias que tienen al menos 3 hijos y con edad maxima inferior a 10.*/

select *
from familias
where num_hijos >= 3
and edad_maxima < 10;

/*2. Casas disponibles desde 01/08/2020 hasta 31/08/2020.*/

Select * 
from casas 
where (year(fecha_desde) = 2020 and month(fecha_desde) = 08);

/*3. Familias cuya dirección de mail sea de hotmail.*/

select *
from familias
where email like '%hotmail%';

/*4. Aquellas casas disponibles a partir de una fecha dada y un número de días específico."*/
select * from casas;



/*5. Todos los clientes que en algún momento realizaron una estancia y la
"descripción de la casa donde la realizaron.*/

select cli.nombre, com.comentario
from cliente cli
inner join estancias est
on cli.id_cliente = est.id_cliente
inner join casas cas
on est.id_casa = cas.id_casa
inner join comentarios com
on cas.id_casa = com.id_casa;

/*6. Todas las estancias que han sido reservadas por un cliente, 
mostrar el nombre, país y ciudad del cliente y además la información
 de la casa que reservó. La que reemplazaría a la anterior.*/
 
 select c.nombre, c.pais, c.ciudad
 from cliente c, estancias e
 where c.id_cliente = e.id_cliente;

/*"7.  Incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.\n"
 "8.  Número de casas que existen para cada uno de los países diferentes.\n"
 "9. Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.\n"
"10. Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.\n"
                        + "11. Salir.");*/
                        







