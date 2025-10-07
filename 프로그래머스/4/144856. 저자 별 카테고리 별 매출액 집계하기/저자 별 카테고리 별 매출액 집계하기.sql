-- 코드를 입력하세요
SELECT
    a.author_id,
    a.author_name,
    info.category,
    SUM(info.sales) as TOTAL_SALES
from author a
join (
    select 
        b.author_id,
        b.category,
        SUM(bs.sales) * b.price as SALES
    from book_sales bs
    join book b on bs.book_id = b.book_id
    where sales_date >= '2022-01-01' and sales_date <= '2022-01-31'
    group by bs.book_id
    ) as info
    on a.author_id = info.author_id
group by 
    a.author_id,
    info.category
order by
    a.author_id asc,
    info.category desc

# 각 책의 저자, 카테고리, 총 가격
# select 
#     b.author_id,
#     b.category,
#     SUM(bs.sales) * b.price as TOTAL_SALES
# from book_sales bs
# join book b on bs.book_id = b.book_id
# where sales_date >= '2022-01-01' and sales_date <= '2022-01-31'
# group by bs.book_id

# SELECT
#     a.author_id,
#     a.author_name,
#     b.category,
#     bs.sales * SUM(bs.sales) as TOTAL_SALES
# from author a
# join book b on a.author_id = b.author_id
# join book_sales bs on b.book_id = bs.book_id
# group by 
#     a.author_name,
#     b.category
# order by
#     a.author_id desc,
#     b.category desc