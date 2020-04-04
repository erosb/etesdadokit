import React from 'react';
import CarListing from './CarListing'
import FoodListing from './FoodListing'

import Offering from '../../Offering'

const PairLogistics = () => {
    return (
        <div>
            <Offering />
            <CarListing />
            <FoodListing />
        </div>
    );
}

export default PairLogistics