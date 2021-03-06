CREATE TABLE PAIS 
(
  IDPAIS INTEGER NOT NULL 
, NOME VARCHAR2(60) NOT NULL 
, CODBACEN VARCHAR2(4) 
, DATAINCLUSAO DATE DEFAULT SYSDATE NOT NULL 
, DATAALTERACAO DATE DEFAULT SYSDATE NOT NULL 
, CONSTRAINT PAIS_PK PRIMARY KEY 
  (
    IDPAIS 
  )
  ENABLE 
);

COMMENT ON COLUMN PAIS.IDPAIS IS 'IDENTIFICADOR DA TABELA PAIS';

COMMENT ON COLUMN PAIS.NOME IS 'NOME DO PAIS';

COMMENT ON COLUMN PAIS.CODBACEN IS 'CÓDIGO BACEN DO PAIS';

COMMENT ON COLUMN PAIS.DATAINCLUSAO IS 'DATA DE INCLUSÃO DO REGISTRO';

COMMENT ON COLUMN PAIS.DATAALTERACAO IS 'DATA DA ÚLTIMA ALTERAÇÃO DO REGISTRO';

CREATE SEQUENCE SEQIDPAIS NOCACHE;
