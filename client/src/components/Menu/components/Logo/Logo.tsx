import React from "react";
import './Logo.css'

interface LogoProps {
    src: string;
}

export default function logo(Props: LogoProps) {
    return <img className={"logo"} src={Props.src} alt="Logo"/>;
}
