import React from 'react'
import './ProductDetail.css'


const ProductDescription = ({ details }) => {

    return (
        <div className="Product-description">
            <h2>Description</h2>
            <p>{details}</p>
        </div>
         
    )
}

export default ProductDescription;
