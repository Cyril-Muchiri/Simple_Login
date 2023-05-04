package bundle;

import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[]args) throws InterruptedException, IOException {
        String s,l;

        int i;

        System.out.println("----------------HI, HOW ARE YOU!------------------");
        System.out.println("\n---PRESS---\n s-for sign up\n l-for login");
        Scanner scanner=new Scanner(System.in);
        while (true){
        switch (scanner.next()){
            case "s":
                System.out.println("Proceeding to Signup page");
                Thread.sleep(1500);
            signUp();return;

            case "l":System.out.println("Proceeding to Login page");
            Thread.sleep(1500);
            login();return;

            default:
                System.out.println("Invalid input!! please try again");
        }}


     }
     public static void signUp(){
        String userName,pass;
         System.out.println("----ENTER PREFFERED USER NAME----");
         Scanner signScanner=new Scanner(System.in);
         userName=signScanner.next();
         System.out.println("----ENTER YOUR PASSWORD---");
         pass=signScanner.next();
         signScanner.close();

         try {
             BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Baby Beast\\Desktop\\finalisima\\trial2.txt"));
             writer.write(userName);
             writer.write("\n"+pass);
             writer.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

         System.out.println("--Details for "+userName+" saved successfully!!--");
     }
     public static void login() throws IOException {
         String pass, userName,content;

         Scanner lScanner;

         System.out.println("----Enter user name---");
         lScanner = new Scanner(System.in);
         userName = lScanner.next();

         System.out.println("----Enter passphrase---");
         pass = lScanner.next();
         lScanner.close();


         BufferedReader reader;
         try {
             reader = new BufferedReader(new FileReader("C:\\Users\\Baby Beast\\Desktop\\finalisima\\trial2.txt"));
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         }
         boolean found = false;
         while ((content = reader.readLine()) != null) {
             String[] fields = content.split("\n");
             if (fields.length == 2 && fields[0].equals(userName) && fields[1].equals(pass)) {
                 found = true;
                 break;
             }
         }
         reader.close();
         if (found) {
             System.out.println("Welcome back " + userName);
         } else {
             System.out.println("Username/password incorrect!!");
         }


     }
    }
