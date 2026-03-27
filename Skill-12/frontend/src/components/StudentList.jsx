import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './StudentList.css';

const API_URL = 'http://localhost:8080/students';

const StudentList = ({ onRefresh }) => {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [editingId, setEditingId] = useState(null);
  const [editForm, setEditForm] = useState({
    name: '',
    email: '',
    course: ''
  });

  // Fetch students
  const fetchStudents = async () => {
    try {
      setLoading(true);
      const response = await axios.get(API_URL);
      setStudents(response.data);
      setError(null);
    } catch (err) {
      setError('Failed to fetch students. Make sure the backend is running.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchStudents();
  }, [onRefresh]);

  // Delete student
  const handleDelete = async (id) => {
    if (window.confirm('Are you sure you want to delete this student?')) {
      try {
        await axios.delete(`${API_URL}/${id}`);
        fetchStudents();
      } catch (err) {
        alert('Failed to delete student');
        console.error(err);
      }
    }
  };

  // Handle edit click
  const handleEditClick = (student) => {
    setEditingId(student.id);
    setEditForm({
      name: student.name,
      email: student.email,
      course: student.course
    });
  };

  // Handle edit form changes
  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditForm({
      ...editForm,
      [name]: value
    });
  };

  // Handle edit submit
  const handleEditSubmit = async (id) => {
    try {
      await axios.put(`${API_URL}/${id}`, editForm);
      setEditingId(null);
      fetchStudents();
    } catch (err) {
      alert('Failed to update student');
      console.error(err);
    }
  };

  // Cancel edit
  const handleCancelEdit = () => {
    setEditingId(null);
    setEditForm({ name: '', email: '', course: '' });
  };

  if (loading) {
    return <div className="loading">Loading students...</div>;
  }

  if (error) {
    return <div className="error">{error}</div>;
  }

  return (
    <div className="student-list-container">
      <h2>📚 Student List</h2>
      
      {students.length === 0 ? (
        <p className="no-students">No students found. Add some students!</p>
      ) : (
        <table className="student-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Course</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                {editingId === student.id ? (
                  // Edit mode
                  <>
                    <td>{student.id}</td>
                    <td>
                      <input
                        type="text"
                        name="name"
                        value={editForm.name}
                        onChange={handleEditChange}
                        className="edit-input"
                      />
                    </td>
                    <td>
                      <input
                        type="email"
                        name="email"
                        value={editForm.email}
                        onChange={handleEditChange}
                        className="edit-input"
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="course"
                        value={editForm.course}
                        onChange={handleEditChange}
                        className="edit-input"
                      />
                    </td>
                    <td>
                      <button 
                        onClick={() => handleEditSubmit(student.id)}
                        className="save-btn"
                      >
                        💾 Save
                      </button>
                      <button 
                        onClick={handleCancelEdit}
                        className="cancel-btn"
                      >
                        ❌ Cancel
                      </button>
                    </td>
                  </>
                ) : (
                  // View mode
                  <>
                    <td>{student.id}</td>
                    <td>{student.name}</td>
                    <td>{student.email}</td>
                    <td>{student.course}</td>
                    <td>
                      <button 
                        onClick={() => handleEditClick(student)}
                        className="edit-btn"
                      >
                        ✏️ Edit
                      </button>
                      <button 
                        onClick={() => handleDelete(student.id)}
                        className="delete-btn"
                      >
                        🗑️ Delete
                      </button>
                    </td>
                  </>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default StudentList;
