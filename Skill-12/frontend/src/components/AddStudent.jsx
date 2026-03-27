import React, { useState } from 'react';
import axios from 'axios';
import './AddStudent.css';

const API_URL = 'http://localhost:8080/students';

const AddStudent = ({ onStudentAdded }) => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    course: ''
  });
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Validation
    if (!formData.name || !formData.email || !formData.course) {
      setMessage('❌ Please fill in all fields');
      return;
    }

    try {
      setLoading(true);
      setMessage('');
      
      // POST request to add student
      const response = await axios.post(API_URL, formData);
      
      setMessage('✅ Student added successfully!');
      setFormData({ name: '', email: '', course: '' });
      
      // Notify parent component
      if (onStudentAdded) {
        onStudentAdded(response.data);
      }
    } catch (error) {
      setMessage('❌ Failed to add student. Make sure backend is running.');
      console.error('Error adding student:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="add-student-container">
      <h2>➕ Add New Student</h2>
      
      <form onSubmit={handleSubmit} className="student-form">
        <div className="form-group">
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter student name"
            className="form-input"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter email address"
            className="form-input"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="course">Course:</label>
          <input
            type="text"
            id="course"
            name="course"
            value={formData.course}
            onChange={handleChange}
            placeholder="Enter course name"
            className="form-input"
            required
          />
        </div>

        <button 
          type="submit" 
          className="submit-btn"
          disabled={loading}
        >
          {loading ? 'Adding...' : '📝 Add Student'}
        </button>

        {message && (
          <div className={`message ${message.includes('success') ? 'success' : 'error'}`}>
            {message}
          </div>
        )}
      </form>
    </div>
  );
};

export default AddStudent;
