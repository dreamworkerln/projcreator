# projcreator
Crutches implementation of custom maven archetype.
(Create pom file and directory structure for simple console app)

Made for Ubuntu (may used in Windows)


1. Make jar
(On right side of Intellij main screen)
Maven Projects -> Lifecycle -> package
Run it.

Or install maven 
and run in console in projcreator directory
mvn package 

You should get 
projcreator/out/projcreator_data/projcreator.jar
(check this)



2. After building jar run projcreator/deploy.sh

(
On Windows 
Change in code 
 
private static final String PROG_DIR = "/usr/local/bin/projcreator_data";
to
private static final String PROG_DIR = "<you_full_path>/projcreator/out/projcreator_data";

rebuild jar

Edit projcreator/out/projcreator.bat script
like 
java -jar <you_full_path>/projcreator/out/projcreator_data/projcreator.jar
(fix to you real full path)

Then add to windows system path <you_full_path>/projcreator/out/projcreator_data/ 
(Environment Variables -> Path)
)

Usage:
In terminal run projcreator then enter group.id and artifact.id
and you will have created you project dir(named as artifact.id) 
in current directory like maven maven-archetype-quickstart
(console helloworld app) with some fixes and new maven dependencies. 