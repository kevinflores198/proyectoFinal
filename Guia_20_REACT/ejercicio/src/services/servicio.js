import { API_RM } from './../components/constants/Api';

class servicio {

    //Esta funcion nos traera todos los personajes
    async obtenerTodo() {

        //usamos fetch para comunicarnos con las apis
        const response = await fetch(API_RM.caracteres());
        //Interceptor
        return response.json();
    }

    //Esta funcion nos traera todos los personajes por id
    async obteretTodoPorID(id) {

        //usamos fetch para comunicarnos con las apis
        const response = await fetch(API_RM.caracteresPorId(id));
        //Interceptor
        return response.json();
    }

}

export default new servicio();