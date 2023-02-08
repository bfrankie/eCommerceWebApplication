import React, { useState } from 'react'
import './ProductDetail.css'

const ProductGallery= ({imgURL1, imgURL2, imgURL3}) => {

    let [mainImg, setMainImg]= useState(imgURL1);

    const viewImg = e => {
        setMainImg(e.target.getAttribute("src"));
    }

    return (
        <div className="Product-gallery">
            <div className= "Product-thumbnails">
            <div className="Gallery-img-1">
                <img src={imgURL1} className= "Product-gallery-img" onClick={viewImg} />
            </div>
            <div className="Gallery-img-2">
                <img src={imgURL2} className= "Product-gallery-img" onClick={viewImg} />
            </div>
            <div className="Gallery-img-3">
                <img src={imgURL3} className= "Product-gallery-img" onClick={viewImg}/>
            </div>
            </div>
            <div>
                <img src={mainImg} className= "Main-gallery-img"></img>
            </div>
        </div>
    )
}

export default ProductGallery;
