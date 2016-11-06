CREATE TABLE ESTADO 
(
  IDESTADO INTEGER NOT NULL 
, IDPAIS INTEGER NOT NULL 
, SIGLA VARCHAR2(2) NOT NULL 
, NOME VARCHAR2(20) NOT NULL 
, CODIBGE INTEGER 
, DATAINCLUSAO DATE DEFAULT SYSDATE NOT NULL 
, DATAALTERACAO DATE DEFAULT SYSDATE NOT NULL 
, CONSTRAINT ESTADO_PK PRIMARY KEY 
  (
    IDESTADO 
  )
  ENABLE 
);

ALTER TABLE ESTADO
ADD CONSTRAINT ESTADO_UK1 UNIQUE 
(
  IDPAIS 
, SIGLA 
)
ENABLE;

ALTER TABLE ESTADO
ADD CONSTRAINT ESTADO_FK_PAIS FOREIGN KEY
(
  IDPAIS
  )
REFERENCES PAIS
(
  IDPAIS 
)
ON DELETE CASCADE ENABLE;

COMMENT ON COLUMN ESTADO.IDESTADO IS 'IDENTIFICADOR DA TABELA ESTADO';

COMMENT ON COLUMN ESTADO.IDPAIS IS 'IDENTIFICADOR DA TABELA PAIS';

COMMENT ON COLUMN ESTADO.SIGLA IS 'SIGLA DO ESTADO';

COMMENT ON COLUMN ESTADO.NOME IS 'NOME DO ESTADO';

COMMENT ON COLUMN ESTADO.CODIBGE IS 'CÓDIGO IBGE DO ESTADO';

COMMENT ON COLUMN ESTADO.DATAINCLUSAO IS 'DATA DE INCLUSÃO DO REGISTRO';

COMMENT ON COLUMN ESTADO.DATAALTERACAO IS 'DATA DA ÚLTIMA ALTERAÇÃO DO REGISTRO';

CREATE SEQUENCE SEQIDESTADO NOCACHE;