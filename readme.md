# projcreator
Crutches implementation of custom maven archetype.

Made for Ubuntu.

Set in File->Project Structure->Artifact (add jar with dep) output directory 
to "projcreator/out/projcreator_data".
After building project run deploy.sh

(On Windows place out/* contents to windows/system32/
and replace projcreator from bash to projcreator.bat script)

Usage:
in terminal run projcreator then enter group.id and artifact.id
and you will have created you project dir(named as artifact.id) in current directory 
like maven maven-archetype-quickstart with some fixes and new maven dependencies. 