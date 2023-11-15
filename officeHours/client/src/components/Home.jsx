import React, { useEffect } from "react"; // ALWAYS import React!!
import axios from "axios";

const Home = () => {
    useEffect(() => {
        axios.get("http://localhost:8080/")
            .then(response => {
                console.log(response);
            })
            .catch(err => {
                console.log(err);
            })
    });

    return (
        <>
            <h1>Hello there!</h1>
        </>
    );
};

export default Home