//Una tienda ofrece para los meses de septiembre, octubre y noviembre un descuento del
//10% sobre el total de la compra que realiza un cliente. Solicitar al usuario que ingreseun
//mes y el importe de la compra. El programa debe calcular cuál es el monto total que se
//debe cobrar al cliente e imprimirlo por pantalla. 
Algoritmo ej2guia2_extras
	
	Definir letra Como Caracter
	Definir importe, desc, resta Como Real

	Escribir "Ingrese el mes de la compra"
	Leer letra
	Escribir "Ingrese el importe de la compra"
	Leer importe
	
	desc = (importe * 10 / 100)
	resta = importe - desc
	
	Si letra = "octubre" o letra = "noviembre" o letra = "diciembre" Entonces
		Escribir "El precio con el descuento del 10% en este mes es " resta
		Sino
		Escribir "No se recibe descuento por comprar en este mes, el importe es el mismo"
	FinSi
FinAlgoritmo
	