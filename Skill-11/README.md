# Skill-11 React API Integration

A comprehensive React application demonstrating API integration with multiple data sources, loading states, error handling, and dynamic filtering.

## Features

✅ **Three Data Sources**:
- 📋 **Local Users** - Load data from local `users.json` file
- 🌐 **Users API** - Fetch users from JSONPlaceholder API with company filter
- 📝 **Fake API Posts** - Display posts from DummyJSON API with refresh functionality

✅ **Key Features Implemented**:
- Loading states with spinner animation
- Error handling for all API calls
- Dropdown filter for users by company
- Refresh button for posts
- Responsive design
- Interactive navigation dashboard

## Technologies Used

- React 18
- Axios (HTTP client)
- CSS3 (Responsive design)
- Fetch API (for local JSON)

## Project Structure

```
Skill-11-ReactAPIIntegration/
├── public/
│   └── users.json              # Local user data
├── src/
│   ├── components/
│   │   ├── Dashboard.jsx       # Main navigation component
│   │   ├── Dashboard.css       # Dashboard styling
│   │   ├── LocalUserList.jsx   # Display local JSON users
│   │   ├── UserList.jsx        # Display API users with filter
│   │   └── FakePostList.jsx    # Display posts with refresh
│   ├── App.js                  # Main app component
│   └── index.js                # React entry point
├── package.json
└── README.md
```

## Installation

The project has already been set up. Dependencies include:

```bash
npm install
```

Axios is pre-installed for API calls.

## Running the Application

Start the development server:

```bash
npm start
```

Open your browser and navigate to:
```
http://localhost:3000
```

## APIs Used

### 1. Local JSON File
- **Source**: `/users.json`
- **Data**: 5 sample users with Indian names
- **Fields**: id, name, email, phone

### 2. JSONPlaceholder Users API
- **URL**: `https://jsonplaceholder.typicode.com/users`
- **Data**: 10 fake users
- **Features**: Company filter dropdown
- **Fields**: id, name, email, phone, company.name, address.city

### 3. DummyJSON Posts API
- **URL**: `https://dummyjson.com/posts`
- **Data**: 30 blog posts
- **Features**: Refresh button
- **Fields**: id, title, body, category, tags, reactions

## Component Details

### Dashboard Component
- Main navigation hub
- Three buttons for each section
- Back button to return home
- Conditional rendering based on selection

### LocalUserList Component
- Fetches from `/users.json`
- Displays in table format
- Loading spinner
- Error handling

### UserList Component
- Fetches from JSONPlaceholder API using Axios
- Company filter dropdown
- Shows filtered vs total count
- Comprehensive user information table

### FakePostList Component
- Fetches posts from DummyJSON API
- Card-based grid layout
- Refresh button to reload data
- Displays post details with likes/dislikes

## Screenshots

### Dashboard Home
- Welcome message
- Three navigation buttons

### Local Users View
- Table with 5 local users
- Clean tabular format

### Users API View
- 10 users from API
- Filter dropdown by company
- Shows filtered results count

### Posts View
- 30 posts in card grid
- Refresh button
- Like/dislike counts

## Learning Outcomes

This project demonstrates:
- ✅ useState and useEffect hooks
- ✅ Axios HTTP client usage
- ✅ Fetch API for local JSON
- ✅ Loading state management
- ✅ Error handling
- ✅ Filter functionality
- ✅ Component composition
- ✅ Responsive CSS
- ✅ API integration patterns

## Author

Created as part of FSAD Skills training program.

## License

This project is for educational purposes.
