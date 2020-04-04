import React from 'react';


const Donations = () => {
  return (
    <div>

      <p className="bank-transfer-details">
        Ha banki átutalással szeretnél támogatni minket, akkor az alábbi adatokad add meg:
          </p>
      <table>
        <tbody>
          <tr>
            <td><strong>Kedvezményezett</strong></td>
            <td>Dr Fodor Judit</td>
          </tr>
          <tr>
            <td><strong>Számlavezető bank</strong></td>
            <td>CIB Bank</td>
          </tr>
          <tr>
            <td><strong>Számlaszám</strong></td>
            <td>10700141-53854944-51900001</td>
          </tr>
          <tr>
            <td><strong>Közlemény</strong></td>
            <td>#Etesdadokit! Debrecen</td>
          </tr>
        </tbody>
      </table>


    </div>
  );
}

export default Donations