INSERT INTO roles(name) VALUE ("ADMIN"), ("USER"), ("INVITED");

INSERT INTO users(username, email, password)
  VALUES ("Lucho", "luchito@gmail.com", "luchito123"),
  ("Lucho", "luchito@gmail.com", "luchito123"),
  ("Sebastian", "sebas@gmail.com", "sebas123"),
  ("diplock", "diplock@gmail.com", "diplock123");

INSERT INTO users_roles(user_id, role_id)
  VALUES (1, 1),
  (2, 1),
  (2, 2),
  (3, 1),
  (3, 2),
  (4, 2);

