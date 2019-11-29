# Single Page App in Angular JS
### Angular JS, JavaScript, HTML5, CSS3, SpringBoot,SpringData and Java


* Create a recipe book single page application (SPA) using AngularJS.
* The list of recipes can be filtered by the selected category
* Clicking the recipe “Delete” button deleted that recipes.
* Clicking the recipe “Add” button adds a new recipe
* To Edit any recipe select the recipe from the drop down.
* The REST layer has been built using Java
* The application uses SpringBoot to simplify deployment process
* SpringData with JPA is the framework for the persistence layer

### Running the application
To run the applicaion use mvnw spring-boot:run

### Bypasing Proxy
If behind a proxy the proxy can be configured as
set MAVEN_OPTS=-Dhttp.proxyHost=proxyhost -Dhttp.proxyPort=8080 -Dhttps.proxyHost=proxyhost -Dhttps.proxyPort=8080


### TODO
* Convert the image into a base 64 string url. This will simplify the persistence and rendering
* Other alternative is to persist the file in Azure file storage or AWS S3 bucket
* Add a lookup for the ingredients
