CREATE SEQUENCE hibernate_sequence START 1
INSERT INTO role (role_id, role_name) VALUES (1, 'ROLE_ADMIN')
INSERT INTO role (role_id, role_name) VALUES (2, 'ROLE_CLIENT')
INSERT INTO role (role_id, role_name) VALUES (3, 'ROLE_USER')
INSERT INTO m_user (fullname, is_enabled, login_failure_count, password, username) VALUES ('Administrator', true, 0, '$2a$11$mgai3.7p8B//jwexcYyYheZWxxOULgRP.KhFl56E0kp9i608DBB7W', 'admin')
INSERT INTO m_user (fullname, is_enabled, login_failure_count, password, username) VALUES ('Client', true, 0, '$2a$11$aW4Q1qYyxHCcfG6J2IF4WujaUkmuM5ICvYU8jx4Rdgp7xgkKD8QDe', 'client')
INSERT INTO user_role (username, role_id) VALUES ('admin', 1)
INSERT INTO user_role (username, role_id) VALUES ('client', 3)
