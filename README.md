# 📚 Library Management System

A console-based **Library Management System** built using Java.

This project is being developed step-by-step to strengthen my understanding of **Core Java, OOP, Collections, Exception Handling, File Handling, and backend development concepts**.

---

## 🚀 Features

### 📖 Book Management

- View all books
- Search book by ID
- Add new book
- Prevent duplicate book IDs
- Delete book
- Show total number of books
- Show available books

### 👨‍🎓 Student Management

- View all students
- Add new student
- Prevent duplicate student IDs
- Search student by ID
- Delete student

### 🔄 Book Issue & Return

- Issue a book to a student
- Return an issued book
- Prevent issuing an already issued book
- Validate student before issuing
- Prevent returning a book that is not issued

### 📋 Transaction Management

- Record book issue transactions
- Record book return transactions
- View transaction history
- Show total number of transactions
- Store transaction date and time

### 💾 File Handling

- Load books from file when application starts
- Save book changes to file
- Save transactions to file
- Load transactions when application starts

### ⚠️ Exception Handling

Custom exceptions are used for library operations:

- `BookNotFoundException`
- `BookAlreadyIssuedException`

---

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- Exception Handling
- Custom Exceptions
- File Handling
- LocalDateTime
- IntelliJ IDEA
- Git
- GitHub

---

## 📂 Project Structure

```text
java-library-management/
│
├── src/
│   │
│   ├── model/
│   │   ├── Book.java
│   │   ├── Student.java
│   │   └── Transaction.java
│   │
│   ├── service/
│   │   └── Library.java
│   │
│   ├── exception/
│   │   ├── BookAlreadyIssuedException.java
│   │   └── BookNotFoundException.java
│   │
│   ├── util/
│   │   └── FileManager.java
│   │
│   └── Main.java
│
├── books.txt
├── transactions.txt
└── README.md