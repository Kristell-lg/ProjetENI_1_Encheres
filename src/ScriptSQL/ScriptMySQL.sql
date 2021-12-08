CREATE TABLE CATEGORIES (
    no_categorie   INTEGER  NOT NULL AUTO_INCREMENT,
    libelle        VARCHAR(30) NOT NULL,
    PRIMARY KEY PK_categorie (no_categorie)
);

CREATE TABLE ENCHERES (
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
    date_enchere     datetime NOT NULL,
	montant_enchere  INTEGER NOT NULL,
	PRIMARY KEY PK_enchere (no_utilisateur, no_article)
);

CREATE TABLE RETRAITS (
	no_article         INTEGER NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    PRIMARY KEY PK_retrait (no_article)
);

CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER NOT NULL AUTO_INCREMENT,
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(20) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL,
    PRIMARY KEY PK_utilisateur  (no_utilisateur)
);

CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER NOT NULL AUTO_INCREMENT, 
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL, 
    PRIMARY KEY ARTICLES_VENDUS (no_article)
);

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT FK_encheres_utilisateur FOREIGN KEY( no_utilisateur ) REFERENCES UTILISATEURS( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action ;

ALTER TABLE ENCHERES
    ADD CONSTRAINT FK_encheres_articles_vendus FOREIGN KEY( no_article )
        REFERENCES ARTICLES_VENDUS( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action ;

ALTER TABLE RETRAITS
    ADD CONSTRAINT FK_retraits_articles_vendus FOREIGN KEY( no_article )
        REFERENCES ARTICLES_VENDUS( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action ;

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT FK_articles_vendus_categories FOREIGN KEY( no_categorie )
        REFERENCES categories( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action ;

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT FK_ventes_utilisateur FOREIGN KEY( no_utilisateur )
        REFERENCES utilisateurs( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action ;


