import React from 'react';


const Donations =()=> {
    return (
      <div>
        <h3>Pénzbeli segítséggel</h3>
  
        <p className="bank-transfer-details">
          Ha banki átutalással szeretnél támogatni minket, akkor az alábbi adatokad atd meg:
  
          <table>
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
          </table>
  
        </p>
      </div>
    );
  }

  export default Donations