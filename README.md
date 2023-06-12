# KratinAssignment

Healthier Diet Plan for Sunita

This project aims to provide Sunita, an older lady, with a healthier diet plan to improve her overall well-being. The project utilizes Spring Boot for the backend and ReactJS for the frontend.
Backend (Spring Boot)

The backend of the project is built using Spring Boot framework, which provides a robust and scalable foundation for developing web applications. The following components are implemented in the backend:
User Registration

A table or POJO (Plain Old Java Object) is created to store the user registration details. Sunita can register herself by providing her name, age, address, email, and password. This information is stored securely in the database.
Diet Plan

Another table or POJO is implemented to manage the diet plans. The diet plans are designed to improve Sunita's health and well-being. These plans are created and maintained by dietitians. Sunita can view her assigned diet plan after logging in to the system.
User Authentication and Login

The UserController provides methods for user authentication and login. Sunita can securely log in to the system by providing her registered email and password. Upon successful login, she gains access to her personalized diet plan and other features.
Customization Option

The system also provides an option for Sunita to customize her diet plan. If she wants to add or modify anything in her diet plan based on recommendations from her dietitian, she can make the necessary changes through the frontend interface.
Frontend (ReactJS)

The frontend of the project is developed using ReactJS, a popular JavaScript library for building user interfaces. The frontend allows Sunita to interact with the backend functionalities in a user-friendly manner. The following features are implemented in the frontend:
User Registration Form

Sunita can register herself by filling out a simple form that collects her name, age, address, email, and password. Upon submission, the data is sent to the backend for processing and storing in the database.
Login Form

A login form is provided for Sunita to securely log in to the system. She needs to enter her registered email and password to gain access to her personalized diet plan and other features.
Profile Page

After successful login, Sunita can view her profile page, which displays her registered information such as name, age, address, and email. This page also provides an interface for her to view her assigned diet plan and customize it if needed.

