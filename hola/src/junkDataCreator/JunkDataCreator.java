package junkDataCreator;

import java.io.*;
import java.nio.file.*;
import java.util.UUID;

public class JunkDataCreator {
    public static final String prefixFile = "./";
    public static final String fileName = "file";
    public static final String fileNameFormat = ".mp3";
    public static final String junkFirstFile = prefixFile+fileName+fileNameFormat;

    public static void main(String arhgs[]) throws Exception{
        File file = new File(junkFirstFile);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        while(true){
            File fileOut = new File((prefixFile+fileName+(UUID.randomUUID())+fileNameFormat));
            fileOut.createNewFile();
            OutputStream outputStream = new FileOutputStream(fileOut);
            Files.write(file.toPath(),fileContent);
        }
    }
}
