# Java Object-Oriented Programming & Defensive Architecture

Welcome to my Java OOP development registry. This repository tracks my progression from writing standard "happy path" scripts to engineering robust, decoupled, and production-grade software engines. 

Each project focuses on specific design patterns, encapsulation strategies, and defensive architectures.

---

## 🚀 Featured Project: Guild Management Terminal (`GuildRegistry.java`)

A highly resilient, interactive command-line application built using multi-layered validation and advanced exception management workflows. 

### 🛡️ Core Engineering Upgrades Implemented:

* **Type-Safety Crash-Proofing (Exception Handling):** Implemented a defensive perimeter using `try-catch` blocks to capture input anomalies (like `InputMismatchException`). If a user accidentally enters alphabetical characters into numerical prompts, the application safely clears the keyboard buffer cache, logs a clean warning layout, and prevents sudden script death or thread crashes.
* **Single-Responsibility Architecture (Method Decomposition):** Refactored a monolithic `main` execution sequence into isolated, modular, and reusable worker actions (`viewHunters`, `recruitDroid`, `purgeLowRatings`). Each function has a singular operational scope, making the codebase scannable and testable.
* **Defense-in-Depth Input Validation:** Designed a two-phase data sanitization wall. The front-end interaction tier isolates numerical entries inside rigorous range-checking loops before the engine ever accepts them, while the backend object mutators protect underlying data model structures from baseline corruption.

---

## 📂 Other Modules in This Suite

This practice hub also includes modules mapping out deeper object relationships:
* **`GalaxyEmpire.java` & `Spacecraft.java`:** Exploring complex control layers, inheritance mapping, and object collections.
* **`CyberAbility.java` & `Artifact.java`:** Structural abstractions focusing on polymorphic behaviors and object blueprints.
* **`SmartDevice.java`:** Granular class design mapping component communication constraints.

---

## 💻 Environment & Setup

* **Language Level:** Java 17+ / OpenJDK 26
* **IDE Utilization:** IntelliJ IDEA
* **Execution Pathway:** Clone the suite, index the `src` directory inside your Java environment, and execute the desired target file.
