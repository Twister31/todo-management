# Todo-management

# Description

This project provides a REST API for managing TODO tasks. It enables users to interact with their tasks by performing operations such as:

- Creating new tasks
- Retrieving specific tasks or all tasks
- Updating existing tasks
- Deleting tasks
- Marking tasks as completed or incomplete

The system implements a role-based access control mechanism to ensure security. There are two primary roles:

- Administrator: Administrators have full permissions, including creating, updating, and deleting tasks.
- User: Users can perform most operations but are restricted from certain administrative actions.

# Stack

- Spring Boot: A framework that simplifies the creation of standalone, production-grade Spring-based applications.
- Spring Security: A framework for securing Spring-based applications. It provides authentication and authorization mechanisms.
- Spring Data JPA: A data access abstraction for Java Persistence API (JPA). It simplifies data access to relational databases.
- Hibernate: An object-relational mapping tool for Java. It maps Java classes to database tables.
- MySQL: A popular open-source relational database management system.
- Postman: An HTTP client used for testing the API.

# version_1.1

Adding multi-factor authentication, such as entering a username and password.

# version_1.2

In this release, we have implemented database authentication by creating user and role tables in the database and establishing a many-to-many relationship between them. This allows for a user to have multiple roles and for multiple roles to be assigned to a single user. To achieve this, we have created User and Role JPA entities, which Hibernate will then map to corresponding tables in the database.

# version_1.3

In this release, we implemented data modification and login/password input directly through the MySQL database, rather than making code changes.
