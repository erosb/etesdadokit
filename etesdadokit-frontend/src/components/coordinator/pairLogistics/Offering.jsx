import React from 'react'
import CarListing from '../listings/Car/CarListing'
import FoodOfferingDataSheet from './FoodOfferingDataSheet'
import ErrorBoundary from '../../common/ErrorBoundary/ErrorBoundary'

class Offering extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      offering: null,
    }
  }

  componentDidMount() {
    const getFoodFromUrl = '/offer/food/'
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
    }

    return (
      <ErrorBoundary name="Offering">
        <div>
          {parsedOffering.name && (
            <div>
              <FoodOfferingDataSheet offering={parsedOffering} />
              {parsedOffering.transportRequest && <CarListing pairToFood={parsedOffering} />}
            </div>
          )}
        </div>
      </ErrorBoundary>
    )
  }
}

export default Offering
