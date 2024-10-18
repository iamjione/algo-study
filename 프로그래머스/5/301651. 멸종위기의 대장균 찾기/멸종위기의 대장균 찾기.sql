WITH RECURSIVE GENERATION AS (
    SELECT ID, PARENT_ID, 1 AS GEN
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT E.ID, E.PARENT_ID, G.GEN+1 AS GEN
    FROM ECOLI_DATA E
    INNER JOIN GENERATION G ON E.PARENT_ID = G.ID
)

SELECT COUNT(G.ID) AS COUNT, G.GEN AS GENERATION
FROM GENERATION G
LEFT JOIN GENERATION C ON G.ID = C.PARENT_ID
WHERE C.PARENT_ID IS NULL
GROUP BY GENERATION
ORDER BY GENERATION;