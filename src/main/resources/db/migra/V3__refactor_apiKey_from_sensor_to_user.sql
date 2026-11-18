ALTER TABLE user_entity
    ADD api_key VARCHAR(255) NULL;

ALTER TABLE sensor_entity
DROP
COLUMN api_key;