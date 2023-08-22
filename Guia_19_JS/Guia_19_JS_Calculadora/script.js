//variable que tendra el resultado
let parcial = "";

//Esta variable contendra las operaciones
let operacionesHechas = document.getElementById("operaciones");

//donde se pone el resultado
let resultadoObtenido = document.getElementById("resultado");

let operadorSeleccionado = "";

//numero que se va ingresar
let numero = "";

//diferenciar si lo ultimo que se ingreso es un numero u operacion
let ultimoPresionado = "";

function operador(num) {

    //concatenamos el numero
    numero = numero + num;

    parcial = parcial + num;

    //y se muestra la operacion
    operacionesHechas.innerHTML = parcial;

    //division por 0
    if (numero == '0' && operadorSeleccionado == '/') {
        borrar();
        resultadoObtenido.innerHTML = "Indefinido"
        return;
    }
    //guardamos la tecla presonada ultima vez
    if (ultimoPresionado == 'operacion') {
        ultimoPresionado = 'numero'
    }
}

//va detectar cuando se presiona una operacion
function operacion(oper) {
    //guardamos la operacion echa
    operadorSeleccionado = oper;

    //actualiza la ultima tecla seleccionada
    ultimoPresionado = 'operacion';

    //armamos la formula
    parcial = parcial + oper;
    numero = 0;
    operacionesHechas.innerHTML = parcial;
}

//realiza el calculo de la formula matematica si seleccionas =
function calculo() {
    //eval evalua la formula matematica que es string
    parcial = eval(parcial);
    resultadoObtenido.innerHTML = parcial;
    // vuelve a ser string si esta otra vez la formula
    parcial = parcial.toString();
    numero = "";
    operacionesHechas.innerHTML = parcial;
}

function borrar() {
operadorSeleccionado = "";
parcial = "";
resultadoObtenido.innerHTML = "";
numero = "";
operacionesHechas.innerHTML = 0;
}