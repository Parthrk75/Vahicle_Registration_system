# Vehicle Management System

This project is a Spring Boot-based REST API for managing vehicle owners and their vehicles. It provides functionalities for adding, retrieving, updating, and deleting owners and vehicles, as well as associating vehicles with specific owners.

## Project Structure

### Controllers
1. **OwnerController**: Handles operations related to vehicle owners, including CRUD operations, and retrieving vehicles associated with a specific owner.
2. **VehicleController**: Manages operations related to vehicles, including CRUD operations and associating vehicles with owners.

### Service Layer
Contains the business logic for owners and vehicles.

### Entity Layer
Defines the data models (Owner and Vehicle) that map to the database.

### Repository Layer
Handles data persistence and retrieval for the entities.

## Prerequisites

Before running this project, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 11 or higher.
2. **Maven**: For building and managing dependencies.
3. **MySQL Database**: Or any other database configured in the application.
4. **Postman** (optional): For testing the API endpoints.

## Running the Project

1. Clone the repository.
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory and build the project.
   ```bash
   mvn clean install
   ```

3. Update the `application.properties` file with your database credentials.

4. Run the application.
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Owner Endpoints

#### Base URL
All endpoints are prefixed with `/owner`.

#### Get All Owners
- **URL**: `GET /`
- **Description**: Retrieves a paginated and sorted list of all owners.
- **Parameters**:
  - `page` (QueryParam): Page number (default: 0).
  - `size` (QueryParam): Page size (default: 10).
  - `sortBy` (QueryParam): Field to sort by (default: `name`).
- **Response**: Paginated list of `Owner` objects.

#### Get Owner by ID
- **URL**: `GET /{id}`
- **Description**: Retrieves a specific owner by their ID.
- **Parameters**:
  - `id` (PathVariable): The ID of the owner.
- **Response**: Single `Owner` object.

#### Add New Owner
- **URL**: `POST /addowner`
- **Description**: Adds a new owner.
- **Request Body**:
  - `Owner` object containing owner details.
- **Response**: The newly created `Owner` object.

#### Update Owner
- **URL**: `PUT /updateowner/{id}`
- **Description**: Updates an existing owner.
- **Parameters**:
  - `id` (PathVariable): The ID of the owner to update.
- **Request Body**:
  - `Owner` object containing updated details.
- **Response**: The updated `Owner` object.

#### Delete Owner
- **URL**: `DELETE /delete/{id}`
- **Description**: Deletes an owner by their ID.
- **Parameters**:
  - `id` (PathVariable): The ID of the owner to delete.
- **Response**: No content.

#### Get Vehicles by Owner
- **URL**: `GET /{id}/vehicles`
- **Description**: Retrieves all vehicles associated with a specific owner.
- **Parameters**:
  - `id` (PathVariable): The ID of the owner.
- **Response**: List of `Vehicle` objects.

### Vehicle Endpoints

#### Base URL
All endpoints are prefixed with `/owners/{ownerId}/vehicles`.

#### Get All Vehicles for an Owner
- **URL**: `GET /`
- **Description**: Retrieves all vehicles associated with a specific owner.
- **Parameters**:
  - `ownerId` (PathVariable): The ID of the owner.
- **Response**: List of `Vehicle` objects.

#### Add New Vehicle
- **URL**: `POST /addvehicle`
- **Description**: Adds a new vehicle for a specific owner.
- **Parameters**:
  - `ownerId` (PathVariable): The ID of the owner.
- **Request Body**:
  - `Vehicle` object containing vehicle details.
- **Response**: The newly created `Vehicle` object.

#### Update Vehicle
- **URL**: `PUT /updatevehicle/{vehicleId}`
- **Description**: Updates an existing vehicle.
- **Parameters**:
  - `vehicleId` (PathVariable): The ID of the vehicle to update.
- **Request Body**:
  - `Vehicle` object containing updated details.
- **Response**: The updated `Vehicle` object.

#### Delete Vehicle
- **URL**: `DELETE /delete/{id}`
- **Description**: Deletes a vehicle by its ID.
- **Parameters**:
  - `id` (PathVariable): The ID of the vehicle to delete.
- **Response**: No content.

## Example `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vehiclemanagementdb
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

## Testing the API

1. Use Postman or any API testing tool to test the endpoints.
2. Ensure the database is running and properly configured.
3. Test each endpoint using the appropriate HTTP method and request body/parameters.

## Future Enhancements

1. Add user authentication and role-based access control.
2. Implement pagination and sorting for retrieving vehicles.
3. Add validations for request payloads.
4. Enhance error handling and logging.
