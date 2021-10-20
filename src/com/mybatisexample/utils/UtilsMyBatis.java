package com.mybatisexample.utils;

import com.mybatisexample.entity.UsersEntity;
import com.mybatisexample.service.UsersMapperImpl;

import java.util.*;

public class UtilsMyBatis {

    //---------------------------------------------------------START METHOD TO RUN APP---------------------------------------------------------
    public static void startChoices() {

        boolean exit = true;
        int exitInInt = 0;
        UsersMapperImpl usersMapperImpl = new UsersMapperImpl();

        while (exit) {
            switch (exitInInt) {
                case 0:
                    System.out.println("What are you do? \n");
                    System.out.println("1, VIEW ALL RECORDS \n");
                    System.out.println("2, TO INSERT NEW RECORD \n");
                    System.out.println("3, TO UPDATE RECORD \n");
                    System.out.println("4, TO DELETE RECORD \n");
                    Scanner scan = new Scanner(System.in);
                    String choice = scan.nextLine();

                    if (choice.equalsIgnoreCase("1")) {

                        List<UsersEntity> listTest = usersMapperImpl.getAllUsers();
                        for (UsersEntity u : listTest) {
                            System.out.println(u.getId_user() + " " + u.getName_user() + " " + u.getSurname_user() + " " + u.getEmail_user());
                        }
                        exit = stopOrNotTheCycle();
                    }

                    if (choice.equalsIgnoreCase("2")) {

                        System.out.println("Perfect, please insert data: \n");
                        System.out.println("FIRST NAME: \n");
                        String nameUser = scan.nextLine();
                        System.out.println("LAST NAME: \n");
                        String surnameUser = scan.nextLine();
                        System.out.println("EMAIL: \n");
                        String emailUser = scan.nextLine();
                        String emailResultToInsert = checkEmail(emailUser);

                        Map<String, String> test = new HashMap<>();
                        test.put("name_user", nameUser);
                        test.put("surname_user", surnameUser);
                        test.put("email_user", emailResultToInsert);

                        usersMapperImpl.insertNewUserSP(test);

                        System.out.println("Perfect, you've already insert: \n");
                        System.out.println("FIRST NAME: " + nameUser + "\n");
                        System.out.println("LAST NAME: " + surnameUser + "\n");
                        System.out.println("EMAIL: " + emailResultToInsert + "\n");

                        exit = stopOrNotTheCycle();
                    }

                    if (choice.equalsIgnoreCase("3")) {

                        System.out.println("Please select the user id you need to update: \n");
                        List<UsersEntity> listTest = usersMapperImpl.getAllUsers();
                        for (UsersEntity u : listTest) {
                            System.out.println(u.getId_user() + " " + u.getName_user() + " " + u.getSurname_user() + " " + u.getEmail_user());
                        }
                        String userIdSelected = scan.nextLine();
                        Integer userSelectedIdInInt = Integer.parseInt(userIdSelected);

                        UsersEntity usersEntityToUpdate = usersMapperImpl.getUsersById(userSelectedIdInInt);
                        System.out.println("Perfect, you've already choice this ID:\n");
                        System.out.println("ID: " + userIdSelected + "\n");
                        System.out.println("FIRST NAME: " + usersEntityToUpdate.getName_user() + "\n");
                        System.out.println("LAST NAME: " + usersEntityToUpdate.getSurname_user() + "\n");
                        System.out.println("EMAIL: " + usersEntityToUpdate.getEmail_user() + "\n");

                        System.out.println("\nPerfect, do you prefer to have it modified entirely or only in part? \n");

                        String choiceToExecute = scan.nextLine();

                        if (checkChoiceToUpdateAllUser(choiceToExecute)) {

                            System.out.println("Perfect, please insert data: \n");
                            System.out.println("FIRST NAME: \n");
                            String nameUser = scan.nextLine();
                            System.out.println("LAST NAME: \n");
                            String surnameUser = scan.nextLine();
                            System.out.println("EMAIL: \n");
                            String emailUser = scan.nextLine();
                            String emailResultToInsert = checkEmail(emailUser);

                            Map<String, Object> test = new HashMap<>();
                            test.put("id_user", userSelectedIdInInt);
                            test.put("name_user", nameUser);
                            test.put("surname_user", surnameUser);
                            test.put("email_user", emailResultToInsert);

                            UsersEntity usersEntityUpdated = usersMapperImpl.getUsersById(userSelectedIdInInt);
                            System.out.println("Perfect, you've already updated this ID in:\n");
                            System.out.println("ID: " + userIdSelected + "\n");
                            System.out.println("FIRST NAME: " + usersEntityUpdated.getName_user() + "\n");
                            System.out.println("LAST NAME: " + usersEntityUpdated.getSurname_user() + "\n");
                            System.out.println("EMAIL: " + usersEntityUpdated.getEmail_user() + "\n");

                            usersMapperImpl.updateUsersAllFieldsSP(test);
                        } else {

                            System.out.println("\nWell, what part of the user do you want to change? \n");
                            String choiceToExecutePart = scan.nextLine();

                            if (checkChoiceToUpdateNameUser(choiceToExecutePart)) {

                                System.out.println("Perfect, please insert new name: \n");
                                System.out.println("FIRST NAME: \n");

                                String nameUser = scan.nextLine();

                                UsersEntity usersEntityToUpdateName = usersMapperImpl.getUsersById(userSelectedIdInInt);
                                usersEntityToUpdate.setName_user(nameUser);

                                Map<String, Object> test = new HashMap<>();
                                test.put("id_user", userSelectedIdInInt);
                                test.put("name_user", nameUser);

                                usersMapperImpl.updateUserNameSP(test);

                                UsersEntity usersEntityUpdated = usersMapperImpl.getUsersById(userSelectedIdInInt);
                                System.out.println("Perfect, you've already updated this ID in:\n");
                                System.out.println("ID: " + userIdSelected + "\n");
                                System.out.println("FIRST NAME: " + usersEntityUpdated.getName_user() + "\n");
                                System.out.println("LAST NAME: " + usersEntityUpdated.getSurname_user() + "\n");
                                System.out.println("EMAIL: " + usersEntityUpdated.getEmail_user() + "\n");

                                exit = stopOrNotTheCycle();
                            }

                            if (checkChoiceToUpdateSurnameUser(choiceToExecutePart)) {

                                System.out.println("Perfect, please insert new surname: \n");
                                System.out.println("LAST NAME: \n");

                                String surnameUser = scan.nextLine();

                                UsersEntity usersEntityToUpdateSurname = usersMapperImpl.getUsersById(userSelectedIdInInt);
                                usersEntityToUpdateSurname.setSurname_user(surnameUser);

                                Map<String, Object> test = new HashMap<>();
                                test.put("id_user", userSelectedIdInInt);
                                test.put("surname_user", surnameUser);

                                usersMapperImpl.updateUserSurnameSP(test);

                                UsersEntity usersEntityUpdated = usersMapperImpl.getUsersById(userSelectedIdInInt);
                                System.out.println("Perfect, you've already updated this ID in:\n");
                                System.out.println("ID: " + userIdSelected + "\n");
                                System.out.println("FIRST NAME: " + usersEntityUpdated.getName_user() + "\n");
                                System.out.println("LAST NAME: " + usersEntityUpdated.getSurname_user() + "\n");
                                System.out.println("EMAIL: " + usersEntityUpdated.getEmail_user() + "\n");

                                exit = stopOrNotTheCycle();
                            }

                            if (checkChoiceToUpdateEmailUser(choiceToExecutePart)) {

                                System.out.println("Perfect, please insert name: \n");
                                System.out.println("EMAIL: \n");

                                String emailUser = scan.nextLine();
                                String emailResultToInsert = checkEmail(emailUser);

                                UsersEntity usersEntityToUpdateEmail = usersMapperImpl.getUsersById(userSelectedIdInInt);
                                usersEntityToUpdate.setEmail_user(emailResultToInsert);

                                Map<String, Object> test = new HashMap<>();
                                test.put("id_user", userSelectedIdInInt);
                                test.put("email_user", emailResultToInsert);

                                usersMapperImpl.updateUserEmailSP(test);

                                UsersEntity usersEntityUpdated = usersMapperImpl.getUsersById(userSelectedIdInInt);
                                System.out.println("Perfect, you've already updated this ID in:\n");
                                System.out.println("ID: " + userIdSelected + "\n");
                                System.out.println("FIRST NAME: " + usersEntityUpdated.getName_user() + "\n");
                                System.out.println("LAST NAME: " + usersEntityUpdated.getSurname_user() + "\n");
                                System.out.println("EMAIL: " + usersEntityUpdated.getEmail_user() + "\n");

                                exit = stopOrNotTheCycle();
                            }


                        }

                        exit = stopOrNotTheCycle();
                    }

                    if (choice.equalsIgnoreCase("4")) {

                        List<UsersEntity> listTest = usersMapperImpl.getAllUsers();
                        for (UsersEntity u : listTest) {
                            System.out.println(u.getId_user() + " " + u.getName_user() + " " + u.getSurname_user() + " " + u.getEmail_user());
                        }

                        System.out.println("\nPerfect, please insert ID to delete: \n");
                        String idUser = scan.nextLine();
                        Integer idUserInt = Integer.parseInt(idUser);

                        UsersEntity usersEntityDeleted = usersMapperImpl.getUsersById(idUserInt);

                        usersMapperImpl.deleteUserSP(idUserInt);
                        usersMapperImpl.updateUsersIDsSP(idUserInt);

                        System.out.println("Perfect, you've already deleted this ID:\n");
                        System.out.println("ID: " + idUser + "\n");
                        System.out.println("FIRST NAME: " + usersEntityDeleted.getName_user() + "\n");
                        System.out.println("LAST NAME: " + usersEntityDeleted.getSurname_user() + "\n");
                        System.out.println("EMAIL: " + usersEntityDeleted.getEmail_user() + "\n");

                        exit = stopOrNotTheCycle();
                    }

            }//and switch

        }//and while
    }







//---------------------------------------------------------UTILS METHODS TO APP------------------------------------------------------------

