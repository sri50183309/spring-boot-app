CREATE TABLE THEATRE (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE MOVIES_RUNNING (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE MOVIES_RUNNING_IN_THEATRE(
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    theatre_id INTEGER NOT NULL,
    movie_id INTEGER NOT NULL,
    shows_times VARCHAR(128) NOT NULL,
    start_date VARCHAR(128) NOT NULL,
    end_date VARCHAR(128) NOT NULL
);



INSERT INTO THEATRE (id, name) VALUES (1, 'PVR');
INSERT INTO THEATRE (id, name) VALUES (2, 'INOX');
INSERT INTO THEATRE (id, name) VALUES (3, 'SATYAM');
INSERT INTO THEATRE (id, name) VALUES (4, 'DEVI');
INSERT INTO THEATRE (id, name) VALUES (5, 'IMAX');

INSERT INTO MOVIES_RUNNING (name) VALUES ('RRR');
INSERT INTO MOVIES_RUNNING (name) VALUES ('VIKRAM');
INSERT INTO MOVIES_RUNNING (name) VALUES ('AVENGERS');

INSERT INTO MOVIES_RUNNING_IN_THEATRE (theatre_id, movie_id, shows_times, start_date, end_date) VALUES (1, 1, 'all day(10.30 - 1,2-5.6-9,10-1am)','29-7-2022','5-8-2022');
INSERT INTO MOVIES_RUNNING_IN_THEATRE ( theatre_id, movie_id, shows_times, start_date, end_date) VALUES (1, 2, 'morning only(10.30 - 1)','29-7-2022','5-10-2022');
INSERT INTO MOVIES_RUNNING_IN_THEATRE ( theatre_id, movie_id, shows_times, start_date, end_date) VALUES (5, 3, 'day only(10.30 - 1,2-5)','29-7-2022','5-12-2022');
INSERT INTO MOVIES_RUNNING_IN_THEATRE ( theatre_id, movie_id, shows_times, start_date, end_date) VALUES (3, 1, 'afternoon only(2-5.6-9)','29-7-2022','5-19-2022');
INSERT INTO MOVIES_RUNNING_IN_THEATRE ( theatre_id, movie_id, shows_times, start_date, end_date) VALUES (4, 1, 'late evening(6-9,10-1am)','29-7-2022','5-8-2022');
INSERT INTO MOVIES_RUNNING_IN_THEATRE ( theatre_id, movie_id, shows_times, start_date, end_date) VALUES (2, 2, 'all day(10.30 - 1,2-5.6-9,10-1am)','29-7-2022','5-8-2022');
