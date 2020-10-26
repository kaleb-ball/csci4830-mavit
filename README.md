# csci4430-mavit
## Enviornment Setup
1. Install Git

2. Install NodeJS & NPM

3. Install Anuglar CLI

4. Install Apache Maven

5. Clone Mavit Repository
6. Open API in IDE
   1. IntelliJ
      a. Select "Open Project From Existing Sources" and open the pom.xml file in /mavit-api
      b. Enable Annotation Processing
      c. Run ``mvn clean install``
7. Open Client in IDE
   1. VSCode
   2. Run ``npm clean install``
  
8. Setup Local Database
   1. Install Docker
   2. Go to the docker directory in terminal
   3. Run ``docker-compose up`` to start local database

## Running the Applictation
1. API
   1. Open terminal in IntelliJ/Ecplise
   2. Run ``mvn spring-boot:run``
   3. Open localhost:8080/api/test in a web browser
2. Client
   1. Open terminal in VSCode
   2. Run ``npm install``
   3. Run ``ng serve``
   4. Vist localhost:4200

## Commit Changes to GitHub

1. **Always** Checkout New Feature Branch
   1. Create a new branch
      ``git checkout -b feature_name``
   2. Add changes to branch
      ``git add filename`` or ``git add .`` to add all
   3. When the feature is finished, push branch to remote repoistory
      ``git commit -m "Message"``
      ``git push remote origin``
   4. Create pull reqest on GitHub
   5. When the merge is reviewed, it will be automatically deployed to the EC2 server
