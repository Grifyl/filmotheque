CREATE TABLE realisateur (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             prenom VARCHAR(255),
                             nom VARCHAR(255),
                             date_naissance DATE
);

CREATE TABLE categorie (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           libelle VARCHAR(255)
);

CREATE TABLE film (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      titre VARCHAR(255),
                      date_sortie DATE,
                      description VARCHAR(255),
                      id_realisateur BIGINT,
                      FOREIGN KEY (id_realisateur) REFERENCES realisateur(id)
);

CREATE TABLE film_categorie (
                                id_film BIGINT NOT NULL,
                                id_categorie BIGINT NOT NULL,
                                PRIMARY KEY (id_film, id_categorie),
                                FOREIGN KEY (id_film) REFERENCES film(id),
                                FOREIGN KEY (id_categorie) REFERENCES categorie(id)
);

CREATE TABLE role (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      libelle VARCHAR(255) NOT NULL
);

CREATE TABLE utilisateur (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             prenom VARCHAR(255),
                             nom VARCHAR(255),
                             email VARCHAR(255) UNIQUE,
                             mot_de_passe VARCHAR(255),
                             id_role BIGINT,
                             FOREIGN KEY (id_role) REFERENCES role(id)
);
