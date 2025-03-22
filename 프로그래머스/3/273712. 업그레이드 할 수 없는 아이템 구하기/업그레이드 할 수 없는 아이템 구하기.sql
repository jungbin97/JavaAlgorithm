select II.item_id, II.item_name, II.RARITY from ITEM_INFO II
left join ITEM_TREE IT
on II.ITEM_ID = IT.PARENT_ITEM_ID
where IT.parent_item_id is null
order by II.item_id desc;






-- 더 이상 업그레이드 할 수 없는 아이템 추렭
-- 아이템 ID기준 내림차순 정렬


-- PARENT_TIEM_ID에 없는 것