import React from 'react';
import Car from './Car'
import './CarList.css'

class CarListing extends React.Component {
    constructor(props) {
        super(props)


        this.state = {
            list: [],
            pairToFood: this.props.pairToFood || null
        }
    }

    componentDidMount() {
        try {
            let newArr = this.props.pairToFood
            if (typeof newArr === "string") {
                newArr = JSON.parse(this.props.pairToFood)
            }

            const url = `/offer/transport?day=${newArr.transportDate}`
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
        const { list, pairToFood } = this.state
        let newArr = list
        if (typeof list === "string") {
            newArr = JSON.parse(list)
        }

        return (
            <table>
                <tbody>
                    <tr>
                        <th>Név/cégnév</th>
                        <th>Email</th>
                        <th>Telefon</th>
                        <th>Ráérés</th>
                        <th>Kapacitás</th>
                    </tr>
                    {Array.isArray(newArr) && newArr.map(car => (<Car details={car} pairToFood={pairToFood} />))}
                </tbody>
            </table>
        );
    }
}

export default CarListing