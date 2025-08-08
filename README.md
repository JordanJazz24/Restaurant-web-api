# Java-restaurant-api


**Author:** JordanJazz24  
**Repository:** `Restaurant-web-api`  
**Languages:** Java (Spring Boot), JavaScript, HTML, CSS

---

## Project Summary

Java-restaurant-api I is a backend application designed for managing menus and dishes in a restaurant, offering a scalable and maintainable REST API that facilitates integration with other systems.

---

## Architecture

The project architecture is organized in layers, following the classic enterprise application pattern:

- **Data Layer (`data/`):**  
  Here are the repositories that manage access and manipulation of the central entities: `Platillo` (Dish) and `Categoria` (Category).  
  Data is stored in in-memory lists for demonstration purposes, allowing searches, listings, and filtering by category.

- **Business Logic Layer (`logic/`):**  
  Exposes the services that interact with the repositories, encapsulating operational rules: reading categories, dishes, and filtering by category.

- **Presentation Layer (`presentation/`):**  
  Implements the REST controllers that expose the endpoints to interact with the API.  
  The main endpoints allow listing, searching, and filtering dishes and categories.

- **Integrable Frontend (`resources/static/pages/restaurante/`):**  
  Includes HTML and JS files that show how to consume the API from the browser, allowing you to view the menu, select categories, and simulate orders.

- **Bootstrap and Configuration:**  
  The entry point is in `restauranteApplication.java`, using Spring Boot to initialize the application.

---

## Implemented Logic

### Entities
- **Category:**  
  Represents a dish category (example: Starters, Meats, Soups).  
  Each category has an identifier and name.

- **Dish:**  
  Represents a menu dish, associated with a category.  
  Includes id, name, description, and price.

### Repositories
- **CategoriaRepository:**  
  Manages the list of categories, allowing searching by id and listing all.

- **PlatilloRepository:**  
  Manages the list of dishes, allowing searching by id, listing all, and filtering by category.  
  Data is preloaded (mock) in the repository constructor.

### Services
- **Service:**  
  Orchestrates access to entities, exposing methods to obtain categories and dishes, and filter them by category.

### REST Controllers
## Main Endpoints

### Dishes

| Method | Endpoint                  | Description                                       |
|--------|---------------------------|---------------------------------------------------|
| GET    | `/api/platillos/listar`   | Lists dishes by category (`categoriaId`)          |
| GET    | `/api/platillos/buscar`   | Searches for a dish by its `id`                   |

> You can easily add, update, and delete dishes by extending the controller.

### Categories

| Method | Endpoint                  | Description                                   |
|--------|---------------------------|-----------------------------------------------|
| GET    | `/api/categorias/listar`  | Lists all available categories                |
| GET    | `/api/categorias/buscar`  | Searches for a category by its `id`           |

---

### Frontend (Integration Example)
In `controller.js`, you can see how to consume the API, render categories, dishes, and simulate orders.  
The HTML in `view.html` allows you to select categories, view their dishes, and build a purchase order, integrating the API with an interactive interface.

---

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── org/example/restaurante/
│   │       ├── data/           # Data repositories (Dish, Category)
│   │       ├── logic/          # Business logic (Service, Dish, Category)
│   │       ├── presentation/   # REST Controllers
│   │       ├── restauranteApplication.java  # Entry point
│   │       └── ServletInitializer.java      # WAR configuration
│   └── resources/
│       └── static/             # Frontend files (HTML, JS, CSS)
│           └── pages/restaurante/
│               ├── controller.js
│               └── view.html
└── test/
    └── java/org/example/restaurante/restauranteApplicationTests.java
```

---

## Technologies

- **Backend:** Java, Spring Boot (dependency injection, REST controllers, services)
- **Frontend:** JavaScript, HTML, CSS (integration example)
- **Testing:** JUnit, Spring Boot Test (context load test)

---

## Installation and Execution

1. **Clone the repository:**
   ```bash
   git clone https://github.com/JordanJazz24/Restaurant-web-api.git
   cd Restaurant-web-api
   ```
2. **Build the project:**
   ```bash
   ./mvnw clean install
   ```
3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
   Access the API at `http://localhost:8080/` and the web interface at `/pages/restaurante/view.html`.

---

## Extensibility

The modular design allows you to easily add new entities, endpoints, and functionalities. It is recommended to follow the layered pattern and Spring Boot best practices to maintain maintainability.

---

## Best Practices and Patterns Used

- Separation of responsibilities (data, logic, presentation)
- Dependency injection
- Basic error control
- Automated tests and easy extension
- Clear, well-named, and documented code

---

## License

MIT

---

## Contact

For support or suggestions: [JordanJazz24](https://github.com/JordanJazz24)
