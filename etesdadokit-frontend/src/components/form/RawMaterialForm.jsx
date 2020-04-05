import React from 'react'
import { Link } from 'react-router-dom';
import history from '../../history'

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

                prevState.formValues[saveType][name] = value

                if (name === 'requestRefrigeratorCar') {
                    prevState.formValues[saveType][name] = this.fixCheckboxValue(value)
                }
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
        const url = '/offer/material/'

        try {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formValues),
            })
                .then((response) => response.text())
                .then(() => {
                    history.push('/thankyou')
                })
        } catch (e) {
            alert("Elnézést kérünk, valamilyen hiba történt!")
            console.log(e)
        }
    }

    goBack = () => {
        history.push('/')
    }

    render() {
        const { formValues } = this.state
        return (
            <form style={{ gridArea: 'form' }} onChange={this.onChange} onSubmit={this.onSubmit}>
                <div className="forms">
                    <div className="has-text-centered is-size-3 margin-top-2">Hozzávaló felajánlás</div>

                    <div className="field is-horizontal margin-top-1">
                        <div className="field-label">
                            <label className="label">Milyen hozzávalót tudsz felajánlani?</label>
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
                            <label className="label">Bármikor elérhető?</label>
                        </div>
                        <div className="field-body">
                            <div className="field is-narrow">
                                <div className="control">
                                    <input className="radio" type="radio" name="availableAnytime" value="yes" /> Igen
                  <input className="radio" type="radio" name="availableAnytime" value="no" /> Nem
                </div>
                            </div>
                        </div>
                    </div>

                    {formValues.availableAnytime === 'no' && (
                        <div className="field is-horizontal">
                            <div className="field-label">
                                <label className="label">Mikor lesz elérhető?</label>
                            </div>
                            <div className="field-body">
                                <div className="field">
                                    <div className="control">
                                        <input
                                            className="input"
                                            type="date"
                                            id="offerAvailableDate"
                                            name="offerAvailableDate"
                                        />
                                    </div>
                                </div>
                            </div>
                        </div>
                    )}

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Meg tudod oldani a kiszállítást étteremhez?</label>
                        </div>
                        <div className="field-body">
                            <div className="field">
                                <input className="radio" type="radio" name="canResolveTransport" value="yes" />{' '}
                Igen, meg tudom oldani
                <input className="radio" type="radio" name="canResolveTransport" value="no" /> Nem
                tudom megoldani
              </div>
                        </div>
                    </div>
                    {formValues.canResolveTransport === 'no' && <SubFormTransportRequest />}
                </div>

                <SubformAddress />

                <SubFormContact />
                <div className="has-text-centered margin-top-1">
                    <button className="button margin-1" onClick={this.goBack}> Vissza</button>
                    <input className="button is-link is-outlined margin-1" type="submit" value="Felajánlás elküldése" />
                </div>
            </form>
        )
    }
}

export default RawMaterialForm
