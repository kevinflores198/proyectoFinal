//Escribir un programa que calcule cu�ntos litros de combustible consumi� un autom�vil. El
//usuario ingresar� una cantidad de litros de combustible cargados en la estaci�n y una
//cantidad de kil�metros recorridos, despu�s, el programa calcular� el consumo (km/lt) y se lo
//mostrar� al usuario.

Proceso sin_titulo
	
	Definir litros, kilometros, consmo Como Real
	
	Escribir "Ingrese los litros de combustible consumidos y kilometros recorridos"
	
	Leer litros
	Leer kilometros
	
	consumo = kilometros / litros
	
	Escribir "Su consumo es " consumo " km/l"
	
FinProceso