    public static boolean stopOrNotTheCycle() {

        System.out.println("\nwould you like to do anything else?\n");
        boolean exitIn = true;
        Scanner scan = new Scanner(System.in);
        String exitOrNot = scan.nextLine();
        if (exitOrNot.equalsIgnoreCase("yes")) {
            exitIn = true;
        } else {
            System.out.println("ok bye, see you...");
            exitIn = false;
        }

        return exitIn;
    }

    public static String checkEmail(String emailIn) {

        boolean exitIn = true;
        int exitInInt = 0;
        String emailInBeforeAtResult = null;
        String emailInAfterAtResult = null;
        while (exitIn) {
            switch (exitInInt) {
                case 0:
                    if (emailIn.contains("@")) {
                        String email_in_before_AT = emailIn.substring(0, emailIn.indexOf("@"));
                        String email_in_after_AT = emailIn.substring(emailIn.indexOf("@") + 1);

                        if (checkCharactersInEmail(email_in_before_AT)) {
                            System.out.println("There is a problem with your email, it contains special characters");
                            emailInBeforeAtResult = updateFirstEmailPart(email_in_before_AT);
                            emailIn = emailInBeforeAtResult;
                        }
                        if (!checkEmailDomain(email_in_after_AT)) {
                            System.out.println("This domain doesn't exist!!");
                            emailInAfterAtResult = updateSecondEmailPart(email_in_after_AT);
                            emailIn = emailInAfterAtResult;
                        }
                        if (!checkCharactersInEmail(email_in_before_AT) && checkEmailDomain(email_in_after_AT)) {
                            exitIn = false;
                        }

                    } else {
                        System.out.println("There is a problem with your e-mail address... the '@' is missing!");
                    }
            }
        }

        return !exitIn ? emailIn : emailInBeforeAtResult + "@" + emailInAfterAtResult;
    }

