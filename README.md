# 📚 Library API – Spring Boot POC

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot">
  <img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven">
  <img src="https://img.shields.io/badge/API-REST-orange?style=for-the-badge">
  <img src="https://img.shields.io/badge/Swagger-OpenAPI-green?style=for-the-badge&logo=swagger">
</p>

---

## 🚀 Overview

**Library API** est un **Proof of Concept (POC)** développé avec **Spring Boot** permettant de gérer une bibliothèque de livres et d’auteurs.

🎯 Objectifs :

* Démontrer une architecture backend propre
* Implémenter une API REST robuste
* Appliquer les bonnes pratiques Spring

---

## 🧱 Tech Stack

| Technologie       | Description              |
| ----------------- | ------------------------ |
| Java 17+          | Langage principal        |
| Spring Boot       | Framework backend        |
| Spring Web        | API REST                 |
| Spring Data JPA   | Accès base de données    |
| Lombok            | Réduction du boilerplate |
| Swagger / OpenAPI | Documentation API        |
| Maven             | Build tool               |

---

## 🏗️ Architecture

```text
📦 fr.aba.poc.library
 ┣ 📂 controller   → REST endpoints
 ┣ 📂 service      → Business logic
 ┣ 📂 repository   → Data access
 ┣ 📂 dto          → Data Transfer Objects
 ┗ 📂 entity       → JPA entities
```

---

## ✨ Features

### 🔎 Rechercher un livre

```http
GET /api/library/searchOneBook
```

**Paramètres :**

* `isbn` *(optionnel)*
* `titre` *(optionnel)*
* `datePublication` *(optionnel)*

📌 Exemple :

```bash
curl "http://localhost:8080/api/library/searchOneBook?titre=Le Petit Prince"
```

---

### 📚 Récupérer tous les livres

Retourne la liste complète des livres.

---

### ➕ Ajouter un livre + auteur

Permet d’ajouter un livre avec son auteur :

* Titre
* ISBN
* Date de publication
* Nom / Prénom
* Sexe

---

### 🔍 Recherche avancée avec pagination

```http
POST /api/library/rechercherBooks?page=0&size=10
```

✔️ Recherche dynamique
✔️ Pagination intégrée

---

### 👤 Recherche d’auteurs

Recherche d’auteurs à partir de critères sur les livres.

---

## 📖 API Documentation

Swagger disponible après démarrage :

👉 http://localhost:8080/swagger-ui.html

---

## ▶️ Getting Started

### ✅ Prérequis

* Java 17+
* Maven 3+

### ⚙️ Installation

```bash
git clone https://github.com/abenabbes/aba-springboot-v2.git
cd aba-springboot-v2
```

### ▶️ Lancement

```bash
mvn spring-boot:run
```

---

## 🧪 Bonnes pratiques appliquées

✔️ Architecture en couches
✔️ Utilisation de DTO
✔️ Injection par constructeur (`@RequiredArgsConstructor`)
✔️ Logging avec SLF4J
✔️ Pagination Spring Data
✔️ Documentation Swagger

---

## 📈 Axes d’amélioration

🔐 Sécurité (Spring Security / JWT)
✅ Validation (`@Valid`, `@NotNull`)
🧪 Tests unitaires & intégration
🐳 Dockerisation
⚙️ CI/CD (GitHub Actions)
📊 Monitoring (Actuator, Prometheus)

---

## 🖼️ Preview (optionnel)

> Tu peux ajouter ici :
>
> * screenshots Swagger
> * diagramme d’architecture
> * schéma base de données

---

## 👨‍💻 Author

**ABA**
Développeur Backend Java / Spring Boot

---

## ⭐ Pourquoi ce projet ?

Ce POC illustre :

* Une bonne maîtrise de Spring Boot
* Une conception API REST propre
* Une approche professionnelle du développement backend

---

## 📄 Licence

Projet à usage pédagogique.

---

<p align="center">
  ⭐ N’hésite pas à star le repo si tu trouves le projet utile !
</p>
