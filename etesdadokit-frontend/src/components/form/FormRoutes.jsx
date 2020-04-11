import React from 'react'
import { Link } from 'react-router-dom'
import Message from '../static/Intro'
import './Form.css'

const FormRoutes = () => {
  const titleClass =
    'content has-text-centered padding-15 is-size-5 is-size-6-tablet is-size-6-mobile'
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
                  <img src="./assets/restaurant-logo.svg" alt="restaurant logo" />
                </figure>
              </div>

              <div className={titleClass}>Éttermet, ételkiszállítót, pékséget képviselek</div>
            </div>
          </Link>
        </div>
        <div className="raw-material flex-item main-page-card">
          <Link to="/raw-material">
            <div className="card m-h">
              <div className="columns is-flex is-centered">
                <figure className="image is-64x64 margin-top-2">
                  <img src="./assets/raw-material.svg" alt="raw-material logo" />
                </figure>
              </div>

              <div className={titleClass}>Alapanyagom, csomagolóanyagom van</div>
            </div>
          </Link>
        </div>
        <div className="flex-item main-page-card">
          <Link to="/shipping">
            <div className="card m-h">
              <div className="columns is-flex is-centered">
                <figure className="image is-64x64 margin-top-2">
                  <img src="./assets/transport.svg" alt="transport logo" />
                </figure>
              </div>

              <div className={titleClass}>Fuvarozó vagyok</div>
            </div>
          </Link>
        </div>
        <div className="flex-item main-page-card">
          <Link to="/donate">
            <div className="card m-h">
              <div className="columns is-flex is-centered">
                <figure className="image is-64x64 margin-top-2">
                  <img src="./assets/donation-svgrepo-com.svg" alt="donation logo" />
                </figure>
              </div>

              <div className={titleClass}>Pénzbeli segítséget szeretnék nyújtani</div>
            </div>
          </Link>
        </div>
      </div>
    </div>
  )
}

export default FormRoutes
