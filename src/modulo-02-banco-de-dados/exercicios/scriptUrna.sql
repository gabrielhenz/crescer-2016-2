

CREATE USER URNA IDENTIFIED BY URNA;

GRANT CONNECT, RESOURCE TO URNA;




-- Gerado por Oracle SQL Developer Data Modeler 4.1.5.907
--   em:        2016-10-18 18:12:27 BRST
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Candidato
  (
    IDCandidato      INTEGER NOT NULL ,
    NomeCompleto     VARCHAR2 (100) NOT NULL ,
    NomePopular      VARCHAR2 (50) NOT NULL ,
    DataDeNascimento DATE NOT NULL ,
    RegistroTRE      VARCHAR2 (30) NOT NULL ,
    IDPartido        INTEGER NOT NULL ,
    Foto             VARCHAR2 (1000) NOT NULL ,
    NumeroDeEscolha  VARCHAR2 (5) ,
    IDCargo          INTEGER NOT NULL ,
    IDCidade         INTEGER NOT NULL
  ) ;
ALTER TABLE Candidato ADD CONSTRAINT PK_Candidato PRIMARY KEY ( IDCandidato ) ;


CREATE TABLE CandidatoVoto
  (
    IDCandidatoVoto INTEGER NOT NULL ,
    IDCandidato     INTEGER NOT NULL ,
    IDVoto          INTEGER NOT NULL
  ) ;
ALTER TABLE CandidatoVoto ADD CONSTRAINT PK_CandidatoVoto PRIMARY KEY ( IDCandidatoVoto ) ;


CREATE TABLE Cidade
  (
    IDCidade INTEGER NOT NULL ,
    Nome     VARCHAR2 (200) NOT NULL ,
    IDEstado INTEGER NOT NULL
  ) ;
ALTER TABLE Cidade ADD CONSTRAINT PK_Cidade PRIMARY KEY ( IDCidade ) ;


CREATE TABLE Eleitor
  (
    IDEleitor        INTEGER NOT NULL ,
    NomeCompleto     VARCHAR2 (100) ,
    TituloEleitoral  VARCHAR2 (12) NOT NULL ,
    RG               VARCHAR2 (10) NOT NULL ,
    DataDeNascimento DATE NOT NULL ,
    Zona             VARCHAR2 (3) NOT NULL ,
    Secao            VARCHAR2 (3) NOT NULL
  ) ;
ALTER TABLE Eleitor ADD CONSTRAINT PK_Eleitor PRIMARY KEY ( IDEleitor ) ;


CREATE TABLE Estado
  (
    IDEstado INTEGER NOT NULL ,
    Nome     VARCHAR2 (200) NOT NULL
  ) ;
ALTER TABLE Estado ADD CONSTRAINT PK_Estado PRIMARY KEY ( IDEstado ) ;


CREATE TABLE Partido
  (
    IDPartido INTEGER NOT NULL ,
    Nome      VARCHAR2 (100) NOT NULL
  ) ;
ALTER TABLE Partido ADD CONSTRAINT PK_Partido PRIMARY KEY ( IDPartido ) ;


CREATE TABLE TipoDeCargo
  (
    IDTipoDeCargo INTEGER NOT NULL ,
    Nome          VARCHAR2 (10) NOT NULL
  ) ;
ALTER TABLE TipoDeCargo ADD CONSTRAINT PK_TipoDeCargo PRIMARY KEY ( IDTipoDeCargo ) ;


CREATE TABLE TipoVoto
  (
    IDTipoVoto INTEGER NOT NULL ,
    Nome       VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE TipoVoto ADD CONSTRAINT TipoVoto_PK PRIMARY KEY ( IDTipoVoto ) ;


CREATE TABLE Voto
  (
    IDVoto     INTEGER NOT NULL ,
    IDEleitor  INTEGER NOT NULL ,
    IDTipoVoto INTEGER NOT NULL
  ) ;
ALTER TABLE Voto ADD CONSTRAINT Voto_PK PRIMARY KEY ( IDVoto ) ;
ALTER TABLE Voto ADD CONSTRAINT UK_Eleitor UNIQUE ( IDEleitor ) ;


ALTER TABLE CandidatoVoto ADD CONSTRAINT FK_CandidatoVoto_Candidato FOREIGN KEY ( IDCandidato ) REFERENCES Candidato ( IDCandidato ) ;

ALTER TABLE CandidatoVoto ADD CONSTRAINT FK_CandidatoVoto_Voto FOREIGN KEY ( IDVoto ) REFERENCES Voto ( IDVoto ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Cidade FOREIGN KEY ( IDCidade ) REFERENCES Cidade ( IDCidade ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Partido FOREIGN KEY ( IDPartido ) REFERENCES Partido ( IDPartido ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_TipoDeCargo FOREIGN KEY ( IDCargo ) REFERENCES TipoDeCargo ( IDTipoDeCargo ) ;

ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_Estado FOREIGN KEY ( IDEstado ) REFERENCES Estado ( IDEstado ) ;

ALTER TABLE Voto ADD CONSTRAINT FK_Voto_Eleitor FOREIGN KEY ( IDEleitor ) REFERENCES Eleitor ( IDEleitor ) ;

ALTER TABLE Voto ADD CONSTRAINT FK_Voto_TipoVoto FOREIGN KEY ( IDTipoVoto ) REFERENCES TipoVoto ( IDTipoVoto ) ;


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             18
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
