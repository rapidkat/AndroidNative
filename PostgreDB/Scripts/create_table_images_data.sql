CREATE TABLE images_data (
	img_id INT,
	img_url varchar(128),
	img_location varchar(128),
	img_tag_id int,
	PRIMARY KEY (img_id)
);

CREATE TABLE images_tag_data (
	img_tag_id int references images_data(img_id),
	img_tag_keys varchar(128) 
);