import React, {useState, createContext, useEffect} from 'react';

export const ProductDetailsContext = createContext();

export const ProductDetailsProvider = props => {
    const [productDetails, setProductDetails] = useState([]);

    const ECOMMERCE_API_URL= 'http://ecommerceapi.eba-d7nppjwr.us-east-2.elasticbeanstalk.com/products/all-products'

    useEffect(() => {
        fetch(ECOMMERCE_API_URL)
            .then(raw => raw.json())
            .then(res => {
               setProductDetails(res);
            });
        }, [])

    return(
        <ProductDetailsContext.Provider value={ [productDetails, setProductDetails]}>
            {props.children}
        </ProductDetailsContext.Provider>
    );

}
