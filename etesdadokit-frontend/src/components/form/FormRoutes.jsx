import React from 'react'
import { Link } from 'react-router-dom'
import Message from '../static/Intro'
import Donate from '../static/Donate'
import './Form.css'

const FormRoutes = () => {
  return (
    <div>
      <Message />

      <div className="has-text-centered is-size-3 has-text-weight-bold">
        Hogyan tudsz segíteni minket?
      </div>

      <div className="flex-row">
        <div className="flex-item">
          <h3 className="want-to-support">Felajánlással</h3>
          <ul className="offering-types ">
            <li className="restaurant">
              <Link to="/restaurant">
                <div className="card m-h">
                  <div className="columns is-flex is-centered">
                    <figure className="image is-64x64 margin-top-2">
                      <img src="./assets/restaurant-logo.svg" />
                    </figure>
                  </div>

                  <div class="content has-text-centered padding-15 is-size-5 is-size-6-tablet">
                    Éttermet, ételkiszállítót, pékséget képviselek
                  </div>
                </div>
              </Link>
            </li>
            <li className="raw-material">
              <Link to="/raw-material">
                <div className="card m-h">
                  <div className="columns is-flex is-centered">
                    <figure className="image is-64x64 margin-top-2">
                      <img src="./assets/raw-material.svg" />
                    </figure>
                  </div>

                  <div class="content has-text-centered padding-15 is-size-5 is-size-6-tablet">
                    Alapanyagom, csomagolóanyagom van
                  </div>
                </div>
              </Link>
            </li>
            <li className="shipping">
              <Link to="/shipping">
                <div className="card m-h">
                  <div className="columns is-flex is-centered">
                    <figure className="image is-64x64 margin-top-2">
                      <img src="./assets/transport.svg" />
                    </figure>
                  </div>

                  <div class="content has-text-centered padding-15 is-size-5 is-size-6-tablet">
                    Fuvarozó vagyok
                  </div>
                </div>
              </Link>
            </li>
          </ul>
        </div>

        <div className="flex-item">
          <h3 className="want-to-support">Pénzbeli segítséggel</h3>
          <Donate />
        </div>
      </div>
    </div>
  )
}

export default FormRoutes
