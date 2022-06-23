# Write your MySQL query statement below
select name,sum(if(distance is null,0,distance)) as travelled_distance from Users left join Rides on Users.id=Rides.user_id group by users.id order by sum(distance) desc,name;

