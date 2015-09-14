# tarema

Source files for the [tarema.org] (http://tarema.org) website. Tarema is a foundation for the Christian community of Taksony, Hungary.

This work is a Java web application based on Google's WSK (Web Starter Kit) and GAE (Google Appengine) and it uses maven and gulp as a build infrastructure.  

## Prerequisites
Make sure the following tools are installed on your machine to build the tarema website.
 
* java 7
* maven 3.2.5
* google appengine (GAE) 1.9.20
  
Optional tools: node, npm and gulp. If installed running gulp for assorted purposes in the root folder will be possible.   

## Dev process
### Building the tarema war  
`mvn clean install`. 
This downloads a local copy of node, npm and all the packages needed to execute the gulp maven plugin. These will only be available for the maven process. Moreover all the maven dependencies will also be fetched. 

### Testing the app in a web container:
`mvn appengine:devserver`

The locally running app will be availabe at http://localhost:8080/

### Publishing the app to the Google cloud 
`mvn appengine:update`
                                                                         
Requires permissions granted by the owner of this project.
