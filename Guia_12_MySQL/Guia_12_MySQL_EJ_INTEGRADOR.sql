select Asistencias_por_partido, 
count(*) as 'Cantidad' 
from estadisticas 
where Asistencias_por_partido = 34;

select sum(peso) as 'clave' 
from jugadores j 
inner join equipos e on j.Nombre_equipo like e.Nombre 
where posicion like '%c%' 
and e.Conferencia like 'east';

select count(*) 
from jugadores j 
where j.Nombre_equipo like 'heat';

select count(*) 
from jugadores j, estadisticas e 
where j.codigo = e.jugador 
and e.Asistencias_por_partido > 16;

select count(codigo) as 'clave' 
from partidos 
where temporada like '%99%';

select (count(*)/(select count(*) from jugadores where peso >= 195) + 0.9945) as 'posicion'
from jugadores j 
inner join equipos e on j.Nombre_equipo 
like e.nombre 
where j.Procedencia like 'michigan' 
and e.Conferencia like 'west';

select (floor(avg(e.Puntos_por_partido) + (count(e.Asistencias_por_partido)) + (sum(e.Tapones_por_partido)))) as 'clave' 
from estadisticas e inner join jugadores j on e.jugador = j.codigo
inner join equipos eq on j.Nombre_equipo like eq.nombre
where eq.Division like 'central';

select (round(e.Tapones_por_partido)) 
from estadisticas e 
inner join jugadores j on j.codigo = e.jugador
 where j.Nombre like 'Corey Maggette' 
 and e.temporada like '00/01';

select (floor(sum(e.Puntos_por_partido)))
from estadisticas e 
inner join jugadores j on j.codigo = e.jugador
where j.Procedencia like 'Argentina';



