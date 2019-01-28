CREATE SEQUENCE hibernate_sequence START 1
INSERT INTO role (role_id, role_name) VALUES (1, 'ROLE_ADMIN')
INSERT INTO role (role_id, role_name) VALUES (2, 'ROLE_CUSTOMER')
INSERT INTO m_user (fullname, is_enabled, login_failure_count, password, username) VALUES ('Administrator', true, 0, '$2a$11$mgai3.7p8B//jwexcYyYheZWxxOULgRP.KhFl56E0kp9i608DBB7W', 'admin')
INSERT INTO user_role (username, role_id) VALUES ('admin', 1)
INSERT INTO client (client_id, client_secret) VALUES ('client', 'secret')

INSERT INTO category(category_id, name) VALUES(1, 'Ales')
INSERT INTO category(category_id, name) VALUES(2, 'Chivas')
INSERT INTO beer(category_id, name, beer_id, manufacturer, country, price, is_archived) VALUES(1, 'Ales White', 1, 'US', 'CANADA', 299.00, true)
INSERT INTO beer(category_id, name, beer_id, manufacturer, country, price, is_archived) VALUES(2, 'Chivas 18', 2, 'US', 'CANADA', 299.00, false)