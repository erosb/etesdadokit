import React, { Component } from 'react'
import { Router, Route, Switch } from 'react-router-dom'
import history from './history'
import './App.css'
import RestaurantForm from './components/form/RestaurantForm'
import FormRoutes from './components/form/FormRoutes'
import Navigator from './components/static/Navigation'

import PairLogistics from './components/coordinator/pairLogistics/PairLogistics'
import Offering from './components/coordinator/pairLogistics/Offering'
import MaterialOffering from './components/coordinator/pairLogistics/MaterialOffering'
import TransportForm from './components/form/TransportForm'
import RawMaterialForm from './components/form/RawMaterialForm'

import Donate from './components/static/Donate'
import ThankYou from './components/static/ThankYou'
import PairSuccess from './components/static/PairSuccess'

class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      chosenOffering: null,
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
    })
  }

  render() {
    return (
      <div>
        <Navigator />
        <div className="container">
          {this.state.chosenOffering || (
            <div>
              <Router history={history}>
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
                  <Route path="/offer/material">
                    <MaterialOffering />
                  </Route>
                  <Route path="/thankyou">
                    <ThankYou />
                  </Route>
                  <Route path="/success">
                    <PairSuccess />
                  </Route>
                  <Route path="/">
                    <FormRoutes />
                  </Route>
                </Switch>
              </Router>
            </div>
          )}
        </div>
      </div>
    )
  }
}

export default App
