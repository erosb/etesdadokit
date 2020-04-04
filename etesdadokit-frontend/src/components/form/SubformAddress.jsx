import React from 'react';

const SubformAddress = () => {
    return (
        <fieldset>
            <div>
                <legend>Cím</legend>
            </div>

            <div className="form-group">
                <label>Város</label>
                <input placeholder="" name="city" id="city" savetype="address" size={30} />
            </div>

            <div className="form-group">
                <label>Irányítószám</label>
                <input placeholder="1111" name="zip" id="zip" savetype="address" size={30} />
            </div>

            <div className="form-group">
                <label>Utca, házszám</label>
                <input placeholder="" name="addressLineOne" id="addressLineOne" savetype="address" size={30} />
            </div>

            <div className="form-group">
                <label>Emelet, ajtó, kapucsengő</label>
                <input placeholder="" name="addressLineTwo" id="addressLineTwo" savetype="address" size={30} />
            </div>
        </fieldset>)
}

export default SubformAddress