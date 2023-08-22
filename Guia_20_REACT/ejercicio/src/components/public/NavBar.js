import React from 'react'
import { Link } from 'react-router-dom'

const NavBar = () => {
    return (

        <div className="container">
            <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="/" className="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <img src="morty.png" className="App-logo" width="30" ></img>
                    <span to={"/"} className="fs-4">Rick and Morty</span>
                </a>

                <ul className="nav nav-pills">

                    <li className="nav-item"><Link to={"/"} className="nav-link active">Home</Link> </li>
                    <li className="nav-item"><Link to={"/main2"} className="nav-link">Home 2</Link> </li>
                    <li className="nav-item"><Link to={"/user-login"} className="nav-link">Login</Link> </li>
                    <li className="nav-item"><Link to={"/user-form"} className="nav-link">Sign up</Link></li>

                </ul>
            </header>
        </div>

    )
}

export default NavBar
