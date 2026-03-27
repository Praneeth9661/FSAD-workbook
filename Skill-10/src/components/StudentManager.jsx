import React, { useState } from 'react';
import './StudentManager.css';

const StudentManager = () => {
  // Initial student data with 5 default students
  const [students, setStudents] = useState([
    { id: 1, name: 'John Doe', course: 'Computer Science' },
    { id: 2, name: 'Jane Smith', course: 'Mathematics' },
    { id: 3, name: 'Bob Johnson', course: 'Physics' },
    { id: 4, name: 'Alice Williams', course: 'Chemistry' },
    { id: 5, name: 'Charlie Brown', course: 'Biology' }
  ]);

  // State for form inputs
  const [formData, setFormData] = useState({
    id: '',
    name: '',
    course: ''
  });

  // Handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  // Add new student
  const addStudent = () => {
    if (formData.id && formData.name && formData.course) {
      const newStudent = {
        id: parseInt(formData.id),
        name: formData.name,
        course: formData.course
      };
      setStudents([...students, newStudent]);
      // Clear form
      setFormData({ id: '', name: '', course: '' });
    } else {
      alert('Please fill in all fields');
    }
  };

  // Delete student by ID
  const deleteStudent = (id) => {
    const updatedStudents = students.filter(student => student.id !== id);
    setStudents(updatedStudents);
  };

  return (
    <div className="container">
      <h1>Student Manager</h1>
      
      {/* Add Student Form */}
      <div className="form-section">
        <h2>Add Student</h2>
        <div className="input-group">
          <input
            type="number"
            name="id"
            placeholder="ID"
            value={formData.id}
            onChange={handleInputChange}
            className="input-field"
          />
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={formData.name}
            onChange={handleInputChange}
            className="input-field"
          />
          <input
            type="text"
            name="course"
            placeholder="Course"
            value={formData.course}
            onChange={handleInputChange}
            className="input-field"
          />
          <button onClick={addStudent} className="add-btn">
            Add Student
          </button>
        </div>
      </div>

      {/* Display Students Table */}
      <div className="table-section">
        <h2>Student List</h2>
        {students.length === 0 ? (
          <p className="no-students">No students available</p>
        ) : (
          <table className="student-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {students.map((student) => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>{student.course}</td>
                  <td>
                    <button 
                      onClick={() => deleteStudent(student.id)} 
                      className="delete-btn"
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default StudentManager;
