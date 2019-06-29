# projcreator
Crutches implementation of custom maven archetype.
(Create pom file and directory structure for simple console app)

Made for Ubuntu (may used in Windows)


1. Make jar 

File->Project Structure->Artifact Add Jar from modules with dependencies

Select main class (ru.home.projcreator.App)

Fix (if required)
Directory for META-INF/MANIFEST.MF
../projcreator/src/main/java to
../projcreator/src/main/resources/

If throw error delete folder /projcreator/src/main/resources/META-INF
and repeat step 1 again


2. Set in File->Project Structure->Artifact (add jar with dep) output directory 
to "projcreator/out/projcreator_data/".
Set checkbox "include in project build" On.

Or build jar with maven and set "outputDirectory" to "projcreator/out/projcreator_data/" 


After building project run projcreator/deploy.sh

(On Windows copy out/* contents to windows/system32/
and replace projcreator from bash to projcreator.bat script and edit it
like 
java -jar C:/windows/system32/projcreator_data/projcreator.jar)

Usage:
in terminal run projcreator then enter group.id and artifact.id
and you will have created you project dir(named as artifact.id) in current directory 
like maven maven-archetype-quickstart(console helloworld app) 
with some fixes and new maven dependencies. 