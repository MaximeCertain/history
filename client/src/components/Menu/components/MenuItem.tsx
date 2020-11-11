import React, {useState} from "react";

function MenuItem() {
    let title = useState("home");
    return (
        <div>
           <a> <h1>{title}</h1></a>
        </div>
    )
}

export default MenuItem;