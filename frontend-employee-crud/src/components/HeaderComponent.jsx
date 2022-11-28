import React, {Component} from 'react';

class HeaderComponent extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                          <a className="text-white navbar-brands ">      React Bootstrap </a>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;