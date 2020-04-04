import React from 'react';
import './Form.css';
import SubFormContact from './SubFormContact'
/**
 * {
  "cityOnly": true,
  "contact": {
    "email": "string",
    "nameOrCompany": "string",
    "phoneNumber": "string"
  },
  "firstAvailableHour": 0,
  "offerAvailableDate": "2020-04-04T12:25:56.458Z",
  "refrigeratorCar": true,
  "vehicleCapacity": "string"
}
 */


class TransportForm extends React.Component {

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
                prevState.formValues[saveType][name] = name === "refrigeratorCar" ? this.fixCheckboxValue(value) : value
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
        const url = "/offer/transport/"

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
            <form style={{ gridArea: "form" }} onChange={this.onChange} onSubmit={this.onSubmit}>

                <SubFormContact />

                <fieldset>
                    <div>
                        <legend>Szállítás</legend>
                    </div>

                    <div className="form-group">
                        <label>Csak városon belül szállítasz?</label>
                        <input type="checkbox" name="cityOnly" id="cityOnly" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Dátum</label>
                        <input type="date" name="offerAvailableDate" id="offerAvailableDate" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Hűtős kocsi?</label>
                        <input type="checkbox" name="refrigeratorCar" id="refrigeratorCar" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Mekkora raktere legyen?</label>
                        <input name="vehicleCapacity" id="vehicleCapacity" size={30} />
                    </div>

                    <div className="form-group">
                        <label>Hányra menjen leghamarabb?</label>
                        <input placeholder="10:10" name="firstAvailableHour" id="firstAvailableHour" size={30} />
                    </div>
                </fieldset>



                <input type="submit" value="Felajánlás elküldése" />
            </form>
        )
    }
}

export default TransportForm;