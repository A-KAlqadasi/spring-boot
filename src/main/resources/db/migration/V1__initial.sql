CREATE TABLE products
(
    id UUID PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    price NUMERIC(12, 2) NOT NULL,

    CONSTRAINT ck_products_price_non_negative
        CHECK (price >= 0)
);