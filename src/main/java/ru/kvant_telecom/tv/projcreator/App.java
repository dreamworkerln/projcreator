package ru.kvant_telecom.tv.projcreator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Hello world!
 *
 */
public class App
{

    private BufferedReader bufferIn;

    private String groupId;
    private String artifactId;
    private String packageName;

    private String sources;
    private String test;
    private String resources;

    private String workingDir;

    public static void main( String[] args ) throws IOException {

        if (args.length == 0 ||
            args[0] .equals("simple")) {

            new App().processSimple();
        }
    }


    private App() {

        bufferIn = new BufferedReader(new InputStreamReader(System.in));
    }



    private void processSimple() throws IOException {

        //Path path = Paths.get(MethodHandles.lookup().lookupClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        //System.out.println(path);

        workingDir = System.getProperty("user.dir");

        //System.out.println(System.getProperty("java.class.path"));




        // DEBUGGING
//        groupId = "ru.kvant_telecom.tv";
//        artifactId = "superapp";

//        workingDir = "/home/khatuncev/coding/java/projcreator/test";
        


        System.out.print("group.id: ");
        groupId = readLine();
        if( isNullOrEmpty(groupId))
            throw new RuntimeException("Bad group.id value");

        System.out.print("artifact.id: ");
        artifactId = readLine();
        if( isNullOrEmpty(groupId))
            throw new RuntimeException("Bad artifact.id value");


        groupId = groupId.replaceAll("-", "_");
        artifactId = artifactId.replaceAll("\\.", "");
        groupId = groupId.replaceAll("/", "");
        artifactId = artifactId.replaceAll("/", "");

        packageName = groupId + "." + artifactId;


        sources = workingDir + "."+ artifactId + ".src" + ".main" + ".java" + "." + groupId + "." + artifactId;
        test = workingDir + "." + artifactId + ".src" + ".test" + ".java" + "." + groupId;
        resources = workingDir + "." + artifactId + ".src" + ".main" + ".resources" + ".META-INF";

        sources = sources.replaceAll("\\.", "/");
        test = test.replaceAll("\\.", "/");
        resources = resources.replaceAll("\\.", "/");

        fileIO();
        createPom();
        createApp();

        System.out.println("Simple app project created");
    }







    private void fileIO() throws IOException {

        //Files.createDirectory(workingPath);

        Files.createDirectories(Paths.get(sources));
        Files.createDirectories(Paths.get(test));
        Files.createDirectories(Paths.get(resources));

    }



    private void createPom() throws IOException {


        Path pathIn = Paths.get("/usr/local/bin/projcreator_data/pom.xml");
        Path pathOut = Paths.get(workingDir + "/" + artifactId + "/pom.xml");

        String content = new String(Files.readAllBytes(pathIn), StandardCharsets.UTF_8);

        content = content.replaceAll("PROJCREATOR_GROUP_ID", groupId);
        content = content.replaceAll("PROJCREATOR_ARTIFACT_ID", artifactId);
        content = content.replaceAll("PROJCREATOR_NAME", artifactId);


        byte[] strToBytes = content.getBytes(StandardCharsets.UTF_8);
        Files.write(pathOut, strToBytes);
    }


    private void createApp() throws IOException {


        Path pathIn = Paths.get("/usr/local/bin/projcreator_data/App.java");
        Path pathOut = Paths.get(sources + "/App.java");

        String content = new String(Files.readAllBytes(pathIn), StandardCharsets.UTF_8);

        content = content.replaceAll("PROJCREATOR_PACKAGE_NAME", packageName);


        byte[] strToBytes = content.getBytes(StandardCharsets.UTF_8);
        Files.write(pathOut, strToBytes);
    }





    private String readLine() {

        String result = null;
        try {
            result=  bufferIn.readLine();
        }
        catch (IOException ignore) {}
        return result;
    }

    public static boolean isNullOrEmpty(Object object) {

        return object == null || object.getClass() == String.class && ((String)object).trim().isEmpty();
    }

}



//    int a = -1;
//
//    for (int i = 0; i < 1000; i++) {
//
//        a = (a+1) & 0xff;
//        System.out.println(a);
//    }
