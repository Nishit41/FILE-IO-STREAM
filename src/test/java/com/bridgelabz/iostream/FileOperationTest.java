package com.bridgelabz.iostream;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class FileOperationTest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";
    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));
        Path playPath = Paths.get(HOME+"/"+PLAY_WITH_NIO);
        //Create Directory
        if(Files.exists(playPath))FileUtils.deleteFiles(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));
        //Create File
        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));
        IntStream.range(1,10).forEach(cntr ->{
            Path tempFile = Paths.get(playPath+"/temp"+cntr);
            Assert.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Assert.assertTrue(Files.exists(tempFile));
        });
        //ListAllFilesAndDirectories
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath,path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
    }
}
