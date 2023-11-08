-- Criação da tabela 'usuario'
CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL,
                         cpf VARCHAR(255) NOT NULL,
                         telefone VARCHAR(255),
                         email VARCHAR(255) NOT NULL,
                         senha VARCHAR(255) NOT NULL,
                         idioma_id BIGINT NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (idioma_id) REFERENCES idioma(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);