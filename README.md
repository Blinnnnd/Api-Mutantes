# 🧬 Detector de mutantes| Technical Challenge

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.0-green?style=for-the-badge&logo=spring-boot)
![Coverage](https://img.shields.io/badge/Coverage-90%25-success?style=for-the-badge)
![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)
![Deploy](https://img.shields.io/badge/Deploy-Render-blue?style=for-the-badge&logo=render)

## 📋 Resumen Ejecutivo

Este proyecto implementa una API REST de alto rendimiento diseñada para detectar anomalías genéticas (mutantes) basadas en secuencias de ADN. El sistema ha sido construido siguiendo los principios de **Arquitectura Hexagonal**, garantizando escalabilidad, mantenibilidad y un desacoplamiento efectivo entre la lógica de negocio y la infraestructura.

La solución prioriza la eficiencia algorítmica y la integridad de los datos, implementando mecanismos de hashing para evitar el reprocesamiento de secuencias y optimizaciones de *early termination* en el algoritmo de búsqueda.

---

## 🔗 Enlaces del Proyecto

| Recurso | URL de Acceso |
|---------|---------------|
| **💻 Repositorio GitHub** | [github.com/Blinnnnd/Api-Mutantes](https://github.com/Blinnnnd/Api-Mutantes) |
| **☁️ API en Producción** | [api-mutantes-global.onrender.com](https://api-mutantes-global.onrender.com) |
| **📄 Documentación (Swagger)** | [Swagger UI Live](https://api-mutantes-global.onrender.com/swagger-ui.html) |

---

## 🏗️ Arquitectura y Tecnologías

El sistema está construido sobre un stack moderno y robusto:

* **Core:** Java 17 & Spring Boot 3.2.0.
* **Persistencia:** H2 Database (In-Memory) optimizada para alta velocidad.
* **Deduplicación:** Indexación mediante Hash **SHA-256** para búsquedas O(1).
* **Contenedorización:** Docker & Docker Compose.
* **Calidad:** JUnit 5, Mockito & JaCoCo (>80% cobertura).

### Optimización Algorítmica
El núcleo del detector utiliza un algoritmo de búsqueda matricial optimizado:
1.  **Complejidad:** O(N²) en el peor caso, tendiendo a **O(N)** en casos promedio gracias a la terminación temprana.
2.  **Eficiencia:** Uso de arrays nativos (`char[][]`) para minimizar el overhead de memoria frente a objetos `String`.

---

## 🚀 Guía de Despliegue y Ejecución

### 1. Requisitos Previos
* Java JDK 17+
* Docker (Opcional)

### 2. Ejecución Local
Utilizando el wrapper de Gradle incluido para garantizar la compatibilidad:

```bash
# Clonar el proyecto
git clone [https://github.com/Blinnnnd/Api-Mutantes.git](https://github.com/Blinnnnd/Api-Mutantes.git)

# Ejecutar tests y verificar cobertura
./gradlew test jacocoTestReport

# Iniciar la aplicación
./gradlew bootRun
La API estará disponible en http://localhost:8080

3. Ejecución con Docker
El proyecto incluye un Dockerfile multi-stage para optimizar el tamaño de la imagen final.

Bash

docker build -t mutant-api .
docker run -p 8080:8080 mutant-api
📡 Endpoints de la API
La API cumple estrictamente con los contratos definidos:

POST /mutant
Analiza una secuencia de ADN para determinar si corresponde a un mutante.

Input: Matriz NxN de Strings (A, T, C, G).

Output:

200 OK: Mutante detectado.

403 Forbidden: Humano detectado.

400 Bad Request: Formato inválido.

JSON

{
  "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
GET /stats
Provee estadísticas de uso del sistema en tiempo real.

JSON

{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
🧪 Calidad y Cobertura
El proyecto mantiene un estándar alto de calidad de código:

Unit Tests: Validación exhaustiva de la lógica de negocio (MutantDetector, MutantService).

Integration Tests: Verificación de los controladores y el flujo HTTP completo.

Examen Técnico Backend - MercadoLibre Desarrollado por Luna Marcelo Joaquin