-- 코드를 작성해주세요
# 하나도 안 겹치면 0
select
    count(id) as COUNT
from ecoli_data
where genotype & 5 != 0 and genotype & 2 = 0