
**Find Consultant Slot**
----------

### Overview
The web application built using Spring Boot that allows users to register and find consultants. The application provides user registration functionality as clients or consultants, allowing clients to search for consultants based on their area of expertise and experience. Additionally, consultants can create slots for the upcoming week to indicate their availability.

----------
### Features

-   **User Registration**: Users can register themselves as clients or consultants with basic details like name, email, phone number, and role. Consultants provide additional details such as experience and area of expertise.
-   **Slot Creation**: Consultants can create slots for their availability in the upcoming week.
-   **Consultant Search**: Clients can search for consultants based on their area of expertise and experience.

----------
### API Endpoints

-   **Client Registration**:
    -   `POST /api/users/clients`: Register a new client with the details.
-   **Consultant Registration**:
    -   `POST /api/users/consultants`: Register a new consultant with the details.
-   **Create Slot**:
    -   `POST /api/slots/create`: Create a new slot for a consultant's availability.
-   **Consultant Search**:
    -   `GET /search`: Search for consultants based on their area of expertise and experience.

----------
### Database Structure

-   **Users Table**: Stores details of registered users.
-   **Client Table**: Stores details of registered clients.
-   **Consultant Table**: Stores details of registered consultants including additional fields for experience and area of expertise.
-   **Slot Table**: Stores slots created by consultants for their availability.

----------
### Technical Stack

-   **Backend**: Java, Spring Boot
-   **Database**: H2 (in-memory database)
-   **Testing**: JUnit, Mockito

----------
### Installation and Setup

1.  Clone the repository: `git clone https://github.com/mehuljain91/consultant-slot.git`
2.  Navigate to the project directory: `cd consultant-slot`
3.  Build the project: `mvn clean install`
4.  Run the application: `mvn spring-boot:run`

----------
### Usage

1.  Register as a client or consultant using the provided endpoints.
2.  Create slots for availability using the appropriate endpoint.
3.  Search for consultants based on area of expertise and experience.
   
