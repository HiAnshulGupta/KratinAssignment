import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./ProfilePage.css"

const ProfilePage = () => {
  const [profileData, setProfileData] = useState(null);

  useEffect(() => {
    fetchProfileData();
  }, []);

  const fetchProfileData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/User/login/:userId');

      // Handle successful data retrieval
      console.log(response.data); // Assuming the response contains profile data

      setProfileData(response.data);

    } catch (error) {
      // Handle error
      console.log(error);
    }
  };

  return (
    <div>
      {/* Display the profile data */}
      {profileData && (
        <div>
          <h2>Profile Page</h2>
          <p>Name: {profileData.name}</p>
          <p>Age: {profileData.age}</p>
          <p>Address: {profileData.add}</p>
          <p>Email: {profileData.email}</p>
        </div>
      )}
    </div>
  );
}

export default ProfilePage;