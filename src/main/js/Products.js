import React, {Component} from 'react';
import Product from './Product';
//import $ from "jquery";
import axios from 'axios';

class Products extends Component {
    constructor(props) {
        super(props);
        this.state = {products: []};
        // $.ajax({
        //     method: "GET",
        //     url: "/api/products",
        //     dataType: "json"
        // }).done((data) => {
        //     console.log();
        //     this.setState({products: data});
        // });
        axios.get('/api/products')
            .then((response) => {
                console.log(response.data);
                this.setState({products: response.data});
            });
    }

    render() {
        return (
            <table className="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.products.map(prod => {
                            return <Product key={prod.id} id={prod.id} name={prod.name} price={prod.price} />
                        })
                    }
                </tbody>
            </table>
        );
    } 
}

export default Products;