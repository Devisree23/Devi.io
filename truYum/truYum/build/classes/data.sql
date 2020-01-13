SELECT * FROM truyum.menu_item;


/*View Menu Item List Admin*/

INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Sandwich', '99.00', 'Yes', '2017-03-15', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Burger', '129.00', 'Yes', '2017-12-23', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Pizza', '149.00', 'Yes', '2020-08-21', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('French Fries', '57.00', 'No', '2020-07-02', 'Starters', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Chocolate Brownie', '32.00', 'Yes', '2022-11-02', 'Dessert', 'Yes');

SELECT * FROM truyum.menu_item;

INSERT INTO truyum.user (us_name) VALUES ('Chinju');
INSERT INTO truyum.user (us_name) VALUES ('Dhanu');


/*View Menu Item List Customer*/

select *from 
truyum.menu_item
where menu_item.me_date_of_launch>=CURDATE() AND me_active='Yes';

/*Edit Menu Item */

select * FROM truyum.menu_item
where me_id=5;

update truyum.menu_item set
me_name ='Biriyani',
me_date_of_launch='2018-03-03',
me_category='Main Course',
me_free_delivery  ='NO',
me_price =100 where me_id=5;


/*Add to Cart*/

INSERT INTO truyum.cart (ct_us_id, ct_me_id) VALUES ('1', '3');
INSERT INTO truyum.cart (ct_us_id, ct_me_id) VALUES ('1', '4');
INSERT INTO truyum.cart (ct_us_id, ct_me_id) VALUES ('1', '5');

/*View Cart*/ 

use truyum;

select truyum.menu_item.me_name,menu_item.me_free_delivery,menu_item.me_price from cart
inner join menu_item on menu_item.me_id=cart.ct_me_id
inner join user on user.us_id = cart.ct_us_id
where user.us_id = 1;

select truyum.user.us_id,sum(menu_item.me_price) as Total from cart
inner join menu_item on menu_item.me_id = cart.ct_me_id
inner join user on user.us_id = cart.ct_us_id
where user.us_id = 2;

/*Remove Item from Cart*/

delete from truyum.cart where ct_us_id = 2 and ct_me_id = 3;

