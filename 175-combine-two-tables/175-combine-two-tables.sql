# Write your MySQL query statement below
select firstname, lastname, city, state 
from person p
left join address a
on p.personID=a.personId 

