/*1.Mostrar el nombre de todos los jugadores ordenados alfabéticamente.*/
select nombre from jugadores order by nombre;

/*2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, 
ordenados por nombre alfabéticamente.*/
select nombre from jugadores where posicion like '%c%' and peso > 200 order by Nombre;

/*3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.*/
select nombre from equipos order by nombre;

/*4. Mostrar el nombre de los equipos del este (East).*/
select nombre from equipos where conferencia like 'east';

/*5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.*/
select * from equipos where ciudad like 'c%' order by nombre;

/*6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.*/
select nombre, Nombre_equipo from jugadores order by Nombre_equipo;

/*7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.*/
select * from jugadores where nombre_equipo like 'Raptors' order by nombre;

/*8. Mostrar los puntos por partido del jugador ‘Pau Gasol’*/
select nombre, puntos_por_partido as Puntos 
from jugadores j inner join estadisticas e
on j.codigo = e.jugador where nombre like 'pau gasol';

/*9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.*/
select puntos_por_partido, temporada
from jugadores j inner join estadisticas e
on j.codigo = e.jugador where nombre like 'pau gasol' and temporada = '04/05';

/*10. Mostrar el número de puntos de cada jugador en toda su carrera.*/
select nombre, sum(e.puntos_por_partido)
from jugadores j inner join estadisticas e
on j.codigo = e.jugador
group by j.nombre 
order by sum(e.puntos_por_partido) desc;

/*11. Mostrar el número de jugadores de cada equipo.*/
select nombre_equipo, count(*) as 'numbero de jugadores' 
from jugadores  
group by nombre_equipo
having count(*);

/*49
12. Mostrar el jugador que más puntos ha realizado en toda su carrera.*/
select j.nombre, sum(e.Puntos_por_partido)
from  jugadores j,estadisticas e
where e.jugador = j.codigo
group by j.nombre
order by sum(e.Puntos_por_partido) desc limit 1;

/*13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.*/
select j.nombre, e.nombre, e.conferencia, e.division
from equipos e, jugadores j 
where e.nombre = j.nombre_equipo and j.altura = (select max(altura) from jugadores);

/*14. Mostrar la media de puntos en partidos de los equipos de la división Pacific.*/
select p.equipo_local, avg(p.puntos_local) as promedio, e.Division
from partidos p
inner join equipos e
on p.equipo_local = e.nombre
where e.division = 'pacific'
group by p.equipo_local;

/*15. Mostrar los partidos (equipo_local, equipo_visitante y diferencia) con mayor 
diferencia de puntos.*/
select p.equipo_local, p.equipo_visitante from partidos 
where abs(puntos_local - puntos_visitante) = (select max(abs(puntos_local - puntos_visitante))
from partidos);

/*17. Mostrar los puntos de cada equipo en los partidos, tanto de local como de visitante. */
select equipo_local, puntos_local, equipo_visitante, puntos_visitante
from partidos
order by equipo_local;

select * from puntos_equipo_partidos;
/*18. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, 
equipo_ganador), en caso de empate sera null.*/

select codigo, equipo_local, equipo_visitante,
if (puntos_local>puntos_visitante,equipo_local, 
if(puntos_local<puntos_visitante,equipo_visitante,null))
as 'resultado' from partidos;
