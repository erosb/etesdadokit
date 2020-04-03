import React, { Component, Fragment, ReactElement } from 'react';
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import './App.css';
import { RestaurantForm } from "./RestaurantForm";

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

function WelcomeContent(props: object) {
  return (<Fragment>
    <h2 id="want-to-support">Hogyan tudsz segíteni minket?</h2>
          <div className="tile" id="tile-offerings">
            <h3>Felajánlással</h3>
            <ul className="offering-types">
              <li className="restaurant">
                <Link to="/restaurant">
                  <span>Éttermet, ételkiszállítót, pékséget képviselek</span>
                  <div className="hover"></div>
                </Link>
              </li>
              <li className="raw-material">
                <Link to="/raw-material">
                  <span>Alapanyagom, csomagolóanyagom van</span>
                  <div className="hover"></div>
                </Link>
              </li>
              <li className="shipping">
                <Link to="/shipping">
                  <span>Fuvarozó vagyok</span>
                  <div className="hover"></div>
                </Link>
              </li>
            </ul>
          </div>

          <div className="tile" id="tile-donations">
            <Donations />
          </div>
  </Fragment>)
}

interface AppState {
  chosenOffering: ReactElement | null,
  layoutClass: string
}

export class App extends Component<any, AppState> {

  public state = {
    chosenOffering: null,
    layoutClass: ""
  };

  onRestaurantClick() {
    this.setState({
      chosenOffering: (
        <form style={{ gridArea: "form" }}>
          <div className="form-group">
            <label>Milyen ételt tudsz felajánlani?</label>
            <textarea name="txt-dish" id="txt-dish"></textarea>
          </div>
        </form>
      ),
      layoutClass: "offering-form"
    })
  }

  render() {
    let content: (ReactElement | null) = this.state.chosenOffering;
    if (content === null) {
      content = (
        <BrowserRouter>
        <Switch>
          <Route path="/restaurant">
            <RestaurantForm />
          </Route>
          <Route path="/">
            <WelcomeContent />
          </Route>
        </Switch>
          
        </BrowserRouter>);
    }
    return (
      <Fragment>
        <div id="main-grid" className={this.state.layoutClass}>
          <Intro />
          {content}
        </div>
      </Fragment>
    );
  }
}

export default App;
