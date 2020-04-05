import React from 'react';
import { Link } from 'react-router-dom';


const Food = (details) => {
    const { details: { id, name, quantity, transportDate, transportRequest } } = details
    const transportClass = transportRequest ? "need-transport" : "no-transport-needed"

    return (
        <Link to={`/offer/food/${id}`}>
            <div id={id} className={`food-box ${transportClass}`}>
                <div> {quantity} adag {name}</div>
                <div>Kiszállítás:  {transportDate}</div>
                <div>Fuvar:  {transportRequest ? "nem megoldott" : "megoldott"}</div>
            </div>
        </Link>
    );
}

export default Food