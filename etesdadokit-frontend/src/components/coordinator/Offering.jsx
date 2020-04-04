import React from 'react';
import CarListing from './listings/pairLogistics/CarListing';
import OfferingDataSheet from './listings/pairLogistics/OfferingDataSheet';

class Offering extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            offering: null,
            date: ''
        }
    }

    componentDidMount() {
        const getFoodFromUrl = "/offer/food/"
        const url = window.location.href
        const urlsSplit = url.split(getFoodFromUrl)

        fetch(`${getFoodFromUrl}${urlsSplit[1]}`)
            .then(response => response.text())
            .then(data => {
                this.setState({ offering: data, dayParam: data.transportDate })
            });

    }

    render() {
        const { offering, dayParam } = this.state
        return (
            <div>
                {offering && <div>
                    <OfferingDataSheet offering={offering} />
                    <CarListing date={dayParam} pairToFood={offering} />
                </div>}
            </div>
        )
    }
}

export default Offering