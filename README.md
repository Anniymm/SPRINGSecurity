# 🛡️ Spring Security with JWT (Access & Refresh Tokens)

Project about authentication and authorization using **Spring Security**, **JWT (JSON Web Token)**, and **refresh tokens**. It ensures secure user login and token management for API authentication.

---

## 🚀 Features

✅ **User Authentication**: Secure login with JWT access and refresh tokens.  
✅ **Role-Based Authorization**: Protect API routes based on user roles.  
✅ **Token Expiry & Refresh**: Access tokens expire.  
✅ **Spring Boot & Security Integration**: Uses Spring Security filters for JWT validation.

---

## ⚙️ Prerequisites

- Java 17+  
- Spring Boot 3+  
- PostgreSQL
- Gradle or Maven

---

## 📌 Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Anniymm/SPRINGSecurity.git
cd SPRINGSecurity
```

## 2️⃣ Configure Database

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=DB_URL:jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate Settings
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```
## 🔑 Authentication Flow

1️⃣ **User registers** → `/auth/register`  
2️⃣ **User logs in** → `/auth/login`  
3️⃣ **Receives access & refresh tokens**  
4️⃣ **Uses access token** to access protected APIs  
5️⃣ **When access token expires**, sends refresh token to `/auth/refresh-token`  

## 🛠️ API Endpoints

| Method | Endpoint            | Description                                 | 
|--------|---------------------|---------------------------------------------|
| POST   | `/auth/register`     | Register a new user                        | 
| POST   | `/auth/login`        | Authenticate & get JWT tokens              | 
| POST   | `/auth/refresh-token`      | Get new access token using refresh token   | 
| GET    | `/auth//logout`          | for logout                   | 


## 🔐 JWT Token Structure

- **Access Token**
  - Short-lived 
  - Used for API access
  - Included in `Authorization: Bearer <token>` header

- **Refresh Token**
  - Long-lived
  - Used to get a new access token


## ▶️ Running the Application

### Using Gradle

```bash
./gradlew bootRun
```
## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.


