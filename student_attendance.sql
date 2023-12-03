-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2021 at 11:15 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_attendance`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `Administrator_Id` tinyint(4) NOT NULL,
  `Administrator_Name` varchar(45) NOT NULL,
  `User_Id` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`Administrator_Id`, `Administrator_Name`, `User_Id`) VALUES
(1, 'Karim', 2),
(2, 'Rahim', 3),
(6, 'Management', 1924);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `Date` datetime NOT NULL,
  `Student_Id` mediumint(9) NOT NULL,
  `Course_Id` tinyint(4) NOT NULL,
  `Course_Initial` varchar(10) NOT NULL,
  `Faculty_Id` mediumint(9) NOT NULL,
  `Status` enum('Present','Absent','Late') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`Date`, `Student_Id`, `Course_Id`, `Course_Initial`, `Faculty_Id`, `Status`) VALUES
('2021-05-21 00:00:00', 181, 1, 'CSE 311', 501, 'Present'),
('2021-05-22 00:00:00', 181, 2, 'EEE142', 502, 'Present'),
('2021-05-23 00:00:00', 191, 2, 'EEE142', 502, 'Late'),
('2021-05-26 00:00:00', 181, 2, 'EEE142', 502, 'Present'),
('2021-05-26 00:00:00', 191, 2, 'EEE142', 502, 'Present'),
('2021-05-26 00:00:00', 181, 2, 'EEE142', 502, 'Absent'),
('2021-05-11 00:00:00', 191, 1, 'CSE 311', 501, 'Present'),
('2006-05-01 00:00:00', 11, 1, 'CSE 311', 501, 'Late');

-- --------------------------------------------------------

--
-- Table structure for table `course_information`
--

CREATE TABLE `course_information` (
  `Course_Id` tinyint(4) NOT NULL,
  `Course_Initial` varchar(10) NOT NULL,
  `Course_Name` varchar(45) NOT NULL,
  `Semester` enum('Spring','Summer','Fall') NOT NULL,
  `Year` year(4) NOT NULL,
  `Section` tinyint(4) NOT NULL,
  `Faculty_Id` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course_information`
--

INSERT INTO `course_information` (`Course_Id`, `Course_Initial`, `Course_Name`, `Semester`, `Year`, `Section`, `Faculty_Id`) VALUES
(1, 'CSE 311', 'Database', 'Spring', 2020, 1, 501),
(2, 'EEE142', 'Electronics', 'Spring', 2021, 3, 502),
(4, 'EEE154', 'klk', 'Summer', 2021, 1, 502),
(5, 'ddlj', 'uuyy', 'Spring', 2021, 5, 501),
(6, 'iiuu', 'scd', 'Summer', 2019, 7, 501),
(6, 'jhyui', 'vfv', 'Fall', 2021, 7, 501),
(9, 'ty', 'uu', 'Fall', 2021, 2, 502),
(10, 'tyt', 'uu', 'Spring', 2021, 2, 502),
(78, 'pp', 'pp', 'Spring', 2021, 5, 501),
(91, 'ii', 'scdi', 'Summer', 2019, 7, 501),
(100, 'iiuui', 'scd', 'Summer', 2019, 7, 501),
(102, 'iii', 'scdi', 'Summer', 2019, 7, 501);

-- --------------------------------------------------------

--
-- Table structure for table `faculty_information`
--

