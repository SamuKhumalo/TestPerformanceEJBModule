# Test Performance EJB Module

This is an EJB (Enterprise JavaBeans) module project for testing performance, developed in NetBeans.

## Project Structure

The project contains the following key components:

- **Entities**: 
  - `Student.java` - Entity class representing student data
- **Facades**:
  - `AbstractFacade.java` - Base facade class
  - `StudentFacade.java` - Student-specific facade implementation
  - `StudentFacadeLocal.java` - Local interface for Student facade
- **Configuration**:
  - `persistence.xml` - JPA persistence configuration
  - `MANIFEST.MF` - Deployment descriptor

## Getting Started

### Prerequisites
- Java JDK (version 8 or higher recommended)
- NetBeans IDE (with Java EE support)
- Application Server (GlassFish, WildFly, etc.)
- Maven (if using Maven build)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/SamuKhumalo/TestPerformanceEJBModule.git
