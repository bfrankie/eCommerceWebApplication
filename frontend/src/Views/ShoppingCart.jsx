import React, { useContext, useEffect } from 'react'
import CartTotalSummary from "../Components/CartComponents/CartTotalSummary"
import ItemsInCart from "../Components/CartComponents/ItemsInCart"
import CartItem from "../Components/CartComponents/CartItem"
import "../Components/CartComponents/Cart.css"
import { CartContext } from '../Components/CartComponents/CartContext'
import EmptyCart from '../Components/CartComponents/EmptyCart'
import Purchase from '../Components/CartComponents/Purchase'
import { Link } from 'react-router-dom';


 const ShoppingCart = () => {

    const [cartItems, setCartItems] = useContext(CartContext);


    useEffect(()=>{
        const data = localStorage.getItem('data')
        if(data){
          setCartItems(JSON.parse(data))
         }
        },[])
        
        useEffect(()=>{
          localStorage.setItem('data', JSON.stringify(cartItems))
          console.log(cartItems)
        });

    
    
    return (
        <div className= "Shopping-cart">
            <h1>
            <ItemsInCart />
            <EmptyCart />
            </h1>

            <div className="Cart-details">

                <div className= "Cart-items">
                    {cartItems.map(item => (
                        <CartItem item= {item} title= {item.title} price= {item.price} imgURL1= {item.imgURL1} id={item.productID} key ={item.productID}/>
                    ))}
                </div>

                <div className= "Cart-summary">
                    <CartTotalSummary />
                    <Link to= "./checkout"> <Purchase /> </Link>
                </div>

            </div>


        </div>
    )
}


export default ShoppingCart;