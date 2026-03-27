import React, { useState } from 'react';
import LocalUserList from './LocalUserList';
import UserList from './UserList';
import FakePostList from './FakePostList';
import './Dashboard.css';

const Dashboard = () => {
  const [activeSection, setActiveSection] = useState('');

  const renderSection = () => {
    switch (activeSection) {
      case 'local':
        return <LocalUserList />;
      case 'users':
        return <UserList />;
      case 'posts':
        return <FakePostList />;
      default:
        return (
          <div className="welcome-message">
            <h2>Welcome to Skill-11 React API Integration</h2>
            <p>Select an option from the menu above to view data</p>
          </div>
        );
    }
  };

  return (
    <div className="dashboard-container">
      <h1>Skill-11 React API Integration</h1>
      
      <div className="button-container">
        <button 
          onClick={() => setActiveSection('local')}
          className={activeSection === 'local' ? 'active' : ''}
        >
          📋 Local Users
        </button>
        <button 
          onClick={() => setActiveSection('users')}
          className={activeSection === 'users' ? 'active' : ''}
        >
          🌐 Users API
        </button>
        <button 
          onClick={() => setActiveSection('posts')}
          className={activeSection === 'posts' ? 'active' : ''}
        >
          📝 Fake API Posts
        </button>
        {activeSection && (
          <button 
            onClick={() => setActiveSection('')}
            className="back-btn"
          >
            ← Back to Home
          </button>
        )}
      </div>

      <div className="content-section">
        {renderSection()}
      </div>
    </div>
  );
};

export default Dashboard;
