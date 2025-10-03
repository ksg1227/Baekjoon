-- 코드를 작성해주세요
select 
    m.year as YEAR,
    (m.max_length - ed.size_of_colony) as YEAR_DEV,
    ed.id as ID
from ecoli_data ed
join 
    (select YEAR(differentiation_date) as year, MAX(size_of_colony) as max_length
    from ecoli_data
    group by year
    ) as m
    on YEAR(ed.differentiation_date) = m.year
order by 
    YEAR asc,
    YEAR_DEV asc