CREATE TABLE IF NOT EXISTS expense
(
    id           BIGINT AUTO_INCREMENT NOT NULL COMMENT 'Expense ID',
    person_id    VARCHAR(255)          NOT NULL COMMENT 'Payer ID',
    household_id BIGINT                NOT NULL COMMENT 'Household ID',
    pay_date     DATE                  NOT NULL COMMENT 'Expense date',
    category_id  BIGINT                NOT NULL COMMENT 'Expense category ID',
    amount       DECIMAL(10, 2)        NOT NULL COMMENT 'Expense amount',
    description  VARCHAR(255)          NULL     COMMENT 'Expense description',
    remark       VARCHAR(255)          NULL     COMMENT 'Expense remark',
    PRIMARY KEY (id),
    CONSTRAINT fk_expense_person FOREIGN KEY (person_id) REFERENCES person(id),
    CONSTRAINT fk_expense_household FOREIGN KEY (household_id) REFERENCES household(id),
    CONSTRAINT fk_category_household FOREIGN KEY (category_id) REFERENCES category(id)
);