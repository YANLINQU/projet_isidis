create table user
(
id INTEGER not null AUTO_INCREMENT,
username varchar(45),
primary key (id)
);

mysql -u root -p;
use projet_isidis;

Drop table commande_detaille;
Drop table menu;
Drop table commande;
Drop table tables;
Drop table resto;
Drop table restaurateur;

create table restaurateur
(
id INTEGER not null AUTO_INCREMENT,
nom varchar(45),
prenom varchar(45),
pwd varchar(20),
email varchar(50),
sex varchar(2),
datenaissance DATE default NULL,
portable varchar(20),
telephone varchar(20),
adresse varchar(150),
ville varchar(20),
postal varchar(10),
pays varchar(15),
id_identity varchar(50),
primary key (id),
UNIQUE (email)
);

insert into restaurateur (nom,prenom,pwd,email,sex,portable,telephone,adresse,ville,postal,pays,id_identity,datenaissance) values 
	('QU','YANLIN','qu001','quyanlingg@hotmail.com','M','0664973861','0664973861','74 marin la meslee','calais','62100','frence','477064','1970-01-01');

create table resto
(
id INTEGER not null AUTO_INCREMENT,
nom varchar(50),
adresse varchar(150),
ville varchar(20),
postal varchar(10),
revenu decimal(10,2),
id_restaurateur INTEGER,
primary key (id),
FOREIGN key (id_restaurateur) references restaurateur(id)
);

insert into resto (nom,adresse,ville,postal,revenu,id_restaurateur) values 
	('SUSHI KAN','24, Avenue de U.R.S.S.','TOULOUSE','31000','0',4);

create table tables
(
id int not null AUTO_INCREMENT,
numero int,
qr varchar(255),
id_resto int,
primary key (id),
foreign key (id_resto) references resto(id)
);

insert into tables (numero,qr,id_resto) values (1,'',1);
insert into tables (numero,qr,id_resto) values (2,'',1);
insert into tables (numero,qr,id_resto) values (3,'',1);
insert into tables (numero,qr,id_resto) values (4,'',1);
insert into tables (numero,qr,id_resto) values (5,'',1);

create table commande
(
id int not null AUTO_INCREMENT,
datecommande DATETIME,
montant decimal(10,2),
paiement boolean,
valider boolean,
id_table int,
id_client int,
primary key (id),
foreign key (id_table) references tables(id)
);

insert into commande (datecommande,montant,paiement,valider,id_table,id_client) VALUES
        ('1970-01-05 20:23:24',35.6,TRUE ,FALSE ,1,1);
insert into commande (datecommande,montant,paiement,valider,id_table,id_client) VALUES
        ('1970-01-02 20:23:24',46,FALSE ,FALSE ,2,1);
insert into commande (datecommande,montant,paiement,valider,id_table,id_client) VALUES
        ('1970-01-03 20:23:24',46,FALSE ,TRUE ,3,1);
insert into commande (datecommande,montant,paiement,valider,id_table,id_client) VALUES
        ('1970-01-04 20:23:24',46,TRUE ,TRUE ,4,1);

create table menu
(
id int not null AUTO_INCREMENT,
nomme varchar(50),
imageadresse varchar(255),
prix decimal(10,2),
description varchar(1000),
activite boolean,
id_restaurant int,
primary key (id),
foreign key (id_restaurant) references resto(id)
);

insert into menu (nomme,imageadresse,prix,description,activite,id_restaurant) VALUES
    ('FirstMenu','',15.3,'description',TRUE,1);
insert into menu (nomme,imageadresse,prix,description,activite,id_restaurant) VALUES
    ('SecondeMenu','',18.3,'description',TRUE,1);

create table commande_detaille
(
id int not null AUTO_INCREMENT,
quantite int,
id_commande int,
id_menu int,
primary key (id),
foreign key (id_commande) references commande(id),
foreign key (id_menu) references menu(id)
);
