CREATE TABLE IF NOT EXISTS household_category
(
    household_id BIGINT NOT NULL COMMENT 'Household ID',
    category_id  BIGINT NOT NULL COMMENT 'Category ID',
    PRIMARY KEY (household_id, category_id)
);