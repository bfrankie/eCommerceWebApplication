import React, {useContext, useState} from 'react'
import { Link } from 'react-router-dom';
import './ProductsPreview.css'
import { ProductDetailsContext } from '../../ProductDetailsContext';

const ItemPreview = ({ title, imgURL1, id, price }) => {

    const [productDetails, setProductDetails] = useContext(ProductDetailsContext)

    const viewDetails = e => {

        const productId = (e.target.getAttribute("value"));
        setProductDetails(products => [products[productId - 1]]
        )
        productDetails[productId - 1].quantity = 1;
    }

    return (
        <div className="Products-preview">

            <Link to="/productdetail" className="Product-link" onClick={viewDetails}>
                <img src={imgURL1} value={id} className="Product-preview-img"/>
            </Link>

            <h1 className="Product-preview-title">{title}</h1>
            <h2 className= "Product-price">Price: ${price}</h2>

        </div>
          
    );
};

export default ItemPreview;
