/* eslint-disable no-console */
import React from 'react'
import { Link } from 'react-router-dom'

const Food = ({ details }) => {
  console.log(details)
  const { id, name, quantity, transportDate, transportRequest, contact: { nameOrCompany } } = details
  const transportClass = transportRequest ? 'need-transport' : 'no-transport-needed'

  const d = new Date(transportDate)
  const weekday = new Array(7);

  weekday[0] = "vasárnap";
  weekday[1] = "hétfő";
  weekday[2] = "kedd";
  weekday[3] = "szerda";
  weekday[4] = "csütörtök";
  weekday[5] = "péntek";
  weekday[6] = "szombat";
  const n = weekday[d.getDay()];

  return (
    <Link to={`/offer/food/${id}`}>
      <div id={id} className={`card m-h food-box ${transportClass}`}>
        <div className="card-flex">

          <div className="card-flex-item">
            <div className="card-title">
              {quantity} adag {name}
            </div>
          </div>

          <div className="card-flex-item columns">
            <img className="marker-img" src="./assets/restaurant-logo.svg" alt="restaurant logo" align="right" />
          </div>
        </div>

        <hr />
        <div>Felajánló: {nameOrCompany}</div>
        <div>Kiszállítás: {transportDate} ({n})</div>
        <div>Fuvar {transportRequest ? 'nem megoldott' : 'megoldott'}</div>
      </div>
    </Link>
  )
}

export default Food
