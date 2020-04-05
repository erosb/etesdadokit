import React, { Component } from 'react'
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import './App.css'
import RestaurantForm from './components/form/RestaurantForm'
import FormRoutes from './components/form/FormRoutes'
import Navigator from './components/static/Navigation'

import PairLogistics from './components/coordinator/pairLogistics/PairLogistics'
import Offering from './components/coordinator/pairLogistics/Offering'

import TransportForm from './components/form/TransportForm'
import RawMaterialForm from './components/form/RawMaterialForm'

import Donate from './components/static/Donate'

export class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      chosenOffering: null,
      layoutClass: '',
    }
  }

  onRestaurantClick() {
    this.setState({
      chosenOffering: (
        <form style={{ gridArea: 'form' }}>
          <div className="form-group">
            <label>Milyen ételt tudsz felajánlani?</label>
            <textarea name="txt-dish" id="txt-dish"></textarea>
          </div>
        </form>
      ),
      layoutClass: 'offering-form',
    })
  }

  render() {
    return (
      <div>
        <Navigator />
        <div className="container">
          {this.state.chosenOffering || (
            <div>
              <BrowserRouter>
                <Switch>
                  <Route path="/restaurant">
                    <RestaurantForm />
                  </Route>
                  <Route path="/shipping">
                    <TransportForm />
                  </Route>
                  <Route path="/raw-material">
                    <RawMaterialForm />
                  </Route>
                  <Route path="/donate">
                    <Donate />
                  </Route>
                  <Route path="/logistics">
                    <PairLogistics />
                  </Route>
                  <Route path="/offer/food">
                    <Offering />
                  </Route>
                  <Route path="/">
                    <FormRoutes />
                  </Route>
                </Switch>
              </BrowserRouter>
            </div>
          )}
        </div>
      </div>
    )
  }
}

export default App
