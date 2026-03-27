import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UserList = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [filterCompany, setFilterCompany] = useState('all');
  const [companies, setCompanies] = useState([]);

  useEffect(() => {
    // Fetch users from JSONPlaceholder API
    axios.get('https://jsonplaceholder.typicode.com/users')
      .then((response) => {
        setUsers(response.data);
        // Extract unique company names for filter
        const uniqueCompanies = [...new Set(response.data.map(user => user.company.name))];
        setCompanies(uniqueCompanies);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  // Filter users by company
  const filteredUsers = filterCompany === 'all' 
    ? users 
    : users.filter(user => user.company.name === filterCompany);

  if (loading) {
    return (
      <div className="loading">
        <div className="spinner"></div>
        <p>Loading users from API...</p>
      </div>
    );
  }

  if (error) {
    return <div className="error">Error: {error}</div>;
  }

  return (
    <div>
      <h2>🌐 Users from JSONPlaceholder API</h2>
      
      {/* Filter Dropdown */}
      <div className="filter-container">
        <label htmlFor="company-filter">Filter by Company: </label>
        <select 
          id="company-filter"
          value={filterCompany} 
          onChange={(e) => setFilterCompany(e.target.value)}
        >
          <option value="all">All Companies</option>
          {companies.map((company, index) => (
            <option key={index} value={company}>
              {company}
            </option>
          ))}
        </select>
      </div>

      <p><strong>Total Users:</strong> {filteredUsers.length} out of {users.length}</p>
      
      <table className="data-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Company</th>
            <th>City</th>
          </tr>
        </thead>
        <tbody>
          {filteredUsers.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.phone}</td>
              <td>{user.company.name}</td>
              <td>{user.address.city}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserList;
