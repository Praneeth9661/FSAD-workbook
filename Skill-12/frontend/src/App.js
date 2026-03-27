import React, { useState } from 'react';
import './App.css';
import AddStudent from './components/AddStudent';
import StudentList from './components/StudentList';

function App() {
  const [refreshKey, setRefreshKey] = useState(0);

  // Trigger refresh of student list
  const handleStudentAdded = () => {
    setRefreshKey(prevKey => prevKey + 1);
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>🎓 Skill-12 Full-Stack CRUD Application</h1>
        <p>React Frontend + Spring Boot Backend</p>
      </header>
      
      <div className="app-container">
        <AddStudent onStudentAdded={handleStudentAdded} />
        <StudentList onRefresh={refreshKey} />
      </div>
    </div>
  );
}

export default App;
