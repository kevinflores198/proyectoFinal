
import { API_RM } from './../components/constants/Api.constants';

class RickAndMortyService {

    //Esta funcion nos traera todos los personajes
    async getAllCharacters() {

        //usamos fetch para comunicarnos con las apis
        const response = await fetch(API_RM.CHARACTERS());
        //Interceptor
        return response.json();
    }

    //Esta funcion nos traera todos los personajes por id
    async getAllCharactersById(id) {

        //usamos fetch para comunicarnos con las apis
        const response = await fetch(API_RM.CHARACTER_BY_ID(id));
        //Interceptor
        return response.json();
    }

}

export default new RickAndMortyService();