//El promedio de los trabajos prácticos de un curso se calcula en base a cuatro notas de las
//cuales se elimina la nota menor y se promedian las tres notas más altas. Escriba un
//programa que determine cuál es la nota eliminada y el promedio de los trabajos prácticos
//de un estudiante.
Algoritmo ej11guia2_extras
	Definir nota1,nota2,nota3,nota4,prom1,prom2,prom3,prom4,sum1,sum2,sum3,sum4 Como Real
	Escribir "Ingrese las 4 notas de los trabajos practicos"
	Leer nota1,nota2,nota3,nota4
	Escribir " "
	Escribir "Solamente tomaremos las 3 notas mas altas de las 4 ingresadas"
	Escribir " "
	
	sum1=nota2+nota3+nota4
	sum2=nota1+nota3+nota4
	sum3=nota1+nota2+nota4
	sum4=nota1+nota2+nota3
	
	prom1=sum1/3
	prom2=sum2/3
	prom3=sum3/3
	prom4=sum4/3
	
	Si nota1<nota2 y nota1<nota3 y nota1<nota4 entonces
		Escribir "La nota mas baja ingresada es: " nota1 ". Si sumamos las 3 notas mas altas da un total de " sum1 " y su promerdio es de " prom1
		SiNo
		Si nota2<nota1 y nota2<nota3 y nota2<nota4 entonces
			Escribir "La nota mas baja ingresada es: " nota2 ". Si sumamos las 3 notas mas altas da un total de " sum2 " y su promerdio es de " prom2
			SiNo
			Si nota3<nota1 y nota3<nota2 y nota3<nota4 entonces
				Escribir "La nota mas baja ingresada es: " nota3 ". Si sumamos las 3 notas mas altas da un total de " sum3 " y su promerdio es de " prom3
				SiNo
				Si nota4<nota1 y nota4<nota2 y nota4<nota3 entonces
					Escribir "La nota mas baja ingresada es: " nota4 ". Si sumamos las 3 notas mas altas da un total de " sum4 " y su promerdio es de " prom4
				FinSi
			FinSi
		FinSi
	FinSi
FinAlgoritmo
