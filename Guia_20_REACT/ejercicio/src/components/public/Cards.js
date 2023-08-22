import React from 'react'
import Card from './Card'
import { useState, useEffect } from 'react';
import servicio from '../../services/servicio';


const Cards = () => {

    const [personaje, setPersonaje] = useState([])

    useEffect(() => {

        servicio.obtenerTodo()
            .then((data) => setPersonaje(data.results.splice(0,9)))
            .catch((error) => console.log(error))
    }, [personaje])

    const cardList = personaje.map((m) => <Card personaje={m} key={m.id} />)

    return (

        <div className="album py-5">
            <div className="container">
                <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                        {cardList}
                </div>
            </div>
        </div>


    )
}

export default Cards
