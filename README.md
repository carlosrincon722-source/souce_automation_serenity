# 🧪 SauceDemo Automation Framework

## 📋 Descripción general

Este proyecto implementa un **framework de automatización de pruebas** para la página [SauceDemo](https://www.saucedemo.com/), desarrollado con **Serenity BDD**, **Cucumber** y **Java**.  
mi objetivo es validar los principales flujos funcionales del sitio web, incluyendo:

- 🔐 Inicio de sesión (login)
- 🛒 Gestión del carrito de compras
- 🧾 Proceso de checkout
- ⚙️ Validación de filtros de productos
- 🧱 Validaciones de mensajes y errores del sistema

Este proyecto forma parte de un portafolio QA automatizador, demostrando habilidades en la automatización de **UI Web, validaciones backend y uso de **buenas prácticas en Screenplay Pattern**.

---

## 🧰 Tecnologías utilizadas

| Tecnología | Descripción |
|-------------|-------------|
| ☕ **Java 17+** | Lenguaje principal |
| 🧬 **Serenity BDD 4.x** | Framework de reporting y patrón Screenplay |
| 🥒 **Cucumber** | Definición de escenarios Gherkin |
| 🧭 **Selenium WebDriver** | Automatización de interfaz web |
| 🧱 **JUnit** | Ejecutor de pruebas |
| 🐳 **Docker / Jenkins (CI/CD)** | Integración y ejecución continua |
| 💡 **Maven** | Gestión de dependencias y ejecución |
| 🌐 **SauceDemo.com** | Web bajo prueba |

---

## 🧩 Estructura del proyecto
    src
    ├── main
    │   └── java
    │       └── starter
    │           ├── interactions
    │           ├── objects
    │           ├── questions
    │           ├── tasks
    │           ├── ui 
    │           └── utils
    └── test
    ├── java
    │   └── starter
    │       ├── runners
    │       │   └── RunnerTest.java
    │       └── stepdefinitions
    │           ├── cartstepdefinitions
    │           ├── checkoutstepdefinitions
    │           ├── hooks
    │           ├── loginstepdefinitions
    │           └── productsstepdefinitions
    │
    └── resources
    ├── features
    │   ├── cart 
    │   ├── checkout
    │   ├── login
    │   └── products
    ├── junit-platform.properties
    ├── logback-test.xml
    └── serenity.conf



## ⚙️ Instalación y configuración

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/carlosrincon722-source/souce_automation_serenity.git
   cd saucedemo-automation
Verificar Java y Maven

    java -version
    mvn -version

🚀 Ejecución de pruebas

Para ejecutar todas las pruebas automatizadas:

    mvn clean verify
clean: limpia el directorio target/

verify: compila, ejecuta los tests y genera el reporte de Serenity

Visualiza el reporte Serenity:

    target/site/serenity/index.html
 
🧩 Buenas prácticas aplicadas

- Patrón Screenplay para un código modular y reutilizable

- Separación clara de responsabilidades (tasks, questions, interactions)

- Escenarios Gherkin legibles en lenguaje natural

- Reporte visual con evidencia automática




🧑‍💻 Autor

Carlos Rincón
QA Automatizador & Fullstack Developer
# souce_automation_serenity
