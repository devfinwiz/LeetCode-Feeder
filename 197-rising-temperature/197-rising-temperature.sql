# Write your MySQL query statement below
select a.id as Id from weather a,weather b where a.temperature>b.temperature and datediff(a.recordDate,b.recordDate)=1;