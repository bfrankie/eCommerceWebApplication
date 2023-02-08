import React, { useState, useContext, useEffect } from 'react'
import { CartContext } from '../../Components/CartComponents/CartContext'

function Quantity({ item }) {

    const [itemPrice, setItemPrice] = useState(item.quantity * item.price)
    const [itemQuantity, setItemQuantity] = useState(item.quantity)
    const [cartItems, setCartItems] = useContext(CartContext);

    const handleChange = (e) => {
        item.quantity = (e.target.value);
        setItemQuantity(e.target.value);
        setItemPrice(item.quantity * item.price);
        setCartItems([...cartItems]);
        e.target.value= item.quantity;
        console.log(cartItems);
    }

    return (
        <div>
            <label htmlFor="qty" className="Quantity-label">Qty.</label>
            <select name="qty" className="Quantity" onChange= {handleChange} value= {itemQuantity}>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
        </div>
    )
}


export default Quantity