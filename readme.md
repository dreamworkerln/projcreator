# projcreator
Crutches implementation of custom maven archetype.

Maded for Ubuntu.

Set in File->Project Structure->Artifact (add jar with dep) output directory to "projcreator/out/projcreator_data"
After building project run deploy.sh

(On Windows place out/* contents to windows/system32/
and replace projcreator from bash to projcreator.bat script)

Usage:
in terminal run projcreator then enter group.id and artefact.id
and you will have created project like maven maven-archetype-quickstart with some fixies and new maven dependencies. 