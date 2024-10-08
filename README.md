# JavaDocker

### Java Spring Boot API with PostgreSQL & Docker

This project is a RESTful API built with **Java Spring Boot**, integrated with a **PostgreSQL** database, and containerized using **Docker**. Key features include:

- **Spring Boot** framework for efficient API development
- **PostgreSQL** as the relational database, managed via **Spring Data JPA**
- **Docker** for easy containerization and environment consistency
- Basic **CRUD** operations for resource management
- **Exception handling**, **logging**, and **validation** mechanisms
- **Unit** and **integration tests** for reliability

Perfect for scalable and portable backend services.

---

# API Endpoints Documentation

This API allows CRUD operations on a resource. Below are the available routes:

## 1. Get Resource

- **Method:** GET
- **Endpoint:** `/tarefas/{TarefaId}`
- **Description:** Retrieves a specific resource by ID.
- **URL Example:** `http://localhost:8080/tarefas/{TarefaId}`
- **Response:**
  ```json
  {
    "id": 1,
    "titulo": "Resource titulo",
    "descricao": "Resource description"
  }
  ```

---

## 1.1 Get All Resources

- **Method:** GET
- **Endpoint:** `/tarefas`
- **Description:** Retrieves all resources.
- **URL Example:** `http://localhost:8080/tarefas`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "titulo": "Resource titulo",
      "descricao": "Resource description"
    },
    {
      "id": 2,
      "titulo": "Resource titulo",
      "descricao": "Resource description"
    }
  ]
  ```

---

## 2. Create Resource

- **Method:** POST
- **Endpoint:** `/tarefas`
- **Description:** Creates a new resource.
- **URL Example:** `http://localhost:8080/tarefas`
- **Request Body:**
  ```json
  {
    "titulo": "New Resource",
    "descricao": "Resource description"
  }
  ```
- **Response:**
  ```json
  {
    "id": 2,
    "titulo": "New Resource",
    "descricao": "Resource description"
  }
  ```

---

## 3. Update Resource

- **Method:** PUT
- **Endpoint:** `/tarefas/{TarefaId}`
- **Description:** Updates an existing resource by ID.
- **URL Example:** `http://localhost:8080/tarefas/{TarefaId}`
- **Request Body:**
  ```json
  {
    "titulo": "Updated Resource",
    "descricao": "Updated description"
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "titulo": "Updated Resource",
    "descricao": "Updated description"
  }
  ```

---

## 4. Delete Resource

- **Method:** DELETE
- **Endpoint:** `/tarefas/{TarefaId}`
- **Description:** Deletes a specific resource by ID.
- **URL Example:** `http://localhost:8080/tarefas/{TarefaId}`
- **Response:**
  ```json
  {
    "message": "Deleted"
  }
  ```
