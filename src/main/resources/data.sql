USE ecommerceDB;

INSERT INTO category
    (category_name)
VALUES ('Candles'),
       ('Canvases'),
       ('Coffee Mugs');

INSERT INTO product
    (title, price, serial_number, img_url_1, img_url_2, img_url_3, img_url_4, img_url_5, details, category_category_id, quantity)
VALUES ('Teakwood & Mahogany Soy Candle', 20.00, 940336603, 'https://i.etsystatic.com/10385964/r/il/6122c8/2837322878/il_1588xN.2837322878_ijk4.jpg', 'https://i.etsystatic.com/10385964/r/il/e14d41/2834026665/il_794xN.2834026665_ejg5.jpg', 'https://i.etsystatic.com/10385964/r/il/97e876/2834027311/il_794xN.2834027311_g2kb.jpg', 'https://i.etsystatic.com/10385964/d/il/b82ae6/2631724851/il_75x75.2631724851_o6mk.jpg?version=0', 'https://i.etsystatic.com/10385964/d/il/a793db/2884967009/il_75x75.2884967009_8yxk.jpg?version=0', 'SCENT NOTES:\n\n    • Top: Fresh Lavender, Geranium\n    • Middle: Warm Mahogany\n    • Base: Earthy Wood\n\n     CANDLE INFO:\n\n    • Jar Size: 9oz | 7.2oz Net Weight | 2.75 x 2.75 x 3.5\"\n    • Burn Time: 40+ Hours\n    • Wick: Cotton (Lead and Zinc Free)\n    • Wax: Proprietary Soy Based Wax Blend | Vegan, Non-GMO, Kosher | Made in USA\n    • Premium Fragrance Oil\n    • Gluten Free, Phthalate Free, Non-Toxic, Cruelty Free\n    • Made in the USA | Hand-poured in Pittsburgh, PA', 1, 1);