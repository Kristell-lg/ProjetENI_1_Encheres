CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
	
	pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(50) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
	--CODE POSTAL 5 CHIFFRES EN FRANCE 
    code_postal      VARCHAR(5) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL,
	--UNIQUE pour le pseudo & l'email
	CONSTRAINT UQ_PSEUDO UNIQUE (pseudo),
	CONSTRAINT UQ_EMAIL UNIQUE (email)
)

--CHANGEMENT nom de contrainte pour être plus précise
ALTER TABLE UTILISATEURS ADD constraint PK_UTILISATEURS_NO_UTILISATEURS PRIMARY KEY (no_utilisateur)
