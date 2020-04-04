import React from 'react';

const SubFormTransportRequest = () => {
    return (<fieldset>
        <div>
            <legend>Szállítás kérés</legend>
        </div>

        <div className="form-group">
            <label>Hűtős kocsira van szükség?</label>
            <input type="checkbox" name="requestRefrigeratorCar" id="requestRefrigeratorCar" savetype="transportRequest" size={30} />
        </div>

        <div className="form-group">
            <label>Mekkora raktere legyen?</label>
            <input name="requestVehicleCapacity" id="requestVehicleCapacity" savetype="transportRequest" size={30} />
        </div>

        <div className="form-group">
            <label>Hányra érkezzen?</label>
            <input placeholder="10:10" name="timeToPickUp" id="timeToPickUp" savetype="transportRequest" size={30} />
        </div>
    </fieldset>)
}

export default SubFormTransportRequest