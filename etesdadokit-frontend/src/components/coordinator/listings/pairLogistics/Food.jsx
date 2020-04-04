import React from 'react';


const Food = (details) => {
    return (
        <div>
            <div>FOOD</div>
            <div>
                <pre>{JSON.stringify(details)}</pre>
            </div>
        </div>
    );
}

export default Food