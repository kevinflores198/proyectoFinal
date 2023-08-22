-- 1. Obtener los datos completos de los empleados.
select * from empleados;

-- 2. Obtener los datos completos de los departamentos.
select * from departamentos;

-- 3. Listar el nombre de los departamentos.
select nombre_depto from departamentos;

-- 4. Obtener el nombre y salario de todos los empleados.
select nombre, sal_emp from empleados;

-- 5. Listar todas las comisiones.
select comision_emp from empleados;

-- 6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
select * from empleados where cargo_emp = 'Secretaria';

-- 7. Obtener los datos de los empleados vendedores, ordenados por nombre
-- alfabéticamente.
select * from empleados where cargo_emp = 'Vendedor' order by nombre asc;

-- 8. Obtener el nombre y cargo de todos los empleados, ordenados por 
-- salario de menor a mayor.
select nombre, cargo_emp from empleados order by sal_emp;

-- 9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad
-- de “Ciudad Real”
select nombre_jefe_depto from departamentos where ciudad = 'Ciudad real';

-- 10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las
-- respectivas tablas de empleados.
select nombre as Nombre, cargo_emp as Cargo from empleados;

-- 11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado
-- por comisión de menor a mayor.
select sal_emp as Salario, comision_emp as Comisiones from empleados where id_depto = 2000 order by comision_emp;

-- 12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta
-- de: sumar el salario y la comisión, más una bonificación de 500. Mostrar el nombre del
-- empleado y el total a pagar, en orden alfabético.
select nombre as Nombre, sal_emp as Salario, comision_emp as Comision, (sal_emp + comision_emp + 500) as 'Salario Total'
from empleados where id_depto = 3000 order by nombre asc;

-- 13. Muestra los empleados cuyo nombre empiece con la letra J.
select * from empleados where nombre like 'j%';

-- 14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos
-- empleados que tienen comisión superior a 1000.
select nombre as Nombre, sal_emp as Salario, comision_emp as Comision, (sal_emp + comision_emp) as 'Salario Total'
from empleados where comision_emp > 1000;

-- 15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen
-- comisión.
select nombre as Nombre, sal_emp as 'Salario Final' from empleados where comision_emp = 0;

-- 16. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
select nombre as Nombre, sal_emp as Salario, comision_emp as Comision from empleados where sal_emp < comision_emp;

-- 17. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
select nombre as Nombre, comision_emp as Comision from empleados where (sal_emp*0.3) >= comision_emp;

-- 18. Hallar los empleados cuyo nombre no contiene la cadena “MA”
select nombre from empleados where nombre not like 'MA%';

-- 19. Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o
-- ‘Mantenimiento.
select * from departamentos where nombre_depto in ('Ventas','Investigacion','Mantenimiento');

-- 20. Ahora obtener el contrario, los nombres de los departamentos que no sean “Ventas” ni
-- “Investigación” ni ‘Mantenimiento.
select * from departamentos where nombre_depto not in ('Ventas','Investigacion','Mantenimiento');

-- 21. Mostrar el salario más alto de la empresa.
select MAX(sal_emp) as 'Salario maximo' from empleados;

-- 22. Mostrar el nombre del último empleado de la lista por orden alfabético.
select max(nombre) as 'Ultimo en orden alfabetico' from empleados;

-- 23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
select max(sal_emp) as Maximo, min(sal_emp) as Minimo, (max(sal_emp) - min(sal_emp)) as 'Diferencia' from empleados;

-- 24. Hallar el salario promedio por departamento. Consultas con Having
select avg(sal_emp) as 'Salario Promedio general' from empleados;

-- 25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de
-- empleados de esos departamentos.
select id_depto as 'Departamento con mas de 3 empleados',count(*) as Numero_de_empleados 
from empleados group by id_depto having count(*)>3;

-- 26. Hallar los departamentos que no tienen empleados
select id_depto as 'Departamento sin empleados', count(*) as sin_empleados from empleados group by id_depto having count(*)<1;

-- Consulta Multitabla (Uso de la sentencia JOIN/LEFT JOIN/RIGHT JOIN)
-- 27. Mostrar la lista de empleados, con su respectivo departamento y el jefe de cada
-- departamento.
select  nombre as Empleado , nombre_depto as Departamento, nombre_jefe_depto as Jefe 
from empleados e left outer join departamentos d on e.id_depto = d.id_depto; 

-- Consulta con Subconsulta
-- 28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la
-- empresa. Ordenarlo por departamento.
select nombre as empleado, sal_emp as '+ o = salario emplesar', id_depto as Departamento 
from empleados where sal_emp>=( select avg(sal_emp) from empleados ) 
order by id_depto; 



