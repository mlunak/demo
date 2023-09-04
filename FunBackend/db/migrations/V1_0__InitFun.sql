CREATE TABLE IF NOT EXISTS some_products (
       productId         int not null generated always as identity,
       productName       varchar(100) not null,
       productCode       varchar(50) not null,
       releaseDate       date,
       description       varchar(200),
       price             numeric(12,2),
       starRating        numeric(3,2),
       imageUrl          varchar(100),
       primary key (productId)
);