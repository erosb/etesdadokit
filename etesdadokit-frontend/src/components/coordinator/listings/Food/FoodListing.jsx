/* eslint-disable no-console */
import React from 'react'
import Food from './Food'
import './FoodList.css'
import Material from '../Material/Material'

class FoodListing extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      foodList: [],
      materialList: [],
    }
  }

  componentDidMount() {
    try {
      const url = '/offer/food'
      fetch(url)
        .then(response => response.text())
        .then(data => {
          const array = JSON.parse(data) || []
          this.setState({ foodList: array })
        })
    } catch (err) {
      //
      console.log(err)
    }

    try {
      const url = '/offer/material'
      fetch(url)
        .then(response => response.text())
        .then(data => {
          const array = JSON.parse(data) || []
          this.setState({ materialList: array })
        })
    } catch (err) {
      console.log(err)
    }
  }

  render() {
    const { foodList, materialList } = this.state

    return (
      <div>

        <div className="need-space has-text-centered is-size-3 has-text-weight-bold">Felajánlások</div>
        <form>
          <div>Szűrés dátumra <input type="date" name="filter-date" />          <button type="submit" >Szűrés</button> </div>

        </form>
        <div className="flex-row">
          {Array.isArray(foodList) && foodList.map(food => <Food details={food} />)}
          {Array.isArray(materialList) &&
            materialList.map(material => <Material details={material} />)}
        </div>
      </div>
    )
  }
}

export default FoodListing
