import React from 'react';

const SubFormContact = () => {

    return (
        <fieldset>
            <div>
                <legend>Kapcsolat</legend>
            </div>

            <div className="form-group">
                <label>Cégnév, vagy kapcsolattartó neve (saját neved)</label>
                <input placeholder="" name="nameOrCompany" id="nameOrCompany" savetype="contact" size={30} />
            </div>

            <div className="form-group">
                <label>Email cím</label>
                <input placeholder="neved@example.org" name="email" id="email" savetype="contact" size={30} />
            </div>

            <div className="form-group">
                <label>Telefonszám</label>
                <input placeholder="06-30-123-4567" name="phoneNumber" id="phoneNumber" savetype="contact" size={30} />
            </div>
        </fieldset>)
}


export default SubFormContact