import Carousel from './Carousel'
import React, { Component } from 'react'
import Container from './Container'
import Cards from './Cards';

export default class Main extends Component {

    constructor(props) {
        super(props)
        this.state = { cosas: [] };
    }

    componentDidMount() {
    }

    render() {
        return (
            <main>
                <Carousel />

                {/* <Container /> */}

                <Cards/>
            </main>
        )
    }
}

