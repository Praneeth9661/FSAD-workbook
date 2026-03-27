import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FakePostList = () => {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchPosts = async () => {
    setLoading(true);
    try {
      const response = await axios.get('https://dummyjson.com/posts');
      setPosts(response.data.posts);
      setLoading(false);
    } catch (err) {
      setError(err.message);
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  if (loading) {
    return (
      <div className="loading">
        <div className="spinner"></div>
        <p>Loading posts from API...</p>
      </div>
    );
  }

  if (error) {
    return <div className="error">Error: {error}</div>;
  }

  return (
    <div>
      <h2>📝 Fake API Posts from DummyJSON</h2>
      
      {/* Refresh Button */}
      <button onClick={fetchPosts} className="refresh-btn">
        🔄 Refresh Posts
      </button>

      <p><strong>Total Posts:</strong> {posts.length}</p>
      
      <div className="card-grid">
        {posts.map((post) => (
          <div key={post.id} className="card">
            <h3>{post.title}</h3>
            <p><strong>ID:</strong> {post.id}</p>
            <p><strong>Category:</strong> {post.category}</p>
            <p><strong>Likes:</strong> {post.reactions.likes} 👍</p>
            <p><strong>Dislikes:</strong> {post.reactions.dislikes} 👎</p>
            <p><strong>Tags:</strong> {post.tags.slice(0, 3).join(', ')}</p>
            <p className="post-body">{post.body.substring(0, 100)}...</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default FakePostList;
