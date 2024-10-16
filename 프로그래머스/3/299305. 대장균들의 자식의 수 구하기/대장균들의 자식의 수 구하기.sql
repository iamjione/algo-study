SELECT E.ID AS ID, COUNT(P.ID) AS CHILD_COUNT
FROM ECOLI_DATA E
LEFT JOIN ECOLI_DATA P ON E.ID = P.PARENT_ID
GROUP BY ID
ORDER BY ID;