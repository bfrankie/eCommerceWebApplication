import React, { useContext, useEffect } from 'react'
import './ProductDetail.css'
import { CartContext } from '../CartComponents/CartContext'
import AddToCart from '../CartComponents/AddToCart'
import Quantity from '../Quantity/Quantity'

const ProductSummary = ({title, serialNumber, price, category, item}) => {

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

    return (
        <div className= "Product-summary">
            <h2>{title}</h2>
            <h6 className="Serial-number">Serial Number: {serialNumber}</h6>
            <h4>Price: ${price}</h4>
            <Quantity item= {item} />
            <AddToCart qty= {item.quantity}/>
            <h6 className="Category">Category: {category}</h6>
        </div>
    )
}

export default ProductSummary;