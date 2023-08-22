//Escribir un programa que calcule cuántos litros de combustible consumió un automóvil. El
//usuario ingresará una cantidad de litros de combustible cargados en la estación y una
//cantidad de kilómetros recorridos, después, el programa calculará el consumo (km/lt) y se lo
//mostrará al usuario.

Proceso sin_titulo
	
	Definir litros, kilometros, consmo Como Real
	
	Escribir "Ingrese los litros de combustible consumidos y kilometros recorridos"
	
	Leer litros
	Leer kilometros
	
	consumo = kilometros / litros
	
	Escribir "Su consumo es " consumo " km/l"
	
FinProceso
