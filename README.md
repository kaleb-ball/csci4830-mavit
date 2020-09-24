# csci4430-mavit
## Enviornment Setup
1. Install Git
   1. Mac
   2. Windows
2. Install NodeJS
   1. Mac
   2. Windows
3. Install NPM CLI
   1. Mac
   2. Windows
4. Install Apache Maven
   1. Windows
   2. Mac
5. Clone Mavit Repository
6. Open API in IDE
   1. IntelliJ
      1. Sele
   2. Ecplise
7. Open Client in IDE
   1. VSCode

## Running the Applictation
1. API
   1. Open terminal in IntelliJ/Ecplise
   2. Run command mvn spring-boot:run
   3. Open localhost:8080/api/test in a web browser
2. Client
   1. Open terminal in VSCode
   2. Run command npm install
   3. Run command ng serve
   4. Vist localhost:4200

## Commit Changes to GitHub

1. **Always** Checkout New Feature Branch
   1. Create a new branch
      git checkout -b feature_name
   2. Add changes to branch
   3. When the feature is finished, push branch to remote repoistory
   4. Create pull reqest on GitHub
   5. When the merge is reviewed, it will be automatically deployed to the EC2 server
