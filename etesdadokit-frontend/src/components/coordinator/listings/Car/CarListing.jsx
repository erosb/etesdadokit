import React from 'react';
import Car from './Car'
import './CarList.css'

class CarListing extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            list: []
        }
    }

    componentDidMount() {
        try {
            const url = `/offer/transport?day=${this.props.pairToFood.transportDate}`
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
        const { pairToFood } = this.props
        let newArr = list
        if (typeof list === "string") {
            newArr = JSON.parse(list)
        }

        return (
            <div>
                <table className="desktop">
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
                <div className="mobile">
                    Mobil nézet
                </div>
            </div>
        );
    }
}

export default CarListing