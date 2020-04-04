import React from 'react';
import './Form.css';


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
        console.log(this.state)
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
                        <label>Hány adagot tudsz készíteni?</label>
                        <input type="number" id="quantity" name="quantity" min="10" max="1000" />
                    </div>

                    <div className="form-group">
                        <label>Milyen fontosabb hozzávalók kellenek hozzá?</label>
                        <textarea cols={30} rows={4} name="ingredients" id="ingredients"></textarea>
                    </div>

                </fieldset>

                <fieldset>
                    <div>
                        <legend>Szállítás</legend>
                    </div>


                    <div className="form-group">
                        <label>Meg tudod oldani a kiszállítást a kórházhoz?</label>
                        <input type="radio" /> Igen, meg tudom oldani
                    <input type="radio" /> Nem tudom megoldani
                    </div>

                    <div className="form-group">
                        <label>Dátum</label>
                        <input type="date" name="transportDate" id="transportDate" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Hűtős kocsi?</label>
                        <input name="requestRefrigeratorCar" id="requestRefrigeratorCar" savetype="transportRequest" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Mekkora raktere legyen?</label>
                        <input name="requestVehicleCapacity" id="requestVehicleCapacity" savetype="transportRequest" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Hányra menjen?</label>
                        <input placeholder="10:10" name="timeToPickUp" id="timeToPickUp" savetype="transportRequest" size={30} />
                    </div>
                </fieldset>


                <fieldset>
                    <div>
                        <legend>Kapcsolat</legend>
                    </div>

                    <div className="form-group">
                        <label>Cégnév, vagy kapcsolattartó neve (saját neved)</label>
                        <input placeholder="" name="nameOrCompany" id="nameOrCompany" savetype="contact" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Email cím</label>
                        <input placeholder="neved@example.org" name="email" id="email" savetype="contact" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Telefonszám</label>
                        <input placeholder="06-30-123-4567" name="phoneNumber" id="phoneNumber" savetype="contact" size={30} />
                    </div>
                </fieldset>


                <fieldset>
                    <div>
                        <legend>Cím</legend>
                    </div>

                    <div className="form-group">
                        <label>Város</label>
                        <input placeholder="" name="city" id="city" savetype="address" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Irányítószám</label>
                        <input placeholder="1111" name="zip" id="zip" savetype="address" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Utca, házszám</label>
                        <input placeholder="" name="addressLineOne" id="addressLineOne" savetype="address" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Emelet, ajtó, kapucsengő</label>
                        <input placeholder="" name="addressLineTwo" id="addressLineTwo" savetype="address" size={30} />
                    </div>
                </fieldset>

                <input type="submit" value="Felajánlás elküldése" />
            </form>
        )
    }
}

export default RestaurantForm;