README.txt
=================
Things to download and install:
	1. Java 7 SDK: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
	2. Eclipse: https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr1
	3. Maven: http://maven.apache.org/download.cgi 
	4. Tomcat 7: http://tomcat.apache.org/download-70.cgi
	5. SQLite: http://www.sqlite.org/download.html
=================
Instructions:

	1. After you get everything installed, open up Eclipse and open up the project.  There should be a window on the left side of the screen that says "Project Explorer".  Right click > Import > Import... > General > Existing Project.  The project should be called HelloWorld.

	2. Set the java version for the project. Right click project > Properties > Java Compiler.

	3. Run the project.  Right click project > Run as > Run on Server.

	4. On any web browser, go to localhost:8080/HelloWorld/api/test to test if it works. A JSON object containing the strings "foo" and "bar" should appear.

	5.  The URL's for the api calls are /api/getUser/"username" and /api/newUser.
	getUser is a GET request and produces a JSON.  newUser is  POST request and consumes a JSON with fields "username" and "password".

	6. The current database directory is hardcoded in HelloWorld.java.  You can choose your own desired location.