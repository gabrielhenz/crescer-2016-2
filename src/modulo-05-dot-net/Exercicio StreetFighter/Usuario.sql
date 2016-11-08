CREATE TABLE Usuarios(
	Id int identity not null primary key,
	Login varchar(255) not null unique,
	Senha varchar(255) not null,
	Nome varchar(255) not null
);

INSERT INTO Usuarios VALUES ('gabrieldhenz', '3f0a0f668ac920694c3e4d31fcaa350a', 'Gabriel Henz');
