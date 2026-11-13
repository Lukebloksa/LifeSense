CREATE TABLE measurement_entity
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    sensor_id   VARCHAR(36) NOT NULL,
    value DOUBLE NULL,
    measured_at datetime    NOT NULL,
    CONSTRAINT pk_measuremententity PRIMARY KEY (id)
);

CREATE TABLE sensor_entity
(
    id      VARCHAR(36) NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    name    VARCHAR(255) NULL,
    type    VARCHAR(255) NULL,
    unit    VARCHAR(255) NULL,
    api_key VARCHAR(255) NULL,
    CONSTRAINT pk_sensorentity PRIMARY KEY (id)
);

CREATE TABLE user_entity
(
    id       VARCHAR(36) NOT NULL,
    username VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_userentity PRIMARY KEY (id)
);

ALTER TABLE measurement_entity
    ADD CONSTRAINT FK_MEASUREMENTENTITY_ON_SENSOR FOREIGN KEY (sensor_id) REFERENCES sensor_entity (id);

ALTER TABLE sensor_entity
    ADD CONSTRAINT FK_SENSORENTITY_ON_USER FOREIGN KEY (user_id) REFERENCES user_entity (id);