INSERT INTO user (id, name, email, password) VALUES (1, 'Admin', 'admin@email.com', '$2a$10$TjiNqZ7koeqHWe7u1bkdA.6MYTcP5A7U0Yxdt.gw90JDM/KX5IWsy');
INSERT INTO user (id, name, email, password) VALUES (2, 'Caminhoneiro', 'caminhoneiro@email.com', '$2a$10$TjiNqZ7koeqHWe7u1bkdA.6MYTcP5A7U0Yxdt.gw90JDM/KX5IWsy');

INSERT INTO profile (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO profile (id, name) VALUES (2, 'ROLE_CAMINHONEIRO');

INSERT INTO user_profiles (user_id, profiles_id) VALUES (1, 1);
INSERT INTO user_profiles (user_id, profiles_id) VALUES (2, 2);

INSERT INTO employee (id, name, office) VALUES (1, 'Carlos Hideki Yamakawa', 'Gerente');
INSERT INTO employee (id, name, office) VALUES (2, 'Natalia Yumi Nakamura', 'Líder');
INSERT INTO employee (id, name, office) VALUES (3,'Eliana Mayumi Imanisse Yamakawa', 'Adminstradora');
INSERT INTO employee (id, name, office) VALUES (4,'Yukio Yamakawa', 'Presidente');
INSERT INTO employee (id, name, office) VALUES (5, 'Leticia Satie Yamakawa', 'Vendedora');
INSERT INTO employee (id, name, office) VALUES (6, 'Alberto Yugi Yamakawa', 'Agricultor');