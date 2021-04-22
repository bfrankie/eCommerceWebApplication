import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { GrCart } from 'react-icons/gr';
import { ProductContext } from '../../ProductContext'
import { ProductDetailsContext } from '../../ProductDetailsContext';
import SearchBar from '../SearchBar/SearchBar'
import "./NavBar.css"

const NavBar = () => {
    const [productDetails, setProductDetails] = useContext(ProductDetailsContext)
    const [products, setProducts] = useContext(ProductContext);
    
    const returnHome = e => {
        setProductDetails(products)
    }

    return (
        <div className="Nav-bar">
            <nav>
                <ul>
                    <li>
                        <Link to= "/" className="Nav-link" onClick= {returnHome}>HOME</Link>
                    </li>
                    <li>
                        <SearchBar />
                    </li>
                    <li>
                        <Link to="/shoppingcart" className="Nav-link"><GrCart size={50}/></Link>
                    </li>
                </ul>
                <hr></hr>
            </nav>
        </div>
    )
}

export default NavBar;
