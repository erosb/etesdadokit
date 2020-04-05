import React from 'react'
import './Offering.css'

/**
 *
 * @param {[{"id":1,"name":"Pizza","quantity":50,"transportDate":"2020-04-04","ingredients":"food","address":{"zip":9045,"city":"Budapest","addressLineOne":"Egyik utca","addressLineTwo":"16"},"contact":{"nameOrCompany":"Janos","email":"test@test.com","phoneNumber":"0630123456"},"transportRequest":{"timeToPickUp":"12:00","requestVehicleCapacity":"normal","requestRefrigeratorCar":true}}]} offering
 */
const OfferingDataSheet = ({ offering }) => {
  const {
    name,
    quantity,
    transportDate,
    ingredients,
    contact: { nameOrCompany, email, phoneNumber },
    transportRequest,
    address: { city, zip, addressLineOne, addressLinetwo },
  } = offering

  const { timeToPickUp = null, requestRefrigeratorCar = null, requestVehicleCapacity = null } =
    transportRequest || {}

  return (
    <div className="offering-details">
      <table>
        <tbody>
          <tr>
            <td className="offer-title">Felajánlás </td>
            <td>
              {quantity} db {name}
            </td>
          </tr>
          <tr>
            <td className="offer-title">Hozzávalók</td>
            <td>{ingredients}</td>
          </tr>
          <tr>
            <td className="offer-title">Felajánló neve</td>
            <td>{nameOrCompany}</td>
          </tr>
          <tr>
            <td className="offer-title">Kapcsolattartási adatok</td>
            <td>
              {email} / {phoneNumber}
            </td>
          </tr>
          <tr>
            <td className="offer-title">Cím</td>
            <td>
              {zip}, {city} {addressLineOne}, {addressLinetwo}
            </td>
          </tr>
          <tr>
            <td className="offer-title">Szállítás kért ideje</td>
            <td>
              {transportDate} {timeToPickUp}{' '}
            </td>
          </tr>
          <tr>
            <td className="offer-title">Szükséges szállítási kapacitás</td>
            <td>{requestVehicleCapacity}</td>
          </tr>
          <tr>
            <td className="offer-title">Hűtős kocsi</td>
            <td>{requestRefrigeratorCar ? 'igen' : 'nem'}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default OfferingDataSheet
