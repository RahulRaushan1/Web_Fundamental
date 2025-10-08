package HTML;
import java.io.*;
import java.util.*;

public class AutoCommit {
    public static void main(String[] args) {
        String repoPath = "D:\\AllPrograming\\WebDevelopment\\HTML";
        int commits = 13;

        try {
            for (int i = 1; i <= commits; i++) {
                FileWriter fw = new FileWriter(repoPath + "\\dummy.txt", true);
                fw.write("Auto commit number " + i + " at " + new Date() + "\n");
                fw.close();

                runCommand(repoPath, "git add .");
                runCommand(repoPath, "git commit -m \"Auto commit " + i + "\"");

                Thread.sleep(2000);
            }

            runCommand(repoPath, "git push origin main");

            System.out.println("✅ Done! " + commits + " commits pushed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runCommand(String directory, String command)
            throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
        pb.directory(new File(directory));
        pb.inheritIO();
        Process process = pb.start();
        process.waitFor();
    }
}
