select count(*) as count from ecoli_data
where (GENOTYPE & 2) = 0 and ((GENOTYPE & 4 = 4) or (GENOTYPE & 1 = 1))

-- 2번 형질(0010)을 보유하지 않고, 1번 형질(0001)이나 3번 형질(0011)을 보유한 개체
