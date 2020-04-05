import React from 'react';
import history from '../../../../history'
/**
 * 
 * @param {{
  "date": "string",
  "foodSupplyTask": {
    "acceptedFoodOfferId": 0,
    "portions": 0
  },
  "materialSupplyTasks": [
    {
      "acceptedMaterialOfferId": 0,
      "transferTask": {
        "acceptedTransferOfferId": 0,
        "departureTime": {
          "hour": 0,
          "minute": 0,
          "nano": 0,
          "second": 0
        }
      }
    }
  ],
  "transferTask": {
    "acceptedTransferOfferId": 0,
    "departureTime": {
      "hour": 0,
      "minute": 0,
      "nano": 0,
      "second": 0
    }
  }
}} param0 
 */

const Car = ({ details, pairToFood }) => {

    const {
        id: transferId,
        transportDate,
        vehicleCapacity,
        refrigeratorCar,
        firstAvailableHour,
        cityOnly,
        contact: { nameOrCompany, email, phoneNumber }
    } = details


    //POST delivery plan
    const onClick = (event) => {
        const { target: { id } } = event
        const sendDeliveryPlan = {
            date: transportDate,
            foodSupplyTask: {
                acceptedFoodOfferId: id,
                portions: pairToFood.quantity
            },
            transferTask: {
                acceptedTransferOfferId: transferId,
                departureTime: pairToFood.timeToPickUp
            },
            materialSupplyTasks: []
        }

        const url = '/delivery-plan'
        try {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(sendDeliveryPlan)
            }).then(response => response.text())
                .then(data => {
                    history.push('/success')
                });
        } catch (e) {
            console.log(e)
        }
    }


    return (
        <tr>
            <td>{nameOrCompany}</td>
            <td>{email}</td>
            <td>{phoneNumber}</td>
            <td>{transportDate} {firstAvailableHour}:00-</td>
            <td><table>
                <tbody>
                    <tr><td>Kapacitás: {vehicleCapacity}</td></tr>
                    <tr><td>Hűtős? {refrigeratorCar ? "igen" : "nem"}</td></tr>
                    <tr><td>Csak városon belül? {cityOnly ? "igen" : "nem"}</td></tr>
                </tbody>
            </table></td>
            <td>
                <button id={pairToFood.id} onClick={onClick}>Kiválaszt</button>
            </td>
        </tr >
    );
}

export default Car