# 👨‍💼 Employee Directory Web UI

A simple web application built using **Spring Boot** and **Thymeleaf** to manage an employee directory with full CRUD functionality.

---

## ✅ Features

Users can perform the following operations:

- 📋 **Get a list of employees**
- ➕ **Add a new employee**
- 🔄 **Update an existing employee**
- ❌ **Delete an employee**
- ⚠️ **Delete all employees** (via endpoint)

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf
- **Templating Engine**: Thymeleaf
- **Build Tool**: Maven or Gradle
- **Database**: H2 (In-memory) or other supported DBMS

---

## 📁 Project Structure

src/
├── main/
│ ├── java/com/luv2code/springboot/thymeleafdemo/
│ │ ├── controller/ # Web controllers (e.g., EmployeeController)
│ │ ├── entity/ # JPA entities (e.g., Employee.java)
│ │ ├── repository/ # Spring Data JPA repositories
│ │ └── service/ # Business logic layer
│ └── resources/
│ ├── templates/ # Thymeleaf HTML templates
│ ├── static/ # Static assets like CSS/JS/images (if needed)
│ └── application.properties



---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 

### Running the App

Using **Maven**:

```bash
./mvnw spring-boot:run


## 📌 REST Endpoints

-🌐 Accessing the App
- http://localhost:8080/employees/list


### 🔍 Get All Employees
- **GET** `/employees/list`  
  Displays a list of all employees.

### ➕ Show Add Employee Form
- **GET** `/employees/showFormForAdd`  
  Returns a form to add a new employee.

### 💾 Save Employee
- **POST** `/employees/save`  
  Saves a new or updated employee.  
  > Uses `@Valid` to validate fields on the `Employee` entity.

### 🗑️ Delete Employee
- **GET** `/employees/delete?employeeId={id}`  
  Deletes a specific employee by ID.

### ✏️ Update Employee
- **GET** `/employees/update?employeeId={id}`  
  Fetches an employee and shows the form pre-filled for update.

### ⚠️ Delete All Employees
- **DELETE** `/employees/deleteAll`  
  Deletes **all** employees from the database.  
  > Use with caution!

