# School Management Tool

This project was created during the Server Programming course. The goal to provide a full back-end solution for a school regarding grading.

## Installation

If you want to follow the same implementation as me, you can run this project using Eclipse. After importing the project, all the dependencies will be automatically downloaded using the [pox.xml](https://github.com/palavina95/SchoolManagementTool/blob/0.1/pom.xml) file.

The java version used for this project is 1.8.

## Deployment

This app is currently running on Heroku. You can test it [here](https://schooltools.herokuapp.com).

## Roles

Here are the two roles within the app (username/password) :
- admin/admin
- user/user

## Usage

When you first arrive on the app, you are asked to log in. 
ATTENTION! There is still a bug that will occur on the first time you log in. You need to go back and enter the credential again.

### Admin

If you log in as an admin, you will have access to all the courses. You are able to create, modify and delete every course. In addition, you are able to "manage" a course, you can grade the students who enrol for this course.

### User

If you log as a user, you will have access to all the students. You are able to create, modify and delete every student. In addition, you are able to "manage" a student, you can choose the courses a student will apply for. You can also see the grades of the student. If a course has been graded, you can't unenroll, but it hasn't you can.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Author
Vivian Bridy