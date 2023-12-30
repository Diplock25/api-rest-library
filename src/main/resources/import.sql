INSERT INTO users(id_user, username, email, password) VALUES(1, 'Dante', 'dante@gmail.com', 'dante123')
INSERT INTO users(id_user, username, email, password) VALUES(2, 'Sebastian', 'sebas@gmail.com', 'sebas123')
INSERT INTO users(id_user, username, email, password) VALUES(3, 'Ruben', 'ruben@gmail.com', 'ruben123')
--INSERT INTO users(id_user, username, email, password) VALUES(4, 'Dante', 'dante@gmail.com', 'dante123')

INSERT INTO roles(id_role, name) VALUE(1, "ADMIN")
INSERT INTO roles(id_role, name) VALUE(2, "USER")
INSERT INTO roles(id_role, name) VALUE(3, "INVITED")

INSERT INTO user_roles(role_id, user_id) VALUE(1, 1)
INSERT INTO user_roles(role_id, user_id) VALUE(2, 1)
INSERT INTO user_roles(role_id, user_id) VALUE(1, 2)
INSERT INTO user_roles(role_id, user_id) VALUE(1, 3)
--INSERT INTO user_roles(role_id, user_id) VALUE(1, 4)