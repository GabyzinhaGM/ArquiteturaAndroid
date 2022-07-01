CREATE DATABASE MovieFlixDB;
USE MovieFlixDB;

CREATE TABLE Usuario(
    id int AUTO_INCREMENT,
    cpf varchar(11),
    nome varchar(255),
    email varchar(80),
senha varchar(25),
    PRIMARY KEY(id)
);

CREATE TABLE Filme(
    cod_filme int AUTO_INCREMENT,
    titulo varchar(255),
    imagem varchar(50),
    descricao varchar(1000),
genero varchar(50),
    PRIMARY KEY(cod_filme)
);

CREATE TABLE FilmeFavoritado(
    id int AUTO_INCREMENT,
    titulo varchar(255),
    imagem varchar(50),
    PRIMARY KEY(id)
);

-- Insert filmes

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('A Era do Gelo', 'images/gelo.jpg', 'A era do gelo, um filme top', 'aventura');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('O Senhor dos Aneis', 'images/aneis.jpg', 'Filme interessante', 'fantasia');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('Titanic', 'images/titanic.jpg', 'um filme emocionante', 'romanse');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('Divertidamente', 'images/divertidamente.jpg', 'um filme legal', 'animacao');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('Tubarao', 'images/tubarao.jpg', 'um filme bom', 'suspense');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('A Culpa eh das Estrelas', 'images/estrelas.jpg', 'um filme recomendavel', 'romanse');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('Escolha ou Morra', 'images/escolha.jpg', 'um filme de prender o folego', 'suspense');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('Annabelle', 'images/annabelle.jpg', 'um filme assustador', 'terror');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('O Tunel', 'images/tunel.jpg', 'um filme dramático', 'suspense');

INSERT INTO Filme(titulo, imagem, descricao, genero)
VALUES ('O Menino do Pijama Listrado', 'images/pijama.jpg', 'um filme triste', 'suspense');

-- Insert usuarios

INSERT INTO Usuario(cpf, nome, email, senha)
VALUES ('00000000022', 'Joao Silva', 'joao.silva@gmail.com', 'abc12345');

INSERT INTO Usuario(cpf, nome, email, senha)
VALUES ('00000000033', 'Paulo Pereira', 'paulo.p@gmail.com', 'cba123');

INSERT INTO Usuario(cpf, nome, email, senha)
VALUES ('00000000044', 'Rosa Oliveira', 'rosa.oliveira@gmail.com', '321cba');

INSERT INTO Usuario(cpf, nome, email, senha)
VALUES ('00000000055', 'Kiko Chaves', 'kiko.chaves@gmail.com', 'cab231');

INSERT INTO Usuario(cpf, nome, email, senha)
VALUES ('00000000011', 'Jessica Maria', 'jessica.maria@gmail.com', '213bac');

SELECT *
FROM Usuario
WHERE nome = 'Paulo Pereira';

SELECT *
FROM Filme
WHERE titulo = 'A Era do Gelo';

UPDATE Filme SET
titulo = 'Vingadores: Ultimato',
descricao = 'Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco'
WHERE cod_filme = 3;

DELETE FROM Usuario
WHERE id = 2;


-- Insert filmes favoritados

INSERT INTO FilmeFavoritado(titulo, imagem)
VALUES ('A Era do Gelo', 'images/gelo.jpg');

INSERT INTO FilmeFavoritado(titulo, imagem)
VALUES ('O Senhor dos Aneis', 'images/aneis.jpg');
