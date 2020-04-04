


import React from 'react';
import { Link } from "react-router-dom";
import Message from '../static/Intro'
import Donate from '../static/Donate'

const FormRoutes = () => {
  return (<div>
    <Message />

    <h2 id="want-to-support">Hogyan tudsz segíteni minket?</h2>

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

    <div className="donations-col">
      <Donate />
    </div>
  </div>)
}

export default FormRoutes