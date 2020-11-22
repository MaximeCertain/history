import React, { Component } from "react";
import "./MovieCard.css"
import Title from "../../DefaultsElements/Title";
import ImageMovieCard from "./components/ImageMovieCard";
import DescriptionMovieCard from "./components/DescriptionMovieCard";

interface Movie{
    Title: string,
    Year: number,
    Poster: string,
    Type: string,
    imdbID: string
}
interface IProps {
    movie: Movie
}

interface IState {
}
export class MovieCard extends Component<IProps, IState>{
    render() {
        return <div className={"container"}>

            <Title title={this.props.movie.Title} color={"white"}/>

            <div className={"subContainer"}>
                <ImageMovieCard src={this.props.movie.Poster}/>
                <DescriptionMovieCard description={this.props.movie.Year}/>
            </div>

        </div>;
    }

}