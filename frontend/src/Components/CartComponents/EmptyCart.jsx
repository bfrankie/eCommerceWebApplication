import React, { useContext, useEffect } from 'react'
import { CartContext} from './CartContext'

function EmptyCart() {

    const [cartItems, setCartItems] = useContext(CartContext);    

    const emptyCart = () => {
        setCartItems([]);
    }

    return (
        <div>
           <button type="button" className="Empty-cart-btn" onClick= {emptyCart}>Empty Cart</button> 
        </div>
    )
}

export default EmptyCart
