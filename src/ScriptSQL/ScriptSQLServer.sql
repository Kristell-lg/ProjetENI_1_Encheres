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


--Articles 
CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL
)

ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)


	ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_utilisateur_fk FOREIGN KEY ( no_utilisateur )
        REFERENCES utilisateurs ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 


	CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)

--Categories
ALTER TABLE CATEGORIES ADD constraint categorie_pk PRIMARY KEY (no_categorie)

INSERT INTO CATEGORIES(libelle) VALUES ('Vêtement')
INSERT INTO CATEGORIES(libelle) VALUES ('Multimédia et Jeux_vidéos')
INSERT INTO CATEGORIES(libelle) VALUES ('Ameublement')
INSERT INTO CATEGORIES(libelle) VALUES ('Maison')
INSERT INTO CATEGORIES(libelle) VALUES ('Bricolage')
INSERT INTO CATEGORIES(libelle) VALUES ('Loisir créatif')
INSERT INTO CATEGORIES(libelle) VALUES ('Sport')
INSERT INTO CATEGORIES(libelle) VALUES ('Livres')
INSERT INTO CATEGORIES(libelle) VALUES ('Divers')