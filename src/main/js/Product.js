import React, { Component } from 'react';

class Product extends Component {
    render() {
        return (
            <tr>
                <td>{this.props.id}</td>
                <td>{this.props.name}</td>
                <td>{this.props.price}</td>
            </tr>
        );
    }
}

export default Product;