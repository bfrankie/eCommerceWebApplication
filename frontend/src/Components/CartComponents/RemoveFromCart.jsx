import React, { useContext, useEffect } from 'react'
import { CartContext } from './CartContext'


export default function RemoveFromCart( {item} ) {

    const [cartItems, setCartItems] = useContext(CartContext);

    useEffect(()=>{
        const data = localStorage.getItem('data')
        if(data){
          setCartItems(JSON.parse(data))
         }
        },[])
        
        useEffect(()=>{
          localStorage.setItem('data',JSON.stringify(cartItems))
        })
    
    const removeItem = () => {
        const index = cartItems.indexOf(item);
        cartItems.splice(index, 1)
        setCartItems([...cartItems]);
        console.log(cartItems);
    }
    return (
        <div>
           <button type="button" className="Rmv-from-cart-btn" onClick= {removeItem} >Remove from cart</button> 
        </div>
    )
}
