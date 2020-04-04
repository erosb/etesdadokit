import React from 'react';
import './Form.css';

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


const TransportForm = () => {
    return (
        <form style={{ gridArea: "form" }}>
            <h2>Készétel felajánlás</h2>
            <div className="form-group">
                <label>Milyen ételt tudsz felajánlani?</label>
                <input name="txt-dish" id="txt-dish" size={30} />
            </div>

            <div className="form-group">
                <label>Hány adagot tudsz készíteni?</label>
                <input type="number" name="dish-count" min="10" max="1000" />
            </div>

            <div className="form-group">
                <label>Milyen fontosabb hozzávalók kellenek hozzá?</label>
                <textarea cols={30} rows={4} name="txt-ingredients"></textarea>
            </div>

            <div className="form-group">
                <label>Meg tudod oldani a kiszállítást a kórházhoz?</label>
                <input type="radio" /> Igen, meg tudom oldani
            <input type="radio" /> Nem tudom megoldani
        </div>

            <fieldset>
                <legend>
                    Kapcsolat
            </legend>
                <div className="form-group">
                    <label>Cégnév, vagy kapcsolattartó neve (saját neved)</label>
                    <input placeholder="" size={30} />
                </div>

                <div className="form-group">
                    <label>Email cím</label>
                    <input placeholder="neved@example.org" size={30} />
                </div>

                <div className="form-group">
                    <label>Telefonszám</label>
                    <input placeholder="06-30-123-4567" size={30} />
                </div>
            </fieldset>

            <input type="submit" value="Felajánlás elküldése" />
        </form>
    )
}

export default TransportForm;