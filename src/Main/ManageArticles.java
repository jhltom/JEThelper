package Main;

import Components.ArticleEntry;
import Components.Journal;

import java.util.Scanner;

public class ManageArticles {

    public static void manageArticles(Scanner console, Journal volume) {

        boolean cont = true;

        while(cont){
            System.out.println("====================================");
            System.out.println("A          Add Articles");
            System.out.println("V          View Accepted Articles");
            System.out.println("R          View Rejected Articles");
            System.out.println("P          View Reviewing Articles");
            System.out.println("M          Manage Review Process");
            System.out.println("G          Generate Emails");
            System.out.println("X          Exit");
            System.out.println("====================================");
            System.out.println("What action would you like to perform?");
            String in = console.next();

            switch (in) {
                case "a":
                case "A":
                    System.out.println("");
                    System.out.println("Author Name : (do not leave any white space)");
                    String authorName = console.next();
                    System.out.println("Author Institution : (do not leave any white space)");
                    String authorInstitution = console.next();
                    System.out.println("Article Title : (do not leave any white space) ");
                    String title = console.next();
                    String language = "";
                    do {
                        System.out.println("Language : EN, KOR, or SPA");
                        language = console.next();
                    } while (!language.equals("EN") && !language.equals("KOR") && !language.equals("SPA"));
                    System.out.println("Submitted Date : MM/DD ");
                    String date = console.next();
                    new ArticleEntry(volume, authorName, authorInstitution, title, language, date); //this also adds it into the journal
                    break;

                case "v":
                case "V":
                    System.out.println("");
                    volume.acceptedArticles();
                    System.out.println("");break;
                case "r":
                case "R":
                    System.out.println("");
                    volume.rejectedArticles();
                    System.out.println("");break;
                case "p":
                case "P":
                    System.out.println("");
                    volume.reviewingArticles();
                    System.out.println("");break;
                case "g":
                case "G":
                    System.out.println("");

                    //print list of articles
                    int i = 0;
                    for (i = 0; i < volume.getSubmittedArticles().size(); i++){
                        System.out.println(i+"\t"+volume.getSubmittedArticles().get(i).getTitle());
                    }

                    //let article be chosen by user
                    int j;
                    do{
                        System.out.println("");
                        System.out.println("Choose between 0 and "+(i-1)+"  *must be number!!");
                        j = console.nextInt();
                    } while (j < 0 || j > i-1 );

                    ArticleEntry ent = volume.getSubmittedArticles().get(j);

                    String overall = ent.getOverallResult();
                    String result = ent.getResult();
                    System.out.println("OverallResult : "+overall);
                    System.out.println("Result: "+result);
                    //  Accepted, AcceptedWithRevision, ReviseAndResubmit, Rejected
                    switch(overall){
                        case "Accepted":
                            ent.acceptance();
                            break;
                        case "Rejected":
                            String innn = "";
                            do {
                                System.out.println(" Rejected after Review: O ");
                                System.out.println(" Rejected w/o Review: X ");
                                innn = console.next();
                            }
                            while (!innn.equals("O") && !innn.equals("X"));
                            if (innn.equals("O"))
                                ent.reject();
                            else
                                ent.rejectWithoutReview();
                            break;
                        default:
                            switch (result){
                                case "Accepted":
                                    ent.acceptance();
                                    break;
                                case "AcceptedWithRevision":
                                    ent.acceptanceWithRevision();
                                    break;
                                case "ReviseAndResubmit":
                                    ent.reviseAndResubmit();
                                    break;
                                case "Rejected":
                                    innn = "";
                                    do {
                                        System.out.println(" Rejected after Review: O ");
                                        System.out.println(" Rejected w/o Review: X ");
                                        innn = console.next();
                                    }
                                    while (!innn.equals("O") && !innn.equals("X"));
                                    if (innn.equals("O"))
                                        ent.reject();
                                    else
                                        ent.rejectWithoutReview();
                                    break;
                                default:
                                    innn = "";
                                    do {
                                        System.out.println(" Thank you for submitting email: O ");
                                        System.out.println(" Request submission form email: X ");
                                        innn = console.next();
                                    }
                                    while (!innn.equals("O") && !innn.equals("X"));
                                    if (innn.equals("O"))
                                        ent.articleReceived();
                                    else
                                        ent.requestSubmissionForm();
                                    break;
                            }
                            break;
                    }
                    System.out.println("");break;
                case "m":
                case "M":
                    System.out.println("");
                    System.out.println("Choose Article :  *must be number");
                    System.out.println("");

                    //print list of articles
                    i = 0;
                    for (i = 0; i < volume.getSubmittedArticles().size(); i++){
                        System.out.println(i+"\t"+volume.getSubmittedArticles().get(i).getTitle());
                    }

                    //let article be chosen by user
                    j=-1;
                    do{
                        System.out.println("");
                        j = console.nextInt();
                    } while (j < 0 || j > i-1 );

                    ArticleEntry entry = volume.getSubmittedArticles().get(j);

                    System.out.println(entry.getTitle()+" - "+entry.getAuthorName());
                    System.out.println("status: "+entry.getStatus());

                    //task depending on status
                    //Reviewing
                    if (entry.getStatus().equals("Reviewing")){
                        String answer = "";
                        do {
                            System.out.println("Update Status? (y/n)");
                            answer = console.next();
                        } while (!answer.equals("y") && !answer.equals("n"));
                        if (answer.equals("y")) {
                            do {
                                System.out.println("Set result : (Accepted, AcceptedWithRevision, ReviseAndResubmit, Reject ");
                                answer = console.next();
                            }
                            while (!answer.equals("Accepted") && !answer.equals("AcceptedWithRevision") && !answer.equals("ReviseAndResubmit") && !answer.equals("Reject"));
                            switch (answer){
                                case "Accepted":
                                    entry.setStatus("Accepted");
                                    entry.setResult("Accepted");
                                    entry.setOverallResult("Accepted");
                                    break;
                                case "AcceptedWithRevision" :
                                    entry.setStatus("WaitingForRevisedVersion");
                                    entry.setResult("AcceptedWithRevision");
                                    System.out.println("Revion due by : MM/DD ");
                                    entry.setNewDueDate( console.next());
                                    break;
                                case "ReviseAndResubmit" :
                                    entry.setStatus("WaitingForRevisedVersion");
                                    entry.setResult("ReviseAndResubmit");
                                    System.out.println("Revion due by : MM/DD ");
                                    entry.setNewDueDate( console.next());
                                    break;
                                case "Reject" :
                                    entry.setStatus("Rejected");
                                    entry.setResult("Rejected");
                                    entry.setOverallResult("Rejected");
                                    break;
                                default : break;
                            }
                        } else {
                            System.out.println("Task Done");
                        }
                    } //WaitingForRevisedVersion
                    else if (entry.getStatus().equals("WaitingForRevisedVersion")){
                        String answer = "";
                        do {
                            System.out.println("Revised Version Received? (y/n)");
                            answer = console.next();
                        } while (!answer.equals("y") && !answer.equals("n"));
                        if (answer.equals("y")){
                            entry.setStatus("Re-reviewing");
                            entry.setRevisedArticleReceived(true);
                        } else
                            System.out.println("Task Done");
                    } //Re-reviewing
                    else if (entry.getStatus().equals("Re-reviewing")){
                        String answer = "";
                        do {
                            System.out.println("Update Status? (y/n)");
                            answer = console.next();
                        } while (!answer.equals("y") && !answer.equals("n"));
                        if (answer.equals("y")) {
                            do {
                                System.out.println("Set result : (Accepted, AcceptedWithRevision, ReviseAndResubmit, Reject ");
                                answer = console.next();
                            }
                            while (!answer.equals("Accepted") && !answer.equals("AcceptedWithRevision") && !answer.equals("ReviseAndResubmit") && !answer.equals("Reject"));
                            switch (answer){
                                case "Accepted":
                                    entry.setStatus("Accepted");
                                    entry.setOverallResult("Accepted");
                                    break;
                                case "AcceptedWithRevision" :
                                    entry.setStatus("WaitingForRerevisedVersion");
                                    System.out.println("Revion due by : MM/DD ");
                                    entry.setNewDueDate( console.next());
                                    break;
                                case "ReviseAndResubmit" :
                                    entry.setStatus("WaitingForRerevisedVersion");
                                    System.out.println("Revion due by : MM/DD ");
                                    entry.setNewDueDate( console.next());
                                    break;
                                case "Reject" :
                                    entry.setStatus("Rejected");
                                    entry.setOverallResult("Rejected");
                                    break;
                                default : break;
                            }
                        } else {
                            System.out.println("Task Done");
                        }
                    }//WaitingForRerevisedVersion
                    else if (entry.getStatus().equals("WaitingForRerevisedVersion")){
                        String answer = "";
                        do {
                            System.out.println("Re-Revised Version Received? (y/n)");
                            answer = console.next();
                        } while (!answer.equals("y") && !answer.equals("n"));
                        if (answer.equals("y")){
                            entry.setStatus("Accepted");
                            entry.setRerevisedArticleReceived(true);
                            entry.setOverallResult("Accepted");
                        } else
                            System.out.println("Task Done");
                    }
                    System.out.println("");break;

                case "x":
                case "X":
                    System.out.println("");
                    System.out.println("Quiting...");
                    System.out.println("");
                    cont = false;
                    break;
                default: break;
            }
        }
    }
}
