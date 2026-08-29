## 🚀 Features

### 📚 Book Management
- Add new books
- View all books
- Search books by ID
- Delete books
- Display available books
- Display total number of books
- Issue books
- Return books
- Prevent duplicate book IDs
- Prevent issuing an already issued book

### 👨‍🎓 Student Management
- Add new students
- View all students
- Search students by ID
- Delete students
- Display total students
- Prevent duplicate student IDs
- Store student information using file persistence

### 🔄 Transaction Management
- Record book issue transactions
- Record book return transactions
- View complete transaction history
- Display total number of transactions
- Store transactions in a file
- Load previous transactions when the application starts

### 💾 File Persistence
The application uses text files to preserve data between program executions.

Files used:

- `books.txt` → Stores book information
- `students.txt` → Stores student information
- `transactions.txt` → Stores issue and return transaction history

The application loads existing data when it starts and saves changes whenever books, students, or transactions are modified.

### ⚠️ Exception Handling
Custom exceptions are used to handle common library errors:

- `BookNotFoundException`
- `BookAlreadyIssuedException`

These exceptions provide meaningful error messages instead of allowing the application to crash.

---

## 🖥️ Application Menu

```text
========== LIBRARY MENU ==========

1. View All Books
2. Search Book
3. Add New Book
4. Issue Book
5. Return Book
6. Delete Book
7. Show Available Books
8. Show Total Books
9. Transaction History
10. Show Total Transactions
11. View All Students
12. Add New Student
13. Search Student
14. Delete Student
15. Exit