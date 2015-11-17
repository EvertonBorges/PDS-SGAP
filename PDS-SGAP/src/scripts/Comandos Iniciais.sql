DROP DATABASE IF EXISTS BD_PDS_SGAP;
CREATE DATABASE BD_PDS_SGAP;
USE BD_PDS_SGAP;

DELIMITER #
    CREATE PROCEDURE SP_SOLICITACOES_PRODUTO(P_PRODUTO INT, P_DATA DATE)
BEGIN
    SELECT DISTINCT *
    FROM SOLICITACAOALUGUEL 
    WHERE DATAINICIOALUGUEL >= P_DATA
    AND CODIGO NOT IN (SELECT SOLICITACAOALUGUEL_CODIGO 
                       FROM ALUGUEL)
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