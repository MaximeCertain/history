import React, { Component } from "react";
import "./MovieCard.css"
import Title from "../../DefaultsElements/Title";
import ImageMovieCard from "./components/ImageMovieCard";
import DescriptionMovieCard from "./components/DescriptionMovieCard";
interface IProps {
}

interface IState {
}
export class MovieCard extends Component<IProps, IState>{

    render() {
        return <div className={"container"}>

            <Title title={"Le silence des ânes"} color={"white"}/>

            <div className={"subContainer"}>
                <ImageMovieCard src={"http://www.omdbapi.com/src/poster.jpg"}/>
                <DescriptionMovieCard description={"Le silence des Anes est un film réalisé par Alejandro González Iñárritu sorti le 31 février 2020 "}/>
            </div>

        </div>;
    }

}