import React from 'react';
import './Form.css';
import SubFormContact from './SubFormContact'
import SubformAddress from './SubformAddress';
import SubFormTransportRequest from './SubFormTransportRequest'

/**
 * {
  "address": {
    "addressLineOne": "string",
    "addressLineTwo": "string",
    "city": "string",
    "zip": 0
  },
  "contact": {
    "email": "string",
    "nameOrCompany": "string",
    "phoneNumber": "string"
  },
  "ingredients": "string",
  "offerAvailableDate": "2020-04-04T12:25:34.991Z",
  "transportRequest": {
    "requestRefrigeratorCar": true,
    "requestVehicleCapacity": "string",
    "timeToPickUp": {
      "hour": 0,
      "minute": 0,
      "nano": 0,
      "second": 0
    }
  }
}
 */

class RawMaterialForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            formValues: {}
        }
    }

    onChange = (event) => {
        const saveType = event.target.getAttribute("savetype")
        const { target: { id, value } } = event
        this.setState(prevState => {
            if (saveType) {
                prevState.formValues[saveType] = prevState.formValues[saveType] ? prevState.formValues[saveType] : {}
                prevState.formValues[saveType][id] = value
            } else {
                prevState.formValues[id] = value
            }
            return ({
                ...prevState
            })
        })
    }

    onSubmit = (event) => {
        //TODO: transport
        //TODO transportRequest
        //TODO: date format yyyy-mm-dd
        event.preventDefault()
        const { formValues } = this.state
        const url = "/offer/food"

        try {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formValues)
            }).then(response => response.text())
                .then(data => {
                    console.log(data)
                });
        } catch (e) {
            console.log(e)
        }
    }

    render() {
        return (
            <form style={{ gridArea: "form" }}>
                "ingredients": "string",
                "offerAvailableDate": "2020-04-04T12:25:34.991Z",
                <SubformAddress />

                <SubFormContact />

                <SubFormTransportRequest />
                <input type="submit" value="Felajánlás elküldése" />
            </form >
        )
    }
}

export default RawMaterialForm;