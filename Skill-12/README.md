# Skill-12 Full-Stack CRUD Application

A complete full-stack web application built with **React** (frontend) and **Spring Boot** (backend) for managing student records.

## Features

✅ **Complete CRUD Operations**:
- ➕ Add new students
- 📖 View all students
- ✏️ Update student information
- 🗑️ Delete students

✅ **Frontend Features**:
- Real-time UI updates without page reload
- Form validation
- Loading states
- Error handling
- Responsive design
- Inline editing capability

✅ **Backend Features**:
- RESTful API endpoints
- MySQL database integration
- JPA/Hibernate ORM
- Cross-Origin Resource Sharing (CORS) enabled

## Technology Stack

### Frontend
- React 18
- Axios (HTTP client)
- CSS3 (Responsive design)
- useState & useEffect hooks

### Backend
- Spring Boot 3.2.0
- Spring Data JPA
- MySQL Database
- Maven
- Java 17

## Project Structure

```
Skill-12-FullStackCRUD/
│
├── backend/
│   ├── src/main/java/com/fsad/backend/
│   │   ├── controller/
│   │   │   └── StudentController.java
│   │   ├── service/
│   │   │   └── StudentService.java
│   │   ├── repository/
│   │   │   └── StudentRepository.java
│   │   ├── model/
│   │   │   └── Student.java
│   │   └── BackendApplication.java
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
│
└── frontend/
    ├── src/
    │   ├── components/
    │   │   ├── StudentList.jsx
    │   │   ├── StudentList.css
    │   │   ├── AddStudent.jsx
    │   │   └── AddStudent.css
    │   ├── App.js
    │   ├── App.css
    │   └── index.js
    ├── public/
    └── package.json
```

## Installation & Setup

### Prerequisites
- Java 17 or higher
- Node.js and npm
- MySQL Server

### Backend Setup

1. Navigate to backend folder:
```bash
cd backend
```

2. Update `src/main/resources/application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/skill12db
spring.datasource.username=root
spring.datasource.password=your_password
```

3. Create MySQL database:
```sql
CREATE DATABASE skill12db;
```

4. Run the backend:
```bash
mvn spring-boot:run
```

Backend will start at: `http://localhost:8080`

### Frontend Setup

1. Navigate to frontend folder:
```bash
cd frontend
```

2. Install dependencies (already done):
```bash
npm install
```

3. Start the frontend:
```bash
npm start
```

Frontend will start at: `http://localhost:3000`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Add new student |
| PUT | `/students/{id}` | Update student |
| DELETE | `/students/{id}` | Delete student |

## Request/Response Format

### Student Object
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "course": "Computer Science"
}
```

## Testing the Application

1. **Add Student**: 
   - Fill in Name, Email, and Course
   - Click "Add Student" button
   - Success message appears

2. **View Students**:
   - All students display in table format
   - Shows ID, Name, Email, and Course

3. **Update Student**:
   - Click "Edit" button
   - Modify fields inline
   - Click "Save" or "Cancel"

4. **Delete Student**:
   - Click "Delete" button
   - Confirm deletion in popup
   - Student removed from list

## Screenshots

### Main Interface
- Header with application title
- Add Student form on top
- Student List table below
- Beautiful gradient background

### Features Working
- ✅ Form validation
- ✅ Loading indicators
- ✅ Success/Error messages
- ✅ Responsive layout
- ✅ Inline editing
- ✅ Delete confirmation

## Running Both Servers Simultaneously

Open two terminal windows:

**Terminal 1 (Backend)**:
```bash
cd Skill-12-FullStackCRUD/backend
mvn spring-boot:run
```

**Terminal 2 (Frontend)**:
```bash
cd Skill-12-FullStackCRUD/frontend
npm start
```

## Troubleshooting

### Backend Issues
- Ensure MySQL is running
- Check database credentials in application.properties
- Verify port 8080 is available

### Frontend Issues
- Ensure backend is running at http://localhost:8080
- Check browser console for errors
- Verify CORS is enabled in backend

### Connection Issues
- Backend must be running before frontend can fetch data
- Check firewall settings
- Verify both servers are on correct ports

## Learning Outcomes

This project demonstrates:
- ✅ Full-stack development
- ✅ REST API design
- ✅ React component architecture
- ✅ State management with hooks
- ✅ Axios HTTP client
- ✅ Spring Boot + JPA
- ✅ Database integration
- ✅ CRUD operations
- ✅ Error handling
- ✅ Responsive UI design

## Author

Created as part of FSAD Skills training program.

## License

This project is for educational purposes.
