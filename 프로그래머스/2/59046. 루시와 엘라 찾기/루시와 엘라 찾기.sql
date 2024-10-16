SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME REGEXP '\\bLucy\\b|\\bElla\\b|\\bPickle\\b|\\bRogan\\b|\\bSabrina\\b|\\bMitty\\b'
ORDER BY ANIMAL_ID;