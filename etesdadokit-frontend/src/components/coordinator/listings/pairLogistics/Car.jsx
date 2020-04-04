import React from 'react';


const Car = (details) => {
    console.log(details)
    const { details: { name } } = details
    return (
        <div>
            {JSON.stringify(details)}
            <div>{name}</div>
        </div>
    );
}

export default Car