import React, { useContext, useEffect } from 'react'
import Paypal from '../Components/CartComponents/Paypal'
import { CartContext } from '../Components/CartComponents/CartContext'
import ItemsInCart from '../Components/CartComponents/ItemsInCart';
import CartTotalSummary from "../Components/CartComponents/CartTotalSummary"

function Checkout() {

    const [cartItems, setCartItems] = useContext(CartContext);

    // Assign cart items from local storage
    useEffect(()=>{
        const data = localStorage.getItem('data')
        if(data){
          setCartItems(JSON.parse(data))
         }
        },[])

    return (
        <div className="Checkout">
            <ItemsInCart />
            <CartTotalSummary />
            <Paypal />
        </div>
    )
}

export default Checkout
