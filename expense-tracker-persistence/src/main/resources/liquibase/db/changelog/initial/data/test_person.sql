INSERT INTO person(name, email, household_id)
VALUES ('Test Person', 'test@test.com', (SELECT id FROM household WHERE name = 'Test'))