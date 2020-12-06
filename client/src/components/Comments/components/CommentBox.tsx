import React from "react";
import {Component} from "react";

interface IState {
    comment: []
}

interface Comment {
    content: string
}

interface IProps {
    comment: Comment
}

export class CommentBox extends Component<IProps, IState> {
    render() {
        return (
            <div>
                <p>{this.props.comment.content}</p>
            </div>
        );
    }
}