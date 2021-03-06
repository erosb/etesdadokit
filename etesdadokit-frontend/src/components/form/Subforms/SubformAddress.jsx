import React from 'react'

const SubformAddress = () => {
  return (
    <div className="forms">
      <legend className="label has-text-centered margin-top-2">Cím</legend>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Város</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="control">
              <input
                className="input"
                placeholder=""
                name="city"
                id="city"
                savetype="address"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Irányítószám</label>
        </div>
        <div className="field-body">
          <div className="field">
            <input
              className="input"
              placeholder="1111"
              name="zip"
              id="zip"
              savetype="address"
              size={30}
              autoComplete="postal-code"
            />
          </div>
        </div>
      </div>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Utca, házszám</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="control">
              <input
                className="input"
                placeholder=""
                name="addressLineOne"
                id="addressLineOne"
                savetype="address"
                autoComplete="address-line1"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Emelet, ajtó, kapucsengő</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="control">
              <input
                className="input"
                placeholder=""
                name="addressLineTwo"
                id="addressLineTwo"
                savetype="address"
                autoComplete="address-line2"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SubformAddress
