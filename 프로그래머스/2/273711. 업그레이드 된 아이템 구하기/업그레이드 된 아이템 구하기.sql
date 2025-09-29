-- 코드를 작성해주세요
select 
    ii.item_id,
    ii.item_name,
    ii.rarity
from item_info ii # 현재
join item_tree it on ii.item_id = it.item_id
join item_info ii2 on ii2.item_id = it.parent_item_id
where ii2.rarity = 'RARE' and it.parent_item_id is not NULL
order by ii.item_id desc