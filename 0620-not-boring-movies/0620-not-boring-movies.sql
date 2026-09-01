# Write your MySQL query statement below
select id , movie , description , rating
from Cinema
WHERE id%2 != 0 and description != 'boring'
order by rating DESC;