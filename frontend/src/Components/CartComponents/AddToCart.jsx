import React, {useContext} from 'react'
import { CartContext } from './CartContext'
import { ProductDetailsContext } from '../../ProductDetailsContext';


export default function AddToCart() {

    const [cartItems, setCartItems] = useContext(CartContext);
    const [productDetails, setProductDetails] = useContext(ProductDetailsContext);

    const addToCart = () => {
        setCartItems(prvItems => [...prvItems, productDetails[0]]);
    }

    return (
        <div>
           <button type="button" className="Add-to-cart-btn" onClick= {addToCart}>Add to cart</button> 
        </div>
    )
}
