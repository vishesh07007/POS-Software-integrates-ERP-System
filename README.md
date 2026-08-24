# POS-Software-integrates-ERP-System
Billing &amp; POS software and a full ERP system tailored especially for pharma operations — handling everything from billing and inventory to financial compliance and ordering automation.

## Prerequisites

- Java 21
- Maven 3.9+
- MySQL 8+

## Local setup

1. Create the database:
   ```sql
   CREATE DATABASE erp_db;
   ```

2. Copy the secret config template and set your MySQL password:
   ```bash
   cp src/main/resources/application-secret.properties.example src/main/resources/application-secret.properties
   ```
   Edit `application-secret.properties` and replace `your_mysql_password_here` with your local MySQL root password.

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The app starts on `http://localhost:8080`. JPA will auto-create/update tables on first run (`spring.jpa.hibernate.ddl-auto=update`).

## API endpoints (current)

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/medicines` | List all medicines |
| POST | `/api/medicines` | Add medicine (duplicate SKU rejected) |
| GET | `/api/medicines/{id}` | Get medicine by id |
| GET | `/api/medicines/search?name=` | Search medicines by name |
| DELETE | `/api/medicines/{id}` | Delete medicine |
| GET | `/api/customers` | List all customers |
| GET | `/api/customers/{id}` | Get customer by id |
| POST | `/api/sales` | Create sale invoice |
| GET | `/api/sales` | List all sales |
| GET | `/api/batches` | Batches expiring within 30 days |
| GET | `/api/batches/low-stock` | Batches with quantity below 10 |
