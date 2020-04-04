import React from 'react';

const SubFormTransportRequest = () => {
    return (<fieldset>
        <div>
            <legend>Szállítás</legend>
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
    </fieldset>)
}

export default SubFormTransportRequest