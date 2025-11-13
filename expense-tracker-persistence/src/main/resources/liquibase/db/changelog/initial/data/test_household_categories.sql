INSERT INTO household_category (household_id, category_id)
SELECT
    (SELECT id FROM household WHERE name = 'Test') as household_id,
    c.id as category_id
FROM category c
WHERE c.household_id IS NULL;