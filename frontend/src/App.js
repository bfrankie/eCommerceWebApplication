import React from 'react'
import { Route } from 'react-router-dom'
import { ProductProvider } from './ProductContext'
import { CartProvider } from './Components/CartComponents/CartContext'
import NavBar from './Components/NavBar/NavBar'
import Home from './Views/Home'
import ProductDetail from './Views/ProductDetail'
import ShoppingCart from './Views/ShoppingCart'
import Checkout from './Views/Checkout'
import logo from "./logo.jpg"
import './App.css';
import { ProductDetailsProvider } from './ProductDetailsContext'

  
function App() {

  return (


      <ProductProvider>
      <ProductDetailsProvider>  
      <CartProvider>
      <div className="App">

        <header className="App-header">
          <img src= {logo} className="Logo-img" />
          <NavBar/>
        </header>

        <Route exact path ="/">
          <Home />
        </Route>

        <Route path ="/productdetail">
          <ProductDetail />
        </Route>

        <Route path ="/shoppingcart">
          <ShoppingCart />
        </Route>

        <Route path ="/checkout">
          <Checkout />
        </Route>

      </div>
      </CartProvider>
      </ProductDetailsProvider>
      </ProductProvider>
);
}

export default App;
