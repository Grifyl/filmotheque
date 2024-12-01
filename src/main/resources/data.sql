-- Données pour les réalisateurs
INSERT INTO realisateur (id, prenom, nom, date_naissance) VALUES
                                                              (1, 'Steven', 'Spielberg', '1946-12-18'),
                                                              (2, 'Christopher', 'Nolan', '1970-07-30'),
                                                              (3, 'Quentin', 'Tarantino', '1963-03-27'),
                                                              (4, 'James', 'Cameron', '1954-08-16'),
                                                              (5, 'Martin', 'Scorsese', '1942-11-17');

-- Données pour les catégories
INSERT INTO categorie (id, libelle) VALUES
                                        (1, 'Action'),
                                        (2, 'Aventure'),
                                        (3, 'Comédie'),
                                        (4, 'Drame'),
                                        (5, 'Science-Fiction'),
                                        (6, 'Horreur');

-- Données pour les films
INSERT INTO film (id, titre, date_sortie, description, id_realisateur) VALUES
                                                                           (1, 'Jurassic Park', '1993-06-11', 'Un parc rempli de dinosaures.', 1),
                                                                           (2, 'Inception', '2010-07-16', 'Rêves dans les rêves.', 2),
                                                                           (3, 'Pulp Fiction', '1994-10-14', 'Des histoires entrecroisées.', 3),
                                                                           (4, 'Avatar', '2009-12-18', 'Un monde extraterrestre.', 4),
                                                                           (5, 'Shutter Island', '2010-02-19', 'Un thriller psychologique.', 5),
                                                                           (6, 'The Dark Knight', '2008-07-18', 'Le chevalier noir contre le Joker.', 2),
                                                                           (7, 'Kill Bill: Volume 1', '2003-10-10', 'Une mariée en quête de vengeance.', 3),
                                                                           (8, 'Titanic', '1997-12-19', 'Une romance tragique.', 4);

-- Liaisons film-catégorie
INSERT INTO film_categorie (id_film, id_categorie) VALUES
                                                       (1, 2), (1, 5),
                                                       (2, 1), (2, 5),
                                                       (3, 4), (3, 3),
                                                       (4, 2), (4, 5),
                                                       (5, 4),
                                                       (6, 1),
                                                       (7, 1), (7, 3),
                                                       (8, 4), (8, 2);

-- Données pour les rôles
INSERT INTO role (id, libelle) VALUES
                                   (1, 'Admin'),
                                   (2, 'User'),
                                   (3, 'Editor');

-- Données pour les utilisateurs
INSERT INTO utilisateur (id, prenom, nom, email, mot_de_passe, id_role) VALUES
                                                                            (1, 'John', 'Doe', 'john.doe@gema.com', '123', 1),
                                                                            (2, 'Jane', 'Smith', 'jane.smith@gema.com', '123', 2),
                                                                            (3, 'Alice', 'Brown', 'alice.brown@gema.com', '123', 2),
                                                                            (4, 'Bob', 'Johnson', 'bob.johnson@gema.com', '123', 1),
                                                                            (5, 'Emily', 'Davis', 'emily.davis@gema.com', '123', 3);

