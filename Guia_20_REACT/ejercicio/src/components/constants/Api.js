export const API_RM = {

    //base
    URL: "https://rickandmortyapi.com/api/character",


    //personajes
    caracteres: function () {
        return `${this.URL}`
    },

    //personaje por id
    caracteresPorId: function (id) {
        return `${this.URL}/${id}`
    }
}