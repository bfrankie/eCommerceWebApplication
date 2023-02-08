import React, {useContext, useState, useEffect} from 'react'
import ProductsPreview from '../Components/ProductPreviewComponent/ProductsPreview'
import { ProductDetailsContext } from '../ProductDetailsContext'

const Home = () => {
    const [productDetails, setProductDetails] = useContext(ProductDetailsContext);
    console.log(productDetails);

    return (
        <div className="Homepage">
            {productDetails.map(item => (
                <ProductsPreview imgURL1={item.imgURL1} title= {item.title} price= {item.price} key= {item.productID} id={item.productID} />
            ))}
        </div>
    )
}

export default Home;
