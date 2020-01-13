SELECT * FROM moviecruiser.movie_list;

/*View Movie List Admin*/

INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('Avatar', '2787965087', 'Yes', '2017-03-15', 'Science Fiction', 'Yes');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('The Avengers', '1518812988', 'Yes', '2017-12-23', 'Superhero', 'No');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('Titanic', '2187463944', 'Yes', '2017-08-21', 'Romance', 'No');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('Jurassic World', '1671713208', 'No', '2020-07-02', 'Science Fiction', 'Yes');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('Avengers:End Game', '2750760348', 'Yes', '2022-11-02', 'Superhero', 'Yes');

SELECT * FROM moviecruiser.movie_list;

use moviecruiser;
insert into user(us_id, us_name)values(1 , 'Devu');
insert into user(us_id,us_name)values(2 , 'achu');


/*View Movie List Customer*/

select*from moviecruiser.movie_list
where movie_list.mo_date_of_launch>=curdate() AND mo_active = 'Yes';


/*Edit Movie */

select * FROM moviecruiser.movie_list
where mo_id=3;

update moviecruiser.movie_list set
mo_title ='Harrypotter',
mo_date_of_launch='2022-03-03',
mo_genre='Science Fiction',
mo_has_teaser ='NO',
mo_gross =987653 where mo_id=1;

/*Add to Favorite*/

INSERT INTO moviecruiser.favorite (fv_us_id, fv_mo_id) VALUES ('1', '1');
INSERT INTO moviecruiser.favorite (fv_us_id, fv_mo_id) VALUES ('1', '2');
INSERT INTO moviecruiser.favorite (fv_us_id, fv_mo_id) VALUES ('1', '3');


/*View Favorite*/ 

select moviecruiser.movie_list.mo_title,movie_list.mo_genre,movie_list.mo_gross from favorite
inner join movie_list on movie_list.mo_id = favorite.fv_mo_id
inner join user on user.us_id = favorite.fv_us_id
where user.us_id=1;

select moviecruiser.user.us_id, count(movie_list.mo_id) as mo_total from favorite
inner join movie_list on movie_list.mo_id=favorite.fv_mo_id
inner join user on user.us_id = favorite.fv_us_id
where user.us_id=1;


/*Remove Movie from Favorite*/

delete from  moviecruiser.favorite where fv_us_id=1 and fv_mo_id=1;



