Algoritmo sin_titulo
//Los empleados de una fábrica trabajan en 
//dos turnos: Diurno y Nocturno. Se desea calcular el 
//jornal diario de acuerdo con las siguientes reglas:
//a) La tarifa de las horas diurnas es de $ 90
//b) La tarifa de las horas nocturnas es de $ 125
//c) En caso de ser feriado, la tarifa se incrementa 
//en un 10% si el turno es diurno y en 
//un 15% si el turno es nocturno
	
	definir Hdiu, Hnoc, horas Como Entero
	definir nom, dia Como Caracter
	definir feriado, turno Como Logico
	Escribir "Ingrese su nombre"
	Leer nombre
	Escribir "Ingrese dia trabajado"
	Leer dia
	Escribir "en que turno trabajo?"
	Leer turno
FinAlgoritmo

Funcion salario <- devsalario ( Argumentos )
	Si Minusculas(turno) = horas*90
		Hdiu = horas*90
	sino
		
	FinSi
Fin Funcion
	
FinFuncion
	

