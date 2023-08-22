import React from 'react'
import { useState } from 'react';
import { Link } from 'react-router-dom';

const Card = ({ personaje }) => {

    //hacemos el hook como boolean para que cambie cuando hacemos el if en el boton
    const [meGusta, setMeGusta] = useState(false);

    const handleClicks = () => {
        setMeGusta(!meGusta);
    }
    return (
        <div className="col" >
            <div className="card shadow-sm">
                <img onClick={handleClicks} src={personaje.image} className={meGusta ? "bd-placeholder-img card-img-top" : "bd-placeholder-img card-img-top"} width="100%" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
                <h3 className="mb-0 text-dark">{personaje.name}</h3>
                <div className="card-body">
                    <p className="card-text">Character number {personaje.id } who appears in this serie and is {personaje.species}. Select details to know more about {personaje.name}.</p>
                    <div className="d-flex justify-content-between align-items-center">
                        <div className="btn-group">
                            <button
                                type="button"
                                className='btn btn-outline-primary'>
                                <Link to={`/detail/${personaje.id}`} className='nav-link'>
                                    Detalle
                                </Link>
                            </button>
                        </div>
                        <div className="btn-group">
                            <button
                                onClick={handleClicks}
                                type="button"
                                className={meGusta ? "btn btn-lg btn-danger" : "btn btn-lg btn-primary"}>
                                Me gusta
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Card
