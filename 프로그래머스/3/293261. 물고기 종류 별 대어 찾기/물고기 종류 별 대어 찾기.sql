-- 코드를 작성해주세요
select 
    fi.id,
    fni.fish_name,
    fi.length
from fish_info fi 
join 
    (select fish_type, MAX(length) as length
        from fish_info
        group by fish_type
    ) as m 
    on fi.fish_type = m.fish_type and fi.length = m.length
join fish_name_info fni on fi.fish_type = fni.fish_type
order by id asc