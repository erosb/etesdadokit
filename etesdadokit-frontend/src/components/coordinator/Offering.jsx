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
        const getFoodFromUrl = "/offer/food?day="

        const url = window.location.href
        var regex = /[?&]([^=#]+)=([^&#]*)/g,
            params = {},
            match;
        while (match = regex.exec(url)) {
            params[match[1]] = match[2];
        }

        const dayParam = params.day

        fetch(`${getFoodFromUrl}${dayParam}`)
            .then(response => response.text())
            .then(data => {
                this.setState({ offering: data, dayParam })
            });

    }

    render() {
        const { offering, dayParam } = this.state
        return (
            <div>
                {offering && <div>
                    <OfferingDataSheet offering={offering} />
                    <CarListing date={dayParam} />
                </div>}
            </div>
        )
    }
}

export default Offering