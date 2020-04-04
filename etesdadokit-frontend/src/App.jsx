import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from "react-router-dom";
import './App.css';
import RestaurantForm from "./components/form/RestaurantForm";
import FormRoutes from './components/form/FormRoutes';
import Message from './components/static/Message';
import Donate from './components/static/Donate';

import PairLogistics from './components/coordinator/listings/pairLogistics/PairLogistics'
import TransportForm from './components/form/TransportForm';
import RawMaterialForm from './components/form/RawMaterialForm';

export class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      chosenOffering: null,
      layoutClass: ""
    };
  }

  onRestaurantClick() {
    this.setState({
      chosenOffering: (
        <form style={{ gridArea: "form" }}>
          <div className="form-group">
            <label>Milyen ételt tudsz felajánlani?</label>
            <textarea name="txt-dish" id="txt-dish"></textarea>
          </div>
        </form>
      ),
      layoutClass: "offering-form"
    })
  }

  render() {
    return (
      <div className="donations-row">

        <div className="donations-col">
          <Message />
        </div>
        <div className="donations-col">
          <div className={this.state.layoutClass}>
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
                    <Route path="/logistics">
                      <PairLogistics />
                    </Route>
                    <Route path="/">
                      <FormRoutes />
                    </Route>
                  </Switch>

                </BrowserRouter>
              </div>)}
          </div>

          <div className="donations-col">
            <Donate />
          </div>
        </div>
      </div>
    );
  }
}

export default App;
