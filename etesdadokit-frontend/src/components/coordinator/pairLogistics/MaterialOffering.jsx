import React from 'react'
import CarListing from '../listings/Car/CarListing'
import OfferingDataSheet from './OfferingDataSheet'
import ErrorBoundary from '../../common/ErrorBoundary/ErrorBoundary'

class MaterialOffering extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            offering: null,
        }
    }

    componentDidMount() {
        const getFoodFromUrl = '/offer/material/'
        const url = window.location.href
        const urlsSplit = url.split(getFoodFromUrl)

        fetch(`${getFoodFromUrl}${urlsSplit[1]}`)
            .then(response => response.text())
            .then(data => {
                this.setState({ offering: data })
            })
    }

    render() {
        const { offering } = this.state

        let parsedOffering = {}
        if (offering && typeof offering === 'string') {
            parsedOffering = JSON.parse(offering)
            console.log(parsedOffering)
        }

        return (
            <ErrorBoundary name="MaterialOffering">
                <div>
                    {parsedOffering.name && (
                        <div>
                            <OfferingDataSheet offering={parsedOffering} />
                            {parsedOffering.transportRequest && <CarListing pairToFood={parsedOffering} />}
                        </div>
                    )}
                </div>
            </ErrorBoundary>
        )
    }
}

export default MaterialOffering
