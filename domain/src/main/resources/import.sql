CREATE SEQUENCE hibernate_sequence START 1
INSERT INTO role (role_id, role_name) VALUES (1, 'ROLE_ADMIN')
INSERT INTO role (role_id, role_name) VALUES (2, 'ROLE_USER')
INSERT INTO m_user (fullname, is_enabled, login_failure_count, password, username) VALUES ('Administrator', true, 0, '$2a$11$mgai3.7p8B//jwexcYyYheZWxxOULgRP.KhFl56E0kp9i608DBB7W', 'admin')
INSERT INTO user_role (username, role_id) VALUES ('admin', 1)
INSERT INTO oauth (client_id, client_secret) VALUES ('id', 'secret')