//Una verdulería ofrece las manzanas con descuento según la siguiente tabla:
//	Nº DE KILOS COMPRADOS   / % DESCUENTO
//	0 - 2					/	0%				
//	2.01 - 5				/	10%
//	5.01 - 10				/	15%
//	10.01 en adelante		/	20%
//	Determinar cuánto pagará una persona que compre manzanas en esa verdulería

Algoritmo ej10guia2_extras
	Definir man,man2,man3,man4 Como Real
	Escribir "Por favor ingrese la cantiddad kilos que desea de manzanas"
	Escribir " "
	Escribir "Recordar las promos de:" 
	Escribir "  ------------------------------------------"
	Escribir " |  Nº DE KILOS COMPRADOS  | % DESCUENTO    |"
	Escribir "  ------------------------------------------"
	Escribir " |          0-2            |      0%        |"
	Escribir "  ------------------------------------------"
	Escribir " |          2.01-5         |       10%      |"
	Escribir "  ------------------------------------------"
	Escribir " |         5.01-10         |       15%      |"
	Escribir "  ------------------------------------------"
	Escribir " |       10.01 y +         |       20%      |"
	Escribir "  ------------------------------------------"
	Leer man
	man2=10
	man3=15
	man4=20
	
	Si man>=0 y man<=2 Entonces
		Escribir "Haz comprado " man " kg de manzanas y en total vas a pagar sin descuento" 
		SiNo
		Si man>=2.01 y man<=5 Entonces
			Escribir "Haz comprado " man " kg de manzanas y en total vas a pagar con un " man2 "% de descuento" 
			SiNo
			Si man>=5.01 y man<=10 Entonces
				Escribir "Haz comprado " man " kg de manzanas y en total vas a pagar con un " man3 "% de descuento" 
				SiNo
				Si man>=10.01 Entonces
					Escribir "Haz comprado " man " kg de manzanas y en total vas a pagar con un " man4 "% de descuento" 
				FinSi
			FinSi
		FinSi
	FinSi

FinAlgoritmo
