INSERT INTO CAT_CLIENT (id_company, name, description) VALUES (1, 'FORD', 'FORD');
INSERT INTO CAT_CLIENT (id_company, name, description) VALUES (2, 'LINCOLN', 'LINCOLN');
INSERT INTO CAT_CLIENT (id_company, name, description) VALUES (4, 'FORD CREDIT', 'FORD CREDIT');
INSERT INTO CAT_CLIENT (id_company, name, description) VALUES (5, 'FORD ELITE VENTAS', 'FORD VENTAS');
INSERT INTO CAT_CLIENT (id_company, name, description) VALUES (6, 'FORD SERVICIO', 'FORD SERVICIO');
INSERT INTO CAT_CLIENT (id_company, name, description) VALUES (7, 'FORD ELITE VENTAS / FORD CREDIT', 'FORD ELITE VENTAS / FORD CREDIT');

INSERT INTO cat_profiles ( profile, comments) VALUES ('ADMIN', 'comment-ADMIN');
INSERT INTO cat_profiles ( profile, comments) VALUES ('CARD_HOLDER', 'comment-CARD_HOLDER');
INSERT INTO cat_profiles ( profile, comments) VALUES ('SUPERVISOR', 'comment-SUPERVISOR');

UPDATE cat_profiles SET profile_id = 0 WHERE cat_profiles.profile_id = 1;
UPDATE cat_profiles SET profile_id = 1 WHERE cat_profiles.profile_id = 2;
UPDATE cat_profiles SET profile_id = 2 WHERE cat_profiles.profile_id = 3;

INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (1, 0, 'sivaleAdmin', 'sivale', 'vanesa@acme.com.mx', 'Vanesa', 'Ponce', 'Hinojosa','th-4444');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (1, 0, 'lealtadAdmin', 'sivale', 'supervisor@latbc.com.mx','Víctor', 'Robles', 'Días','sv-1111');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_card_number, tj_account_number, tj_stars) VALUES (4, 1, '000987739', 'pass-d', 'luisl@svlealtad.com.mx' ,'Luis', 'López', 'Pereda', '5273740100060052', '000987739','000987739');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_card_number, tj_account_number, tj_stars) VALUES (6, 1, '000972575', 'pass-d', 'mariog@svlealtad.com.mx', 'Mario', 'Gutiérrez', 'Hernández', '5452900200030677', '000972575','000972575');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_card_number, tj_account_number, tj_stars) VALUES (7, 1, '000967675', 'pass-d', 'ignacioh@svlealtad.com.mx', 'Ignacio', 'Hueso', 'Hernández', '5349261200148580', '000967675','000967675');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (1, 0, 'fordAdmin', 'ford', 'jorge@walmart.com', 'ford', 'ford', 'ford','ford-1111');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (2, 0, 'lincolnAdmin', 'lincoln', 'jorge@walmart.com', 'lincoln', 'lincoln', 'lincoln','lincoln-1111');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (4, 0, 'fordCredit', 'credit', 'jorge@walmart.com', 'credit', 'credit', 'credit','credit-1');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (5, 0, 'fordVentas', 'ventas', 'jorge@walmart.com', 'ventas', 'ventas', 'ventas','ventas-1');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (6, 0, 'fordServicio', 'servicio', 'jorge@walmart.com', 'servicio', 'servicio', 'servicio','servicio-1');
INSERT INTO t_users (fk_company, fk_profile, user_login, password, email, first_name, last_name_1, last_name_2, tj_employer) VALUES (7, 0, 'ventasCredit', 'ventas', 'jorge@walmart.com', 'User Ventas Credit', 'servicio', 'servicio','servicio-1');

