import React, { useContext, useEffect } from 'react'
import { ProductContext } from '../../ProductContext'
import { ProductDetailsContext } from '../../ProductDetailsContext';
import { Link } from 'react-router-dom';
import './SearchBar.css'

export default function SearchBar() {

    const [products, setProducts] = useContext(ProductContext);
    const [productDetails, setProductDetails] = useContext(ProductDetailsContext);
    let searchResults = []
    let input = []
    let searchBar = []

    // Assign input and searchResults after ProductPreview component(s) renders
    useEffect(()=>{

        searchBar = document.getElementsByClassName("Search-input")[0];
        // Search products with every key press
        searchBar.addEventListener('keyup', (e) => {
            input = e.target.value.toLowerCase()
            searchResults = products.filter (product => {
            return product.title.toLowerCase().includes(input) ||
            product.details.toLowerCase().includes(input) || 
            product.category.categoryName.toLowerCase().includes(input) ||
            product.serialNumber.toString().includes(input) ||
            product.price.toString().includes(input);
            })
        });
    });

    const searchProducts = () => {
        document.getElementsByClassName("Search-input")[0].value= ('')
        // Error handling for bad/no user input
        if(searchResults.length > 0) {
        setProductDetails(searchResults)
        } else {
            setProducts(products)
            searchBar.placeholder= "No results found. Try again."
        }
    }

    return (
        <div className="Search-bar">

            <input type="text" placeholder="Search products" className= "Search-input" />

            <Link to= "/" className="Search-products"
                ><button type= "button" className="Search-btn" onClick= {searchProducts}>Search</button>
            </Link>

        </div>
    )
}
