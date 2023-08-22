import React from 'react'
import { Link, useParams } from 'react-router-dom'
import { useEffect, useState } from 'react';
import servicio from '../../services/servicio';

const Detail = () => {

    const [personaje, setPersonaje] = useState({});

    const { id } = useParams();


    useEffect(() => {
        servicio.obteretTodoPorID(id)
            .then((data) => setPersonaje(data))
    }, [])

    return (

        <div className="p-4 p-md-5 mb-4 rounded text-body-emphasis">
            <div className="col-md-3">
                <img src={personaje.image} className="img-fluid rounded-start imgDetalle" alt="img del personaje" />
            </div>
            <div className="col-lg-6 px-0">

                <h1 className="display-4 fst-italic">{personaje.name}</h1>

                <p className="lead my-3"><small className=""> Specie: {personaje.species}</small></p>
                <p className="lead my-3"><small className=""> Status: {personaje.status}</small></p>
                <p className="lead my-3"><small className=""> Gender: {personaje.gender}</small></p>
                <p className="lead my-3"><small className=""> Created: {personaje.created}</small></p>
                <div className="display-4" style={{ 'marginLeft': '15px' }}>
                    <button
                        type="button"
                        className="btn btn-lg btn-primary">
                        <Link
                            to={'/'}
                            className="nav-link px-2">
                            Volver
                        </Link>
                    </button>
                </div>
            </div>
        </div>
    )
}

export default Detail
