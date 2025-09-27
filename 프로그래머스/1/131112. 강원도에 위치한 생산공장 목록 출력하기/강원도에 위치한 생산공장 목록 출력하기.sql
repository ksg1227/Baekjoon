-- 코드를 입력하세요
SELECT
    ff.factory_id,
    ff.factory_name,
    ff.address
from food_factory ff
where ff.address like '강원도%'
order by ff.factory_id asc