import React, {useContext} from 'react'
import ProductDescription from '../Components/ProductDetailComponents/ProductDescription'
import ProductGallery from '../Components/ProductDetailComponents/ProductGallery'
import ProductSummary from '../Components/ProductDetailComponents/ProductSummary'
import { ProductDetailsContext } from '../ProductDetailsContext';
import '../Components/ProductDetailComponents/ProductDetail.css'

const ProductDetail = () => {

    const [productDetails, setProductDetails] = useContext(ProductDetailsContext);

    return (
        <div className="Product-detail">
            {productDetails.map(item => (
                 <ProductGallery imgURL1= {item.imgURL1} imgURL2={item.imgURL2} imgURL3={item.imgURL3} key={item.productID} />
            ))}

            {productDetails.map(item => (
                <ProductSummary title= {item.title} serialNumber={item.serialNumber} price={item.price} category ={item.category.categoryName} key={item.productID} qty= {item.qantity} item= {item}/>
            ))}

            {productDetails.map(item => (
                 <ProductDescription details= {item.details} key={item.productID} />
            ))}

        </div>
    )
}

export default ProductDetail;
