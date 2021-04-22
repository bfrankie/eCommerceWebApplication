import React, { useContext } from 'react'
import "./Cart.css"
import { CartContext } from "./CartContext"


export default function ItemsInCart() {

    const [cartItems, setCartItems] = useContext(CartContext);
    
    const qtyArr = cartItems.map((item) => item.quantity);
    
    const qtyNums = qtyArr.map((qty) => Number(qty));

    const quantitySum = totals => totals.reduce((a, b) => a + b, 0);

    const totalQuantity = (quantitySum(qtyNums));

    return (
        <div className= "Items-in-cart">
            <h1>{totalQuantity} Items in Cart</h1>
        </div>
    )
}
