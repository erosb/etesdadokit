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
  "name": "string",
  "quantity": 0,
  "transportDate": "string",
  "transportRequest": {
    "requestRefrigeratorCar": true,
    "requestVehicleCapacity": "string",
    "timeToPickUp": "10:10"
  }
}
 */

class RestaurantForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            formValues: {}
        }
    }

    fixCheckboxValue = (value) => {
        return value === "on" ? true : false
    }

    onChange = (event) => {
        const saveType = event.target.getAttribute("savetype")
        const { target: { name, value } } = event

        this.setState(prevState => {
            if (saveType) {
                prevState.formValues[saveType] = prevState.formValues[saveType] ? prevState.formValues[saveType] : {}
                prevState.formValues[saveType][name] = name === "requestRefrigeratorCar" ? this.fixCheckboxValue(value) : value
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

        const url = "/offer/food/"



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
                        <legend>Készétel felajánlás</legend>
                    </div>
                    <div className="form-group">
                        <label>Milyen ételt tudsz felajánlani?</label>
                        <input name="name" id="name" type="text" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Hány adagot tudsz készíteni? (minimum 50)</label>
                        <input type="number" id="quantity" name="quantity" min="50" max="1000" />
                    </div>

                    <div className="form-group">
                        <label>Milyen fontosabb hozzávalók kellenek hozzá?</label>
                        <textarea cols={30} rows={4} name="ingredients" id="ingredients"></textarea>
                    </div>


                    <div className="form-group">
                        <label>Mikor lesz elérhető?</label>
                        <input type="date" id="transportDate" name="transportDate" />
                    </div>

                    <div className="form-group">
                        <label>Meg tudod oldani a kiszállítást a kórházhoz?</label>
                        <input type="radio" name="canResolveTransport" value="yes" /> Igen, meg tudom oldani
                        <input type="radio" name="canResolveTransport" value="no" /> Nem tudom megoldani
                    </div>
                    {formValues.canResolveTransport === "no" && <SubFormTransportRequest />}

                </fieldset>

                <SubFormContact />

                <SubformAddress />

                <input type="submit" value="Felajánlás elküldése" />
            </form>
        )
    }
}

export default RestaurantForm;