-- 코드를 입력하세요
SELECT
    ri.rest_id,
    ri.rest_name,
    ri.food_type,
    ri.favorites,
    ri.address,
    ROUND(AVG(rr.review_score), 2) score
from rest_info ri
join rest_review rr on ri.rest_id = rr.rest_id
group by ri.rest_id
having ri.address like '서울%'
order by score desc,
    ri.favorites desc