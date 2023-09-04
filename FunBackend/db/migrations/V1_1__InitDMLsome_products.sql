INSERT INTO some_products
(
   productname
  ,productcode
  ,releasedate
  ,description
  ,price
  ,starrating
  ,imageurl
	)
VALUES
  (
  'Leaf Rake'
  ,'GDN-0011'
  ,to_date('2023-03-03','YYYY-MM-DD')
  ,'Leaf rake with 48-inch wooden handle.'
  ,109.9
  ,3.2
  ,'assets/images/leaf_rake.png'
  );
INSERT INTO some_products
(
   productName
  ,productCode
  ,releaseDate
  ,description
  ,price
  ,starRating
  ,imageUrl
  )
VALUES
  (
   'Garden Cart'
  ,'GDN-0023'
  ,to_date('2021-06-06','YYYY-MM-DD')
  ,'15 gallon capacity rolling garden cart'
  ,32.01
  ,4.4
  ,'assets/images/v.png'
  );
COMMIT;
