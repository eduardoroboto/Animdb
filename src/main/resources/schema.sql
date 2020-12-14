CREATE TABLE `admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
   PRIMARY KEY (`id`)

  );

CREATE TABLE `usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`)

  );

CREATE TABLE `production` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(300) NOT NULL,
  `author` VARCHAR(45) NULL,
  `synopsis` VARCHAR(5000) NULL,
  `status` VARCHAR(45) NULL,
  `release_date` DATE NULL,
  `format` VARCHAR(10) NULL,
  `rating` FLOAT NULL,
  `duration` INT NULL,
  `episodes` INT NULL,
  `demography` VARCHAR(10) NULL,
  PRIMARY KEY (`id`)

  );

CREATE TABLE `playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_playlist_usuario1`
    FOREIGN KEY (`usuario_id`)
      REFERENCES `usuario` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);


CREATE TABLE `playlist_content` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `playlist_id` INT NOT NULL,
  `production_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_playlist_content_playlist1`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `playlist` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE ,
  CONSTRAINT `fk_playlist_content_production1`
    FOREIGN KEY (`production_id`)
    REFERENCES `production` (`id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
    );


CREATE TABLE `tags` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tag` VARCHAR(45) NULL,
  `production_id` INT NOT NULL,
  PRIMARY KEY (`id`, `production_id`),
  CONSTRAINT `fk_themes_production1`
    FOREIGN KEY (`production_id`)
    REFERENCES `production` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);


CREATE TABLE `casting` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cast` VARCHAR(45) NULL,
  `production_id` INT NOT NULL,
  PRIMARY KEY (`id`, `production_id`),
  CONSTRAINT `fk_Canting_production1`
    FOREIGN KEY (`production_id`)
    REFERENCES `production` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE

    );


insert into usuario (name, email, password) values ('Eduardo','eduardo@gmail.com','edu12345');
insert into usuario (name, email, password) values ('Dede','dede@gmail.com','dede54321');
insert into admin (name, email, password) values ('adminMaster','admin1@animdb.com','adminmaster');
insert into admin (name, email, password) values ('adminNormal','admin2@animdb.com','admin2');
insert into admin (name, email, password) values ('adminFake','admin3@animdb.com','admin3');
insert into admin (name, email, password) values ('adminToDelete','admin4@animdb.com','admin4');


insert into production (title,rating,episodes,format,author,status,release_date,synopsis) values ('One Piece',8.4,995,'anime','Eichiirou Oda','Airing',to_date('20/08/1999','DD/MM/YYYY'),'Gold Roger was known as the Pirate King, the strongest and most infamous being to have sailed the Grand Line. The capture and death of Roger by the World Government brought a change throughout the world. His last words before his death revealed the location of the greatest treasure in the world, One Piece. It was this revelation that brought about the Grand Age of Pirates, men who dreamed of finding One Piece (which promises an unlimited amount of riches and fame), and quite possibly the most coveted of titles for the person who found it, the title of the Pirate King.');
insert into production (title,rating,episodes,format,author,status,release_date,synopsis) values ('Breaking Bad',9.4,62,'serie','Vince Gilligan','Finished',to_date('20/01/2008','DD/MM/YYYY'),'A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family''s future. ');

insert into production (title,rating,format,author,status,release_date,synopsis) values('Um Sonho de Liberdade (1994)',9.2,'movie','Stephen King','Released',to_date('17/03/1995','DD/MM/YYYY'),'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('Poderoso Chefão (1972)',9.1,'movie','Mario Puzo, Francis Ford Coppola','Released',to_date('17/03/1995','DD/MM/YYYY'),'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('Poderoso Chefão II (1974)',9.0,'movie','Mario Puzo, Francis Ford Coppola','Released',to_date('14/03/1975','DD/MM/YYYY'),'The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('Batman O Cavaleiro das Trevas(2008)',9.0,'movie',' Jonathan Nolan,Christopher Nolan','Released',to_date('18/07/2008','DD/MM/YYYY'),'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('12 Homens e uma Sentença (1957)',8.9,'movie','Reginald Rose,Reginald Rose','Released',to_date('10/10/1958','DD/MM/YYYY'),'A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('Lista de Schindler (1993)',8.9,'movie','Thomas Keneally,Steven Zaillian','Released',to_date('11/03/1994','DD/MM/YYYY'),'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('Senhor dos Anéis O Retorno do Rei (2003)',8.9,'movie','J.R.R. Tolkien, Fran Walsh','Released',to_date('25/12/2003','DD/MM/YYYY'),'Gandalf and Aragorn lead the World of Men against Sauron`s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('Pulp Fiction Tempo de Violência (1994)',8.8,'movie','Quentin Tarantino,Roger Avary','Released',to_date('03/03/1995','DD/MM/YYYY'),'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('Três Homens em Conflito (1966)',8.8,'movie','Luciano Vincenzoni,Sergio Leone','Released',to_date('11/01/1968','DD/MM/YYYY'),'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.');
insert into production (title,rating,format,author,status,release_date,synopsis) values('O Senhor dos Anéis A Sociedade do Anel (2001)',8.8,'movie','J.R.R. Tolkien, Fran Walsh','Released',to_date('01/01/2002','DD/MM/YYYY'),'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.');


insert into tags (production_id,tag) values (3,'drama');

insert into tags (production_id,tag) values (4,'crime');
insert into tags (production_id,tag) values (4,'drama');

insert into tags (production_id,tag) values (5,'crime');
insert into tags (production_id,tag) values (5,'drama');

insert into tags (production_id,tag) values (6,'action');
insert into tags (production_id,tag) values (6,'crime');
insert into tags (production_id,tag) values (6,'drama');
insert into tags (production_id,tag) values (6,'thriller');


insert into tags (production_id,tag) values (7,'crime');
insert into tags (production_id,tag) values (7,'drama');

insert into tags (production_id,tag) values (8,'biography');
insert into tags (production_id,tag) values (8,'drama');
insert into tags (production_id,tag) values (8,'history');

insert into tags (production_id,tag) values (9,'action');
insert into tags (production_id,tag) values (9,'adventure');
insert into tags (production_id,tag) values (9,'drama');
insert into tags (production_id,tag) values (9,'fantasy');


insert into tags (production_id,tag) values (10, 'crime');
insert into tags (production_id,tag) values (10,'drama');

insert into tags (production_id,tag) values (11, 'western');

insert into tags (production_id,tag) values (12,'action');
insert into tags (production_id,tag) values (12,'adventure');
insert into tags (production_id,tag) values (12,'drama');
insert into tags (production_id,tag) values (12,'fantasy');



insert into playlist (name,usuario_id ) values ('favoritos',1 );
insert into playlist_content (playlist_id,production_id ) values (1,1);
insert into playlist_content (playlist_id,production_id ) values (1,2);









