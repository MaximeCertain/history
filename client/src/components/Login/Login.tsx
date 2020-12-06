import React, {Component} from 'react'
import axios from "axios";

interface IState {
    password: string,
    username: string
}

export class Login extends Component<any, any> {

    constructor(props: any) {
        super(props);

        this.state = {
            password: '',
            username: ''
        }

    }

    handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        e.preventDefault();

        this.setState({
            [e.currentTarget.name]: e.currentTarget.value
        })

        /* console.log(event.currentTarget)
         this.setState({
             username: event.currentTarget.value
         })*/
        // this.setState({password: event.target.password});
    }

    async handleSubmit(event: any) {
        //alert('Le nom a été soumis : ' + this.state.value);

        event.preventDefault();

        let response = await axios.post(`http://localhost:8080/api/auth/signin`, {
            username: this.state.username,
            password: this.state.password
        })
        console.log(response)

        //e => this.setState({username: e.target.value})
    }


    render() {
        return (
            <form onSubmit={this.handleSubmit.bind(this)}>
                <label>
                    Username :


                    <input type="text" name="username" value={this.state.username}
                           onChange={this.handleChange.bind(this)}/>
                </label>
                <label>
                    Password :
                    <input type="password" name="password" value={this.state.password}
                           onChange={this.handleChange.bind(this)}/>
                </label>
                <input type="submit" value="Envoyer"/>
            </form>
        );
    }
}