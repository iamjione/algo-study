select i.flavor
from icecream_info i
join first_half fh on i.flavor = fh.flavor
where TOTAL_ORDER >= 3000
and INGREDIENT_TYPE like 'fruit_based'
order by TOTAL_ORDER DESC;