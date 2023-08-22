// Escriba una función de JavaScript para 
// obtener los valores de Nombre y Apellido del
// siguiente formulario.

function ingreso() {
        
    var form = document.getElementById("form");

    var nombre
        = form.elements["nombre"].value;

    var apellido
        = form.elements["apellido"].value;

    alert(`La persona ingresada se llama: ${nombre} ${apellido}`);

    return false;

}