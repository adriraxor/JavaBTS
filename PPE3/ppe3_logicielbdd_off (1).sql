-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 19 oct. 2020 à 11:37
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ppe3_logicielbdd_off`
--
CREATE DATABASE IF NOT EXISTS `ppe3_logicielbdd_off` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ppe3_logicielbdd_off`;

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

DROP TABLE IF EXISTS `agent`;
CREATE TABLE IF NOT EXISTS `agent` (
  `idPersonnel` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `num_telephone` varchar(50) DEFAULT NULL,
  `idProfil` int(11) NOT NULL,
  PRIMARY KEY (`idPersonnel`),
  KEY `idProfil` (`idProfil`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `agent`
--

INSERT INTO `agent` (`idPersonnel`, `nom`, `prenom`, `num_telephone`, `idProfil`) VALUES
(1, 'FIGUERES', 'Adrien', '0638319676', 1),
(2, 'LEON', 'Bernard', '0626248296', 2);

-- --------------------------------------------------------

--
-- Structure de la table `appartenir`
--

DROP TABLE IF EXISTS `appartenir`;
CREATE TABLE IF NOT EXISTS `appartenir` (
  `idProduit` int(11) NOT NULL,
  `Id_Categorie` int(11) NOT NULL,
  PRIMARY KEY (`idProduit`,`Id_Categorie`),
  KEY `Id_Categorie` (`Id_Categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `appartenir`
--

INSERT INTO `appartenir` (`idProduit`, `Id_Categorie`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `Id_Categorie` int(255) NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(50) DEFAULT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id_Categorie`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`Id_Categorie`, `nom_categorie`, `libelle`) VALUES
(1, 'SUV', 'Les SUV sont des 4x4 performants '),
(2, 'Berline', 'Les berlines sont des véhicules très polyvalents');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(255) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `num_telephone` int(11) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `email`, `num_telephone`) VALUES
(1, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(2, 'Ameline', 'Saint-Eustache-la-Forêt', 'adri@gmail.com', 62646265),
(3, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(4, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(5, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(6, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(7, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(8, 'fhf', 'adri', 'Bernad.test@gmail.com', 626248056),
(9, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(10, 'AdriModifTest', 'adri', 'Bernad.test@gmail.com', 626248056),
(12, 'Test', 'Bernard', 'Bernad.test@gmail.com', 626248056),
(11, 'TEST FINAL', 'adri', 'Bernad.test@gmail.com', 626248056),
(13, 'Test', 'Bernard', 'Bernad.test@gmail.com', 626248056),
(14, 'Test', 'Bernard', 'Bernad.test@gmail.com', 626248056),
(15, 'Test', 'Bernard', 'Bernad.test@gmail.com', 626248056),
(16, 'Test', 'Bernard', 'Bernad.test@gmail.com', 626248056),
(17, 'Test', 'Bernard', 'Bernad.test@gmail.com', 626248056),
(18, 'BimBam', 'OleOle', 'Bernad.test@gmail.com', 626248056),
(19, 'Test', 'Bernard', 'Bernad.test@gmail.com', 626248056);

-- --------------------------------------------------------

--
-- Structure de la table `contenir`
--

DROP TABLE IF EXISTS `contenir`;
CREATE TABLE IF NOT EXISTS `contenir` (
  `idProduit` int(11) NOT NULL,
  `idVente` int(11) NOT NULL,
  `quantiter` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduit`,`idVente`),
  KEY `idVente` (`idVente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `creer`
--

DROP TABLE IF EXISTS `creer`;
CREATE TABLE IF NOT EXISTS `creer` (
  `idVente` int(11) NOT NULL,
  `Id_Facture` int(11) NOT NULL,
  PRIMARY KEY (`idVente`,`Id_Facture`),
  KEY `Id_Facture` (`Id_Facture`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `effectuer`
--

DROP TABLE IF EXISTS `effectuer`;
CREATE TABLE IF NOT EXISTS `effectuer` (
  `idClient` varchar(50) NOT NULL,
  `idVente` int(11) NOT NULL,
  PRIMARY KEY (`idClient`,`idVente`),
  KEY `idVente` (`idVente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `Id_Facture` int(11) NOT NULL,
  PRIMARY KEY (`Id_Facture`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `generer`
--

DROP TABLE IF EXISTS `generer`;
CREATE TABLE IF NOT EXISTS `generer` (
  `idVente` int(11) NOT NULL,
  `idPersonnel` int(11) NOT NULL,
  PRIMARY KEY (`idVente`,`idPersonnel`),
  KEY `idPersonnel` (`idPersonnel`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `idProduit` int(255) NOT NULL AUTO_INCREMENT,
  `nom_produit` varchar(50) DEFAULT NULL,
  `tarif_produit` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `popularite` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduit`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idProduit`, `nom_produit`, `tarif_produit`, `stock`, `libelle`, `image`, `popularite`) VALUES
(1, 'Lamborghini URUS', 170000, 3, 'Lamborghini URUS neuf', NULL, 9),
(2, 'Renault CLIO IV 90 ', 17000, 500, 'Clio IV neuve, 90 chevaux', NULL, 5);

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `idProfil` int(11) NOT NULL AUTO_INCREMENT,
  `num_telephone` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `permission` int(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idProfil`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`idProfil`, `num_telephone`, `username`, `password`, `email`, `permission`) VALUES
(1, '0638319676', 'Adriraxor', 'root', 'figueres.adrien@gmail.com', 0),
(2, '0626248296', 'Admin', 'toto', 'admin.toto@gmail.com', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE IF NOT EXISTS `vente` (
  `idVente` int(11) NOT NULL,
  `numero_commande` int(11) DEFAULT NULL,
  `date_vente` datetime DEFAULT NULL,
  PRIMARY KEY (`idVente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
