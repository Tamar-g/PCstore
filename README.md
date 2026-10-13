# PCstore — Computer Store Management System

A Java desktop application for managing a computer store's customers, product catalog, and purchase orders. The project demonstrates object-oriented programming, GUI development, separation of concerns, and basic data persistence.

## Overview

PCstore provides a graphical interface for managing the main operations of a computer store. Users can maintain customer records, manage hardware and software products, create purchase orders, and review customer purchases.

The application is built in Java using Swing for the graphical user interface and a dedicated backend component for managing application data.

## Features

- **Customer Management** — Add and maintain customer information, including ID, name, and address.
- **Product Catalog** — Add, view, and remove products from the catalog.
- **Product Modeling** — Represent hardware and software products using specialized classes that inherit from a common abstract `Product` class.
- **Order Management** — Create purchase orders, select customers and products, and manage order contents.
- **Price Calculation** — Calculate the total cost of selected products.
- **Purchase History** — View products purchased by a selected customer.
- **Data Persistence** — Serialize customer, product, and purchase-order collections to a local file.

## Technologies

- **Language:** Java
- **GUI:** Java Swing
- **Core Concepts:** Object-Oriented Programming (OOP), Inheritance, Abstraction, Interfaces, Collections, Serialization
- **Development Environment:** IntelliJ IDEA project structure

## Architecture

The source code is organized into three main packages:

### `model`
Contains the application's domain classes:

- `Customer` — Customer information.
- `Product` — Abstract base class for products.
- `HardwareProduct` — Hardware-specific product representation.
- `SoftwareProduct` — Software-specific product representation.
- `ProductType` — Enumeration of product categories.
- `PurchaseOrder` — Represents a customer's order and its products.

### `controller`
Contains the backend logic:

- `Backend` — Defines the operations supported by the application.
- `Backend_DAO_List` — Implements customer, product, and order management using Java collections, with file-based serialization for persistence.

### `gui`
Contains the Swing forms used to interact with the system, including customer management, catalog management, order creation, and purchase viewing.

## Object-Oriented Design

The project applies several object-oriented programming principles:

- **Abstraction:** `Product` defines a common base for different product types.
- **Inheritance:** `HardwareProduct` and `SoftwareProduct` extend `Product`.
- **Polymorphism:** Product-specific classes implement behavior through a shared interface.
- **Encapsulation:** Domain classes expose getters and setters for their data.
- **Interfaces:** The `Backend` interface separates the application's backend contract from its implementation.

## Running the Application

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Ensure a compatible Java Development Kit (JDK) is configured.
4. Locate `gui.StoreManagerGUIViewForm`.
5. Run its `main` method to launch the application.

The application stores its data in a local file named `data`. A valid initialized data file may be required for startup because the application attempts to load persisted data when its main window opens.

## Project Structure

```text
PCstore/
└── src/
    ├── controller/
    │   ├── Backend.java
    │   └── Backend_DAO_List.java
    ├── gui/
    │   ├── AddCustomer.java
    │   ├── AddNewProductForm.java
    │   ├── ManageCatalogForm.java
    │   ├── PlaceOrderForm.java
    │   ├── StoreManagerGUIViewForm.java
    │   └── ViewPurchasesForm.java
    ├── model/
    │   ├── Customer.java
    │   ├── HardwareProduct.java
    │   ├── Product.java
    │   ├── ProductType.java
    │   ├── PurchaseOrder.java
    │   └── SoftwareProduct.java
    └── Main.java
```

## Purpose

PCstore is a software engineering project focused on building a functional desktop application with a graphical interface, structured domain models, backend operations, and basic persistence. It demonstrates the application of Java and object-oriented design concepts in a practical management system.
