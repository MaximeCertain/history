import React from "react";
import "./ImageMovieCard.css"

interface DescriptionMovieCardProps {
    description: string;
}

export default function descriptionMovieCard(Props: DescriptionMovieCardProps) {
    return <p className={"elemSubContainer"}>{Props.description}</p>;
}
