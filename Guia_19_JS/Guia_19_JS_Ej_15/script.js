// 15. Escribe un programa JavaScript 
// para calcular el área y el perímetro de un objeto Círculo
// con la propiedad radio. Nota: Cree
// dos métodos para calcular el área y el perímetro. El
// radio del círculo lo proporcionará el usuario.

var Circulo = {
    radio: 0,
    area: 0,
    perimetro: 0,
    calcularArea: function () {
        return Math.PI * this.radio ** 2;
    },
    calcularPerimetro: function () {
        return Math.PI * this.radio * 2;
    }
}

Circulo.radio = prompt("Ingrese el radio:");
Circulo.area = Circulo.calcularArea();
Circulo.perimetro = Circulo.calcularPerimetro();

var mensaje = `El circulo es:
Radio : ${Circulo.radio}
Area : ${Circulo.area}
Perimetro : ${Circulo.perimetro}`;

alert(mensaje);