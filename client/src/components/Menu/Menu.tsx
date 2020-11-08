import React from "react";
import './Menu.css'
import Logo from  './components/Logo';
import Title from "./components/Title";

function Menu() {
    return (
        <div className={"menu"}>
            <div className={"logoCard"}>
                <Logo/>
                <Title/>
            </div>
        </div>
    )
}

export default Menu;