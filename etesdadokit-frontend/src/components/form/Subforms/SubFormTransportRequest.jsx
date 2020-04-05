import React from 'react'

const SubFormTransportRequest = () => {
  return (
    <div>
      <legend className="label has-text-centered">Szállítás kérés</legend>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Hűtős kocsira van szükség?</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="control">
              <input
                className="checkbox"
                type="checkbox"
                name="requestRefrigeratorCar"
                id="requestRefrigeratorCar"
                savetype="transportRequest"
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
          <div className="field">
            <div className="control">
              <input
                className="input"
                name="requestVehicleCapacity"
                id="requestVehicleCapacity"
                savetype="transportRequest"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Hányra érkezzen?</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="control">
              <input
                className="input"
                placeholder="10:10"
                name="timeToPickUp"
                id="timeToPickUp"
                savetype="transportRequest"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SubFormTransportRequest
