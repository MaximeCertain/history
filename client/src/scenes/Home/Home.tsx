import React from "react";
import axios from 'axios';
import {MovieCard} from "../../components/Movies/MovieCard/MovieCard";
import "./Home.css"
interface IProps {
}

interface IState {
    movies?: [];
}
interface Movie{
    Title: string,
    Year: number,
    Poster: string,
    Type: string,
    imdbID: string
}

class Home extends React.Component<IProps, IState> {
    constructor(props: IProps) {
        super(props);
        this.state = {
            movies: []
        }
    }

    componentDidMount() {
        axios.get(`http://www.omdbapi.com/?s=Batman&page=2&apikey=81c42988`)
            .then(res => {
                const movies = res.data.Search;
                this.setState({movies});
            })
    }

    render() {
        return (
            <div className={"moviesContainer"}>
                {typeof this.state.movies !== "undefined" && this.state.movies.map((movie: Movie) => (
                    <MovieCard movie={movie} />
                ))}

            </div>
        )
    }
}

export default Home;