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
            const url = "/offer/transport"
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
        console.log(newArr)
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
                    {Array.isArray(newArr) && newArr.map(car => (<Car details={car} />))}
                </tbody>
            </table>
        );
    }
}

export default CarListing