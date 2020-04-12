import React from 'react'
import './Offering.css'
import ErrorBoundary from '../../common/ErrorBoundary/ErrorBoundary'

/**
 * @param {
[
  {
     "id":1,
     "name":"Pizza",
     "quantity":50,
     "transportDate":"2020-04-04",
     "ingredients":"food",
     "address":{
        "zip":9045,
        "city":"Budapest",
        "addressLineOne":"Egyik utca",
        "addressLineTwo":"16"
     },
     "contact":{
        "nameOrCompany":"Janos",
        "email":"test@test.com",
        "phoneNumber":"0630123456"
     },
     "transportRequest":{
        "timeToPickUp":"12:00",
        "requestVehicleCapacity":"normal",
        "requestRefrigeratorCar":true
     }
  }
]
offering
 */

const FoodOfferingDataSheet = ({ offering }) => {
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
    <ErrorBoundary name="FoodOfferingDataSheet">
      <div className="offering-details">
        <table className="desktop">
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

        <div className="mobile">
          <div className="offer-title">Felajánlás </div>
          <div>
            {quantity} db {name}
          </div>
          <div className="offer-title">Hozzávalók</div>
          <div>{ingredients}</div>
          <div className="offer-title">Felajánló neve</div>
          <div>{nameOrCompany}</div>
          <div className="offer-title">Kapcsolattartási adatok</div>
          <div>
            {email} / {phoneNumber}
          </div>
          <div className="offer-title">Cím</div>
          <div>
            {zip}, {city} {addressLineOne}, {addressLinetwo}
          </div>
          <div className="offer-title">Szállítás kért ideje</div>
          <div>
            {transportDate} {timeToPickUp}{' '}
          </div>
          <div className="offer-title">Szükséges szállítási kapacitás</div>
          <div>{requestVehicleCapacity}</div>
          <div className="offer-title">Hűtős kocsi</div>
          <div>{requestRefrigeratorCar ? 'igen' : 'nem'}</div>
        </div>
      </div>
    </ErrorBoundary>
  )
}

export default FoodOfferingDataSheet
