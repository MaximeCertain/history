import React from "react";
import "./ImageMovieCard.css"
interface ImageMovieCardProps {
    src: string;
}

export default function imageMovieCard(Props: ImageMovieCardProps) {
    return <img className={"elemSubContainer"} src={Props.src} alt="Logo"/>;
}
