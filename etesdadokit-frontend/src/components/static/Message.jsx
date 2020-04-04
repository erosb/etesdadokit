import React from 'react';

const Intro = () => {
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
        Amire biztos szükség van: szakácsok, éttermek, konyhák, beszállítók, hűtők-hűtőkocsik,
        marketinges, logisztika,
        csomagolóanyagok. Főleg kapcsolatok, hogy hogyan is lehet <strong>összeszervezni
        és eljuttatni az ételt</strong>.
            </p>

      <p>
        Abszolút elsődleges szempont a biztonság, az éttermeknek a
        HACCP kívánalmaknak meg kell felelnie, a szakácsok
        védőfelszerelésben (szájmaszk+kesztyűben) főznének.
            </p>

      <p>
        <a href="https://www.facebook.com/groups/195786688381007">
          <img
            src="./fb-logo.png"
            className="fb-logo"
            alt="Keress minket Facebookon!"
            title="Keress minket Facebookon!" />
                    &nbsp;Csatlakozz hozzánk Facebookon!
                </a>
      </p>
    </div>
  );
}

export default Intro