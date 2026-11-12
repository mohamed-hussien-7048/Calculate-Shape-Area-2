# 🔷 OOP Learning Project Using Java + Node.js

A simple Shapes Calculator (Circle & Rectangle), built with **Java and Node.js** to demonstrate the four main principles of Object-Oriented Programming (OOP).

## 💡 Project Overview

The application calculates the areas of different geometric shapes. Each technology has a specific responsibility:

* **Java:** Responsible for building the Classes, validating dimensions, and calculating shape areas using OOP principles.

* **Node.js:** Provides the REST API and communicates with the compiled Java application.

* **HTML + CSS + JavaScript:** Provides a simple web interface for users to select shapes, enter dimensions, and view results.

* **Communication:** Node.js sends input to Java through Standard Input (`stdin`) and receives a JSON response through Standard Output (`stdout`) using `child_process.spawn()`.

## 🛠️ Technologies

* **Java 25**
* **Node.js**
* **Express.js**
* **HTML5**
* **CSS3**
* **JavaScript**
* **PowerShell**
* **JDK (javac and java)**

## 🧩 OOP Principles

### 1️⃣ Encapsulation

Implemented in the `Circle` and `Rectangle` Classes:

* Shape dimensions are defined as `private` fields.
* Constructors validate the input values.
* Public getter methods provide controlled access to the dimensions.
* Fields use `final` to prevent changes after object creation.

### 2️⃣ Abstraction

Implemented through the abstract Class `Shape`:

* `Shape` defines the abstract methods `calculateArea()` and `getName()`.
* Child Classes must implement these methods.
* We cannot create an object directly from the abstract `Shape` Class.

### 3️⃣ Inheritance

Implemented through:

* `Circle extends Shape`
* `Rectangle extends Shape`

Both Classes inherit the basic structure and behavior defined in `Shape`.

### 4️⃣ Polymorphism

Implemented using the `Shape` reference:

* Different shape objects can be stored and handled through the same `Shape` type.
* Each object executes its own implementation of `calculateArea()` and `getName()` at runtime.

## 📂 Project Structure

```text
SAQR_1/
│
├── java-engine/
│   ├── src/
│   │   └── com/
│   │       └── saqr/
│   │           └── shapes/
│   │               ├── models/
│   │               │   ├── Shape.java
│   │               │   ├── Circle.java
│   │               │   └── Rectangle.java
│   │               │
│   │               ├── Main.java
│   │               └── ApiMain.java
│   │
│   └── out/
│
├── node-backend/
│   ├── src/
│   │   ├── server.js
│   │   └── javaService.js
│   │
│   ├── package.json
│   └── package-lock.json
│
├── frontend/
│   ├── index.html
│   └── style.css
│
└── README.md
```

## 📐 Application Architecture

```text
           User
             |
             v
       HTML + CSS
             |
             v
        JavaScript
             |
             | HTTP Request (JSON)
             v
      Node.js + Express
             |
             v
       Java Service
             |
             | child_process.spawn()
             |
             | stdin: CIRCLE|5
             v
         Java Engine
             |
             v
           Shape
             |
          +--+--+
          |     |
          v     v
        Circle Rectangle
          |     |
          +--+--+
             |
             v
       calculateArea()
             |
             v
       JSON Response
             |
             | stdout
             v
         Node.js
             |
             v
        HTTP Response
             |
             v
       JavaScript
             |
             v
       Display Result
```

## ⚙️ Requirements

* **Java JDK 25** or a compatible version.
* **Node.js and npm**.
* **PowerShell**.
* A web browser.
* VS Code (recommended).

## 🔨 Java Build

Run these commands from the main project folder.

Compile the Java files:

```powershell
javac -d .\java-engine\out .\java-engine\src\com\saqr\shapes\models\Shape.java .\java-engine\src\com\saqr\shapes\models\Circle.java .\java-engine\src\com\saqr\shapes\models\Rectangle.java .\java-engine\src\com\saqr\shapes\Main.java .\java-engine\src\com\saqr\shapes\ApiMain.java
```

Run the original Java application:

```powershell
java -cp .\java-engine\out com.saqr.shapes.Main
```

Run the API entry point:

```powershell
"CIRCLE|5" | java -cp .\java-engine\out com.saqr.shapes.ApiMain
```

## 🚀 Node.js Setup

Open the backend folder:

```powershell
cd node-backend
```

Install dependencies:

```powershell
npm install
```

Start the development server:

```powershell
node .\src\server.js
```

The server runs at:

`http://localhost:3000`

## 🌐 Frontend

Open the following address in your browser:

`http://localhost:3000`

The interface allows users to:

* Select Circle or Rectangle.
* Enter the required dimensions.
* Calculate the shape area.
* Display the calculation result.

## 🔌 REST API Endpoints

### 1️⃣ Health Check

`GET /api/health`

Success response:

```json
{
    "success": true,
    "message": "Shapes API is running."
}
```

### 2️⃣ Calculate Shape Area

`POST /api/shapes/calculate`

Content-Type:

`application/json`

**Circle Request:**

```json
{
    "type": "circle",
    "radius": 5
}
```

**Rectangle Request:**

```json
{
    "type": "rectangle",
    "width": 4,
    "height": 6
}
```

**Circle Success Response:**

```json
{
    "success": true,
    "shape": "Circle",
    "area": 78.54
}
```

**Rectangle Success Response:**

```json
{
    "success": true,
    "shape": "Rectangle",
    "area": 24.00
}
```

## 🎯 Project Objectives

The main objectives of this project are:

* Understand and apply the four OOP principles using Java.
* Understand the difference between Java and Node.js responsibilities.
* Learn how to build a REST API using Express.js.
* Learn how to execute Java applications from Node.js.
* Understand communication between two different programming languages.
* Learn how to build a simple frontend using HTML, CSS, and JavaScript.

❤️ **Developed by Techno Science**
