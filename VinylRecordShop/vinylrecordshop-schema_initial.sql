/* Benjamin Munoz
   August 8, 2021 */

DROP DATABASE IF EXISTS vinylrecordshop;

CREATE DATABASE vinylrecordshop;
USE vinylrecordshop;

CREATE TABLE artist (
    artistId INT NOT NULL AUTO_INCREMENT,
    artistFirstName VARCHAR(25),
    artistLastName VARCHAR(50) NOT NULL,
    CONSTRAINT pk_artist PRIMARY KEY (artistId)
);

CREATE TABLE band (
    bandId INT NOT NULL AUTO_INCREMENT,
    band_name VARCHAR(50) NOT NULL,
    CONSTRAINT PK_band PRIMARY KEY (bandId)
);

CREATE TABLE bandArtist (
    bandId INT, 
    artistId INT,
    CONSTRAINT pk_band_artist
        PRIMARY KEY (bandId, artistId),
    CONSTRAINT fk_bandArtist_band
        FOREIGN KEY (bandId)
        REFERENCES band (bandId),
    CONSTRAINT FK2_bandArtist_artist FOREIGN KEY (artistId)
        REFERENCES artist (artistId)
);

CREATE TABLE song (
    songId INT NOT NULL AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    bandId INT NOT NULL,
    CONSTRAINT pk_song
        PRIMARY KEY (songId),
    CONSTRAINT fk_song_band
        FOREIGN KEY (bandId)
        REFERENCES band (bandId)
);

CREATE TABLE album (
    albumId INT NOT NULL AUTO_INCREMENT,
    albumTitle VARCHAR(100) NOT NULL,
    label VARCHAR(50),
    releaseDate DATETIME,
    price DECIMAL(5, 2),

    CONSTRAINT pk_album PRIMARY KEY (albumId)
);

CREATE TABLE songAlbum (
    songId INT,
    albumId INT,
    CONSTRAINT pk_songAlbum
        PRIMARY KEY (songId, albumId),
    CONSTRAINT fk_songAlbum_song 
        FOREIGN KEY (songId)
        REFERENCES song (songId),
    CONSTRAINT fk_songAlbum_album
        FOREIGN KEY (albumId)
        REFERENCES album (albumId)
);

SHOW TABLES;
DESCRIBE album;
DESCRIBE artist;
DESCRIBE band;
DESCRIBE bandartist;

DESCRIBE song;
DESCRIBE songAlbum;