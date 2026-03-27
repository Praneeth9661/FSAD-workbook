# Skill 10 - React Student Management

A React application that demonstrates the use of the `useState` hook to manage student data with add, display, and delete functionality.

## Features

- ✅ Display 5 default students on load
- ✅ Add new students with ID, Name, and Course
- ✅ Delete students dynamically
- ✅ Real-time UI updates using useState hook
- ✅ Shows "No students available" when list is empty
- ✅ Responsive design

## Technologies Used

- React 18
- useState Hook
- CSS3

## Project Structure

```
skill-10-react-management/
├── src/
│   ├── components/
│   │   ├── StudentManager.jsx    # Main component with all logic
│   │   └── StudentManager.css    # Styling for the component
│   ├── App.js                    # Main app component
│   └── index.js                  # React entry point
├── public/
├── package.json
└── README.md
```

## Installation

The project has already been created. If you need to reinstall:

```bash
npm install
```

## Running the Application

Start the development server:

```bash
npm start
```

Open your browser and navigate to:
```
http://localhost:3000
```

## How to Use

### Adding a Student

1. Enter an ID number in the ID field
2. Enter the student's name
3. Enter the course name
4. Click "Add Student" button

### Deleting a Student

Click the "Delete" button next to any student in the table to remove them.

## Default Students

The application loads with 5 default students:
1. John Doe - Computer Science
2. Jane Smith - Mathematics
3. Bob Johnson - Physics
4. Alice Williams - Chemistry
5. Charlie Brown - Biology

## Component Details

### StudentManager Component

**State Variables:**
- `students` - Array of student objects
- `formData` - Object containing form input values

**Functions:**
- `handleInputChange()` - Handles form input changes
- `addStudent()` - Adds a new student to the list
- `deleteStudent(id)` - Removes a student by ID

## Learning Outcomes

This project demonstrates:
- Understanding of React hooks (useState)
- Managing arrays in state
- Form handling in React
- Conditional rendering
- Event handling
- Component-based architecture

## Author

Created as part of FSAD Skills training program.

## License

This project is for educational purposes.
