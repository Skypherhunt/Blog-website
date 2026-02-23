# Blogify - A blog website

Blogify is a blog website developed as a college group project to learn the fundamentals of web development.

<img width="1897" height="902" alt="Screenshot 2026-02-22 124919" src="https://github.com/user-attachments/assets/36f1082e-6b8b-452a-9ca7-7d358d5b279d" />

## Introduction
Blogify is a web application designed to provide users with a platform to share their thoughts and ideas through blog posts. It allows users to create, view, and manage blogs while learning the basics of web development using modern technologies.

### Tech Used:
- Spring Boot (Java)
- HTML, CSS, JavaScript
- MySQL

<img width="1902" height="1032" alt="Screenshot 2026-02-22 124853" src="https://github.com/user-attachments/assets/93a9abba-a6fd-4e89-8ded-4cec2e7f3316" />

## Features
- User authentication (login and signup)
- Create, edit, and delete blog posts
- View all blogs and individual blog posts
- Comment on blog posts
- Responsive design for better user experience

## Usage
1. Clone the repository to your local machine.
2. Set up the database using the provided schema in the `resources` folder.
3. Run the application using the Spring Boot `mvnw` or `mvnw.cmd` script.
4. Access the application at `http://localhost:8080` in your browser.

## Folder Structure
```
blogify/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── blogify/
│   │   │           ├── BlogifyApplication.java
│   │   │           ├── controller/
│   │   │           │   ├── AuthController.java
│   │   │           │   ├── BlogController.java
│   │   │           │   └── CommentController.java
│   │   │           ├── dto/
│   │   │           │   └── CommentDto.java
│   │   │           ├── model/
│   │   │           │   ├── Blog.java
│   │   │           │   ├── Comment.java
│   │   │           │   └── User.java
│   │   │           ├── repository/
│   │   │           │   ├── BlogRepository.java
│   │   │           │   ├── CommentRepository.java
│   │   │           │   └── UserRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           ├── about.html
│   │           ├── blog_post.html
│   │           ├── blogs.html
│   │           ├── index.html
│   │           ├── login.html
│   │           ├── my_blogs.html
│   │           ├── signup.html
│   │           └── write_blog.html
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── blog/
│                       └── BlogifyApplicationTests.java
└── target/
    ├── classes/
    │   ├── application.properties
    │   └── com/
    │       └── blogify/
    │           ├── controller/
    │           ├── dto/
    │           ├── model/
    │           └── repository/
    │   └── static/
    │       ├── about.html
    │       ├── blog_post.html
    │       ├── blogs.html
    │       ├── index.html
    │       ├── login.html
    │       ├── my_blogs.html
    │       ├── signup.html
    │       └── write_blog.html
    └── test-classes/
        └── com/
            └── example/
                └── blog/
```

> This project was made for learning purposes.
