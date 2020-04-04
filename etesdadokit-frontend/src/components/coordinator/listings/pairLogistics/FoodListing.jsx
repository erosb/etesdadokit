import React from 'react';
import Food from './Food'

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
                    this.setState({ list: data })
                });
        } catch (err) {
            console.log(err)
        }
    }

    render() {
        const { list } = this.state
        let newArr = list
        if (typeof list === "string") {
            newArr = JSON.parse(list)
        }

        return (
            <div>
                {Array.isArray(newArr) && newArr.map(food => (<Food details={food} />))}
            </div>
        );
    }
}

export default FoodListing