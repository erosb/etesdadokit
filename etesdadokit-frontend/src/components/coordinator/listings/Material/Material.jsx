/* eslint-disable no-console */
import React from 'react'
import { Link } from 'react-router-dom'

const Material = ({ details }) => {
  console.log(details)
  const { id, ingredients, offerDate, transportRequest } = details
  const transportClass = transportRequest ? 'need-transport' : 'no-transport-needed'

  return (
    <Link to={`/offer/material/${id}`}>
      <div id={id} className={`food-box ${transportClass}`}>
        <div> {ingredients}</div>
        <div>Kiszállítás: {offerDate || 'ismeretlen'}</div>
        <div>Fuvar: {transportRequest ? 'nem megoldott' : 'megoldott'}</div>
      </div>
    </Link>
  )
}

export default Material
