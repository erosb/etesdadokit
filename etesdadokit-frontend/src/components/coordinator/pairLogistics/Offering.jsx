import React from 'react';
import CarListing from '../listings/Car/CarListing';
import OfferingDataSheet from './OfferingDataSheet';

class Offering extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            offering: null
        }
    }

    componentDidMount() {
        const getFoodFromUrl = "/offer/food/"
        const url = window.location.href
        const urlsSplit = url.split(getFoodFromUrl)

        fetch(`${getFoodFromUrl}${urlsSplit[1]}`)
            .then(response => response.text())
            .then(data => {
                this.setState({ offering: data })
            });
    }

    render() {
        const { offering } = this.state

        return (
            <div>
                {offering && <div>
                    <OfferingDataSheet offering={offering} />
                    {offering && <CarListing pairToFood={offering} />}
                </div>}
            </div>
        )
    }
}

export default Offering