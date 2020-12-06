import React, {Component} from 'react'
import axios from "axios";
import SockJsClient from 'react-stomp';
import {CommentBox} from "./components/CommentBox";

interface IState {
    comments: Array<string>,
    contentMessage: string
}


export class Comment extends Component<any, any> {
    private clientRef: any;

    constructor(props: any) {
        super(props);

        this.state = {
            comments: [],
            contentMessage: "j'aime l'oignon frit à l'huile"
        }
    }

    async componentDidMount() {
        try {
            let response = await axios.get(`http://localhost:8080/api/comments`)
            this.setState({
                'comments': response.data
            })
        } catch (e) {
            console.log(e.message);
        }
    }

    async saveComment(event: any){
        await this.clientRef.sendMessage('/app/user-all', JSON.stringify({
            content: this.state.contentMessage
        }))
    }

    async addCommentToList(newComment: string) {
        let newCommentObject = {
            content: newComment
        }
        await this.setState({
            comments: [...this.state.comments, newCommentObject]
        })
    }

    handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        e.preventDefault();
        this.setState({
            [e.currentTarget.name]: e.currentTarget.value
        })
    }

    render() {
        return (
            <div>
                <input type="text" name="contentMessage" value={this.state.contentMessage}
                       onChange={this.handleChange.bind(this)}/>
                <button onClick={this.saveComment.bind(this)}>Yes</button>
                <SockJsClient url='http://localhost:8080/chat/'
                              topics={['/topic/comments']}
                              onConnect={() => {
                                  console.log("connected");
                              }}
                              onDisconnect={() => {
                                  console.log("Disconnected");
                              }}
                              onMessage={(msg) => {
                                  console.log()
                                  this.addCommentToList(msg.content)
                              }}
                              ref={(client) => {
                                  this.clientRef = client
                              }}/>

                {this.state.comments.map((comment: any) =>
                    (<CommentBox comment={comment}/>)
                )}
            </div>
        );
    }
}
