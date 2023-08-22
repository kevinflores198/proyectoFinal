// rce

import React, { Component } from 'react'
import Cards from './Cards';

export default class Main extends Component {

    constructor(props) {
        // El padrr de main es component y con super lo llamamos,
        // component nos lo provee react. Necesitamos ver el pasaje
        // de informacion con los props que son las propiedades que
        // recibe el main component
        super(props)

        //Se le pone un estado inicial, en este caso es un array vacio. initial state
        this.state = { mascotas: [] };
    }

    componentDidMount() {

    }
    render() {
        return (
            <main>
                <section className="py-5 text-center container">
                    <div className="row py-lg-5">
                        <div className="col-lg-6 col-md-8 mx-auto">
                            <h1 className="fw-light">MascotAPP</h1>
                            <p className="lead text-body-secondary">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don’t simply skip over it entirely.</p>
                            <p>
                                <a href="#" className="btn btn-primary my-2">Main call to action</a>
                                <a href="#" className="btn btn-secondary my-2">Secondary action</a>
                            </p>
                        </div>
                    </div>
                </section>
                {/* //de esta manera le estoy pasando a cards las mascotas que necesita */}
                <Cards />
            </main>

        )
    }
}
