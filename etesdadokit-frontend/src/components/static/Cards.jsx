import React from 'react';
import './Cards.css';
import Card1 from './Card1';

const Cards = () => {
  return (
	<div className="cards">
		<div className="columns">
			<div className="column">

				<Card1 />
			</div>
			<div className="column">
				Card2 here
			</div>
			<div className="column">
				Card3 here
			</div>
			<div className="column">
				Card4 here
			</div>
		</div>
  	</div>
)
}

export default Cards;