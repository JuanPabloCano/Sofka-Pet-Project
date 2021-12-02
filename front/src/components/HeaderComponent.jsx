import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div > 
                 <header>
                    <nav className="navbar">
                        <div className="header"><h1>App manejo de empleados</h1></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent