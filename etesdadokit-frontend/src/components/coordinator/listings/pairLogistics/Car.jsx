import React from 'react';


const Car = (details) => {

    const onClick = (event) => {
        console.log(event.target)
    }

    const {
        details: {
            transportDate,
            vehicleCapacity,
            refrigeratorCar,
            firstAvailableHour,
            cityOnly,
            contact: { nameOrCompany, email, phoneNumber } }
    } = details
    return (
        <tr>
            <td>{nameOrCompany}</td>
            <td>{email}</td>
            <td>{phoneNumber}</td>
            <td>{transportDate} {firstAvailableHour}:00-</td>
            <td><table>
                <tbody>
                    <tr><td>Kapacitás: {vehicleCapacity}</td></tr>
                    <tr><td>Hűtős? {refrigeratorCar ? "igen" : "nem"}</td></tr>
                    <tr><td>Csak városon belül? {cityOnly ? "igen" : "nem"}</td></tr>
                </tbody>
            </table></td>
            <td>
                <button onClick={onClick}>Kiválaszt</button>
            </td>
        </tr >
    );
}

export default Car