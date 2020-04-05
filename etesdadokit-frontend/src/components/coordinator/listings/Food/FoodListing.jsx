import React from 'react';
import Food from './Food'
import './FoodList.css'

class FoodListing extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            list: []
        }
    }
    async componentDidMount() {
        try {
            const url = "/offer/food"
            fetch(url)
                .then(response => response.text())
                .then(data => {
                    this.setState({ list: JSON.parse(data) })
                });
        } catch (err) {
            console.log(err)
        }
    }

    render() {
        const { list } = this.state

        return (
            <div>
                {Array.isArray(list) && list.map(food => (<Food details={food} />))}
            </div>
        );
    }
}

export default FoodListing