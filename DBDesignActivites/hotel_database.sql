DROP DATABASE IF EXISTS hotel;

CREATE DATABASE hotel;
USE hotel;

CREATE TABLE amenityType (
	amenityTypeId INT NOT NULL AUTO_INCREMENT,
    amenityName VARCHAR(50) NOT NULL,
    CONSTRAINT pk_amenityType
		PRIMARY KEY (amenityTypeId)
);

CREATE TABLE room (
	roomNumber INT NOT NULL AUTO_INCREMENT,
    floor INT NOT NULL,
    CONSTRAINT pk_room
		PRIMARY KEY (roomNumber)
);

CREATE TABLE roomHasAmenityType (
	roomNumber INT NOT NULL,
    amenityTypeId INT NOT NULL,
    CONSTRAINT fk_roomHasAmenityType_room
		FOREIGN KEY (roomNumber)
        REFERENCES room (roomNumber),
	CONSTRAINT fk_roomHasAmenityType_amenityType
		FOREIGN KEY (amenityTypeId)
        REFERENCES amenityType (amenityTypeId)
);

CREATE TABLE bed (
	bedId INT NOT NULL AUTO_INCREMENT,
    bedSize VARCHAR(20) NOT NULL,
    roomNumber INT NOT NULL,
    CONSTRAINT pk_bed
		PRIMARY KEY (bedId),
	CONSTRAINT fk_bed_room
		FOREIGN KEY (roomNumber)
        REFERENCES room (roomNumber)
);

CREATE TABLE guest (
	guestId INT NOT NULL AUTO_INCREMENT,
    guestName VARCHAR(100) NOT NULL,
    address VARCHAR(50),
    phoneNumber VARCHAR(11),
    emailAddress VARCHAR(50),
    CONSTRAINT pk_guest
		PRIMARY KEY (guestId)
);

CREATE TABLE reservation (
	reservationId INT NOT NULL AUTO_INCREMENT,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    reservedRoomNumber INT NOT NULL,
    reservedGuestId INT NOT NULL,
    CONSTRAINT pk_reservation
		PRIMARY KEY (reservationId),
	CONSTRAINT fk_reservation_room
		FOREIGN KEY (reservedRoomNumber)
		REFERENCES room (roomNumber),
	CONSTRAINT fk_reservation_guest
		FOREIGN KEY (reservedGuestId)
        REFERENCES guest (guestId)
);

CREATE TABLE reservationHasNonReservingGuest (
	reservationId INT NOT NULL,
    guestId INT NOT NULL,
    CONSTRAINT pk_reservationHasNonReservingGuest
		PRIMARY KEY (reservationId, guestId),
	CONSTRAINT fk_reservationHasNonReservingGuest_reservation
		FOREIGN KEY (reservationId)
        REFERENCES reservation (reservationId),
	CONSTRAINT fk_reservationHasNonReservingGuest_guest
		FOREIGN KEY (guestId)
        REFERENCES guest (guestId)
);

SHOW TABLES;
DESCRIBE RESERVATION;
DESCRIBE GUEST;
DESCRIBE ReservationHasNonReservingGuest;
DESCRIBE ROOM;
DESCRIBE AMENITYType;
DESCRIBE RoomHasAmenityType;
DESCRIBE BED;