Project directory-angular
=================

jkulba@gmail.com

Single Page App using AngularJS for the client, SpringFramework for the back-end services, and mongodb data persistence.

Environment Setup 
-------
My personal and professional development machine is a Mac.  I used the excellent HomeBrew (http://brew.sh/) package manager to install mongoDB and Apache Maven.  

mongoDB ~ http://www.mongodb.org/

Robomongo ~ http://robomongo.org/ - Shell and Gui tool to view and manage your local and remote mongoDB instances.

Apache Maven 3.0+ ~ http://maven.apache.org/

Java (Oracle) SDK 1.7.0 or higher

Spring Framework Usage
-
Spring Java Config 
I used the Spring Java Config to create the Java back-end.  The configuration is fairly clean and could used as a quick template as a starter app for future projects.

Installation
-

Run the following command to install it:

```console
git clone https://github.com/jkulba/directory-angular.git
```

Navigate into your newly created directory-angular directory and run the following to grab all of the third party libraries:

```console
mvn clean install
```

Depending on the speed of your internet connection, you can safely grab some coffee.

History
--------
1.0 - Functioning CRUD activities - 5/19/2014
* Single Spring Controller handles basic CRUD for Contact.
* Simple Bootstrap layout with left-hand navigation
* AgularJs controllers and services 

1.0 - Initial release - 1/19/2014
* Created and uploaded initial project structure.