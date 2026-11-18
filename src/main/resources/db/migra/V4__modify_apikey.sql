ALTER TABLE user_entity
    ADD CONSTRAINT uc_userentity_api_key UNIQUE (api_key);

ALTER TABLE user_entity
    MODIFY api_key VARCHAR (36);