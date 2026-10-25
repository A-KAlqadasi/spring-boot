
CREATE TABLE categories
(
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

ALTER TABLE products
    ADD COLUMN category_id UUID;

ALTER TABLE products
    ADD CONSTRAINT fk_products_category
        FOREIGN KEY (category_id)
            REFERENCES categories(id);

CREATE INDEX ix_products_category_id
    ON products(category_id);

