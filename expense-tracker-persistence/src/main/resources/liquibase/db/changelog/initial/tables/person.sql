CREATE TABLE IF NOT EXISTS person
(
    id           BIGINT AUTO_INCREMENT NOT NULL COMMENT 'Person ID',
    name         VARCHAR(255)          NOT NULL COMMENT 'Person name',
    email        VARCHAR(255)          NOT NULL COMMENT 'Person email',
    household_id BIGINT                NOT NULL COMMENT 'Household ID',
    PRIMARY KEY (id),
    CONSTRAINT fk_person_household FOREIGN KEY (household_id) REFERENCES household(id)
);