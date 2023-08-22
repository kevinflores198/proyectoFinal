import React from 'react'
import { Link } from 'react-router-dom';

const Card = ({ mascota }) => {
    return (

        <div className="col">
            <div className="card shadow-sm">
                {/* //debemos usar el scr con la mascota y la imagen para traer la imagen a la carta y mostrarlas */}
                <img width="100%" src={mascota.image} alt='imagen' />
                <h3 className="mb-0 text-dark">{mascota.name}</h3>
                <div className="card-body">
                    <p className="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div className="d-flex justify-content-between align-items-center">
                        <div className="btn-group">
                            <button
                                type="button"
                                className='btn btn-sm btn-outline-secundary'>
                                <Link to={`/details/${mascota.id}`} className='nav-link'>
                                    Detalle
                                </Link>
                            </button>
                        </div>
                        <small className="text-body-secondary">9 mins</small>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Card
