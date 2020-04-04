import React from 'react';
import FoodListing from './FoodListing'
import Food from './Food'

const PairLogistics = () => {

    const url = window.location.href
    var regex = /[?&]([^=#]+)=([^&#]*)/g,
        params = {},
        match;
    while (match = regex.exec(url)) {
        params[match[1]] = match[2];
    }

    return (<div>
        {"for" in params ? <div> RÉSZLETEK </div> :
            <FoodListing />
        } </div>
    );
}

export default PairLogistics