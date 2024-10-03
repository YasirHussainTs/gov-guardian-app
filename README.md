# GovGuardianApp

**GovGuardianApp** is a full-stack product designed to fight corruption and protect the nation from bribery within government offices. This application empowers citizens to report bribe-related activities while enabling government bodies to track, manage, and act on corruption cases efficiently. Built with modern technologies like JHipster, OpenAPI for Spring Boot, Flutter, Docker, and Grafana, it provides a robust and user-friendly solution to tackle bribery in public offices.

## Project Overview

The **GovGuardianApp** is a groundbreaking application aimed at reducing bribery and corruption in government offices. It combines powerful backend capabilities with sleek Flutter-based UIs, making it intuitive for users to report suspicious activities. This full-stack application is built using **JHipster** for scaffolding, **OpenAPI** for the Spring Boot back end, and **Flutter** for mobile and web front-end development. The app is also containerized using **Docker** and integrates **Grafana** for monitoring system performance.

## Key Features

- **Bribe Reporting System**:
  - Citizens can report cases of bribery anonymously or with credentials.
  
- **Tracking and Monitoring**:
  - Government offices can track reported cases, monitor patterns, and take appropriate actions.

- **CRUD Operations**:
  - Easily manage case reports, officer records, and action statuses via standard create, read, update, and delete functionalities.

- **Modern UI/UX**:
  - Flutter provides a highly interactive and responsive user interface for both mobile and web users.

- **API Integration**:
  - Built using **OpenAPI**, it provides well-documented REST APIs for smooth integration with third-party services.

- **Docker**:
  - The app is fully containerized for easy deployment across different environments using Docker.

- **Grafana Integration**:
  - Real-time monitoring and visualizations of system metrics via Grafana, ensuring optimal performance.

## Architecture and Technology Stack

- **Frontend**: 
  - Developed using **Flutter** for mobile and web applications.
  
- **Backend**:
  - Powered by **Spring Boot** with **OpenAPI** for seamless API management and documentation.

- **DevOps**:
  - **Docker** is used to containerize the application for deployment.
  - **Grafana** monitors system metrics and provides real-time insights into app performance.

- **JHipster**:
  - Used for rapid development and scaffolding of the application, ensuring a smooth full-stack integration between the front-end and back-end services.

## Features and Functionality

### Citizen Reporting Module

1. **Report a Bribe**:
   - Citizens can submit a detailed report on bribery cases directly from the Flutter-based app.
   - The report can include descriptions, office details, and any evidence.

2. **Track Case Status**:
   - Government officials and citizens (with access) can track the status of reported bribery cases.

### Admin and Government Office Features

1. **Case Management**:
   - Admin users can create, view, update, and delete case records.
   - Assign government officers to investigate reported cases.

2. **Officer Records**:
   - Keep a record of officers handling cases, including case progress and actions taken.

3. **Bribe Statistics Dashboard**:
   - View detailed dashboards with statistics on bribe cases, reports by region, and office performance.
   - **Grafana** integration allows real-time monitoring of system data.

### Features

- **Citizen Reports**: Create, read, update, and delete bribery reports.
- **Officer Management**: Manage government officers responsible for handling cases.
- **Case Management**: Oversee the life cycle of bribery cases from report to resolution.
