CREATE DATABASE IF NOT EXISTS `lp1`;
USE `lp1`;

DROP TABLE IF EXISTS `Animal`;
DROP TABLE IF EXISTS `Aparelho`;
DROP TABLE IF EXISTS `Aviao`;
DROP TABLE IF EXISTS `Carro`;
DROP TABLE IF EXISTS `Instrumento`;
DROP TABLE IF EXISTS `Planeta`;
DROP TABLE IF EXISTS `Pokemon`;
DROP TABLE IF EXISTS `PowerRanger`;
DROP TABLE IF EXISTS `Roupa`;
DROP TABLE IF EXISTS `VideoGame`;

CREATE TABLE Animal (
    IDAnimal INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    especie VARCHAR(255) NOT NULL
);
CREATE TABLE Aparelho (
    numeroSerie INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL
);
CREATE TABLE Aviao (
    numeroSerie INT PRIMARY KEY AUTO_INCREMENT,
    fabricante VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL
);
CREATE TABLE Carro (
    placa VARCHAR(10) PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL
);
CREATE TABLE Instrumento (
    IDInstrumento INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    numeroCordas INT NOT NULL
);
CREATE TABLE Planeta (
    nome VARCHAR(255) PRIMARY KEY,
    raio FLOAT NOT NULL,
    massa VARCHAR(255) NOT NULL
);
CREATE TABLE Pokemon (
    numeroPokedex INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipos VARCHAR(255) NOT NULL
);
CREATE TABLE PowerRanger (
    nome VARCHAR(255) PRIMARY KEY,
    corUniforme VARCHAR(50) NOT NULL,
    zord VARCHAR(255) NOT NULL
);
CREATE TABLE Roupa (
    IDRoupa INT PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    tamanho VARCHAR(50) NOT NULL,
    cor VARCHAR(50) NOT NULL
);
CREATE TABLE VideoGame (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    genero VARCHAR(100),
    classificacaoEtaria INT
);
