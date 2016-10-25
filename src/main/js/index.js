import React from 'react';
import ReactDOM from 'react-dom';
import Products from './Products';
import { Router, Route, Link, hashHistory } from 'react-router';

import App from './App';
import Product from './Product';

ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/" component={App}>
            <Route path="products" component={Products} />
        </Route>
    </Router>,
    document.getElementById('root')
);