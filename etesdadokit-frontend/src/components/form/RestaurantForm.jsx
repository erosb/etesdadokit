import React from 'react'
import { Link } from 'react-router-dom'

import './Form.css'
import SubFormContact from './Subforms/SubFormContact'
import SubformAddress from './Subforms/SubformAddress'
import SubFormTransportRequest from './Subforms/SubFormTransportRequest'
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
            formValues: {},
        }
    }

    fixCheckboxValue = (value) => {
        return value === 'on' ? true : false
    }

    onChange = (event) => {
        const saveType = event.target.getAttribute('savetype')
        const {
            target: { name, value },
        } = event

        this.setState((prevState) => {
            if (saveType) {
                prevState.formValues[saveType] = prevState.formValues[saveType]
                    ? prevState.formValues[saveType]
                    : {}
                prevState.formValues[saveType][name] =
                    name === 'requestRefrigeratorCar' ? this.fixCheckboxValue(value) : value
            } else {
                prevState.formValues[name] = value
            }
            return {
                ...prevState,
            }
        })
    }

    onSubmit = (event) => {
        event.preventDefault()
        const { formValues } = this.state

        const url = '/offer/food/'

        try {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formValues),
            })
                .then((response) => response.text())
                .then((data) => {
                    console.log(data)
                })
        } catch (e) {
            console.log(e)
        }
    }

    render() {
        const { formValues } = this.state
        return (
            <div>
                <form style={{ gridArea: 'form' }} onChange={this.onChange} onSubmit={this.onSubmit}>
                    <div className="has-text-centered is-size-3 margin-top-2">Készétel felajánlás</div>

                    <div className="field is-horizontal margin-top-1">
                        <div className="field-label">
                            <label className="label">Milyen ételt tudsz felajánlani?</label>
                        </div>
                        <div className="field-body">
                            <div className="field">
                                <div className="control">
                                    <input className="input" name="name" id="name" type="text" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Hány adagot tudsz készíteni? (minimum 50)</label>
                        </div>
                        <div className="field-body">
                            <div className="field">
                                <div className="control">
                                    <input
                                        className="input"
                                        type="number"
                                        id="quantity"
                                        name="quantity"
                                        min="50"
                                        max="1000"
                                    />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Milyen fontosabb hozzávalók kellenek hozzá?</label>
                        </div>
                        <div className="field-body">
                            <div className="field">
                                <div className="control">
                                    <textarea
                                        className="textarea"
                                        cols={30}
                                        rows={4}
                                        name="ingredients"
                                        id="ingredients"
                                    ></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Mikor lesz elérhető?</label>
                        </div>
                        <div className="field-body">
                            <div className="field">
                                <div className="control">
                                    <input className="input" type="date" id="transportDate" name="transportDate" />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Meg tudod oldani a kiszállítást a kórházhoz?</label>
                        </div>
                        <div className="field-body">
                            <div className="field is-narrow">
                                <div className="control">
                                    <label className="radio">
                                        <input className="radio" type="radio" name="canResolveTransport" value="yes" />{' '}
                    Igen, meg tudom oldani
                  </label>
                                    <label className="radio">
                                        <input className="radio" type="radio" name="canResolveTransport" value="no" />{' '}
                    Nem tudom megoldani
                  </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    {formValues.canResolveTransport === 'no' && <SubFormTransportRequest />}

                    <SubFormContact />

                    <SubformAddress />
                    <div className="has-text-centered margin-top-1">
                        <Link href="/">
                            <button className="button margin-1"> Vissza</button>
                        </Link>
                        <input
                            className="button is-link is-outlined margin-1"
                            type="submit"
                            value="Felajánlás elküldése"
                        />
                    </div>
                </form>
            </div>
        )
    }
}

export default RestaurantForm
