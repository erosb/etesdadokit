/* eslint-disable no-console */
import React from 'react'
import { Link } from 'react-router-dom'

const Material = ({ details }) => {
  console.log(details)
  const { id, ingredients, offerDate, transportRequest, contact: { nameOrCompany } } = details
  const transportClass = transportRequest ? 'need-transport' : 'no-transport-needed'

  return (
    <Link to={`/offer/material/${id}`}>
      <div id={id} className={`card food-box ${transportClass}`}>
        <div className="card-flex">

          <div className="card-flex-item">
            <div className="card-title">
              <div> {ingredients}</div>
            </div>
          </div>

          <div className="card-flex-item columns">
            <img className="marker-img" src="./assets/raw-material.svg" alt="raw-material logo" align="right" />
          </div>
        </div>

        <hr />
        <div>Felajánló: {nameOrCompany}</div>
        <div>Kiszállítás: {offerDate || 'ismeretlen'}</div>
        <div>Fuvar: {transportRequest ? 'nem megoldott' : 'megoldott'}</div>
        <div className="card-operation">{transportRequest ? 'Fuvar szervezése' : 'Adatlap megtekintése'} ></div>
      </div>
    </Link>
  )
}

export default Material
