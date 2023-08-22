import React, { useState } from 'react'
import { Link } from 'react-router-dom';


export const Footer = () => {

    const [click, setClick] = useState(0);

    const year = new Date().getFullYear();

    const handleClicks = () => {
        setClick(click + 1);
    }

    return (

        <div className="container">
            <footer className="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
                <div className="col mb-3">
                    <a onClick={handleClicks} className="d-flex align-items-center mb-3 link-body-emphasis text-decoration-none">
                        <img src="morty.png" className="App-logo" width="30" href="#bootstrap"></img>
                        <a className="text" >&copy; {year} {click}</a>
                    </a>
                </div>

                <div className="col mb-3">

                </div>

                <div className="col mb-3">
                    <h5>Social Media</h5>
                    <ul className="nav flex-column">
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Facebok</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Twitter</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Instagram</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Tik Tok</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">You Tube</a></li>
                    </ul>
                </div>

                <div className="col mb-3">
                    <h5>Rick and Morty</h5>
                    <ul className="nav flex-column">
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0 ">Home</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0 ">Features</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0 ">Pricing</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0 ">Log in</a></li>
                        <li className="nav-item mb-2"><Link to={"/user-form"} className="nav-link p-0 ">Sign up</Link></li>

                    </ul>
                </div>

                <div className="col mb-3">
                    <h5>Community</h5>
                    <ul className="nav flex-column">
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Issues</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Discussions</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Corporate sponsors</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Open Collective</a></li>
                        <li className="nav-item mb-2"><a href="#" className="nav-link p-0">Stack Overflow</a></li>
                    </ul>
                </div>
            </footer>
        </div>

    )
}

export default Footer
