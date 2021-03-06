import React from "react";
import './Menu.css'
import Logo from './components/Logo/Logo';
import Title from "../DefaultsElements/Title";
import MenuItem from "./components/MenuItem/MenuItem";
import {Login} from "../Login/Login";
import {Comment} from "../Comments/Comment";


function Menu() {
    return (
        <div className={"menu"}>
            <div className={"logoCard"}>
                <Logo src={"https://www.flaticon.com/svg/static/icons/svg/1169/1169097.svg"}/>
                <Title title={"Cinéma"} color={"white"}/>
                <hr/>
                <Login/>

                    <MenuItem title={"coo"}/>
                    <Comment/>
            </div>
        </div>
);
}

export default Menu;