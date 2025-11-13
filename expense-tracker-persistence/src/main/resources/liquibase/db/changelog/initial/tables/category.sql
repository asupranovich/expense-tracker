CREATE TABLE IF NOT EXISTS category
(
    id         BIGINT AUTO_INCREMENT NOT NULL COMMENT 'Category ID',
    name       VARCHAR(255)          NOT NULL COMMENT 'Category name',
    is_deleted BOOLEAN               NOT NULL DEFAULT false COMMENT 'Is category deleted',
    household_id BIGINT              NULL COMMENT 'Household ID',
    PRIMARY KEY (id),
    CONSTRAINT fk_category_household FOREIGN KEY (household_id) REFERENCES household(id)
);