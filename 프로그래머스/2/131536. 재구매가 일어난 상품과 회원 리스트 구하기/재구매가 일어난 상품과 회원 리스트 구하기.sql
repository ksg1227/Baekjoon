-- 코드를 입력하세요
SELECT
    os.user_id,
    os.product_id
from online_sale os
group by 
    os.user_id, 
    os.product_id
having count(os.online_sale_id) >= 2
order by 
    os.user_id asc,
    os.product_id desc


