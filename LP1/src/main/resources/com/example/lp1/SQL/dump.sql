-- Dump de dados para o banco 'lp1'

-- Tabela Animal
INSERT INTO Animal (nome, especie) VALUES 
('Leão', 'Felino'),
('Tigre', 'Felino'),
('Elefante', 'Mamífero'),
('Águia', 'Ave'),
('Tubarão', 'Peixe');

-- Tabela Aparelho
INSERT INTO Aparelho (marca, tipo) VALUES 
('Samsung', 'Smartphone'),
('Apple', 'Tablet'),
('Sony', 'Televisão'),
('LG', 'Notebook'),
('Dell', 'Desktop');

-- Tabela Aviao
INSERT INTO Aviao (fabricante, modelo) VALUES 
('Boeing', '737'),
('Airbus', 'A320'),
('Embraer', 'E195'),
('Cessna', 'Skyhawk'),
('Lockheed Martin', 'F-22 Raptor');

-- Tabela Carro
INSERT INTO Carro (placa, marca, modelo) VALUES 
('ABC1234', 'Toyota', 'Corolla'),
('DEF5678', 'Ford', 'Mustang'),
('GHI9012', 'Chevrolet', 'Onix'),
('JKL3456', 'Honda', 'Civic'),
('MNO7890', 'Tesla', 'Model 3');

-- Tabela Instrumento
INSERT INTO Instrumento (nome, numeroCordas) VALUES 
('Violão', 6),
('Guitarra', 6),
('Baixo', 4),
('Ukulele', 4),
('Harp', 47);

-- Tabela Planeta
INSERT INTO Planeta (nome, raio, massa) VALUES 
('Terra', 6371, '5.972 × 10^24 kg'),
('Marte', 3389.5, '6.39 × 10^23 kg'),
('Júpiter', 69911, '1.898 × 10^27 kg'),
('Saturno', 58232, '5.683 × 10^26 kg'),
('Vênus', 6051.8, '4.867 × 10^24 kg');

-- Tabela Pokemon
INSERT INTO Pokemon (numeroPokedex, nome, tipos) VALUES 
(1, 'Bulbasaur', 'Grama/Veneno'),
(4, 'Charmander', 'Fogo'),
(7, 'Squirtle', 'Água'),
(25, 'Pikachu', 'Elétrico'),
(150, 'Mewtwo', 'Psíquico');

-- Tabela PowerRanger
INSERT INTO PowerRanger (nome, corUniforme, zord) VALUES 
('Jason Lee', 'Vermelho', 'Tyrannosaurus'),
('Kimberly Hart', 'Rosa', 'Pterodactyl'),
('Billy Cranston', 'Azul', 'Triceratops'),
('Trini Kwan', 'Amarelo', 'Sabertooth Tiger'),
('Zack Taylor', 'Preto', 'Mastodon');

-- Tabela Roupa
INSERT INTO Roupa (IDRoupa, tipo, tamanho, cor) VALUES 
(1, 'Camiseta', 'M', 'Preto'),
(2, 'Calça Jeans', '42', 'Azul'),
(3, 'Jaqueta', 'G', 'Vermelho'),
(4, 'Vestido', 'P', 'Rosa'),
(5, 'Chapéu', 'Único', 'Branco');

-- Tabela VideoGame
INSERT INTO VideoGame (nome, genero, classificacaoEtaria) VALUES 
('The Legend of Zelda', 'Aventura', 10),
('Call of Duty', 'FPS', 18),
('Minecraft', 'Sandbox', 7),
('FIFA 23', 'Esporte', 3),
('Super Mario Bros', 'Plataforma', 3);
