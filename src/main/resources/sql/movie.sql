INSERT INTO MOVIE VALUES (1, 'Walt Disney Studios',5, 'Avengers: Koniec gry', 'Fantasy', '2016-02-03 00:00:00.0' );
INSERT INTO MOVIE VALUES (2, '20th Century Fox',4.9, 'Avatar', 'Fantasy', '2018-02-03 00:00:00.0');
INSERT INTO MOVIE VALUES (3, '20th Century Fox',4.8, 'Titanic', 'Dramat', '2000-02-05 00:00:00.0');
INSERT INTO MOVIE VALUES (4, 'Universal Studios',4.5, 'Jurassic World', 'Dramat', '2002-02-03 00:00:00.0');
INSERT INTO MOVIE VALUES (5, 'Walt Disney Studios',4.4, 'Avengers', 'Dramat', '2011-12-03 00:00:00.0');
INSERT INTO MOVIE VALUES (6, 'Universal Studios',4.2, 'Szybcy i wściekli 7', 'Dramat', '2016-02-03 00:00:00.0');
INSERT INTO MOVIE VALUES (7, 'Walt Disney Studios',4.0, 'Czarna Pantera', 'Comedy', '2015-02-03 00:00:00.0');
INSERT INTO MOVIE VALUES (8, 'Walt Disney Studios',4.0, 'Piękna i Bestia', 'Comedy', '2000-02-03 00:00:00.0');
INSERT INTO MOVIE VALUES (9, 'Universal Pictures',3.9, 'Szybcy i wściekli 8', 'Comedy', '2016-01-04 00:00:00.0');
INSERT INTO MOVIE VALUES (10, 'Walt Disney Studios',3.5, 'Iron Man 3', 'Fantasy', '2000-01-03 00:00:00.0');

create index title on Movie(title);
create index distributor on Movie(distributor);
create index type on Movie(type);



