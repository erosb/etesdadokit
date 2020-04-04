import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import Navigation from './components/static/Navigation';
import Intro from './components/static/Intro';
import Cards from './components/static/Cards';

import RestaurantForm from './components/form/RestaurantForm'
import FormRoutes from './components/form/FormRoutes'
//import Message from './components/static/Message'
import Donate from './components/static/Donate'

import PairLogistics from './components/coordinator/listings/pairLogistics/PairLogistics'
import TransportForm from './components/form/TransportForm'
import RawMaterialForm from './components/form/RawMaterialForm'

export class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      chosenOffering: null,
      layoutClass: '',
    }
  }

  render() {
    return (
      <div className="app">
        <Navigation />
        <div className="container">
          <Intro />
          <Cards />
        </div>
      </div>
    )
  }
}

export default App
