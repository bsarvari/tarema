# tarema

Source files for the [tarema.org] (http://tarema.org) website. Tarema is a foundation for the Christian community of Taksony, Hungary.

This work is a Java web application based on Google's WSK (Web Starter Kit) and GAE (Google Appengine) and it uses maven and gulp as a build infrastructure.  

## Prerequisites
Make sure the following tools are installed on your machine to build the tarema website.
 
* java 8+
* maven 3.5+
* google appengine (GAE) -- latest version
* gcloud CLI
  
Optional tools: node, npm and gulp. If installed running gulp for assorted purposes in the root folder will be possible.   

For install and usage notes of appengine and maven see: https://cloud.google.com/appengine/docs/standard/java/tools/maven
 
## Dev process
### Building the tarema war  
`mvn clean install`
 
This downloads a local copy of node, npm and all the packages needed to execute the gulp maven plugin. These will only be available for the maven process. Moreover all the maven dependencies will also be fetched. 

### Testing the app in a web container
`mvn appengine:devserver`

The locally running app will be availabe at [http://localhost:8080/](http://localhost:8080/)

### Publishing the app to the Google cloud
You may have to re-authenticate:
```shell script
gcloud auth login
``` 
Increase version in `pom.xml`:
```xml
<deploy.version>{new_version}</deploy.version>
```

Deploy to google cloud
```shell script
mvn appengine:deploy
```
                                                                         
Requires permissions granted by the owner of this project.

### Useful stuff
https://cloud.google.com/appengine/docs/flexible/java/using-maven
https://cloud.google.com/appengine/docs/flexible/java/how-to
https://cloud.google.com/sdk/gcloud/reference
