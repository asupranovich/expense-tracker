CREATE TABLE IF NOT EXISTS category
(
    id         BIGINT AUTO_INCREMENT NOT NULL COMMENT 'Category ID',
    name       VARCHAR(255)          NOT NULL COMMENT 'Category name',
    is_default BOOLEAN               NOT NULL DEFAULT false COMMENT 'Is default category flag',
    PRIMARY KEY (id)
);