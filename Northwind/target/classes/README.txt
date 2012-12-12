* created a northwnd database in SQL Server 2008 R2 using this database (from restore)
* verified SQL Server 2008 R2 tcp/ip settings are on and SQL Server login for sa has a password.
* setup maven project in MyEclipse per these instructions.
* had to create a web.xml and a test index.jsp to test the deployment
* found the plugin hibernate3-maven-plugin from org.codehaus.mojo, but couldn't figure out how to configure and run the plugin
* StackOverFlow had an example pom.xml setting as well as how to generate source from the plugin
* set a new run configuraiton for maven in MyEclipse to generate the hibernate mapping from the northnd databsae (note: northwnd <- no i)
* all java files outputed to the target\hibernate3\generated-sources and target\hibernate3\generated-mappings
* all hibernate hbm files outputed to \target\classes\ (<-not visible to MyEclipse)

* moved view generated hbm and class files to an isolated view directory