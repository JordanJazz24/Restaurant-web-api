# Restaurant Web API

**Autor:** [JordanJazz24](https://github.com/JordanJazz24)  
**Repositorio:** [Restaurant-web-api](https://github.com/JordanJazz24/Restaurant-web-api)  
**Lenguaje Principal:** Java (Spring Boot)  
**Estado:** En desarrollo

---

## Descripción

Restaurant Web API es una aplicación backend desarrollada en Java con Spring Boot que provee una API REST robusta para la gestión de menús y platillos en un restaurante. Está diseñada bajo principios de escalabilidad y mantenibilidad, y facilita la integración con interfaces web modernas y clientes móviles.

La arquitectura modular permite gestionar categorías de platillos, realizar búsquedas, y obtener información detallada de manera eficiente.

---

## Características principales

- **API RESTful:**  
  Gestiona categorías y platillos mediante endpoints claros y bien estructurados.
- **Inyección de dependencias (Spring):**  
  Facilita la escalabilidad y la prueba de los componentes.
- **Separación de capas:**  
  Distinción clara entre repositorios, lógica de negocio y controladores.
- **Documentación clara y código mantenible:**  
  Uso de JavaDoc, buenas prácticas y convenciones.
- **Pruebas automáticas:**  
  Prueba de carga de contexto y facilidad para extender tests (JUnit, Spring Boot Test).
- **Frontend integrable:**  
  Incluye ejemplos de integración con frontend en JavaScript.

---

## Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── org/example/restaurante/
│   │       ├── data/           # Repositorios de datos (Platillo, Categoria)
│   │       ├── logic/          # Lógica de negocio (Service, Platillo, Categoria)
│   │       ├── presentation/   # Controladores REST (PlatilloController)
│   │       ├── restauranteApplication.java  # Entry point (Spring Boot)
│   │       └── ServletInitializer.java      # Configuración para despliegue WAR
│   └── resources/
│       └── static/             # Archivos estáticos frontend (HTML, JS)
│           └── pages/restaurante/
│               ├── controller.js
│               └── view.html
└── test/
    └── java/org/example/restaurante/restauranteApplicationTests.java
```

---

## Endpoints principales

### Platillos

| Método | Endpoint                  | Descripción                                       |
|--------|---------------------------|---------------------------------------------------|
| GET    | `/api/platillos/listar`   | Lista platillos por categoría (`categoriaId`)     |
| GET    | `/api/platillos/buscar`   | Busca un platillo por su `id`                     |

> Puedes agregar, actualizar y eliminar platillos fácilmente extendiendo el controlador.

### Categorías

| Método | Endpoint                  | Descripción                                   |
|--------|---------------------------|-----------------------------------------------|
| GET    | `/api/categorias/listar`  | Lista todas las categorías disponibles        |
| GET    | `/api/categorias/buscar`  | Busca una categoría por su `id`               |

---

## Ejemplo de integración frontend

Se incluye un archivo `controller.js` que muestra cómo consumir la API desde JavaScript para mostrar categorías y platillos, facilitando la construcción de interfaces de usuario atractivas y dinámicas.

```javascript
// Obtener categorías
async function fetchCategories() {
    const response = await fetch('http://localhost:8080/api/categorias/listar');
    const categories = await response.json();
    // Renderiza las categorías en la UI
}
```

---

## Instalación y ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/JordanJazz24/Restaurant-web-api.git
   cd Restaurant-web-api
   ```

2. **Construye el proyecto:**
   ```bash
   ./mvnw clean install
   ```

3. **Ejecuta la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```
   La API estará disponible en `http://localhost:8080/`.

---

## Pruebas

Incluye pruebas básicas de carga de contexto (`restauranteApplicationTests.java`), fácilmente extendible para pruebas unitarias y de integración.

---

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o pull request con propuestas de mejora o nuevas funcionalidades.

---

## Licencia

Este proyecto está bajo licencia MIT (puedes adaptar según tus necesidades).

---

## Contacto

Para dudas, sugerencias o soporte, contacta a [JordanJazz24](https://github.com/JordanJazz24).

---

**Este proyecto demuestra buenas prácticas de ingeniería de software, organización por capas, uso de Spring Boot y una arquitectura lista para producción y escalabilidad.**
