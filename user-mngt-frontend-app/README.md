# User Management App

A user management application built with Angular and Angular Material. This app allows to search users based on first name, last name and ssn also showing users data.

## Features

- To search employee on first name, last name and SSN.
- Angular Material UI components
- Responsive design
- Routing with Angular Router
- Form validation with Reactive Forms

## Prerequisites

Ensure you have the following installed before proceeding:

- [Node.js](https://nodejs.org/) (LTS version recommended)
- [Angular CLI](https://angular.io/cli)

## Installation

Clone the repository and navigate to the project directory:

```sh
git clone <repository-url>
cd user-management-app
```

Install dependencies:

```sh
npm install
```

## Running the Application

Start the development server:

```sh
ng serve
```

The app will be available at `http://localhost:4200/`.

## Build for Production

To build the project for production, run:

```sh
ng build --prod
```

The output will be in the `dist/` directory.

## Code Structure

```sh
src/
├── app/
│   ├── components/  # Reusable UI components
│   ├── core/  # service and model
│   ├── app.module.ts # Main Angular module
│   ├── app-routing.module.ts # App routing configuration
│   └── ...
├── assets/          # Static assets (icons, images, etc.)
├── environments/    # Environment-specific settings
└── ...
```

## Technologies Used

- **Angular** - Frontend framework
- **Angular Material** - UI component library
- **RxJS** - Reactive programming
- **TypeScript** - Strongly typed Typescript
- **SCSS** - Styling

## Contribution

Feel free to fork this repository and contribute improvements via pull requests.

## License

This project is licensed under the Apache-2.0 license.