    public static boolean checkCharactersInEmail(String partOfEmailToCheck) {

        boolean check = false;
        List<String> charactersToCheck = new ArrayList<>();
        charactersToCheck.add("@");
        charactersToCheck.add("!");
        charactersToCheck.add("\"");
        charactersToCheck.add(".");
        charactersToCheck.add("?");
        charactersToCheck.add("^");
        charactersToCheck.add("=");
        charactersToCheck.add("(");
        charactersToCheck.add(")");
        charactersToCheck.add("$");
        charactersToCheck.add("£");
        charactersToCheck.add("&");
        charactersToCheck.add("*");
        charactersToCheck.add("/");
        charactersToCheck.add("%");
        charactersToCheck.add("|");
        charactersToCheck.add("}");
        charactersToCheck.add("{");
        charactersToCheck.add(":");
        charactersToCheck.add(",");
        charactersToCheck.add("[");
        charactersToCheck.add("]");
        charactersToCheck.add(";");

        for (int i = 0; i < charactersToCheck.size(); i++) {
            if (partOfEmailToCheck.contains(charactersToCheck.get(i))) {
                check = true;
            }
        }
        return check;
    }

    public static boolean checkEmailDomain(String partOfEmailToCheck) {

        boolean check = false;
        List<String> domainsToCheck = new ArrayList<>();
        domainsToCheck.add(".it");
        domainsToCheck.add(".com");
        domainsToCheck.add(".fr");
        domainsToCheck.add(".se");
        domainsToCheck.add(".de");
        domainsToCheck.add(".gov");

        for (int i = 0; i < domainsToCheck.size(); i++) {
            if (partOfEmailToCheck.contains(domainsToCheck.get(i))) {
                check = true;
            }
        }
        return check;
    }

