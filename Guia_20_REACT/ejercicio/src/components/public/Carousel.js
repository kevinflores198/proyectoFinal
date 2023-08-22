import React from 'react'
import { Link } from 'react-router-dom';

const Carousel = () => {
    return (

        <div id="myCarousel" className="carousel slide mb-6" data-bs-ride="carousel" data-bs-theme="light">
            <div className="carousel-indicators">
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" className="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>


            <div className="carousel-inner">
                <div className="carousel-item active">
                    <img src='3.png' className="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
                    <div className="container">
                        <div className="carousel-caption text-end">
                            <h1>Make an account.</h1>
                            <p className="opacity-75">You'll get the whole info about our page! Don't let it go!</p>
                            <p><a className="btn btn-lg btn-primary" href="#"><Link to={"/user-form"} className="nav-link">Sign up today!</Link></a></p>
                        </div>
                    </div>
                </div>
                <div className="carousel-item">
                    <img src='2.png' className="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
                    <div className="container">
                        <div className="carousel-caption text-end">
                            <h1>Do you really know them?</h1>
                            <p>Visit our website!</p>
                            <p><a className="btn btn-lg btn-primary" href="https://es.wikipedia.org/wiki/Rick_y_Morty">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div className="carousel-item">
                    <img src='1.png' className="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
                    <div className="container">
                        <div className="carousel-caption text-end">
                            <h1>Let's take a look at!</h1>
                            <p>Our streaming platform partner can show our seasons and episodes</p>
                            <p><a  className="btn btn-lg btn-primary" href="https://www.hbomax.com/ar/es/series/urn:hbo:series:GXkRjxwjR68PDwwEAABKJ">watch now!</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <button className="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Previous</span>
            </button>
            <button className="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Next</span>
            </button>
        </div>
    )
}

export default Carousel
