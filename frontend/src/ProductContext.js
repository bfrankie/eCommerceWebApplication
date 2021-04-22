import React, {useState, useEffect, createContext} from 'react';

export const ProductContext = createContext();

export const ProductProvider = props => {
    const [products, setProducts] = useState([]);

    const ECOMMERCE_API_URL= 'http://ecommerceapi.eba-d7nppjwr.us-east-2.elasticbeanstalk.com/products/all-products'

    useEffect(() => {
        fetch(ECOMMERCE_API_URL)
            .then(raw => raw.json())
            .then(res => {
               setProducts(res);
            });
        }, [])

    return(
        <ProductContext.Provider value={[products, setProducts]}>
            {props.children}
        </ProductContext.Provider>
    );

}
