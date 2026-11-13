ALTER TABLE sensor_entity
DROP
FOREIGN KEY FKt47qdpryr0rqy53uyadvikrlr;

ALTER TABLE sensor_entity
    ADD api_key VARCHAR(255) NULL;

ALTER TABLE sensor_entity
    MODIFY user_id VARCHAR (255);