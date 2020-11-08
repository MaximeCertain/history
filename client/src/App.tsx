import React from 'react';
import logo from './logo.svg';
import './App.css';
import Home from "./scenes/Home/Home";
import Menu from "./components/Menu/Menu";

function App() {
    return (
        <div>
            <div className={"App-menu"}>
                <Menu/>
            </div>
            <div className={"App-home"}>
                <Home/></div>
        </div>
        /*<div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    Edit <code>src/App.tsx</code> and save to reload. ok
                </p>
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
        </div>*/
    );
}

export default App;