CREATE TABLE `faculty_information` (
  `Faculty_Id` mediumint(9) NOT NULL,
  `Faculty_Name` varchar(45) NOT NULL,
  `Department` varchar(25) NOT NULL,
  `Mobile_No` char(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `User_Id` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faculty_information`
--

INSERT INTO `faculty_information` (`Faculty_Id`, `Faculty_Name`, `Department`, `Mobile_No`, `Email`, `User_Id`) VALUES
(501, 'ahmed', 'cse', '01711287550', 'ahmed@gmail.com', 501),
(502, 'ABH3', 'CSE', '01711287550', 'abh@gmail.com', 502);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `Message` varchar(500) NOT NULL,
  `Course_Id` tinyint(4) NOT NULL,
  `Faculty_Id` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`Message`, `Course_Id`, `Faculty_Id`) VALUES
('Hi .. How are you?', 1, 501);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Student_Id` mediumint(9) NOT NULL,
  `First_Name` varchar(45) NOT NULL,
  `Last_Name` varchar(45) NOT NULL,
  `Street_Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Postal_Code` char(4) NOT NULL,
  `Mobile_No` char(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `User_Id` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Student_Id`, `First_Name`, `Last_Name`, `Street_Address`, `City`, `Postal_Code`, `Mobile_No`, `Email`, `User_Id`) VALUES
(11, 'Majid', 'Ullah', '123', 'Dhaka', '1208', '01711287550', 'ullah@gmail.com', 11),
(181, 'dddd', 'eeee', 'dd', 'df', '108', '01412', 'asd', 181),
(191, 'Akmam', 'Hasan', 'dsd', 'dhk', '1208', '01711287550', 'ak@gmail.com', 191);

-- --------------------------------------------------------

--
-- Table structure for table `student_has_course_information`
--

CREATE TABLE `student_has_course_information` (
  `Student_Id` mediumint(9) NOT NULL,
  `Course_Id` tinyint(4) NOT NULL,
  `Course_Initial` varchar(10) NOT NULL,
  `Faculty_Id` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_has_course_information`
--

INSERT INTO `student_has_course_information` (`Student_Id`, `Course_Id`, `Course_Initial`, `Faculty_Id`) VALUES
(11, 1, 'CSE 311', 502),
(181, 1, 'CSE 311', 501),
(181, 2, 'EEE142', 502),
(191, 1, 'CSE 311', 501),
(191, 2, 'EEE142', 502);

-- --------------------------------------------------------

--
-- Table structure for table `user_information`
--

CREATE TABLE `user_information` (
  `User_Id` mediumint(9) NOT NULL,
  `User_Password` varchar(30) NOT NULL,
  `Role` enum('Student','Faculty','Administrator') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_information`
--

INSERT INTO `user_information` (`User_Id`, `User_Password`, `Role`) VALUES
(2, '12345', 'Administrator'),
(3, '12345', 'Administrator'),
(11, '123456', 'Student'),
(181, '123456', 'Student'),
(191, '1234', 'Student'),
(501, '123456789', 'Faculty'),
(502, '123456', 'Faculty'),
(1924, '123456', 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`Administrator_Id`),
  ADD KEY `s3` (`User_Id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD KEY `attendance_ibfk_2` (`Faculty_Id`),
  ADD KEY `attendance_ibfk_3` (`Student_Id`),
  ADD KEY `attendance_ibfk_4` (`Course_Id`),
  ADD KEY `attendance_ibfk_5` (`Course_Initial`);

--
-- Indexes for table `course_information`
--
ALTER TABLE `course_information`
  ADD PRIMARY KEY (`Course_Id`,`Course_Initial`),
  ADD UNIQUE KEY `Course_Initial` (`Course_Initial`),
  ADD KEY `Faculty_Id` (`Faculty_Id`);

--
-- Indexes for table `faculty_information`
--
ALTER TABLE `faculty_information`
  ADD PRIMARY KEY (`Faculty_Id`),
  ADD KEY `ss2` (`User_Id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD KEY `message_ibfk_1` (`Course_Id`),
  ADD KEY `message_ibfk_2` (`Faculty_Id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Student_Id`),
  ADD KEY `ss1` (`User_Id`);

--
-- Indexes for table `student_has_course_information`
--
ALTER TABLE `student_has_course_information`
  ADD PRIMARY KEY (`Student_Id`,`Course_Id`,`Course_Initial`,`Faculty_Id`),
  ADD KEY `c2` (`Course_Id`),
  ADD KEY `c3` (`Course_Initial`),
  ADD KEY `c4` (`Faculty_Id`);

--
-- Indexes for table `user_information`
--
ALTER TABLE `user_information`
  ADD PRIMARY KEY (`User_Id`),
  ADD UNIQUE KEY `User_Id` (`User_Id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `s3` FOREIGN KEY (`User_Id`) REFERENCES `user_information` (`User_Id`);

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`Faculty_Id`) REFERENCES `student_has_course_information` (`Faculty_Id`),
  ADD CONSTRAINT `attendance_ibfk_3` FOREIGN KEY (`Student_Id`) REFERENCES `student_has_course_information` (`Student_Id`),
  ADD CONSTRAINT `attendance_ibfk_4` FOREIGN KEY (`Course_Id`) REFERENCES `student_has_course_information` (`Course_Id`),
  ADD CONSTRAINT `attendance_ibfk_5` FOREIGN KEY (`Course_Initial`) REFERENCES `student_has_course_information` (`Course_Initial`);

--
-- Constraints for table `course_information`
--
ALTER TABLE `course_information`
  ADD CONSTRAINT `course_information_ibfk_1` FOREIGN KEY (`Faculty_Id`) REFERENCES `faculty_information` (`Faculty_Id`);

--
-- Constraints for table `faculty_information`
--
ALTER TABLE `faculty_information`
  ADD CONSTRAINT `ss2` FOREIGN KEY (`User_Id`) REFERENCES `user_information` (`User_Id`);

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`Course_Id`) REFERENCES `course_information` (`Course_Id`),
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`Faculty_Id`) REFERENCES `course_information` (`Faculty_Id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `ss1` FOREIGN KEY (`User_Id`) REFERENCES `user_information` (`User_Id`);

--
-- Constraints for table `student_has_course_information`
--
ALTER TABLE `student_has_course_information`
  ADD CONSTRAINT `c1` FOREIGN KEY (`Student_Id`) REFERENCES `student` (`Student_Id`),
  ADD CONSTRAINT `c2` FOREIGN KEY (`Course_Id`) REFERENCES `course_information` (`Course_Id`),
  ADD CONSTRAINT `c3` FOREIGN KEY (`Course_Initial`) REFERENCES `course_information` (`Course_Initial`),
  ADD CONSTRAINT `c4` FOREIGN KEY (`Faculty_Id`) REFERENCES `course_information` (`Faculty_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
