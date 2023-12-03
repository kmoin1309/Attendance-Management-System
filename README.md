# Attendance Management System

This is an Attendance Management System implemented in Java Swing for the frontend and MySQL for the backend.

## Getting Started

To use the system, follow these steps:

1. **Project Setup:**
   - Fork and clone the repository.
   - Unzip and place the project files in your preferred location.

2. **Login:**
   - Go to the `Login` class and run the file.
   - Create an Administrator user account through the signup option.
   - Log in with proper Administrator credentials to access the Administrator window.

3. **Administrator Actions:**
   - Create faculty profiles and student profiles.
   - Launch courses.
   - Add students to their respective courses.
   - Update Administrator information, using dropdown menus to handle foreign key-related errors.
   - Log out from the Administrator window.

4. **Faculty Actions:**
   - Log in with Faculty ID and password.
   - Manage attendance for students in courses.
   - Send messages to other faculty members.
   - Log out from the Faculty window.

5. **Student Actions:**
   - Log in with Student ID and password.
   - Check attendance for enrolled courses.
   - Log out from the Student window.

6. **Exiting the Application:**
   - Click "EXIT" in the login window to close the application.

## Usage

To run this system, you need to have the following software and components installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL Database Server](https://dev.mysql.com/downloads/installer/)
- [MySQL Connector/J JDBC Driver](https://dev.mysql.com/downloads/connector/j/)

Before running the application, set up the necessary database and tables, which can be found in the `student_attendance` file inside the `FinalProject` directory.

## Contributing

If you'd like to contribute to this project, feel free to submit issues and pull requests on the GitHub repository.

## License

This project is licensed under the [MIT License](LICENSE).


