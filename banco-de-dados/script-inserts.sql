INSERT INTO tb_abrigo (nome, localizacao) VALUES
('Abrigo Esperança', 'Rua das Flores, 123'),
('Abrigo São João', 'Av. Central, 456'),
('Abrigo Luz do Sol', 'Rua Aurora, 789'),
('Abrigo Vida Nova', 'Rua Harmonia, 101'),
('Abrigo São Pedro', 'Alameda Paz, 202'),
('Abrigo Recanto Feliz', 'Rua da Alegria, 303'),
('Abrigo Bom Pastor', 'Av. Liberdade, 404');

INSERT INTO tb_cargo_usuario (cargo) VALUES
('Administrador'),
('Coordenador'),
('Assistente Social'),
('Psicólogo'),
('Voluntário'),
('Segurança'),
('Cozinheiro');

INSERT INTO tb_usuario (login, senha, id_cargo, nome, cpf, endereco) VALUES
('carlSilva', 'senha123', 1, 'Carlos Silva', '12345678901', 'Rua A, 100'),
('aninha', 'senha456', 2, 'Ana Lima', '23456789012', 'Rua B, 200'),
('marcosD', 'senha789', 3, 'Marcos Dias', '34567890123', 'Rua C, 300'),
('souza_lucia', 'senha321', 4, 'Lúcia Souza', '45678901234', 'Rua D, 400'),
('robertoAlves', 'senha654', 5, 'Roberto Alves', '56789012345', 'Rua E, 500'),
('fernanda', 'senha987', 6, 'Fernanda Rocha', '67890123456', 'Rua F, 600'),
('edu_ramos', 'senha159', 7, 'Eduardo Ramos', '78901234567', 'Rua G, 700');

INSERT INTO tb_natureza_notificacao (natureza) VALUES
('Inundação'),
('Deslizamento'),
('Tufão'),
('Segurança'),
('Alimentação'),
('Transporte'),
('Atendimento');

INSERT INTO tb_notificacao (descricao, id_natureza_notificacao) VALUES
('Vazamento de água', 1),
('Refeições insuficientes', 5),
('Atraso no transporte', 2);

INSERT INTO tb_recurso (nome_recurso) VALUES
('Água'),
('Comida'),
('Cobertores'),
('Medicamentos'),
('Produtos de higiene'),
('Roupas'),
('Máscaras');

INSERT INTO tb_recurso_abrigo (id_abrigo, id_recurso, quantidade, unidade_medida) VALUES
(1, 1, 1000, 'litros'),
(1, 2, 300, 'kg'),
(2, 3, 150, 'unidades'),
(3, 4, 200, 'caixas'),
(4, 5, 500, 'unidades'),
(5, 6, 250, 'peças'),
(6, 7, 400, 'unidades');

INSERT INTO tb_pessoa (nome, nascimento, cpf) VALUES
('João da Silva', '1980-01-15', '11111111111'),
('Maria Oliveira', '1992-07-23', '22222222222'),
('Pedro Santos', '2000-05-10', '33333333333'),
('Carla Pereira', '1985-03-30', '44444444444'),
('Lucas Souza', '1999-09-18', '55555555555'),
('Fernanda Lima', '1975-12-12', '66666666666'),
('José Almeida', '2003-06-06', '77777777777');

INSERT INTO tb_pessoa_abrigo (id_pessoa, id_abrigo) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(6, 5),
(7, 6);

INSERT INTO tb_chat (nome, data_criacao) VALUES
('Chat Geral', '2025-01-01'),
('Equipe Saúde', '2025-01-05'),
('Equipe Segurança', '2025-01-10'),
('Coordenação', '2025-01-15'),
('Voluntários', '2025-01-20'),
('Psicologia', '2025-01-25'),
('Administração', '2025-02-01');

INSERT INTO tb_mensagem (conteudo, id_autor, id_chat, data_criacao) VALUES
('Bom dia a todos!', 1, 1, '2025-01-01'),
('Reunião às 14h', 2, 4, '2025-01-05'),
('Falta de remédios no abrigo 3', 3, 2, '2025-01-07'),
('Precisamos de mais voluntários', 5, 5, '2025-01-08'),
('Banheiros com problemas', 6, 3, '2025-01-09'),
('Atualizando relatório de recursos', 1, 7, '2025-01-10'),
('Boa noite, equipe!', 4, 6, '2025-01-11');

INSERT INTO tb_usuario_chat (id_chat, id_usuario) VALUES
(1, 1),
(2, 3),
(3, 6),
(4, 2),
(5, 5),
(6, 4),
(7, 1);

