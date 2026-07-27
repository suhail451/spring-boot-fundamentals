# Spring Boot Fundamentals — Practice Project

A Spring Boot project built from scratch to reinforce core backend concepts, step by step — CRUD, REST API design, DTOs, global exception handling, and custom filters. Built as a hands-on learning exercise alongside my main portfolio projects ([Auth_Vault](https://github.com/suhail451), [Lock Manager](https://github.com/suhail451)).

## Why this project exists

Rather than passively reviewing concepts, this repo is my way of re-implementing core Spring Boot backend patterns from zero, one deliberate phase at a time — treating each addition as its own milestone before moving to the next.

## Progress

- ✅ **CRUD** — Full Create, Read, Update, Delete for a `Student` resource
- ✅ **API Contract** — Proper REST naming conventions, correct HTTP status codes (`201`, `200`, `204`), input validation with `@Valid`
- ✅ **DTOs** — Separate `RequestDTO` / `ResponseDTO` to decouple the API contract from the database entity
- ✅ **Global Exception Handling** — Custom exceptions (`StudentNotFound`, `NameAlreadyExist`, `DuplicateUpdate`) handled centrally via `@RestControllerAdvice`, including clean validation error responses
- ✅ **Custom Filters** — Request ID tagging, header inspection, and response time logging implemented via the servlet `Filter` chain
- 🔜 **Spring Security + JWT** — Authentication and authorization (in progress)

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Jakarta Validation
- Maven

## Key Concepts Practiced

- REST API design principles (resource naming, status codes, contract separation)
- DTO pattern for request/response decoupling
- Centralized exception handling with `@RestControllerAdvice`
- Custom `Filter` implementations (request logging, request ID injection, response timing)
- Business-rule validation (duplicate entry checks) alongside field-level validation

## Notes

This is a learning-focused repository, built incrementally and intentionally kept small in scope — the goal is depth of understanding over breadth of features.
