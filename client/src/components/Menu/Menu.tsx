import React from "react";
import './Menu.css'
import Logo from  './components/Logo';
import Title from "./components/Title";
import MenuItem from "./components/MenuItem";

function Menu() {
    return (
        <div className={"menu"}>
            <div className={"logoCard"}>
                <Logo/>
                <Title/>
                <hr/>
                <MenuItem/>
            </div>
        </div>
    )
}

export default Menu;