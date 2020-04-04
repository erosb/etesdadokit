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
        const { target: { name, value } } = event
        this.setState(prevState => {
            if (saveType) {
                prevState.formValues[saveType] = prevState.formValues[saveType] ? prevState.formValues[saveType] : {}
                prevState.formValues[saveType][name] = value
            } else {
                prevState.formValues[name] = value
            }
            return ({
                ...prevState
            })
        })
    }

    onSubmit = (event) => {
        event.preventDefault()
        const { formValues } = this.state
        const url = "/offer/material"

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
        const { formValues } = this.state
        return (
            <form style={{ gridArea: "form" }} onChange={this.onChange} onSubmit={this.onSubmit}>

                <fieldset>
                    <div>
                        <legend>Hozzávaló felajánlás</legend>
                    </div>
                    <div className="form-group">
                        <label>Milyen hozzávalót tudsz felajánlani?</label>
                        <textarea cols={30} rows={4} name="ingredients" id="ingredients"></textarea>
                    </div>

                    <div className="form-group">
                        <label>Mikor lesz elérhető?</label>
                        <input type="date" id="offerAvailableDate" name="offerAvailableDate" />
                    </div>
                    <div className="form-group">
                        <label>Meg tudod oldani a kiszállítást étteremhez?</label>
                        <input type="radio" name="canResolveTransport" value="yes" /> Igen, meg tudom oldani
                        <input type="radio" name="canResolveTransport" value="no" /> Nem tudom megoldani
                    </div>
                    {formValues.canResolveTransport === "no" && <SubFormTransportRequest />}

                </fieldset>

                <SubformAddress />

                <SubFormContact />

                <input type="submit" value="Felajánlás elküldése" />
            </form >
        )
    }
}

export default RawMaterialForm;