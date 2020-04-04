import React from 'react';
import CarListing from './listings/pairLogistics/CarListing';

class Offering extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            offering: null
        }
    }

    componentDidMount() {
        const getFoodFromUrl = "/offer/food?day="
        const getTransportFromUrl = "/offer/transport?day="

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
                this.setState({ offering: data, date: dayParam })
            });

    }

    render() {
        return (
            <div>
                Felajánlás
                {JSON.stringify(this.state)}
                <CarListing date={this.state.dayParam} />
            </div>
        )
    }
}

export default Offering