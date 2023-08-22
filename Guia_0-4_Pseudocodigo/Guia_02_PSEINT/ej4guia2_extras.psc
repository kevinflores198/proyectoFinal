//La empresa "Te llevo a todos lados" está destinada al alquiler de autos y tiene un sistema
//de tarifa que consiste en cobrar el alquiler por hora. Si el cliente devuelve el auto dentro
//de las 2 horas de uso el valor que corresponde pagar es de $400 pesos y la nafta va de
//regalo. Cuando el cliente regresa a la empresa pasadas las 2 horas, se ingresan la
//cantidad de litros de nafta gastados y el tiempo transcurrido en horas. Luego, se le cobra
//40 pesos por litro de nafta gastado, y la hora se fracciona en minutos, cobrando un total
//de $5,20 el minuto de uso. Realice un programa que permita registrar esa información y el
//total a pagar por el cliente
Algoritmo ej4guia2_extras
	
	///alquiler por hora, en minutos se fracciona(5.20) . 200$
	///dos horas 400 con nafta de regalo
	///despues de dos horas + cantidad de litros usados (litro sale 40$)
	
	Definir horas,mini,nafta, exceso, naftademas, horapasada, total Como Real
	Escribir "Ingrese cantidad de tiempo utilizada con el auto"
	Leer horas
	horapasada=312
	nafta=40
	mini=400
	naftademas=40
	total=(horapasada * horas) + naftademas
	Si horas <= 2 Entonces
		Escribir "Haz conducido dos horas o menos, por lo cual no tienes costo de nafta, tu pago es " mini " y el combustible va sin cargo"
	SiNo
		Escribir "Haz superado las dos horas de conduccion."
		Escribir " "
		Escribir "Necesitamos verificar la cantidad de litros de nafta gastados y el tiempo transcurrido en horas"
		Leer naftademas, horas
		Escribir "En total es " total
	FinSi
	
	
FinAlgoritmo
