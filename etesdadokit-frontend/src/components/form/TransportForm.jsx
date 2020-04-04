import React from 'react'
import './Form.css'
import SubFormContact from './SubFormContact'
import { Link } from 'react-router-dom';
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
            } else {
                prevState.formValues[name] = value

                if (name === 'refrigeratorCar') prevState.formValues[name] = this.fixCheckboxValue(value)

                if (name === 'cityOnly') prevState.formValues[name] = this.fixCheckboxValue(value)
            }
            return {
                ...prevState,
            }
        })
    }

    onSubmit = (event) => {
        event.preventDefault()
        const { formValues } = this.state
        const url = '/offer/transport/'

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
        return (
            <form style={{ gridArea: 'form' }} onChange={this.onChange} onSubmit={this.onSubmit}>
                <SubFormContact />

                <div>
                    <div className="has-text-centered is-size-3 margin-top-2">Szállítás</div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Csak városon belül szállítasz?</label>
                        </div>
                        <div className="field-body">
                            <div className="field is-narrow">
                                <div className="control">
                                    <input
                                        className="checkbox"
                                        type="checkbox"
                                        name="cityOnly"
                                        id="cityOnly"
                                        size={30}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Dátum</label>
                        </div>
                        <div className="field-body">
                            <div className="field is-narrow">
                                <div className="control">
                                    <input
                                        className="input"
                                        type="date"
                                        name="offerAvailableDate"
                                        id="offerAvailableDate"
                                        size={30}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Hűtős kocsi?</label>
                        </div>
                        <div className="field-body">
                            <div className="field is-narrow">
                                <div className="control">
                                    <input
                                        className="checkbox"
                                        type="checkbox"
                                        name="refrigeratorCar"
                                        id="refrigeratorCar"
                                        size={30}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Mekkora raktere legyen?</label>
                        </div>
                        <div className="field-body">
                            <div className="field is-narrow">
                                <div className="control">
                                    <input className="input" name="vehicleCapacity" id="vehicleCapacity" size={30} />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="field is-horizontal">
                        <div className="field-label">
                            <label className="label">Hányra menjen leghamarabb? (óra)</label>
                        </div>
                        <div className="field-body">
                            <div className="field is-narrow">
                                <div className="control">
                                    <input
                                        className="input"
                                        placeholder="10:10"
                                        name="availableFrom"
                                        id="availableFrom"
                                        size={30}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="has-text-centered margin-top-1">
                    <Link href="/"><button className="button"> Vissza</button></Link>
                    <input className="button" type="submit" value="Felajánlás elküldése" />
                </div>
            </form>
        )
    }
}

export default TransportForm
