SELECT * FROM watchmoviegn.movie;

SELECT count(*) FROM watchmoviegn.movie;
update movie set time = 120;

update movie set status = "NEW";

delete from  movie where url_image is null;