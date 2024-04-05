// import java.io.File;

// public class A1 {
//     public static void main(String[] args) {
//         if (args.length == 0) {
//             System.out.println("Please provide a file or directory path as an argument.");
//             return;
//         }

//         String path = args[0];
//         File fileOrDir = new File(path);

//         if (!fileOrDir.exists()) {
//             System.out.println("The specified file or directory does not exist.");
//             return;
//         }

//         if (fileOrDir.isDirectory()) {
//             System.out.println("Directory: " + fileOrDir.getAbsolutePath());
//             File[] files = fileOrDir.listFiles();
//             if (files != null) {
//                 System.out.println("Files in the directory:");
//                 int txtFileCount = 0;
//                 for (File file : files) {
//                     if (file.isFile()) {
//                         System.out.println(file.getName());
//                         if (file.getName().toLowerCase().endsWith(".txt")) {
//                             txtFileCount++;
//                         }
//                     }
//                 }
//                 System.out.println("Total files: " + files.length);
//                 System.out.println("Total .txt files: " + txtFileCount);
//             }
//         } else {
//             System.out.println("File: " + fileOrDir.getAbsolutePath());
//             System.out.println("File size: " + fileOrDir.length() + " bytes");
//             System.out.println("File attributes: ");
//             System.out.println("Readable: " + fileOrDir.canRead());
//             System.out.println("Writable: " + fileOrDir.canWrite());
//             System.out.println("Executable: " + fileOrDir.canExecute());
//         }
//     }
// }


import java.io.*;

public class A1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file or directory path as an argument.");
            return;
        }

        String path = args[0];
        File fileOrDir = new File(path);

        if (!fileOrDir.exists()) {
            System.out.println("The specified file or directory does not exist.");
            return;
        }

        if (fileOrDir.isDirectory()) {
            System.out.println("Directory: " + fileOrDir.getAbsolutePath());
            File[] files = fileOrDir.listFiles();
            if (files != null) {
                System.out.println("Files in the directory:");
                int txtFileCount = 0;
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    if (file.isFile()) {
                        System.out.println(file.getName());
                        if (file.getName().toLowerCase().endsWith(".txt")) {
                            txtFileCount++;
                        }
                    }
                }
                System.out.println("Total files: " + files.length);
                System.out.println("Total .txt files: " + txtFileCount);
            }
        } else {
            System.out.println("File: " + fileOrDir.getAbsolutePath());
            System.out.println("File size: " + fileOrDir.length() + " bytes");
            System.out.println("File attributes: ");
            System.out.println("Readable: " + fileOrDir.canRead());
            System.out.println("Writable: " + fileOrDir.canWrite());
            System.out.println("Executable: " + fileOrDir.canExecute());
        }
    }
}
