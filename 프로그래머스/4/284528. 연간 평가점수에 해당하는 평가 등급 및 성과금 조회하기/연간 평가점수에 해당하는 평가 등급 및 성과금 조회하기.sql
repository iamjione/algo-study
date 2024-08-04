# SELECT 
# E.EMP_NO, 
# EMP_NAME, 
# CASE
#     WHEN SCORE >= 96 THEN 'S'
#     WHEN SCORE >= 90 THEN 'A'
#     WHEN SCORE >= 80 THEN 'B'
#     ELSE 'C'
# END AS GRADE,
# CASE
#     WHEN SCORE >= 96 THEN SAL*0.2
#     WHEN SCORE >= 90 THEN SAL*0.15
#     WHEN SCORE >= 80 THEN SAL*0.1
#     ELSE 0
# END AS BONUS
# FROM HR_EMPLOYEES E
# JOIN (SELECT EMP_NO, AVG(SCORE) AS SCORE
#      FROM HR_GRADE
#      GROUP BY EMP_NO) G
# ON E.EMP_NO = G.EMP_NO
# ORDER BY E.EMP_NO;

WITH HR_BONUS AS (
SELECT EMP_NO,
    CASE
        WHEN AVG(SCORE) >= 96 THEN 'S'
        WHEN AVG(SCORE) >= 90 THEN 'A'
        WHEN AVG(SCORE) >= 80 THEN 'B'
        ELSE 'C' 
    END AS GRADE,
    CASE
        WHEN AVG(SCORE) >= 96 THEN 0.2
        WHEN AVG(SCORE) >= 90 THEN 0.15
        WHEN AVG(SCORE) >= 80 THEN 0.1
        ELSE 0 
    END AS BONUS
FROM  HR_GRADE
GROUP BY  EMP_NO)

SELECT E.EMP_NO, EMP_NAME, GRADE, SAL*BONUS AS BONUS
FROM HR_EMPLOYEES E
JOIN HR_BONUS B
ON E.EMP_NO = B.EMP_NO;