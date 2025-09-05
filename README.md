# Ticketing Management System
Backend RESTful pour le système de gestion de tickets SaaS, développé avec Spring Boot et PostgreSQL.
## Technologies
- Java 17, Spring Boot
- Angular 17
- PostgreSQL
- JWT pour authentification
- Maven pour gestion des dépendances
- Bootstrap 5 pour le frontend
## Fonctionnalités
- CRUD des tickets et des utilisateurs
- Gestion des rôles : Admin, Manager, Client, Resource
- Matching automatique des ressources avec les tickets
- Authentification sécurisée avec JWT
## Lien Frontend
Le frontend Angular est disponible ici : https://github.com/aymen-ibh/PFE-gestionTicket-frontend
## Installation
1. Cloner le repo : git clone https://github.com/aymen-ibh/PFE-gestionTicket-backend.git
2. Installer les dépendances : mvn install
3. Configurer PostgreSQL et mettre à jour application.properties
4. Lancer le serveur : mvn spring-boot:run
## Licence
Ce projet est open source et disponible pour usage éducatif.
