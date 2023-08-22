//Si se compran menos de cinco llantas el precio es de $3000 cada una, si se compran
//entre 5 y 10 el precio es de $2500, y si se compran más de 10 el precio es $2000.
//Obtener la cantidad de dinero que una persona tiene que pagar por cada una de las
//llantas que compra, y el monto total que tiene que pagar por el total de la compra.
Algoritmo ej8guia2_extras
	Definir num,compra,prom1,prom2,prom3 Como Entero
	Escribir "Ingrese la cantidad de llantas que desea comprar"
	Escribir " "
	Escribir "Recordar la promo de:"
	Escribir " "
	Escribir "- de 5=3000$, entre 5 y 10=2500$ y + de 10=2000$"
	Leer num
	
	prom1=3000
	prom2=2500
	prom3=2000
	
	Si num<5 Entonces
		Escribir "Lo que gastaste por cada llanta es " prom1
		Escribir " "
		Escribir "Y lo que gastarias en total el " prom1*num
	SiNo
		Si num>=5 y num<=10 Entonces
			Escribir "Lo que gastaste por cada llanta es " prom2 
			Escribir " "
			Escribir "Y lo que gastarias en total el " prom2*num
		SiNo
			Si num>10 Entonces
				Escribir "Lo que gastaste por cada llanta es " prom3
				Escribir " "
				Escribir "Y lo que gastarias en total el " prom3*num
			FinSi
		FinSi
	FinSi
	
	
FinAlgoritmo
