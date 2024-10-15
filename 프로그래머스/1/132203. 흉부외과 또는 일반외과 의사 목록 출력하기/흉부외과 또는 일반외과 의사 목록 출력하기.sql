-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS DATE_FORMAT
FROM DOCTOR
WHERE MCDP_CD LIKE 'CS' OR MCDP_CD LIKE 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC;