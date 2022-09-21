package com.bridgelabz.iostream;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationTest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";
    @Test
    public void givenPathWhenCheckedThenConfirm(){
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));
    }
}
