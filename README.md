# First API — Customer CRUD with Spring Boot

A simple REST API for managing customers, built with Java and Spring Boot. This is a learning project covering a full CRUD (Create, Read, Update, Delete).

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Lombok

## Endpoints

| Method | Route            | Description              |
|--------|------------------|---------------------------|
| GET    | `/clientes`      | List all customers        |
| GET    | `/clientes/{id}` | Get a customer by id      |
| POST   | `/clientes`      | Create a new customer     |
| PUT    | `/clientes/{id}` | Update a customer         |
| DELETE | `/clientes/{id}` | Delete a customer         |

### Example request body (POST / PUT)

```json
{
  "nome": "Test",
  "email": "test@test.com"
}
```

## Validation

- `nome` and `email` are required on creation. Missing or empty fields return `400 Bad Request`.
- Updates are partial — only the fields sent are changed.
- Requests for a customer id that doesn't exist return `404 Not Found`.

## Notes

- Data is stored in memory (a `List`), so it resets every time the app restarts. Adding a real database (JPA + H2/Postgres) is a planned next step.
- This is a learning project — feedback is welcome!

## Running the project

```bash
./mvnw spring-boot:run        # Linux/Mac
mvnw.cmd spring-boot:run       # Windows
```

The API runs on `http://localhost9090` by default.
