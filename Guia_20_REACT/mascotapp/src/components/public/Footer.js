
import React, { useState } from 'react'

const Footer = () => {

    //clicks= existe la bariable que es sometida al estado, setClicks= cambia el estado de click
    const [clicks,setClicks] = useState(0);

    const year = new Date().getFullYear();
    const companyName = "Egg Education";

    const handleClick = () => {
        //Hacemos que la variable clock se le sume 1 para mostrar en pantalla
        setClicks(clicks+1);
    }

    // esto va retornar un jsx element
    return (
        <div className="container">
            <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">

                <p className="col-md-4 mb-0 text-body-secondary">&copy; {year} {companyName} Clicks={clicks}</p>
                <span
                    to={"/"}
                    className="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none"
                onClick={handleClick}
                >
                    <img
                        className="App-logo"
                        height="52"
                        src="gato-tierno.png"
                        alt="perro-giratorio"
                    />
                </span>
                <ul className="nav col-md-4 justify-content-end">
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">Home</a></li>
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">Features</a></li>
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">Pricing</a></li>
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">FAQs</a></li>
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-body-secondary">About</a></li>
                </ul>
            </footer>
        </div>
    )
}

export default Footer
