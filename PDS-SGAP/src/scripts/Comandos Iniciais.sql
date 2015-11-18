DROP DATABASE IF EXISTS BD_PDS_SGAP;
CREATE DATABASE BD_PDS_SGAP;
USE BD_PDS_SGAP;

DELIMITER #
    CREATE PROCEDURE SP_SOLICITACOES_PRODUTO(P_PRODUTO INT, P_DATA DATE)
BEGIN
    SELECT DISTINCT *
    FROM SOLICITACAOALUGUEL 
    WHERE DATAINICIOALUGUEL >= P_DATA
    AND PRODUTO_CODIGO IN (SELECT CODIGO 
                           FROM PRODUTO 
                           WHERE CODIGO = P_PRODUTO);
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_PRODUTOS_SOLICITADOS(P_DONO INT, P_PRODUTO VARCHAR(255), P_DATA DATE)
BEGIN
    DECLARE V_EXISTE_ALUGUEL BOOLEAN DEFAULT 0;
    DECLARE V_DATADEVOLUCAO_IS_NULL BOOLEAN DEFAULT 0;
	
    SET V_EXISTE_ALUGUEL = (SELECT COUNT(*) 
                            FROM ALUGUEL 
                            WHERE SOLICITACAOALUGUEL_CODIGO IN (SELECT CODIGO 
                                                                FROM SOLICITACAOALUGUEL 
                                                                WHERE PRODUTO_CODIGO IN (SELECT CODIGO 
                                                                                         FROM PRODUTO 
                                                                                         WHERE NOME LIKE P_PRODUTO
                                                                                         AND CONDOMINO_CODIGO = P_DONO)));

    IF V_EXISTE_ALUGUEL THEN
        SET V_DATADEVOLUCAO_IS_NULL = (SELECT COUNT(*) 
                                       FROM ALUGUEL 
                                       WHERE DATADEVOLUCAO IS NULL
                                       AND SOLICITACAOALUGUEL_CODIGO IN (SELECT CODIGO 
                                                                         FROM SOLICITACAOALUGUEL 
                                                                         WHERE PRODUTO_CODIGO IN (SELECT CODIGO 
                                                                                                  FROM PRODUTO 
                                                                                                  WHERE CONDOMINO_CODIGO = P_DONO 
                                                                                                  AND NOME LIKE P_PRODUTO)));
    END IF;
    
    IF V_EXISTE_ALUGUEL THEN
	IF NOT V_DATADEVOLUCAO_IS_NULL THEN
            SELECT DISTINCT * 
            FROM PRODUTO AS P
            WHERE P.CONDOMINO_CODIGO = P_DONO
            AND P.NOME LIKE P_PRODUTO
            AND P.CODIGO IN (SELECT PRODUTO_CODIGO 
                             FROM SOLICITACAOALUGUEL AS S
                             WHERE S.DATAINICIOALUGUEL >= P_DATA 
                             AND S.CODIGO IN (SELECT SOLICITACAOALUGUEL_CODIGO 
                                              FROM ALUGUEL AS A
                                              WHERE S.CODIGO = A.SOLICITACAOALUGUEL_CODIGO
                                              AND A.DATADEVOLUCAO IS NOT NULL
                                              GROUP BY A.SOLICITACAOALUGUEL_CODIGO
                                              HAVING MAX(A.DATADEVOLUCAO) < P_DATA));
    ELSE
        SELECT * FROM PRODUTO WHERE CODIGO = 0;
    END IF;
    ELSE
        SELECT DISTINCT * 
        FROM PRODUTO
        WHERE CONDOMINO_CODIGO = P_DONO
        AND NOME LIKE P_PRODUTO
        AND CODIGO IN (SELECT PRODUTO_CODIGO 
                       FROM SOLICITACAOALUGUEL 
                       WHERE DATAINICIOALUGUEL >= P_DATA);
    END IF;
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_SOLICITACOES_PRODUTO_LOCATARIO(P_PRODUTO INT, P_LOCATARIO INT)
BEGIN
    SELECT DISTINCT *
    FROM SOLICITACAOALUGUEL 
    WHERE  PRODUTO_CODIGO IN (SELECT CODIGO 
                              FROM PRODUTO 
                              WHERE CODIGO = P_PRODUTO)
                              AND LOCATARIO_CODIGO IN (SELECT CODIGO
                                                       FROM CONDOMINO
                                                       WHERE CODIGO = P_LOCATARIO);
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_PRODUTOS_SOLICITADOS_LOCATARIO(P_LOCATARIO INT, P_PRODUTO VARCHAR(255))
BEGIN    
    SELECT DISTINCT *
    FROM PRODUTO AS P
    WHERE P.NOME LIKE P_PRODUTO
    AND P.CODIGO IN (SELECT PRODUTO_CODIGO 
                     FROM SOLICITACAOALUGUEL
                     WHERE LOCATARIO_CODIGO = P_LOCATARIO );
END#
DELIMITER ;

DELIMITER #
    CREATE PROCEDURE SP_PRODUTOS_DISPONIVEIS( P_PRODUTO VARCHAR(255))
BEGIN	
    SELECT CODIGO
    FROM PRODUTO 
    WHERE CODIGO NOT IN (SELECT PRODUTO_CODIGO
                         FROM SOLICITACAOALUGUEL
                         WHERE CODIGO IN (SELECT SOLICITACAOALUGUEL_CODIGO
                                          FROM ALUGUEL
                                          WHERE ALUGUEL.DATADEVOLUCAO IS  NULL))
    AND NOME LIKE P_PRODUTO;
END#
DELIMITER ;