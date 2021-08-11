INSERT INTO album 
	VALUES (1,'Imagine','Apple','1971-9-9',9.99);

INSERT INTO album (albumTitle, releaseDate, price, label)
	VALUES ('2525 (Exordium & Terminus)', '1969-7-1', 25.99, 'RCA');

INSERT INTO album (albumTitle, releaseDate, price, label) VALUES
	("No One's Gonna Change Our World", '1969-12-12', 39.95,'Regal Starline'), 
	('Moondance Studio Album', '1969-8-1',14.99,'Warner Bros');

INSERT INTO album (albumTitle, releaseDate, price, label) VALUES
	("Clouds", '1969-05-01', 9.99, 'Reprise'), 
	('Sounds of Silence Studio Album', '1966-01-17',9.99,'Columbia'),
    ('Abbey Road', '1969-01-10', 12.99, 'Apple'),
    ('Smiley Smile', '1967-09-18', 5.99, 'Capitol');

DELETE FROM album
WHERE albumID = 5;

INSERT INTO album (albumTitle, releaseDate, price, label)
	VALUES ("Clouds", '1969-5-1', 9.99,'Reprise'); 

-- ran into safe update issue
UPDATE album 
	SET albumId = 5
WHERE albumTitle = 'Clouds' and albumId = 9;

SELECT * FROM album;

INSERT INTO artist VALUES (1, "John", "Lennon", TRUE);

/* ENTERED INTO MySQL CLI
LOAD DATA LOCAL INFILE "C:/Users/drive/Documents/artist.csv"
INTO TABLE vinylrecordshop.artist
FIELDS TERMINATED BY ',';
*/
SELECT * FROM artist;

/* Used Table import wizard */
SELECT * FROM band;

/* Used table import wizard for the remaining csv files */

SELECT * FROM songAlbum;

SELECT COUNT(bandId) FROM band;
SELECT COUNT(albumId) FROM album;
SELECT COUNT(artistId) FROM artist;
SELECT COUNT(songId) FROM song;
SELECT COUNT(bandId) FROM bandArtist;
SELECT COUNT(songId) FROM songAlbum;