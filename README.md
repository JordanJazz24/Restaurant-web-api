# Restaurant Web API

**Autor:** JordanJazz24  
**Repositorio:** `Restaurant-web-api`  
**Lenguajes:** Java (Spring Boot), JavaScript, HTML, CSS

---

## Resumen del Proyecto

Restaurant Web API es una aplicación backend diseñada para la gestión de menús y platillos en un restaurante, ofreciendo una API REST escalable y mantenible que facilita la integración con interfaces web modernas y clientes móviles. El proyecto sigue principios sólidos de arquitectura en capas y buenas prácticas de ingeniería de software.

---

## Arquitectura

La arquitectura del proyecto está organizada en capas, siguiendo el patrón clásico de aplicaciones empresariales:

- **Capa de Datos (`data/`):**  
  Aquí viven los repositorios que gestionan el acceso y manipulación de las entidades centrales: `Platillo` y `Categoria`.  
  Los datos se almacenan en listas en memoria para fines de demostración, permitiendo búsquedas, listados y filtrado por categoría.

- **Capa de Lógica de Negocio (`logic/`):**  
  Expone los servicios que interactúan con los repositorios, encapsulando las reglas operativas: lectura de categorías, platillos y filtrado por categoría.

- **Capa de Presentación (`presentation/`):**  
  Implementa los controladores REST que exponen los endpoints para interactuar con la API.  
  Los endpoints principales permiten listar, buscar y filtrar platillos y categorías.

- **Frontend Integrable (`resources/static/pages/restaurante/`):**  
  Incluye archivos HTML y JS que muestran cómo consumir la API desde el navegador, permitiendo visualizar el menú, seleccionar categorías y simular órdenes.

- **Bootstrap y configuración:**  
  El punto de entrada está en `restauranteApplication.java`, usando Spring Boot para inicializar la aplicación.

---

## Lógica Implementada

### Entidades
- **Categoria:**  
  Representa una categoría de platillos (ejemplo: Entradas, Carnes, Sopas).  
  Cada categoría tiene un identificador y nombre.

- **Platillo:**  
  Representa un platillo del menú, asociado a una categoría.  
  Incluye id, nombre, descripción y precio.

### Repositorios
- **CategoriaRepository:**  
  Gestiona la lista de categorías, permitiendo buscar por id y listar todas.

- **PlatilloRepository:**  
  Gestiona la lista de platillos, permitiendo buscar por id, listar todos, y filtrar por categoría.  
  Los datos se precargan (mock) en el constructor del repositorio.

### Servicios
- **Service:**  
  Orquesta el acceso a las entidades, exponiendo métodos para obtener categorías y platillos, y filtrarlos por categoría.

### Controladores REST
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


### Frontend (Ejemplo de Integración)
En `controller.js` se muestra cómo consumir la API, renderizar categorías, platillos y simular órdenes.  
El HTML en `view.html` permite seleccionar categorías, ver sus platillos y construir una orden de compra, integrando la API con una interfaz interactiva.

---

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── org/example/restaurante/
│   │       ├── data/           # Repositorios de datos (Platillo, Categoria)
│   │       ├── logic/          # Lógica de negocio (Service, Platillo, Categoria)
│   │       ├── presentation/   # Controladores REST
│   │       ├── restauranteApplication.java  # Entry point
│   │       └── ServletInitializer.java      # Configuración WAR
│   └── resources/
│       └── static/             # Archivos frontend (HTML, JS, CSS)
│           └── pages/restaurante/
│               ├── controller.js
│               └── view.html
└── test/
    └── java/org/example/restaurante/restauranteApplicationTests.java
```

---

## Tecnologías

- **Backend:** Java, Spring Boot (inyección de dependencias, controladores REST, servicios)
- **Frontend:** JavaScript, HTML, CSS (ejemplo de integración)
- **Pruebas:** JUnit, Spring Boot Test (test de carga de contexto)

---

## Instalación y Ejecución

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
   Accede a la API en `http://localhost:8080/` y a la interfaz web en `/pages/restaurante/view.html`.

---

## Extensibilidad

El diseño modular permite agregar nuevas entidades, endpoints y funcionalidades fácilmente. Se recomienda seguir el patrón de capas y buenas prácticas de Spring Boot para mantener la mantenibilidad y escalabilidad.

---

## Buenas Prácticas y Patrones Usados

- Separación de responsabilidades (datos, lógica, presentación)
- Inyección de dependencias
- Control de errores básico
- Pruebas automáticas y facilidad para extenderlas
- Código claro, nombrado y documentado

---

## Licencia

MIT

---

## Contacto

Para soporte o sugerencias: [JordanJazz24](https://github.com/JordanJazz24)
