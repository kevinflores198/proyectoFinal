Algoritmo sin_titulo
//	Crear un vector que contenga 100 notas de 100
//	supuestos estudiantes, con valores entre 0 y
//	20 generadas aleatoriamente mediante el uso de
//	la función azar() o aleatorio() de PseInt.
//	Luego, de acuerdo a las notas contenidas, el 
//programa debe indicar cuántos estudiantes son:
//	a) Deficientes 0-5
//	b) Regulares 6-10
//	c) Buenos 11-15
//	d) Excelentes 16-20
	
	definir vector, i, a, b, c, d Como Entero
	Dimension vector(100)
	a=0
	b=0
	c=0
	d=0
	para i=0 hasta 99 Hacer
		vector(i)=aleatorio(0,20)		
	FinPara
	
	para i=0 hasta 99 Hacer
		si vector(i)<=5 entonces
			a=a+1
		SiNo
			si vector(i)<=10
				b=b+1
			SiNo
				si vector(i)<=15
					c=c+1
				SiNo
					si vector(i)<=20
						d=d+1
					FinSi
				FinSi
			FinSi
		FinSi
	FinPara
	
	Escribir "La cantidad de almnos deficientes es de ", a
	Escribir "La cantidad de almnos regulares es de ", b
	Escribir "La cantidad de almnos benos es de ", c
	Escribir "La cantidad de almnos excelentes es de ", d
FinAlgoritmo
