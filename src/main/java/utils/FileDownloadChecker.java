package utils;

import java.io.File;

public class FileDownloadChecker {

    private File file;
    private String pathToFile;


    //TODO добавить инициализацию из пропери
    public FileDownloadChecker (){
        pathToFile = "src/test/resources/steam.dmg";
        file = new File(pathToFile);
    }

    public boolean isFileHasBeenDownloaded (){
        boolean condition = file.exists() && file.isFile() && file.length() > 0;
        return condition;
    }




}
