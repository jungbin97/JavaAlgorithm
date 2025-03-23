select A.id, A.genotype, B.GENOTYPE as PARENT_GENOTYPE from ECOLI_DATA A join (select ID, GENOTYPE from ECOLI_DATA) as B
on A.PARENT_ID = B.ID
where A.GENOTYPE & B.GENOTYPE = B.GENOTYPE
order by A.id





-- 부모의 형질을 모두, 보유하고 있는 대장균 출력
-- ID기준 오름차순 정렬