-- person definition

-- Drop table

-- DROP TABLE person;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE person
(
    id                                UUID PRIMARY KEY,
    active                            BOOLEAN                                               NULL,
    exclusion_date                    timestamp(6)                                      NULL,
    registration_date                 timestamp(6)                                      NOT NULL,
    update_date                       timestamp(6)                                      NOT NULL,
    keycloak_sync                     BOOLEAN                                          NULL,
    birth_date                        date                                              NULL,
    cell_phone                        varchar(11)  NULL,
    cpf                               varchar(11)  UNIQUE NOT NULL,
    email                             varchar(100) NULL,
    full_name                         varchar(100) NULL,
    keycloak_end_temporary_block      time(6)                                      NULL,
    keycloak_login_failure            bigint                                            NULL,
    keycloak_user_id                  varchar(255) NULL,
    phone                             varchar(11)  NULL,
    receive_news                      BOOLEAN                                               NULL,
    security_code                     varchar(6)   NULL,
    social_name                       varchar(100) NULL
);

-- person_role definition

-- Drop table

-- DROP TABLE person_role;

CREATE TABLE person_role
(
    person_id UUID                                      ,
    roles     varchar(255) NULL,
    CONSTRAINT FKhyx1efsls0f00lxs6xd4w2b3j FOREIGN KEY (person_id) REFERENCES person (id)
);
ALTER TABLE person_role
    ADD CONSTRAINT CK__person_ro__roles__0F624AF8
        CHECK (roles IN ('COMPANY', 'STUDENT', 'USER', 'ADMIN'));



INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:15:02.873367', '2024-06-12 11:15:02.873387',false, '1984-11-15', '67991453488', '36627119668', 'zzewlbpc33@example.com',  'Arica Mohr',  null,0, 'a997eab5-5ed5-491f-b2ca-28b113a33da5',  '67991453488',false, '716217', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:31:37.011490', '2024-06-12 11:31:37.011747',false, '1984-11-15', '86988101189', '74999527111', 'wmczlorce85@gmail.com',  'Bud Reilly', null,0, 'c3ebd205-a3d7-4826-a570-ed116c74661c', '86988101189',true, '459432', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:28:11.390843', '2024-06-12 11:28:11.390853',false, '1984-11-14', '81981077293', '39735167905', 'vcrbqcmw86@gmail.com',  'Christian Ledner',  null,0, 'e3aa19ca-8ee5-454c-8069-3a18933dfecf', '81981077293',true, '532838', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:39:12.539069', '2024-06-12 11:39:12.539082',false, '1984-11-30', '67991998564', '29494712935', 'piydqytd60@outlook.com',  'Fredric Upton',  null,0, '05a8cdec-f08a-4f64-81ca-c1ba96d81968', '67991998564',false, '889232', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:32:56.640479', '2024-06-12 11:32:56.640503',false, '1984-11-20', '68997730484', '39359207683', 'iqvozvrcnc10@example.com',  'Ginger Bergnaum',  null,0, '98cb8dd3-4399-475a-add6-918d43061243',  '68997730484',true, '270252', 'L');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:30:15.874385', '2024-06-12 11:30:15.874395',false, '1984-11-05', '99989790742', '73044709334', 'thckdcq5@gmail.com',  'Janine Waelchi V',  null,0, '94af213c-8b82-403f-b94d-38cba40352db',  '99989790742',false, '314045', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:25:32.283343', '2024-06-12 11:25:32.283563',false, '1984-11-15', '69987484850', '16181652086', 'vmufllk9@yahoo.com',  'Kelly Ledner', null,0, '6cd34355-4a94-4ae4-aa9c-f5e3c713acdd', '69987484850',false, '343774', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:18:01.277922', '2024-06-12 16:03:50.144949',false, '1984-11-19', '95981650342', '97049414204', 'lwtwothp87@example.com',  'Loriann Kuhic',  null,0, '70c5fa17-3df3-4a4c-ade0-5d882964d5a1', '',true, '451899', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:16:06.481898', '2024-06-12 15:46:19.439979',false, '1976-06-27', '67984171370', '48620198890', 'ijaucbav35@gmail.com', 'Mrs. Muoi Kirlin',  null,0, 'a4b5f383-e116-4d2f-bcc7-d0d9313b234c', '',true, '874942', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:37:22.451549', '2024-06-12 15:52:17.746607',false, '1971-08-17', '85992914094', '22838082272', 'nmaxekr60@outlook.com',  'Ms. Jake Schumm',  null,0, '6d83d3db-ed4f-420a-9583-3b033619e881', '',true, '107547', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, null, '2024-06-12 11:34:35.788545', '2024-06-12 15:55:54.903092',false, '1997-12-01', '83995784865', '83367356662', 'kjtfckcv87@example.com',  'Ms. Tristan Konopelski', null,0, '458cedd3-0315-4224-8ffe-5c2036fc8bd7', '',true, '273864', '');
INSERT INTO person (id, active, exclusion_date, registration_date, update_date, keycloak_sync, birth_date, cell_phone, cpf, email,  full_name,  keycloak_end_temporary_block, keycloak_login_failure, keycloak_user_id,  phone,  receive_news, security_code, social_name ) VALUES (uuid_generate_v4(),true, NULL, '2024-06-12 11:18:01.277922', '2024-06-12 16:03:50.144949',false, '1996-01-06', '95981650342', '76308495085', 'bbeeayrrmn79@yahoo.com',  'Randall Pfannerstill', NULL,0, 'cbeb9acf-0196-4f82-a6b2-449979ce5dfb', '',true, NULL, '');

CREATE OR REPLACE FUNCTION inserir_person_role(p_cpf TEXT, p_role VARCHAR(255))
    RETURNS VOID AS $$
DECLARE
    p_id UUID;
BEGIN
    SELECT id INTO p_id FROM person WHERE cpf = p_cpf;
    IF FOUND THEN  -- Verifica se a pessoa foi encontrada
        INSERT INTO person_role (person_id, roles) VALUES (p_id, p_role);
    ELSE
        RAISE NOTICE 'Pessoa não encontrada: %', p_cpf;
    END IF;
END;
$$ LANGUAGE plpgsql;

SELECT inserir_person_role('36627119668', 'ADMIN');
SELECT inserir_person_role('36627119668', 'USER');

SELECT inserir_person_role('74999527111', 'USER');
SELECT inserir_person_role('39735167905', 'USER');
SELECT inserir_person_role('29494712935', 'USER');
SELECT inserir_person_role('39359207683', 'USER');
SELECT inserir_person_role('73044709334', 'USER');
SELECT inserir_person_role('16181652086', 'USER');
SELECT inserir_person_role('97049414204', 'USER');
SELECT inserir_person_role('48620198890', 'USER');
SELECT inserir_person_role('22838082272', 'USER');
SELECT inserir_person_role('83367356662', 'USER');
SELECT inserir_person_role('76308495085', 'USER');