INSERT INTO cat_views (colors, logos, messages) VALUES ('default.css', 'Ford', 'Ford Ventas');
INSERT INTO cat_views (colors, logos, messages) VALUES ('default.css', 'FordCredit', 'Ford Credit');
INSERT INTO cat_views (colors, logos, messages) VALUES ('default.css', 'Lincoln', 'Lincoln');

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (NULL, 1,  1,    'Ford', 'description1', 0);                         --1
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (1,    1,  NULL, 'Ford Ventas', 'description2', 1);                  --2
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (1,    1,  NULL, 'Ford Credit', 'description2', 1);                  --3
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (1,    1,  NULL, 'Ford Servicio', 'description2', 1);                --4

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (2,    1,  NULL, 'Go Ventas', 'description3', 2);                    --5
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (5,    1,  NULL, 'Ford Unid Ventas', 'description4', 3);             --6

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (3,    1,  NULL, 'Go Credit', 'description3', 2);                    --7
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (7,    1,  NULL, 'Ford Unid Credit', 'description4', 3);             --8

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (4,    1,  NULL, 'Go further Servicio', 'description3', 2);          --9
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (9,    1,  NULL, 'Ford Unid Servicio', 'description4', 3);           --10

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (NULL,  4,  2,    'Ford Credit', 'description1', 0);                 --11
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (11,    4,  NULL, 'Club 1234-5678', 'description2', 1);              --12
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (12,    4,  NULL, 'Goford 100', 'description3', 2);                  --13
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (13,    4,  NULL, 'Renovación magazine', 'description4', 3);         --14

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (NULL,  5,  2,    'Ford Elite Ventas', 'description1', 0);           --15
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (15,    5,  NULL, 'Club 1234-5678', 'description2', 1);              --16
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (16,    5,  NULL, 'Goford 100', 'description3', 2);                  --17
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (17,    5,  NULL, 'Renovación magazine', 'description4', 3);         --18

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (NULL,  6,  2,    'Ford Servicio', 'description1', 0);               --19
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (19,    6,  NULL, 'Club 1234-5678', 'description2', 1);              --20
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (20,    6,  NULL, 'Goford 100', 'description3', 2);                  --21
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (21,    6,  NULL, 'Renovación magazine', 'description4', 3);         --22

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (NULL,7,2,   'Ford Elite Ventas / Ford Credit', 'description1', 0);  --23
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (23,  7,NULL,'Club 1234-5678', 'description2', 1);                   --24
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (24,  7,NULL,'Goford 100', 'description3', 2);                       --25
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (25,  7,NULL,'Renovación magazine', 'description4', 3);              --26

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (NULL,5,2,   'Lincoln Ventas','description Lincoln Ventas', 0);      --27
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (27,  5,NULL,'Club 1234-5678', 'description2', 1);                   --28
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (28,  5,NULL,'Goford 100', 'description3', 2);                       --29
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (29,  5,NULL,'Renovación magazine', 'description4', 3);              --30

INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (NULL,6,2,   'Lincoln Servicio','description Lincoln Servicio', 0);  --31
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (31,  6,NULL,'Club 1234-5678', 'description2', 1);                   --32
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (32,  6,NULL,'Goford 100', 'description3', 2);                       --33
INSERT INTO cat_classification_campaigns(parent_classification_id, fk_company, fk_view, class_name, description, level_ccc) VALUES (33,  6,NULL,'Renovación magazine', 'description4', 3);              --34
 
INSERT INTO cat_publications_type (name, description) VALUES ('Teaser', 'Description Teaser');
INSERT INTO cat_publications_type (name, description) VALUES ('Cierre', 'Description Cierre');
INSERT INTO cat_publications_type (name, description) VALUES ('Premiación', 'Description Premiación');
INSERT INTO cat_publications_type (name, description) VALUES ('Avance', 'Descripcion de avance');
INSERT INTO cat_publications_type (name, description) VALUES ('Lanzamiento', 'Descripcion de lanzamiento');
INSERT INTO cat_publications_type (name, description) VALUES ('Otro', 'Descripcion de otros');

COMMIT;