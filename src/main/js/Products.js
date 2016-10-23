import React, {Component} from 'react';
import Product from './Product';

class Products extends Component {
    render() {
        return (
            <table className="table">
                <tr>
                    <Product />
                </tr>
            </table>
        );
    } 
}

export default Products;