CREATE SEQUENCE hibernate_sequence START 1

INSERT INTO role (role_id, role_name, version) VALUES (1, 'ROLE_ADMIN', 0)
INSERT INTO role (role_id, role_name, version) VALUES (2, 'ROLE_CUSTOMER', 0)
INSERT INTO m_user (fullname, is_enabled, login_failure_count, password, username, version) VALUES ('Administrator', true, 0, '$2a$11$mgai3.7p8B//jwexcYyYheZWxxOULgRP.KhFl56E0kp9i608DBB7W', 'admin', 0)
INSERT INTO user_role (username, role_id) VALUES ('admin', 1)
INSERT INTO client (client_id, client_secret, version) VALUES ('client', 'secret', 0)

INSERT INTO category(category_id, name, version) VALUES(3600, 'Ales', 0)
INSERT INTO category(category_id, name, version) VALUES(3601, 'Chivas', 0)
INSERT INTO beer(category_id, name, beer_id, manufacturer, country, price, is_archived, version) VALUES(3600, 'Ales White', 3999, 'US', 'CANADA', 299.00, true, 0)
INSERT INTO beer(category_id, name, beer_id, manufacturer, country, price, is_archived, version) VALUES(3601, 'Chivas 18', 3998, 'UK', 'HongKong', 299.00, false, 0)
