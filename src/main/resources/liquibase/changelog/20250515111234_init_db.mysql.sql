-- liquibase formatted sql

-- changeset huyhanhat:1747282357038-1
CREATE TABLE app_user
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime(6) NOT NULL,
    created_by    VARCHAR(50) NOT NULL,
    updated_at    datetime(6) NULL,
    updated_by    VARCHAR(50) NULL,
    email         VARCHAR(254) NULL,
    full_name     VARCHAR(50) NULL,
    password_hash VARCHAR(60) NOT NULL,
    username      VARCHAR(50) NOT NULL,
    CONSTRAINT app_userPK PRIMARY KEY (id)
);

-- changeset huyhanhat:1747282357038-2
CREATE TABLE authority
(
    name VARCHAR(50) NOT NULL,
    CONSTRAINT authorityPK PRIMARY KEY (name)
);

-- changeset huyhanhat:1747282357038-3
CREATE TABLE permission
(
    name VARCHAR(255) NOT NULL,
    CONSTRAINT permissionPK PRIMARY KEY (name)
);

-- changeset huyhanhat:1747282357038-4
CREATE TABLE user_authority
(
    user_id        BIGINT      NOT NULL,
    authority_name VARCHAR(50) NOT NULL,
    CONSTRAINT user_authorityPK PRIMARY KEY (user_id, authority_name)
);

-- changeset huyhanhat:1747282357038-5
CREATE TABLE user_permission
(
    user_id         BIGINT       NOT NULL,
    permission_name VARCHAR(255) NOT NULL,
    CONSTRAINT user_permissionPK PRIMARY KEY (user_id, permission_name)
);

-- changeset huyhanhat:1747282357038-6
ALTER TABLE app_user
    ADD CONSTRAINT UC_APP_USEREMAIL_COL UNIQUE (email);

-- changeset huyhanhat:1747282357038-7
ALTER TABLE app_user
    ADD CONSTRAINT UC_APP_USERUSERNAME_COL UNIQUE (username);

-- changeset huyhanhat:1747282357038-8
ALTER TABLE user_permission
    ADD CONSTRAINT FK20pntbc5kk8ytopc30j8o84nb FOREIGN KEY (permission_name) REFERENCES permission (name);

-- changeset huyhanhat:1747282357038-9
ALTER TABLE user_permission
    ADD CONSTRAINT FK2ntlvbind4s7co2t7hh4f2jee FOREIGN KEY (user_id) REFERENCES app_user (id);

-- changeset huyhanhat:1747282357038-10
ALTER TABLE user_authority
    ADD CONSTRAINT FK6ktglpl5mjosa283rvken2py5 FOREIGN KEY (authority_name) REFERENCES authority (name);

-- changeset huyhanhat:1747282357038-11
ALTER TABLE user_authority
    ADD CONSTRAINT FKeoyor0ywyy3m5xntqmjvah310 FOREIGN KEY (user_id) REFERENCES app_user (id);



-- changeset huyhanhat:1747282357038-12
INSERT INTO authority (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

-- changeset huyhanhat:1747282357038-13
INSERT INTO permission (name)
VALUES ('READ_PRIVILEGES'),
       ('WRITE_PRIVILEGES'),
       ('DELETE_PRIVILEGES');

-- changeset huyhanhat:1747282357038-14
INSERT INTO app_user (username, password_hash, email, full_name, created_at, created_by)
VALUES ('admin', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'admin@localhost', 'Administrator', CURRENT_TIMESTAMP, 'SYSTEM');

-- changeset huyhanhat:1747282357038-15
INSERT INTO user_authority (user_id, authority_name)
SELECT u.id, 'ROLE_ADMIN'
FROM app_user u
WHERE u.username = 'admin';

