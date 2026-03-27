# 🚀 Quick Start Guide - Skill-12 Full-Stack CRUD

## Prerequisites
Before starting, ensure you have:
- ✅ Java 17 or higher installed
- ✅ Node.js and npm installed
- ✅ MySQL Server running
- ✅ Maven installed (comes with Spring Boot)

## Step-by-Step Setup

### 1️⃣ Create Database

Open MySQL and run:
```sql
CREATE DATABASE skill12db;
```

### 2️⃣ Configure Backend

Navigate to backend folder:
```bash
cd Skill-12-FullStackCRUD/backend
```

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/skill12db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### 3️⃣ Run Backend Server

In the backend folder, run:
```bash
mvn spring-boot:run
```

Wait for this message:
```
Started BackendApplication in X seconds
Tomcat started on port(s): 8080 (http)
```

✅ Backend is now running at: http://localhost:8080

### 4️⃣ Run Frontend

Open a NEW terminal window and navigate to frontend folder:
```bash
cd Skill-12-FullStackCRUD/frontend
npm start
```

Wait for this message:
```
Compiled successfully!
You can now view skill-12-full-stack-crud in the browser.
Local:            http://localhost:3000
```

✅ Frontend is now running at: http://localhost:3000

### 5️⃣ Open Browser

Navigate to: **http://localhost:3000**

You should see:
- 🎓 "Skill-12 Full-Stack CRUD Application" header
- ➕ "Add New Student" form
- 📚 "Student List" table

## Testing the Application

### Test Add Student:
1. Fill in Name: "John Doe"
2. Fill in Email: "john@example.com"
3. Fill in Course: "Computer Science"
4. Click "📝 Add Student"
5. You should see success message

### Test View Students:
- The student you added should appear in the table below

### Test Update Student:
1. Click "✏️ Edit" button on any student
2. Modify the information
3. Click "💾 Save" or "❌ Cancel"

### Test Delete Student:
1. Click "🗑️ Delete" button
2. Confirm deletion in popup
3. Student will be removed from list

## Troubleshooting

### ❌ Backend won't start:
- Check if MySQL is running
- Verify database name is `skill12db`
- Check username/password in application.properties
- Ensure port 8080 is not in use

### ❌ Frontend shows error:
- Make sure backend is running first
- Check browser console (F12) for errors
- Verify backend URL is http://localhost:8080

### ❌ Can't connect to database:
```
ERROR: Access denied for user 'root'@'localhost'
```
**Solution**: Update password in application.properties

### ❌ Port already in use:
```
ERROR: Port 8080 was already in use
```
**Solution**: 
- Stop other applications using port 8080
- Or change port in application.properties: `server.port=8081`

## API Testing with Postman (Optional)

### GET all students:
```
GET http://localhost:8080/students
```

### POST new student:
```
POST http://localhost:8080/students
Content-Type: application/json

{
  "name": "Jane Smith",
  "email": "jane@example.com",
  "course": "Mathematics"
}
```

### PUT update student:
```
PUT http://localhost:8080/students/1
Content-Type: application/json

{
  "name": "Updated Name",
  "email": "updated@example.com",
  "course": "Physics"
}
```

### DELETE student:
```
DELETE http://localhost:8080/students/1
```

## Success Indicators

✅ Backend Console shows:
- "Hibernate: create table students..."
- "Started BackendApplication"
- No ERROR messages

✅ Frontend Browser shows:
- Beautiful gradient background
- Form and table are visible
- No console errors (F12)

✅ Operations Work:
- Adding student updates table immediately
- Edit button enables inline editing
- Delete removes student from list
- UI updates without page reload

## File Structure Reference

```
Skill-12-FullStackCRUD/
│
├── backend/           ← Spring Boot server (Port 8080)
│   ├── src/
│   ├── pom.xml
│   └── application.properties
│
└── frontend/          ← React app (Port 3000)
    ├── src/
    │   ├── components/
    │   ├── App.js
    │   └── ...
    └── package.json
```

## Next Steps

1. ✅ Test all CRUD operations
2. ✅ Try adding multiple students
3. ✅ Test edit and delete functionality
4. ✅ Check database to see stored records
5. ✅ Review code to understand the flow

## Common Commands

### Backend:
```bash
mvn spring-boot:run     # Run application
mvn clean install       # Build project
mvn test               # Run tests
```

### Frontend:
```bash
npm start              # Run development server
npm run build          # Build for production
npm test              # Run tests
```

---

## 🎉 Congratulations!

You now have a fully functional full-stack CRUD application running!

**Frontend**: http://localhost:3000  
**Backend API**: http://localhost:8080/students  
**Database**: MySQL (skill12db)
