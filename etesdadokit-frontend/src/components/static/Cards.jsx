import React from 'react';
import './Cards.css';
import Card1 from './Card1';

const Cards = () => {
  return (
	<div className="cards">
		<div class="columns">
			<div class="column">
				<Card1 />
			</div>
			<div class="column">
				Card2 here
			</div>
			<div class="column">
				Card3 here
			</div>
			<div class="column">
				Card4 here
			</div>
		</div>
  	</div>
  )
}

export default Cards;