import React from 'react'
import { Link } from 'react-router-dom'
import Message from '../static/Intro'
import Donate from '../static/Donate'
import './Form.css'

const FormRoutes = () => {
  return (
    <div>
      <Message />

      <div className="need-space has-text-centered is-size-3 has-text-weight-bold">
        Milyen felajánlással tudsz segíteni minket?
      </div>

      <div className="flex-row">
        <div className="restaurant flex-item main-page-card">
          <Link to="/restaurant">
            <div className="card m-h">
              <div className="columns is-flex is-centered">
                <figure className="image is-64x64 margin-top-2">
                  <img src="./assets/restaurant-logo.svg" />
                </figure>
              </div>

              <div className="content has-text-centered padding-15 is-size-5 is-size-6-tablet is-size-6-mobile">
                Éttermet, ételkiszállítót, pékséget képviselek
              </div>
            </div>
          </Link>
        </div>
        <div className="raw-material flex-item main-page-card">
          <Link to="/raw-material">
            <div className="card m-h">
              <div className="columns is-flex is-centered">
                <figure className="image is-64x64 margin-top-2">
                  <img src="./assets/raw-material.svg" />
                </figure>
              </div>

              <div className="content has-text-centered padding-15 is-size-5 is-size-6-tablet is-size-6-mobile">
                Alapanyagom, csomagolóanyagom van
              </div>
            </div>
          </Link>
        </div>
        <div className="flex-item main-page-card">
          <Link to="/shipping">
            <div className="card m-h">
              <div className="columns is-flex is-centered">
                <figure className="image is-64x64 margin-top-2">
                  <img src="./assets/transport.svg" />
                </figure>
              </div>

              <div className="content has-text-centered padding-15 is-size-5 is-size-6-tablet is-size-6-mobile">
                Fuvarozó vagyok
              </div>
            </div>
          </Link>
        </div>
        <div className="flex-item main-page-card">
          <Link to="/donate">
            <div className="card m-h">
              <div className="columns is-flex is-centered">
                <figure className="image is-64x64 margin-top-2">
                  <img src="./assets/donation-svgrepo-com.svg" />
                </figure>
              </div>

              <div className="content has-text-centered padding-15 is-size-5 is-size-6-tablet is-size-6-mobile">
                Pénzbeli segítséget szeretnék nyújtani
              </div>
            </div>
          </Link>
        </div>
      </div>
    </div>
  )
}

export default FormRoutes
