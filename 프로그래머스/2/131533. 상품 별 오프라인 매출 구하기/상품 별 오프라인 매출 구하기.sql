WITH OFFLINE_INFO AS (
    SELECT PRODUCT_ID, SALES_AMOUNT
    FROM OFFLINE_SALE
)

SELECT PRODUCT_CODE, PRICE*SUM(SALES_AMOUNT) AS SALES
FROM PRODUCT P
JOIN OFFLINE_INFO O ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE;

