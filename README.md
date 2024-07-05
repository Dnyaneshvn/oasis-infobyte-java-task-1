# FloReal Dating App

FloReal is a dating application built with FastAPI that supports JWT-based authentication, user management, and rate limiting. The project uses SQLite for database management and Redis for caching and rate limiting.

## Technologies Used

- **FastAPI**: A modern, fast (high-performance), web framework for building APIs with Python 3.7+ based on standard Python type hints.
- **SQLAlchemy**: The Python SQL toolkit and Object Relational Mapper that gives application developers the full power and flexibility of SQL.
- **Alembic**: A lightweight database migration tool for use with SQLAlchemy.
- **Redis**: An in-memory data structure store, used as a distributed, in-memory key-value database, cache, and message broker.
- **HTTPX**: A next-generation HTTP client for Python.
- **Pytest**: A framework that makes building simple and scalable test cases easy.
- **FastAPI-Limiter**: Rate limiting for FastAPI using Redis.

## Configuration

### Environment Variables

The environment variables are managed in the `.env` file.

```env
DATABASE_URL=sqlite:///./test.db
REDIS_URL=redis://localhost:6379
SECRET_KEY=your_secret_key
OAuth Credentials
To add OAuth credentials, update the config.py file with the required OAuth configurations.

Database Setup
Using Alembic for Database Migrations
Initialize Alembic: Initialize the Alembic environment.

sh
Copy code
alembic init migrations
Edit alembic.ini: Update the sqlalchemy.url in alembic.ini to match the DATABASE_URL in .env.

Generate Migrations: Create a new migration script.

sh
Copy code
alembic revision --autogenerate -m "create users table"
Apply Migrations: Apply the migration to the database.

sh
Copy code
alembic upgrade head
Usage
Running the Application
Install Dependencies: Ensure all dependencies are installed.

sh
Copy code
pip install -r requirements.txt
Run the Application: Use uvicorn to run the FastAPI application.

sh
Copy code
uvicorn app.main:app --reload
Access the API: The application will be available at http://localhost:8000.

Running Tests
Install Dependencies: Ensure all dependencies are installed.

sh
Copy code
pip install -r requirements.txt
Run Tests: Use pytest to run the test suite.

sh
Copy code
pytest -v
API Endpoints
Authentication
POST /auth/token: Generate an access token.
GET /auth/users/me: Get the current logged-in user's information.
POST /auth/users: Create a new user.
User
GET /users/me: Retrieve the logged-in user's profile.
POST /users: Create a new user profile.
Example Requests
Create User
sh
Copy code
curl -X POST "http://localhost:8000/auth/users" -H "accept: application/json" -H "Content-Type: application/json" -d '{
  "username": "johndoe",
  "password": "secret",
  "profile_picture": "http://example.com/pic.jpg",
  "date_of_birth": "2000-01-01",
  "voice": "http://example.com/voice.mp3"
}'
Login User
sh
Copy code
curl -X POST "http://localhost:8000/auth/token" -H "accept: application/json" -H "Content-Type: application/x-www-form-urlencoded" -d 'username=johndoe&password=secret'
Get Current User
sh
Copy code
curl -X GET "http://localhost:8000/auth/users/me" -H "accept: application/json" -H "Authorization: Bearer <access_token>"
Best Practices
Environment Variables: Use environment variables to manage configuration settings.
Asynchronous Processing: Utilize FastAPI's asynchronous capabilities for I/O-bound operations.
Connection Pooling: Ensure efficient database connection management.
Caching: Use Redis for caching frequently accessed data.
Rate Limiting: Implement rate limiting to protect your application from abuse.
Monitoring and Logging: Implement structured logging and monitoring to track application performance and health.
Contribution
To contribute to this project, follow these steps:

Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes.
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature-branch).
Open a Pull Request.
