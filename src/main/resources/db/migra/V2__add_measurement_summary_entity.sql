CREATE TABLE measurement_summary_entity
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    sensor_id            VARCHAR(36) NOT NULL,
    avg_value DOUBLE NULL,
    min_value DOUBLE NULL,
    max_value DOUBLE NULL,
    measured_at_per_hour datetime(6)           NOT NULL,
    CONSTRAINT pk_measurementsummaryentity PRIMARY KEY (id)
);

ALTER TABLE measurement_summary_entity
    ADD CONSTRAINT FK_MEASUREMENTSUMMARYENTITY_ON_SENSOR FOREIGN KEY (sensor_id) REFERENCES sensor_entity (id);