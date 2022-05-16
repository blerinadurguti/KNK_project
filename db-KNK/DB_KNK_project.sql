use SMO;

drop table if exists User;
drop table if exists Studenti;
drop table if exists Grupet;
drop table if exists Lendet;
drop table if exists StafiAkademik;
drop table if exists Salla;
drop table if exists Drejtimi;
drop table if exists VitiAkademik;
drop table if exists Oraret;

-- SMO -> Sistemi per Menaxhimin e Orareve
use SMO;


create table VitiAkademik(
Id integer not null auto_increment,
Viti varchar(10),
primary key(Id)
);

create table Grupet(
Id integer not null auto_increment,
Emri varchar(10),
a_b varchar(1),
Viti integer,
primary key(Id)
);

create table Drejtimi(
Id integer not null auto_increment,
Emri varchar(40),
primary key(Id)
);

create table Studenti(
Id integer not null auto_increment,
Emri varchar(15),
Mbiemri varchar(15),
StudentId varchar(30),
Drejtimi integer,
Viti integer,
Grupi integer,
Primary Key(Id),
foreign key(Drejtimi) references drejtimi(ID),
foreign key(Viti) references vitiakademik(ID),
foreign key(Grupi) references Grupet(Id));

create table User(
Id integer not null,
Username varchar(100),
SaltedHash varchar(256),
Salted varchar(100),
primary key(Id),
foreign key(Id)references Studenti(Id)
);

create table Lendet(
Id integer not null auto_increment,
Emri varchar(30),
primary key(Id)
);

create table StafiAkademik(
Id integer not null auto_increment,
Emri varchar(30),
Mbiemri varchar(30),
Pozita varchar(10),
primary key(Id)
);

create table Salla(
Id integer not null auto_increment,
Emri varchar(10),
primary key(Id)
);


create table Oraret(
Id integer not null auto_increment,
Profesori_Asistenti integer,
Grupi integer,
Koha time,
dita integer,
primary key(Id),
foreign key(Profesori_Asistenti) references StafiAkademik(Id),
foreign key(Grupi) references Grupet(Id)
);

