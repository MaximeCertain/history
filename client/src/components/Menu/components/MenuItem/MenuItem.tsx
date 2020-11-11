import React from "react";
import "./MenuItem.css"

interface MenuItem {
    title: string;
}

export default function menuItem(Props: MenuItem) {
    return <a className={"category"}><h1>{Props.title}</h1></a>;
}

