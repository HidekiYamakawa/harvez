INSERT INTO user (name, email, password) VALUES ('Admin', 'admin@email.com', '$2a$10$TjiNqZ7koeqHWe7u1bkdA.6MYTcP5A7U0Yxdt.gw90JDM/KX5IWsy');
INSERT INTO user (name, email, password) VALUES ('Caminhoneiro', 'caminhoneiro@email.com', '$2a$10$TjiNqZ7koeqHWe7u1bkdA.6MYTcP5A7U0Yxdt.gw90JDM/KX5IWsy');

INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_CAMINHONEIRO');

INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, roles_id) VALUES (2, 2);

INSERT INTO employee (name, office) VALUES ('Carlos Hideki Yamakawa', 'Gerente');
INSERT INTO employee (name, office) VALUES ('Natalia Yumi Nakamura', 'Líder');
INSERT INTO employee (name, office) VALUES ('Eliana Mayumi Imanisse Yamakawa', 'Adminstradora');
INSERT INTO employee (name, office) VALUES ('Yukio Yamakawa', 'Presidente');
INSERT INTO employee (name, office) VALUES ('Leticia Satie Yamakawa', 'Vendedora');
INSERT INTO employee (name, office) VALUES ('Alberto Yugi Yamakawa', 'Agricultor');