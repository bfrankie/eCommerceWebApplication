import React, { useContext, useState } from 'react'
import Quantity from '../Quantity/Quantity'
import "./Cart.css"
import RemoveFromCart from './RemoveFromCart';
import { Link } from 'react-router-dom';
import { ProductContext } from "../../ProductContext"
import { ProductDetailsContext } from '../../ProductDetailsContext'


export default function CartItem({title, imgURL1, item, id}) {

    const itemPrice = (item.quantity * item.price)
    const [products, setProducts] = useContext(ProductContext);
    const [productDetails, setProductDetails] = useContext(ProductDetailsContext);

    const viewDetails = e => {
        setProductDetails(products)
        const productId = (e.target.getAttribute("value"));
        setProductDetails(products => [products[productId - 1]])
    }

    return (

        <div className= "Cart-item">

            <div>
            <Link to="/productdetail" className="Product-link" onClick={viewDetails}>
                <img src={imgURL1} className= "Cart-item-img" value= {id}></img>
            </Link>
            </div>
            
            <div className= "Cart-item-summary">
                <h2>{title}</h2>
                <Quantity item = {item}/>
                <h3 className= "Subtotal">Subtotal: ${itemPrice}.00</h3>
                <RemoveFromCart item= {item} />
            </div>

        </div>
    )
}
