-- 코드를 입력하세요
-- 합쳐야함

SELECT
    date_format(ols.sales_date, '%Y-%m-%d') sales_date,
    ols.product_id,
    ols.user_id,
    ols.sales_amount
from online_sale ols
where ols.sales_date >= '2022-03-01' and ols.sales_date <= '2022-03-31'

union all

SELECT
    date_format(ofs.sales_date, '%Y-%m-%d') sales_date,
    ofs.product_id,
    NULL as user_id,
    ofs.sales_amount
from offline_sale ofs
where ofs.sales_date >= '2022-03-01' and ofs.sales_date <= '2022-03-31'

order by sales_date, product_id, user_id