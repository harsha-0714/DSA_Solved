# Write your MySQL query statement below
select 
round(sum(if(first_order = first_pref,1,0)*100) / count(first_order) ,2) as immediate_percentage
from (select delivery_id , customer_id ,
min(order_date) as first_order ,
min(customer_pref_delivery_date) as first_pref
from Delivery
group by customer_id) as temp_table;