# Mutant Detector API --- Examen Técnico MercadoLibre

Proyecto REST para detectar mutantes analizando secuencias de ADN.
Magneto quiere reclutar la mayor cantidad de mutantes: la API recibe un
array de `String` que representa una matriz cuadrada (NxN) donde cada
letra es A, T, C o G. Se considera mutante si se encuentran más de una
secuencia de cuatro letras iguales en horizontal, vertical u oblicuo.

## Descripción

Esta aplicación está desarrollada en Java (Spring Boot) con arquitectura
por capas. El servicio expone endpoints para verificar si una secuencia
pertenece a un mutante y para consultar estadísticas de uso. Se usa H2
en memoria para almacenar las verificaciones y evitar duplicados
mediante un índice sobre `dna_hash`.

## Tecnologías

Lenguaje Java 17/21 y Spring Boot 3.2.0. H2 Database en memoria. Testing
con JUnit 5, Mockito y MockMvc. JaCoCo para reportes. Docker para
contenedorización. Documentación con OpenAPI/Swagger.

## Requisitos previos

JDK 17 o superior. Wrapper de Gradle incluido. Docker opcional.

## Ejecución local

En PowerShell: `.\gradlew.bat bootRun`\
En Linux/Mac: `./gradlew bootRun`\
API disponible en `http://localhost:8080`.

## Ejecución con Docker

`docker build -t mutant-api .`\
`docker run -p 8080:8080 mutant-api`

## Endpoints principales

### POST /mutant

Ejemplo:

    {
      "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
      ]
    }

Respuestas:\
200 Mutante · 403 Humano · 400 Datos inválidos.

### GET /stats

    {
      "count_mutant_dna": 40,
      "count_human_dna": 100,
      "ratio": 0.4
    }

## Validaciones

Matriz NxN, caracteres válidos A/T/C/G, manejo de null y vacíos. Hash
indexado para evitar duplicados y mejorar rendimiento.

## Algoritmo y optimización

Terminación temprana: cuando se detectan 2 secuencias válidas se retorna
inmediatamente.

## Testing y cobertura

Ejecutar tests: `./gradlew test`\
Reporte JaCoCo: `./gradlew test jacocoTestReport`\
Ubicación: `build/reports/jacoco/test/html/index.html`.

## Swagger

`http://localhost:8080/swagger-ui.html`

## ☁️ Despliegue

La API está desplegada en Render y accesible públicamente:

-   **Base URL:** `https://mutantes-mercadolibre.onrender.com`
-   **Swagger Live:**
    https://mutantes-mercadolibre.onrender.com/swagger-ui.html
