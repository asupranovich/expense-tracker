CREATE TABLE IF NOT EXISTS household
(
    id    BIGINT AUTO_INCREMENT NOT NULL COMMENT 'Household ID',
    name  VARCHAR(255)          NOT NULL COMMENT 'Household name',
    PRIMARY KEY (id)
);