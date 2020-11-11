import React from "react";
import '../Menu/components/Logo/Logo.css'

interface TitleProps {
    title: string;
    color: string;
}

export default function title(Props: TitleProps) {
    return <h1 style={{"color": Props.color}}>{Props.title}</h1>
}
