# printScript

printscript is a typescript-like pseudo language.

## Usage

```terminal

gradlew goJF // Google Java Format

gradle check // Checkstyle Static Code Analyzer

gradle test // Runs all tests, formatter, analyzer and then generates the reports using JaCoCo

gradlew build // Builds the projects. Calls the test task as well which in turn calls other tasks

```

## Branching Strategy

At this moment, this project is comprised of three branches:

- version_1.0: The basic version of printscript lives here. Version 1.0

- version_1.1: This is a newer version of printscript which adds support for booleans, boolean operations and if statements

- main: This is the most recent version of the project. You cannot push directly onto this branch. You should branch from this one and make a pull request. Packages will be automatically published on a succesful merge.

The branching strategy selected for this project consists of creating a new branch from main, implementing whatever changes needed and creating a new Pull Request.

When a version has been sufficiently improved to create a new release, a new release will be created in github. This event will automatically trigger a workflow which will update corresponding packages.
