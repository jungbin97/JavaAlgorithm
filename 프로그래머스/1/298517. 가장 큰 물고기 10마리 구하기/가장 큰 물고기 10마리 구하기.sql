SELECT ID, LENGTH FROM FISH_INFO
WHERE LENGTH is not null
ORDER BY LENGTH desc, ID asc
LIMIT 10;
