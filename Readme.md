<p align="center">
  <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" alt="project-logo">
</p>
<p align="center">
    <h1 align="center">ELEVATOR_MULTITHREADING</h1>
</p>
<p align="center">
    <em>The multi-floor multi-elevator system</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/commit-activity/m/sharanreddy99/elevator_multithreading" alt="last-commit">
	<img src="https://img.shields.io/github/created-at/sharanreddy99/elevator_multithreading" alt="created_at">
   <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/sharanreddy99/elevator_multithreading">
   <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/sharanreddy99/elevator_multithreading">
   <img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/sharanreddy99/elevator_multithreading">

</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>

<br><!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary><br>

- [ Overview](#-overview)
- [ Features](#-features)
- [ Repository Structure](#-repository-structure)
- [ Modules](#-modules)
- [ Getting Started](#-getting-started)
  - [ Installation](#-installation)
  - [ Usage](#-usage)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
</details>
<hr>

##  Overview

The elevator_multithreading project is a sophisticated software system designed to efficiently manage elevator operations in a multi-threaded environment. It encompasses a robust backend API service that coordinates elevator movements, lift requests, and user interactions. The frontend UI component enhances user experience by providing real-time elevator status updates, control functionalities, and visual representations of the elevator system. Leveraging Docker for containerization and Spring Boot for backend services, this project streamlines elevator management, optimizing passenger pickups, and ensuring smooth operation of elevators across multiple floors.

---

##  Features

|    |   Feature         | Description |
|----|-------------------|---------------------------------------------------------------|
| ⚙️  | **Architecture**  | The project follows a microservices architecture using Spring Boot for the elevator REST API service and React for the UI. It leverages multi-threading for elevator operations. The docker-compose setup facilitates communication between backend, frontend, and NGINX services. |
| 🔩 | **Code Quality**  | The codebase maintains good quality standards with proper code structuring, naming conventions, and adherence to best practices. It includes unit tests for critical components ensuring code reliability and maintainability. |
| 📄 | **Documentation** | The repository contains detailed documentation explaining the project structure, key components, and their functionalities. Comments within the codebase provide insights into the logic behind different modules and classes. README.md guides users on setup and usage. |
| 🔌 | **Integrations**  | External dependencies include libraries like Material-UI for UI components and Axios for API calls. It integrates NGINX for routing and load balancing. Docker and docker-compose manage container environments and service orchestration. |
| 🧩 | **Modularity**    | The codebase demonstrates good modularity with distinct modules for elevator system components like Elevator, Dispatcher, and Manager. Each module encapsulates specific functionalities, promoting code reusability and easier maintenance. |
| 🧪 | **Testing**       | The project includes testing frameworks like Jest and Testing Library for unit and integration testing. Tests verify the functionality of key components such as API controllers and UI interactions, ensuring robust code behavior. |
| ⚡️  | **Performance**   | The multi-threaded design enhances efficiency, enabling the system to handle multiple requests concurrently. Synchronized methods manage shared resources effectively. NGINX load balancing optimizes traffic distribution, enhancing overall performance. |
| 🛡️ | **Security**      | Security measures such as environment variable management, secure API endpoints, and NGINX reverse proxy setup enhance data protection. Access control mechanisms ensure authorized interactions between components. |
| 📦 | **Dependencies**  | Key dependencies include Spring Boot, React, Material-UI, Axios, NGINX, Node.js, and Eclipse Temurin. These libraries enable development and runtime functionalities, contributing to the project's feature set. |

---

##  Repository Structure

```sh
└── elevator_multithreading/
    ├── Main.class
    ├── Readme.md
    ├── docker-compose.yml
    ├── elevator-ui
    │   ├── .env
    │   ├── .gitignore
    │   ├── Dockerfile
    │   ├── README.md
    │   ├── package-lock.json
    │   ├── package.json
    │   ├── public
    │   ├── src
    │   └── start.sh
    ├── elevatorrestapp
    │   ├── .gitignore
    │   ├── .mvn
    │   ├── Dockerfile
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src
    └── nginx
        ├── Dockerfile
        └── default.conf
```

---

##  Modules

<details closed><summary>.</summary>

| File                                                                                                              | Summary                                                                                                                                                                                                                                                                                           |
| ---                                                                                                               | ---                                                                                                                                                                                                                                                                                               |
| [docker-compose.yml](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/docker-compose.yml) | Defines services for backend API, UI, and nginx in Docker Compose. Links elevatorrestapp and elevator-ui directories. Sets up ports for backend, frontend, and nginx. Facilitates communication between services, ensuring app functionality in the elevator_multithreading repository structure. |

</details>

<details closed><summary>elevatorrestapp</summary>

| File                                                                                                              | Summary                                                                                                                                                                                                                                   |
| ---                                                                                                               | ---                                                                                                                                                                                                                                       |
| [Dockerfile](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/Dockerfile) | Run` command upon container startup.                                                                                                                                                                                                      |
| [mvnw](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/mvnw)             | Enables Maven to dynamically download dependencies for the project, ensuring the presence of necessary binaries. Supports efficient project setup and execution by managing dependencies automatically based on specified configurations. |
| [mvnw.cmd](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/mvnw.cmd)     | Manages Maven setup and project base directory detection for the elevatorrestapp project. Downloads maven-wrapper.jar if missing to simplify project setup and dependencies management for developers.                                    |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp</summary>

| File                                                                                                                                                                                                      | Summary                                                                                                                                                                                                        |
| ---                                                                                                                                                                                                       | ---                                                                                                                                                                                                            |
| [APIController.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/APIController.java)                           | Handles building initialization, lift retrieval, lift request, and lift movement actions by interacting with the Elevator Multithreading system. Provides REST API endpoints for managing elevator operations. |
| [API.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/API.java)                                               | API record stores ID and content. Fits parent repository architecture by facilitating communication between elevator UI and backend services, enhancing system functionality.                                  |
| [ElevatorrestappApplication.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/ElevatorrestappApplication.java) | Launches Spring Boot application for elevator REST API service.                                                                                                                                                |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.Building</summary>

| File                                                                                                                                                                           | Summary                                                                                                                                                                                                                                                                         |
| ---                                                                                                                                                                            | ---                                                                                                                                                                                                                                                                             |
| [Building.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/Building/Building.java) | Coordinates elevator system interactions with multiple floors and elevators, managing lift requests, displays, and movements. Initializes displays and elevator managers, handles lift requests, shows elevator statuses, and directs elevators to specific floors efficiently. |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.Display</summary>

| File                                                                                                                                                                        | Summary                                                                                                                                                                                                                                                                                              |
| ---                                                                                                                                                                         | ---                                                                                                                                                                                                                                                                                                  |
| [Display.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/Display/Display.java) | Defines Display class modeling elevator state for UI. Implements showDisplay to print current status and getDisplay to return state. setDisplay updates state based on direction, floor, and boarding status. Complements elevatorrestapps UI functionalities in the parent repository architecture. |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.Elevator</summary>

| File                                                                                                                                                                           | Summary                                                                                                                                                                                                       |
| ---                                                                                                                                                                            | ---                                                                                                                                                                                                           |
| [Elevator.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/Elevator/Elevator.java) | Manages elevator movements, floor tracking, and direction changes based on queued requests. Updates display with current position. Implement synchronized methods for producing and consuming floor requests. |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.InternalElevatorDispatcher</summary>

| File                                                                                                                                                                                                                                           | Summary                                                                                                                                                                               |
| ---                                                                                                                                                                                                                                            | ---                                                                                                                                                                                   |
| [BasicInternalElevatorDispatcher.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/InternalElevatorDispatcher/BasicInternalElevatorDispatcher.java) | Facilitates elevator request submission by dispatching to appropriate elevator managers based on floor and ID. Enhances elevator functionality in the parent repository architecture. |
| [InternalElevatorDispatcher.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/InternalElevatorDispatcher/InternalElevatorDispatcher.java)           | Manages elevator dispatching logic across multiple ElevatorManagers in the ElevatorRestApp, enabling dynamic request submission based on floor and elevator ID.                       |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.ElevatorManager</summary>

| File                                                                                                                                                                                                | Summary                                                                                                                                                                             |
| ---                                                                                                                                                                                                 | ---                                                                                                                                                                                 |
| [ElevatorManager.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/ElevatorManager/ElevatorManager.java) | Manages elevator operations by handling requests, tracking current floor and direction, and running elevator logic for efficient performance within the Elevator Manager subsystem. |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.ElevatorManager.Direction</summary>

| File                                                                                                                                                                                              | Summary                                                                                                                                                                   |
| ---                                                                                                                                                                                               | ---                                                                                                                                                                       |
| [Direction.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/ElevatorManager/Direction/Direction.java) | NONE, UP, DOWN. Crucial for managing elevator movement and efficiently handling user requests within the elevator management system architecture in its relevant context. |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.Types</summary>

| File                                                                                                                                                                                      | Summary                                                                                                                                                                                                                         |
| ---                                                                                                                                                                                       | ---                                                                                                                                                                                                                             |
| [DisplayType.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/Types/DisplayType.java)         | Floor, direction, elevator number, boarding status. Handles setting and getting these attributes to represent elevator movements and status visually. Contributing to the UI functionality in the elevator system architecture. |
| [RequestLiftType.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/Types/RequestLiftType.java) | Defines request lift type for elevator system with floor, direction, and status attributes. Maps direction to UP or DOWN enums. Integrated into Elevator Rest App for efficient elevator management.                            |
| [BuildingType.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/Types/BuildingType.java)       | Number of floors, elevators, lift speed, and status. Key for elevator system functionality within the repositorys architecture.                                                                                                 |
| [MoveLiftType.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/Types/MoveLiftType.java)       | Defines elevator movement types with floor, elevator, and status attributes. Crucial for managing elevator operations efficiently in the Elevator Multithreading repositorys architecture.                                      |

</details>

<details closed><summary>elevatorrestapp.src.main.java.com.sharankonda.elevatorrestapp.ExternalElevatorDispatcher</summary>

| File                                                                                                                                                                                                                                           | Summary                                                                                                                                                                                                                                   |
| ---                                                                                                                                                                                                                                            | ---                                                                                                                                                                                                                                       |
| [ExternalElevatorDispatcher.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/ExternalElevatorDispatcher/ExternalElevatorDispatcher.java)           | Defines an abstract class for external elevator dispatching, coordinating with ElevatorManager to handle elevator requests efficiently within the elevatorrestapp module of the repository.                                               |
| [BasicExternalElevatorDispatcher.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/main/java/com/sharankonda/elevatorrestapp/ExternalElevatorDispatcher/BasicExternalElevatorDispatcher.java) | Implements elevator request dispatch logic based on elevator availability, proximity, and direction. Initiates request allocation to closest idle or in-transit elevators, optimizing passenger pickups/drop-offs in the elevator system. |

</details>

<details closed><summary>elevatorrestapp.src.test.java.com.sharankonda.elevatorrestapp</summary>

| File                                                                                                                                                                                                                | Summary                                                                                                                                                                                                                                |
| ---                                                                                                                                                                                                                 | ---                                                                                                                                                                                                                                    |
| [ElevatorrestappApplicationTests.java](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevatorrestapp/src/test/java/com/sharankonda/elevatorrestapp/ElevatorrestappApplicationTests.java) | Verifies Spring Boot application functionality with a test for context loading in the elevatorrestapp. The ElevatorrestappApplicationTests.java ensures proper application setup and execution in the parent repositorys architecture. |

</details>

<details closed><summary>nginx</summary>

| File                                                                                                        | Summary                                                                                                                                                                                                                                |
| ---                                                                                                         | ---                                                                                                                                                                                                                                    |
| [Dockerfile](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/nginx/Dockerfile)     | Implements NGINX server configuration with default.conf file for the Elevator Multithreading project. Facilitates routing and load balancing for the elevator user interface and RESTful API components.                               |
| [default.conf](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/nginx/default.conf) | Defines reverse proxy rules for the parent repository architecture. Redirects incoming traffic to backend services on specified ports. Enables seamless communication between the API and UI components in the dockerized environment. |

</details>

<details closed><summary>elevator-ui</summary>

| File                                                                                                                        | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| ---                                                                                                                         | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [package-lock.json](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/package-lock.json) | The code file `Main.class` within the `elevator_multithreading` repository serves as the entry point for the elevator control system. It orchestrates the multi-threaded functionality of the elevators, enabling them to efficiently handle concurrent requests while maintaining synchronization and ensuring smooth operation. This critical component interfaces with the UI and REST API parts of the application to coordinate elevator movements and status updates in a real-time, responsive manner. |
| [Dockerfile](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/Dockerfile)               | Sets up Node.js environment, installs dependencies, configures port, and specifies startup command for the elevator UI application within the repository structure.                                                                                                                                                                                                                                                                                                                                           |
| [start.sh](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/start.sh)                   | Enables environment variable configuration for the Elevator Multithreading UI in the repository. Facilitates linking with the backend server and initiates the UI server using npm.                                                                                                                                                                                                                                                                                                                           |
| [package.json](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/package.json)           | Defines dependencies, scripts, and configurations for the elevator-ui React application in the repository. Facilitates development and deployment processes, ensuring seamless integration with the elevator system architecture.                                                                                                                                                                                                                                                                             |
| [.env](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/.env)                           | Defines the backend host URL for the Elevator Multithreading projects UI component. This file facilitates communication between the frontend and backend components within the repositorys architecture.                                                                                                                                                                                                                                                                                                      |

</details>

<details closed><summary>elevator-ui.public</summary>

| File                                                                                                                       | Summary                                                                                                                                                                                                                                                    |
| ---                                                                                                                        | ---                                                                                                                                                                                                                                                        |
| [manifest.json](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/public/manifest.json) | Defines visual and interactive properties for the React web app, specifying icons, display behavior, and color themes. Supports seamless user experience within the elevator management systems UI component.                                              |
| [robots.txt](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/public/robots.txt)       | Defines access rules for web crawlers. Facilitates search engine optimization by specifying which pages to exclude from indexing. Complements the repositorys elevator system project, enhancing visibility and navigability of the elevator UI component. |
| [index.html](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/public/index.html)       | Defines the HTML structure for the React web application interface, including metadata and links essential for mobile and desktop app installations. Utilizes placeholders for dynamic URL replacements during build processes within the public folder.   |

</details>

<details closed><summary>elevator-ui.src</summary>

| File                                                                                                                              | Summary                                                                                                                                                                                                                            |
| ---                                                                                                                               | ---                                                                                                                                                                                                                                |
| [reportWebVitals.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/reportWebVitals.js) | Improves web performance by reporting vital metrics using web-vitals library functions. Integrated into the elevator UI for real-time monitoring and optimization.                                                                 |
| [index.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/index.js)                     | Enables rendering of React app, ensuring a performant, user-friendly interface via root element. Tracks and reports app performance metrics. Facilitates enhanced React app development experience.                                |
| [App.test.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/App.test.js)               | Tests if the App component renders learn react link correctly.                                                                                                                                                                     |
| [setupTests.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/setupTests.js)           | Enables custom jest matchers for DOM nodes in the Elevator Multithreading repositorys Elevator UI component. Enhances testing by allowing assertions like `toHaveTextContent(/react/i)`.                                           |
| [App.css](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/App.css)                       | Defines styles for UI elements such as center alignment, logo animation, header layout, and links in the Elevator Multithreading projects frontend.                                                                                |
| [App.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/App.js)                         | Renders** Dashboard UI component **within** the main App component, showcasing **the elevator systems** real-time data and functionalities. **Enables** seamless user interaction **with** the elevator system **through** the UI. |
| [index.css](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/index.css)                   | Styles the user interface for the Elevator system with a clean and modern design. Sets fonts for optimal readability and appearance, ensuring a seamless and aesthetically pleasing user experience.                               |

</details>

<details closed><summary>elevator-ui.src.Display</summary>

| File                                                                                                                      | Summary                                                                                                                                                                                                                 |
| ---                                                                                                                       | ---                                                                                                                                                                                                                     |
| [Display.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/Display/Display.js) | Enables real-time display updates for elevator status. Displays elevator ID, direction, and current floor with corresponding icons. A component in the elevator UI for visualizing elevator movements and floor status. |

</details>

<details closed><summary>elevator-ui.src.Elevator</summary>

| File                                                                                                                                       | Summary                                                                                                                                                                                                                                                          |
| ---                                                                                                                                        | ---                                                                                                                                                                                                                                                              |
| [ElevatorOutside.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/Elevator/ElevatorOutside.js) | Enables requesting elevator lifts from different floors, based on user input direction. Integrates with backend for lift requests. Displays up and down buttons for elevator control.                                                                            |
| [ElevatorInside.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/Elevator/ElevatorInside.js)   | Enables interactive control of elevators movement and destination selection. Facilitates real-time communication with the backend to initiate elevator movement based on user input. Supports dynamic updating of elevator data and visualization within the UI. |

</details>

<details closed><summary>elevator-ui.src.Dashboard</summary>

| File                                                                                                                              | Summary                                                                                                                                                |
| ---                                                                                                                               | ---                                                                                                                                                    |
| [Dashboard.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/Dashboard/Dashboard.js)   | Manages building initialization and elevator status updates, interacts with backend API, and dynamically renders floor components based on user input. |
| [Dashboard.css](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/Dashboard/Dashboard.css) | Defines styling for base container in the Elevator UI dashboard to ensure responsive layout with a fixed height.                                       |

</details>

<details closed><summary>elevator-ui.src.Floor</summary>

| File                                                                                                                | Summary                                                                                                                                               |
| ---                                                                                                                 | ---                                                                                                                                                   |
| [Floor.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/Floor/Floor.js) | Generates floor components displaying elevator status and controls based on provided data. Updates visuals dynamically in the elevator simulation UI. |

</details>

<details closed><summary>elevator-ui.src.DisplayBar</summary>

| File                                                                                                                               | Summary                                                                                                                                                                                                                                                        |
| ---                                                                                                                                | ---                                                                                                                                                                                                                                                            |
| [DisplayBar.js](https://github.com/sharanreddy99/elevator_multithreading.git/blob/master/elevator-ui/src/DisplayBar/DisplayBar.js) | Displays a set of items in a horizontal bar layout with scrollable functionality. It leverages Material-UI components and React to showcase multiple display elements. This component integrates seamlessly with the elevator systems frontend user interface. |

</details>

---

##  Getting Started

**System Requirements:**

* **Java**: `version x.y.z`

###  Installation

<h4>From <code>source</code></h4>

> 1. Clone the elevator_multithreading repository:
>
> ```console
> $ git clone https://github.com/sharanreddy99/elevator_multithreading.git
> ```
>
> 2. Change to the project directory:
> ```console
> $ cd elevator_multithreading
> ```
>
> 3. Run the project using docker compose
> ```console
> $ docker compose up
> ```

###  Usage


> Access the application in the browser at http://localhost

---
##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/sharanreddy99/elevator_multithreading.git/issues)**: Submit bugs found or log feature requests for the `elevator_multithreading` project.
- **[Submit Pull Requests](https://github.com/sharanreddy99/elevator_multithreading.git/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/sharanreddy99/elevator_multithreading.git/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/sharanreddy99/elevator_multithreading.git
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="center">
   <a href="https://github.com/sharanreddy99/elevator_multithreading.git/graphs/contributors">
      <img src="https://contrib.rocks/image?repo=sharanreddy99/elevator_multithreading">
   </a>
</p>
</details>

---
