# 📈 XTrade – Système de Trading Simplifié

## 📝 Description du projet

**XTrade** est une application Java de simulation de trading développée dans un cadre pédagogique.
Elle permet à des utilisateurs (traders) de gérer un portefeuille virtuel et d’effectuer des opérations d’achat et de vente d’actifs financiers dans un environnement contrôlé.

L’objectif principal est de reproduire les mécanismes essentiels d’une plateforme de trading tout en restant simple et adapté à la formation.

---

## 🎯 Objectifs pédagogiques

Ce projet permet de mettre en pratique :

* La **programmation orientée objet (POO)**
* L’**héritage** et le **polymorphisme**
* Les **classes abstraites**
* Les **génériques**
* La gestion des **collections**
* La validation des données
* La manipulation de fichiers (export CSV / Excel)

---

## 🏗️ Architecture du projet

Le diagramme de classes inclut les éléments suivants :

* `Person`
* `Trader` (hérite de `Person`)
* `Asset` (classe abstraite)
* `Stock` (hérite de `Asset`)
* `CryptoCurrency` (hérite de `Asset`)
* `Portfolio<T>`
* `Transaction`
* `TradingPlatform` / `Market`
* `Main`

---

## 🧩 Modèle métier

### 👤 Person

Représente une personne de manière générale.

### 📊 Trader

Hérite de `Person`.
Représente un utilisateur disposant :

* d’un identifiant
* d’un nom
* d’un solde virtuel
* d’un portefeuille

### 💼 Asset (classe abstraite)

Représente un actif financier générique :

* Code unique
* Nom
* Prix unitaire

#### 📈 Stock

Représente une action.

#### ₿ CryptoCurrency

Représente une crypto-monnaie.

### 📂 Portfolio<T>

Classe générique permettant de stocker :

* Les actifs détenus
* Les quantités associées
* La valeur totale

### 🔁 Transaction

Représente une opération :

* Type (ACHAT / VENTE)
* Actif
* Quantité
* Prix
* Date

### 🏦 TradingPlatform / Market

Classe centrale qui :

* Gère les traders
* Gère les actifs
* Centralise les opérations
* Enregistre l’historique

### ▶ Main

Interface console permettant d’interagir avec le système via un menu.

---

## ⚙️ Fonctionnalités principales

### 📌 Gestion des actifs

* Ajouter un actif
* Afficher la liste des actifs disponibles
* Vérifier l’unicité du code

### 👥 Gestion des traders

* Ajouter un trader
* Créer un portefeuille

### 💼 Gestion du portefeuille

* Consulter les actifs détenus
* Afficher les quantités
* Calculer la valeur totale

### 💰 Achat d’actifs

Validation :

* Solde suffisant
* Quantité strictement positive

### 💸 Vente d’actifs

Validation :

* Actif présent dans le portefeuille
* Quantité suffisante

### 🧾 Historique des transactions

* Enregistrement automatique
* Affichage détaillé

### 🛡️ Validation des données

* Interdiction des montants négatifs ou nuls
* Interdiction de vendre un actif non détenu
* Contrôle d’unicité des codes actifs

---

## ⭐ Fonctionnalités Bonus

* 📊 Calcul des gains et pertes
* 📈 Calcul de la performance globale
* 📁 Export des transactions
* 📤 Export de l’historique en **CSV / Excel**

---

## 🚀 Lancement du projet

### Prérequis

* Java 17 ou supérieur
* IDE recommandé : IntelliJ / Eclipse / VS Code

### Compilation

```bash
javac Main.java
```

### Exécution

```bash
java Main
```

---

## 🧪 Exemple de scénario

1. Création d’un trader avec un capital initial.
2. Ajout d’actifs (actions et crypto-monnaies).
3. Achat d’actifs.
4. Consultation du portefeuille.
5. Vente partielle ou totale.
6. Consultation de l’historique.
7. Export des transactions.

---

## 📁 Structure du projet (exemple)

```
src/
│
├── model/
│   ├── Person.java
│   ├── Trader.java
│   ├── Asset.java
│   ├── Stock.java
│   ├── CryptoCurrency.java
│   ├── Portfolio.java
│   └── Transaction.java
│
├── service/
│   └── TradingPlatform.java
│
└── Main.java
```

---

## 🛠️ Améliorations futures possibles

* Interface graphique (JavaFX / Swing)
* Simulation de variation des prix en temps réel
* Sauvegarde en base de données
* Authentification des utilisateurs
* API REST

---

## 📌 Statut du projet

Projet académique – Système fonctionnel destiné à l’apprentissage et à la simulation.

---

## 👨‍💻 Auteur

Projet réalisé dans le cadre d’un apprentissage en développement Java.

---

Si tu veux, je peux aussi te générer :

* ✅ une version plus courte
* ✅ une version plus professionnelle pour portfolio
* ✅ une version avec badges GitHub
* ✅ une version en anglais
* ✅ un README encore plus structuré façon projet open-source sérieux
