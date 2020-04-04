


import React from 'react';
import { Link } from "react-router-dom";

const FormRoutes = () => {
  return (<div>
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


  </div>)
}

export default FormRoutes