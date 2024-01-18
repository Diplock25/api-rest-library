INSERT INTO categories (name, subtopic) VALUES ('Informatica', 'Desarrollo');
INSERT INTO categories (name, subtopic) VALUES ('Informatica', 'Sistemas');
INSERT INTO categories (name, subtopic) VALUES ('Informatica', 'Redes');

INSERT INTO users(name_user, email, password, id_role) VALUES ('Mortadelo Burri Calvo', 'mortadeloburri@tia.es', 'ofelia', 1);
INSERT INTO users(name_user, email, password, id_role) VALUES ('Filemón Pí Ramirez', 'filemonpi@tia.es', 'ofelia', 1);

INSERT INTO books (isbn, title, summary, edition_date, pages, language, cover_image, book_file, file_path, category_id) VALUES ('9788441532106', 'Codigo limpio', 'Manual de estilo para mantener limpio nuestro codigo como desarrolladores', '19/06/2012', 464, 'Castellano', 'codeclean.jpg', 'codeclean.pdf', 'D:\recursos\libros-virtuales', 1);

INSERT INTO users (name, surname) VALUES ('Mortadelo', 'Burri Calvo');
INSERT INTO users (name, surname) VALUES ('Filemón', 'Pi Ramirez');