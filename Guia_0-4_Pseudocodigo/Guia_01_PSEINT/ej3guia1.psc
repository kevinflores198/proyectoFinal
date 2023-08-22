//A partir de una conocida cantidad de metros que el usuario ingresa a través del teclado se
//debe obtener su equivalente en centímetros, en milímetros y en pulgadas.
//Ayuda: 1 pulgada equivale a 2.54 centímetros.

Proceso ej3guia1
	
	Definir centimetros, milimetros, pulgadas, metros Como Real
	
	Escribir "Ingrese cantidad de metros"
	
	Leer metros
	
	centimetros = metros * 100
	milimetros = metros * 1000
	pulgadas = centimetros / 2.54
	
	Escribir "El equivalente en centimetros, milimetros y pulgadas es " , centimetros, ", " , milimetros, ", " , pulgadas
	
	FinProceso
