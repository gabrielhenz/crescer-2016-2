-- CREATE TABLE "Mesario" salva como lower tbm
CREATE TABLE MESARIO (
  IDMesario integer      not null,
  Nome      varchar2(30) not null,
    constraint PK_MESARIO primary key (IDMESARIO)
);

CREATE SEQUENCE SEQ_MESARIO NOCACHE;
                          -- CACHE 200;
-- se eu nao informar nada o padrao eh criar um cache de 20 (armazena 20 numeros no cache do banco de dados)
-- os proximos 19 inserts nao precisará utilizar o sequencial.

INSERT INTO MESARIO (IDMesario, Nome)
VALUES (SEQ_MESARIO.NEXTVAL, 'Pedro de Souza');

SELECT * FROM MESARIO;