# Project One: ERS

## Project Description
This is my Project One For Revature. It is an expense reimbursement system that allows employees to create reimbursement requests for the respective managers to approve or deny.

## Technologies Used
- **Java**, *version 1.8*
- **Selenium**, *version 4.1.1*
- **JUnit**, *version 5.8.1*
- **Mockito**, *version 3.6.28*
- **Cucumber**, *version 7.2.3*
- **Javalin**, *version 4.1.1*
- **SQL**, *Postgres version 42.3.1*
- **Apache Maven**, *version 3.8.4*
- **HTML / JavaScript / CSS**
- **JDBC**

## Characteristics
This section represents the list of features that are currently present as well as the features I plan to implement in future development.

### Implemented Features
 - An employee can login with their correct credentials.
 - An employee can submit a new reimbursement.
 - An employee can review their current and previously submitted reimbursements.
 - A manager can login with their correct company-assigned incredentials.
 - A manager can view *every* current and previously submitted reimbursements.
 - A manager can approve or deny reimbursements they are previewing.
 - A manager can edit the previous decision on a resolved reimbursement.
 
 ### Features in Development
 - A manager can access a statistics page which includes the mean expenditure cost.
 - An employee can also upload documents when submitting a request.

## Getting Started With ERS

### Cloning My Repository
- Open up GitBash and change to the current working directory you would like to clone Solana.
- Input `$ git clone https://github.com/TharjaBestGirl/EmployeeReimbursment.git` and press enter to create a clone.

### Database Set-up and Manipulation
- Under `Desktop/Revature/Workspace/Project1/src/main/resources/misc/` there is a file known as `database.sql`. Running this code, you should be able to create the respective database that is used in my project. We are using Postgres.
- There are two insert commands within `data.sql` that you can use to generate an employee and manager, you can optionally alter these statements or keep these preset users.
- Under `Desktop/Revature/Workspace/Project1/src/main/java/com/jack/project1/utils/` there is a class called `ConnUtil.java`. There is a variable on `line 10`, `MY_CONNECTION`, that you should change to fit your database needs.

### Running Javalin
We will be using Spring Tool Suite for this guide, but you may be able to perform the same tasks on other IDEs.
- Under `Desktop/Revature/Workspace/Project1/src/main/java/com/jack/project1/app/` there is a Java class called `MainApp.java`. This is the class you will be running to start Solana.
- Running this as a Java Application will start Javalin. By default, it will start on `http://localhost:8080/`. However, if you currently have something running on port 8080 you can change the port you are using on line 13 in `MainApp.java`. For example, `start(7070);`

## Usage
- After following all of the steps above with getting started with Solana, you should be able to access Solana on your respective localhost by opening `http://localhost:[port]/`with `[port]` representing the port you have assigned. Remember, by default Javalin will be listening on `8080`.
- Now, you can demostrate every feature listed in [Characteristics](https://github.com/kiieer/ProjectOne#characteristics) using the users you defined in your database set up.

## License
This project uses the following license: [GNU General Public License v3.0](https://choosealicense.com/licenses/gpl-3.0/)
