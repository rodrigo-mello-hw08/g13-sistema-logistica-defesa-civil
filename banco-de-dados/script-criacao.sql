CREATE TABLE tb_abrigo (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	nome VARCHAR(255) NOT NULL,
	localizacao VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE tb_cargo_usuario (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	cargo VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE tb_usuario (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	email VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	id_cargo INTEGER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	cpf CHAR(11) NOT NULL UNIQUE,
	endereco VARCHAR(255),
	PRIMARY KEY(id),
	FOREIGN KEY (id_cargo) REFERENCES tb_cargo_usuario(id)
);

CREATE TABLE tb_natureza_notificacao (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	natureza VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE tb_notificacao (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	descricao VARCHAR(255) NOT NULL,
	id_natureza_notificacao INTEGER NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (id_natureza_notificacao) REFERENCES tb_natureza_notificacao(id)
);

CREATE TABLE tb_recurso (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	nome VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY(id)
);

CREATE TABLE tb_recurso_abrigo (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	id_abrigo INTEGER NOT NULL,
	id_recurso INTEGER NOT NULL,
	quantidade INTEGER NOT NULL,
	unidade_medida VARCHAR(255) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (id_abrigo) REFERENCES tb_abrigo(id),
	FOREIGN KEY (id_recurso) REFERENCES tb_recurso(id)
);

CREATE TABLE tb_pessoa (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	nome VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf CHAR(11) NOT NULL UNIQUE,
	endereco VARCHAR(255),
	PRIMARY KEY(id)
);

CREATE TABLE tb_pessoa_abrigo (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	id_pessoa INTEGER NOT NULL,
	id_abrigo INTEGER NOT NULL,
	fl_ativo CHAR(1) DEFAULT "S",
	PRIMARY KEY(id),
	FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa(id),
	FOREIGN KEY (id_abrigo) REFERENCES tb_abrigo(id),
	CHECK (fl_ativo IN ("S", "N"))
);

CREATE TABLE tb_chat (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	nome VARCHAR(255) NOT NULL,
	data_criacao DATE NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE tb_mensagem (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	conteudo VARCHAR(255) NOT NULL,
	id_autor INTEGER NOT NULL,
	id_chat INTEGER NOT NULL,
	data_criacao DATE NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (id_autor) REFERENCES tb_usuario(id),
	FOREIGN KEY (id_chat) REFERENCES tb_chat(id)
);

CREATE TABLE tb_usuario_chat (
	id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	id_chat INTEGER NOT NULL,
	id_usuario INTEGER NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (id_chat) REFERENCES tb_chat(id),
	FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id)
);
