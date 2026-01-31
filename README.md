# 💎 Crypto Tracker en Tiempo Real

Una aplicación Full Stack que monitoriza el precio de Bitcoin en tiempo real consumiendo la API pública de **CoinGecko**. Utiliza tareas programadas para guardar el historial automáticamente y muestra un dashboard financiero con gráficos en vivo.

## 🚀 Tecnologías

* **Backend:** Java 17, Spring Boot 3
* **Integración:** RestTemplate (Cliente HTTP)
* **Automatización:** Spring Scheduling (`@Scheduled`)
* **Base de Datos:** PostgreSQL (Dockerizado)
* **Frontend:** HTML5 + Chart.js (Visualización de datos)
* **DevOps:** Docker & Docker Compose

## ⚙️ Características

1.  **Piloto Automático:** El sistema consulta el precio de Bitcoin cada 10 segundos automáticamente, sin intervención del usuario.
2.  **Persistencia:** Todos los precios se guardan en base de datos con su marca de tiempo exacta.
3.  **Resiliencia:** Manejo de errores si la API externa falla o cambia el formato de datos (Integer/Double).
4.  **Dashboard:** Gráfico interactivo que se actualiza en vivo consultando la API propia.

## 🛠️ Instalación y Uso

### Requisitos
* Docker Desktop instalado.

### Ejecución

1.  **Clonar repositorio:**
    ```bash
    git clone [https://github.com/DNaviaR/crypto-tracker](https://github.com/DNaviaR/crypto-tracker)
    cd crypto-tracker
    ```

2.  **Construir el proyecto:**
    ```bash
    ./mvnw clean package -DskipTests
    ```

3.  **Levantar servicios:**
    ```bash
    docker-compose up --build
    ```
    * El sistema empezará a guardar precios inmediatamente en la consola.

4.  **Ver el Dashboard:**
    * Abre el archivo `index.html` en tu navegador.
    * O ve a `http://localhost:8080/historial` para ver el JSON crudo.

---

## 🔌 Arquitectura

1.  **Scheduler:** Ejecuta `getBitcoinPrice()` cada 10s.
2.  **Service:** Llama a `api.coingecko.com` -> Parsea JSON -> Guarda en Postgres.
3.  **Controller:** Expone `/historial` vía REST.
4.  **Frontend:** `fetch('/historial')` -> Renderiza con Chart.js.
