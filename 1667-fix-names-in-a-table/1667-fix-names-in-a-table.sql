# Write your MySQL query statement below
select user_id,concat(upper(left(name,1)),lower(right(name,char_length(name)-1))) as name from Users order by user_id;