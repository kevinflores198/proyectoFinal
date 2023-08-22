//Una empresa tiene personal de distintas áreas con distintas condiciones de contratación y
//formas de pago. El departamento de contabilidad necesita calcular los sueldos semanales
//(lunes a viernes) en base a las 3 modalidades de sueldo:
//a) comisión
//b) salario fijo + comisión, y
//c) salario fijo
//a) Para la modalidad salario por comisión se debe ingresar el monto total de las ventas
//realizadas en la semana, y el 40% de ese monto total corresponde al salario del
//empleado.
//b) Para la condición de salario fijo + comisión, se debe ingresar el valor que se paga por
//hora, la cantidad de horas trabajadas semanalmente y el monto total de las ventas en
//esa semana. En este tipo de contrato las horas extras no están contempladas y se fija
//como máximo 40 horas por semana. La comisión por las ventas se calcula como 25%
//del valor de venta total.
//c) Finalmente, para la modalidad de salario fijo se debe ingresar el valor que se paga por
//hora y la cantidad de horas trabajadas en la semana. En el caso de exceder las 40
//horas semanales, las horas extras se deben pagar con un extra del 50% del valor de la
//hora. Realizar un menú de opciones para poder elegir el tipo de contrato que tiene un
//empleado.
Algoritmo ej12guia2_extras
	Definir sueldo,com,com1,venta,salc,horas,horas1,sueldo1,horastotal,comisiones,comisionestotal,sal,extras,extrafinal,totalfinal Como Real
	Escribir "Hola, dejenos saber que tipo de sueldo usted recibe"
	Escribir "1 = Comision"
	Escribir "2 = Salario fijo + comisiones"
	Escribir "3 = Solamente salario fijo"
	Leer sueldo
	com=1
	salc=2
	sal=3
	Si sueldo=1 Entonces
		Escribir "Su sueldo es por comision, ahora necesitamos la cantidad de ventas que hizo en la semana"
		Leer venta
		com1=(venta*40)/100
		Escribir "Las comisiones pagadas siempre son un 40%, su sueldo es un total de " com1
		
	SiNo
		
	Si sueldo = 2 Entonces
		Escribir "Usted tiene un sueldo de salario fijo + comisiones, cuantas horas trabaja por dia?"
		Leer horas
		horas1 = horas*5
		Escribir "Usted recibe $1500 por cada hora trabajada"
		Escribir " "
		horastotal = horas1*1500
		Escribir "En esta semana ha trabajado " horas1 " horas y sus sueldo es de $" horastotal
		Escribir "Ahora debemos sumar las comisiones que usted ha logrado esta semana, ingreselas por favor"
		Leer comisiones
		Escribir "Este es el total de ganancias por comision $" comisionestotal
		comisionestotal = (comisiones*25)/100
		Escribir " "
		Escribir "Usted ha logrado un total de $" comisionestotal+horastotal
	SiNo
		
	Si sueldo = 3 Entonces
		Escribir "Usted tiene un sueldo de salario fijo, cuantas horas trabaja por dia?"
		Leer horas
		horas1 = horas*5
		Escribir " "
		horastotal = horas1*1500
		Escribir "En esta semana ha trabajado " horas1 " horas y su sueldo es de " horastotal
	Si horas1 > 40 Entonces
			Escribir "Usted genera $1500 por cada hora trabajada hasta 40 horas, las horas extras valen un 50%"
			extras=(horas1-40)*1500
			extrafinal = (extras*50)/100
			totalfinal = horastotal+extrafinal
			Escribir "Su sueldo es de $" totalfinal
	FinSi
	FinSi
	//FinSi
FinSi
FinSi

FinAlgoritmo
