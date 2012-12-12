northwnd-spring-hibernate
=========================

My attempt at creating a java spring 3 web and hibernate 4 application based on the northwind database.


* created a northwnd database in SQL Server 2008 R2 using this database (from restore)
* verified SQL Server 2008 R2 tcp/ip settings are on and SQL Server login for sa has a password.
* setup maven project in MyEclipse per these instructions.
* had to create a web.xml and a test index.jsp to test the deployment
* found the plugin hibernate3-maven-plugin from org.codehaus.mojo, but couldn't figure out how to configure and run the plugin
* StackOverFlow had an example pom.xml setting as well as how to generate source from the plugin
http://stackoverflow.com/questions/2843949/how-to-configure-hibernate-tools-with-maven-to-generate-hibernate-cfg-xml-hbm
http://stackoverflow.com/questions/2848567/how-to-configure-hbm2java-and-hbm2dao-to-add-packagename-to-generated-classes
http://hop2croft.wordpress.com/2011/05/08/creating-java-domain-objects-with-the-maven-hibernate-plugin/
* set a new run configuraiton for maven in MyEclipse to generate the hibernate mapping from the northnd databsae (note: northwnd <- no i)
* all java files outputed to the target\hibernate3\generated-sources and target\hibernate3\generated-mappings
* all hibernate hbm files outputed to \target\classes\ (<-not visible to MyEclipse)

* It seems to be common practice to set up generated hibernate files in these output directories, but I don't see how to manage them.  I've tried briefly to search why this would be set up like this, but having found any useful information on project layout with generated file.  Until then, I moved the .hbm.xml and .cfg.xml files to the src/main/resources directories, and the .java files to the /src/main/java directories under their appropriate packages.  I'm convinced there is a better way, as these guys usually like to do the least work possible :-D

* Also all of the dao implementations have Home in the file names.
* Layout now looks like this for java sources

src/main/java
	->com
		->aaronhible
			->dao (extracted dao interfaces)
				->hibernate
					impl (hibernate dao implemenations)
	->com
		->aaronhible
			->model (java pojos of the database tables)
src/main/resources
	->com
		->aaronhible
			->model (hibernate hbm files)
			
* Refactored Generated files to have Generic returns, serializable ids, hashcode, equals, tostring, and interfaces for the Daos
* Removed all database view generated files, mappings, and configurations
* Added a unit test for CategoriesDaoImpl - failed no jndi configured for SessionFactory
* Configured a datasource for jndi for spring.
