import React from 'react'

const SubFormContact = () => {
  return (
    <div>
      <legend className="label has-text-centered margin-top-2">Kapcsolat</legend>

      <div className="field is-horizontal first-field">
        <div className="field-label">
          <label className="label">Neved/Cégnév</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="controll">
              <input
                className="input"
                placeholder=""
                name="nameOrCompany"
                id="nameOrCompany"
                savetype="contact"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Email cím</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="control">
              <input
                className="input"
                placeholder="neved@example.org"
                name="email"
                id="email"
                savetype="contact"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>

      <div className="field is-horizontal">
        <div className="field-label">
          <label className="label">Telefonszám</label>
        </div>
        <div className="field-body">
          <div className="field">
            <div className="control">
              <input
                className="input"
                placeholder="06-30-123-4567"
                name="phoneNumber"
                id="phoneNumber"
                savetype="contact"
                size={30}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default SubFormContact
