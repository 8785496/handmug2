import React, {Component} from 'react';
import Product from './Product';
import $ from "jquery";

class Products extends Component {
    constructor(props) {
        super(props);
        this.state = {products: []};
        $.ajax({
            method: "GET",
            url: "/api/products",
            dataType: "json"
        }).done((data) => {
            console.log();
            this.setState({products: data});
        });
    }

    render() {
        return (
            <table className="table">
                <thead>
                    <th>#</th>
                    <th>Name</th>
                    <th>Price</th>
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