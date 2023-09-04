CREATE TABLE IF NOT EXISTS some_products (
       productId         int not null generated always as identity,
       productName       varchar(100) not null,
       productCode       varchar(50) not null,
       releaseDate       date not null,
       description       varchar(200) not null,
       price             numeric(12,2) not null,
       starRating        numeric(3,2) not null,
       imageUrl          varchar(100) not null,
       primary key (productId)
);