    public static String updateFirstEmailPart(String emailInBeforeAT) {

        boolean exit = true;
        while (exit) {

            System.out.println("Please insert EMAIL again: \n");
            Scanner scan1 = new Scanner(System.in);
            String emailAgain = scan1.nextLine();
            String firstPartEmailAgain = emailAgain.substring(0, emailAgain.indexOf("@"));

            if (emailAgain.contains("@")) {

                if (checkCharactersInEmail(firstPartEmailAgain)) {
                    System.out.println("There is a problem with your email, it contains special characters");
                    exit = true;
                } else {
                    emailInBeforeAT = emailAgain;
                    exit = false;
                }

            } else {
                System.out.println("There is a problem with your e-mail address... the '@' is missing!");
                exit = true;
            }
        }

        return emailInBeforeAT;
    }

    public static String updateSecondEmailPart(String emailInAfterAT) {

        boolean exit = true;
        while (exit) {

            System.out.println("Please insert EMAIL again");
            Scanner scan2 = new Scanner(System.in);
            String emailAgain2 = scan2.nextLine();
            String secondPartEmailAgain = emailAgain2.substring(emailAgain2.indexOf("@") + 1);

            if (emailAgain2.contains("@")) {

                if (!checkEmailDomain(emailAgain2)) {
                    System.out.println("There is a problem with your email, this domain doesn't exist!");
                    exit = true;
                } else {
                    emailInAfterAT = emailAgain2;
                    exit = false;
                }

            } else {
                System.out.println("There is a problem with your e-mail address... the '@' is missing!");
            }
        }

        return emailInAfterAT;
    }

    public static UsersEntity updateAllUser() {
        return null;
    }

    public static UsersEntity updatePartOfUser() {
        return null;
    }

    public static boolean checkChoiceToUpdateAllUser(String choiceToExecute) {

        boolean check = false;
        List<String> possibleChoices = new ArrayList<>();
        possibleChoices.add("yes");
        possibleChoices.add("YES");
        possibleChoices.add("ALL");
        possibleChoices.add("all");
        possibleChoices.add("yes all");
        possibleChoices.add("yes, all");
        possibleChoices.add("YES, ALL");
        possibleChoices.add("YES ALL");
        possibleChoices.add("y");
        possibleChoices.add("Y");

        for (int i = 0; i < possibleChoices.size(); i++) {
            if (choiceToExecute.contains(possibleChoices.get(i))) {
                check = true;
            }
        }
        return check;
    }

    public static boolean checkChoiceToUpdateNameUser(String choiceToExecute) {

        boolean check = false;
        List<String> possibleChoices = new ArrayList<>();
        possibleChoices.add("name");
        possibleChoices.add("Name");
        possibleChoices.add("NAME");
        possibleChoices.add("only name");
        possibleChoices.add("ONLY NAME");
        possibleChoices.add("only, name");
        possibleChoices.add("ONLY, NAME");

        for (int i = 0; i < possibleChoices.size(); i++) {
            if (choiceToExecute.contains(possibleChoices.get(i))) {
                check = true;
            }
        }
        return check;
    }

    public static boolean checkChoiceToUpdateSurnameUser(String choiceToExecute) {

        boolean check = false;
        List<String> possibleChoices = new ArrayList<>();
        possibleChoices.add("surname");
        possibleChoices.add("Surname");
        possibleChoices.add("SURNAME");
        possibleChoices.add("only surname");
        possibleChoices.add("ONLY SURNAME");
        possibleChoices.add("only, surname");
        possibleChoices.add("ONLY, SURNAME");

        for (int i = 0; i < possibleChoices.size(); i++) {
            if (choiceToExecute.contains(possibleChoices.get(i))) {
                check = true;
            }
        }
        return check;
    }

    public static boolean checkChoiceToUpdateEmailUser(String choiceToExecute) {

        boolean check = false;
        List<String> possibleChoices = new ArrayList<>();
        possibleChoices.add("email");
        possibleChoices.add("EMAIL");
        possibleChoices.add("Email");
        possibleChoices.add("only email");
        possibleChoices.add("ONLY EMAIL");
        possibleChoices.add("only, email");
        possibleChoices.add("ONLY, EMAIL");

        for (int i = 0; i < possibleChoices.size(); i++) {
            if (choiceToExecute.contains(possibleChoices.get(i))) {
                check = true;
            }
        }
        return check;
    }
}
