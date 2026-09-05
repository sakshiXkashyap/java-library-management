# 📚 Java Library Management System

A console-based Library Management System developed using Core Java.

This project demonstrates Object-Oriented Programming, exception handling,
file-based data persistence, CRUD operations, and Git/GitHub workflow.

---

## 🚀 Features

### 📖 Book Management
- View all books
- Search book by ID
- Add new books
- Delete books
- Show available books
- Show total books
- Prevent duplicate book IDs
- Prevent deletion of issued books

### 👨‍🎓 Student Management
- View all students
- Search student by ID
- Add new students
- Delete students
- Show total students
- Prevent duplicate student IDs
- Prevent deletion of students with active issued books

### 🔄 Book Transactions
- Issue books to students
- Return books
- Prevent issuing an already-issued book
- Transaction history
- Total transaction count

### 💾 File Persistence
The application stores data using text files:

- `books.txt`
- `students.txt`
- `transactions.txt`

Data is loaded automatically when the application starts.

---

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- Exception Handling
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
│   ├── Main.java
│   │
│   ├── model/
│   │   ├── Book.java
│   │   ├── Student.java
│   │   └── Transaction.java
│   │
│   ├── service/
│   │   └── Library.java
│   │
│   ├── util/
│   │   └── FileManager.java
│   │
│   └── excaption/
│       ├── BookAlreadyIssuedException.java
│       └── BookNotFoundException.java
│
├── books.txt
├── students.txt
├── transactions.txt
├── .gitignore
└── README.md