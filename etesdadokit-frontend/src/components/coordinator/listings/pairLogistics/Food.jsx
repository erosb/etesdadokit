import React from 'react';


const Food = (details) => {
    const { details: { name, quantity, transportDate, transportRequest } } = details
    const transportClass = transportRequest ? "need-transport" : "no-transport-needed"
    return (
        <div className={`food-box ${transportClass}`}>
            <div> {quantity} adag {name}</div>
            <div>Kiszállítás:  {transportDate}</div>
            <div>Fuvar:  {transportRequest ? "nem megoldott" : "megoldott"}</div>
        </div>
    );
}

export default Food