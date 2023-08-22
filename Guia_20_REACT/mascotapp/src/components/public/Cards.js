// rafc

import React, { useEffect, useState } from 'react'
import Card from './Card'
import RickAndMortyService from '../../services/RickAndMorty.service';


//props son las propiedades que le podrian llegar al componente
const Cards = () => {

    const [mascotas, setmascotas] = useState([])

    //Una escucha activa de lo que va pasar
    useEffect(() => {
        //Determinamos donde vamos a llamar los servicios
        RickAndMortyService.getAllCharacters()
            //this palabra reservada para hacer referencia a algo propio de la clase
            .then((data) => setmascotas(data.results))
            .catch((error) => console.log(error));
    }, [mascotas])

    // cardlist lo que hace es generar cartas en base a los componentes, 
    // se hace un mascotas.map y esas cartas estaran en la variable del jxc
    // siempre debemos marcar una key en cuando se iteran elementos, para que se diferencien 
    const cardList = mascotas.map((m) => <Card mascota={m} key={m.id} />)

    return (

        <div className="album py-5 bg-body-tertiary">
            <div className="container">

                <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    {cardList}
                </div>
            </div>
        </div>
    )
}

export default Cards
