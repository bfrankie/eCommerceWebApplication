import React, { useContext } from 'react'
import './Cart.css'
import { CartContext } from "./CartContext"


const CartTotalSummary = () => {
    
    const [cartItems, setCartItems] = useContext(CartContext);
    let shipping = 0;


    const cost = () => {
        const sum = totals => totals.reduce((a, b) => a + b, 0);
        const totals = cartItems.map((item) => item.price * item.quantity);
        return (sum(totals));
    }

    const taxes = (cost() * .0625).toFixed(2);

    if(cartItems.length > 0) {
       shipping = 5.99}

    const totalCost = (cost() + shipping + Number(taxes)).toFixed(2)

    return (
        <div>
            <h3>Subtotal: ${cost()}.00</h3>
            <h3>Shipping: ${shipping} </h3>
            <h3>Taxes: ${taxes} </h3>
            <hr></hr>
            <h3>Total: ${totalCost} </h3>
        </div>
    )
}

export default CartTotalSummary;