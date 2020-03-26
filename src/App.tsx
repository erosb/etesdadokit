import React, { Fragment } from 'react';
import logo from './logo.svg';
import './App.css';

function Intro(props: object) {
  return (
    <div className="intro">
      <h2>Kik vagyunk mi?</h2>
      <p>
        Az <a href="https://www.facebook.com/groups/195786688381007">#EtesdADokit Facebook csoport</a>
                &nbsp;azért jött létre, hogy <strong>segítse az egészségügyben dolgozókat</strong>.
                Pár hét múlva több ezer beteget ápolni megterhelő lesz, az egészségügyben dolgozóknak
                &nbsp;<strong>vitaminokban gazdag étrendre</strong> lesz szükségük.
            </p>

      <p>
        Amire biztos szükség van: szakácsok, éttermek, konyhák, beszállítók, hűtők-hűtőkocsik, marketinges, logisztika,
            csomagolóanyagok. Főleg kapcsolatok, hogy hogyan is lehet <strong>összeszervezni és eljuttatni az ételt</strong>.
            </p>

      <p>
        Abszolút elsődleges szempont a biztonság, az éttermeknek a HACCP kívánalmaknak meg kell felelnie, a szakácsok
        védőfelszerelésben (szájmaszk+kesztyűben) főznének.
            </p>

      <p>
        <a href="https://www.facebook.com/groups/195786688381007">
          <img src="./fb-logo.png" className="fb-logo" alt="Keress minket Facebookon!" title="Keress minket Facebookon!" />
                    &nbsp;Csatlakozz hozzánk Facebookon!
                </a>
      </p>
    </div>
  );
}

function Donations() {
  return (
    <Fragment>
      <h3>Pénzbeli segítséggel</h3>

      <p className="bank-transfer-details">
        Ha banki átutalással szeretnél támogatni minket, akkor az alábbi adatokad add meg:

        <dl>
          <dt>Kedvezményezett</dt>
          <dd>Dr Fodor Judit</dd>

          <dt>Számlavezető bank</dt>
          <dd>CIB Bank</dd>

          <dt>Számlaszám</dt>
          <dd>10700141-53854944-51900001</dd>

          <dt>Közlemény</dt>
          <dd>#Etesdadokit! Debrecen</dd>
        </dl>

            </p>
    </Fragment>
  );
}

function App() {
  return (
    <Fragment>
      {/* <h1>
        <img src="./fb-logo.png" className="fb-logo" alt="Keress minket Facebookon!" title="Keress minket Facebookon!" />
        Etesd A dokit!  
    </h1> */}

      <div id="main-grid">

        <Intro />

        <h2 id="want-to-support">Hogyan tudsz segíteni minket?</h2>

        <div className="tile" id="tile-offerings">
          <h3>Felajánlással</h3>
          <ul className="offering-types">
            <li className="restaurant">
              <span>Éttermet, ételkiszállítót, pékséget képviselek</span>
              <div className="hover"></div>
            </li>
            <li className="raw-material">Alapanyagom, csomagolóanyagom van</li>
            <li className="shipping">Fuvarozó vagyok</li>
          </ul>
        </div>

        <div className="tile" id="tile-donations">
          <Donations />
        </div>

      </div>
    </Fragment>
  );
}

export default App;
