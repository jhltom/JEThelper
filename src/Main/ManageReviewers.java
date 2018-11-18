package Main;

import Components.ArticleEntry;
import Components.Journal;
import Components.Reviewer;

import java.util.Scanner;

public class ManageReviewers {

    public static void manageReviewers(Scanner console, Journal volume) {
        boolean cont = true;

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

        ArticleEntry entry = volume.getSubmittedArticles().get(j);

        while (cont) {
            System.out.println("====================================");
            System.out.println("R          View Reviewers");
            System.out.println("A          Add Reviewer");
            System.out.println("U          Update Reviewer Status");
            System.out.println("G          Generate Emails");
            System.out.println("X          Exit");
            System.out.println("====================================");
            System.out.println("What action would you like to perform?");
            System.out.println("");
            String in = console.next();

            switch (in) {
                case "r":
                case "R":
                    System.out.println("");
                    System.out.println("Reviewers :" +entry.getReviewers());
                    System.out.println("Re-reviewers : " + entry.getReReviewer());
                    System.out.println("");
                    break;
                case "a":
                case "A":
                    String answer = "";
                    do {
                        System.out.println("Add Reviewer? (y/n)");
                        answer = console.next();
                    } while (!answer.equals("y") && !answer.equals("n"));
                    if(answer.equals("y")){
                        // if # of reviewers is less than 3
                        if (entry.getReviewers().size() < 3){
                            System.out.println("Reviewer Name : (do not leave any white space)");
                            String name = console.next();
                            System.out.println("Reviewer Institution : (do not leave any white space)");
                            String institution = console.next();
                            System.out.println("Review due date : MM/DD ");
                            String duedate = console.next();
                            new Reviewer(name, institution, entry, duedate);

                        } //ask if the reviewer is a re-reviewer
                        else if (entry.getReviewers().size() == 3){
                            answer = "";
                            do {
                                System.out.println("Add Re-reviewer? (y/n)");
                                answer = console.next();
                            } while (!answer.equals("y") && !answer.equals("n"));
                            if(answer.equals("y")){
                                if (entry.getReReviewer() != null){
                                    System.out.println("We already have a Re-reviewer");
                                }else {
                                    System.out.println("Reviewer Name : (do not leave any white space)");
                                    String name = console.next();
                                    System.out.println("Reviewer Institution : (do not leave any white space)");
                                    String institution = console.next();
                                    System.out.println("Review due date : MM/DD ");
                                    String duedate = console.next();
                                    new Reviewer(name, institution, entry, duedate, "rereviewer");
                                }
                            } else{
                                System.out.println("task done");
                            }
                        } else {
                            System.out.println("task done");
                        }

                    } else {
                        System.out.println("Task Done");
                    }
                    break;
                case "u":
                case "U":
                    System.out.println("");
                    //print list of reviewers
                    i = 0;
                    for (i = 0; i < entry.getReviewers().size(); i++){
                        System.out.println(i+"\t"+entry.getReviewers().get(i)+" - "+entry.getReviewers().get(i).getResultGrade());
                    }
                    if (entry.getReReviewer() != null) {
                        System.out.println(i + "\t" + "Re-reviewer: "+entry.getReReviewer()+" - "+entry.getReReviewer().getResultGrade());
                        i++;
                    }

                    //let article be chosen by user
                    j = -1;
                    do{
                        System.out.println("");
                        System.out.println("Choose between 0 and "+(i-1)+"  *must be number!!");
                        j = console.nextInt();
                    } while (j < 0 || j > i-1 );

                    Reviewer r;
                    if (j < 3) {
                        r = entry.getReviewers().get(j);
                    } else {
                        r = entry.getReReviewer();
                    }

                    if (!r.requestSent()){ //sent request?
                        System.out.println("Status : ");
                        System.out.println(" - request sent: X");
                        System.out.println("");
                        answer = "";
                        do {
                            System.out.println("Request Sent? (y/n)");
                            answer = console.next();
                        } while (!answer.equals("y") && !answer.equals("n"));
                        if(answer.equals("y")){
                            r.setRequestSent(true);
                        }
                        break;
                    }
                    if (!r.requestResponse()){ //did he/she accept?
                        System.out.println("Status : ");
                        System.out.println(" - request sent: O");
                        System.out.println(" - answer from reviewer: X");
                        System.out.println("");
                        answer = "";
                        do {
                            System.out.println("Did the he/she agree to review? (y/n)");
                            answer = console.next();
                        } while (!answer.equals("y") && !answer.equals("n"));
                        if(answer.equals("y")){
                            r.setRequestResponse(true);
                        }
                        break;
                    }
                    if (!r.isReviewReceived()){ //
                        System.out.println("Status : ");
                        System.out.println(" - request sent: O");
                        System.out.println(" - answer from reviewer: O");
                        System.out.println(" - review received: X");
                        System.out.println("");
                        answer = "";
                        do {
                            System.out.println("Review received? (y/n)");
                            answer = console.next();
                        } while (!answer.equals("y") && !answer.equals("n"));
                        if(answer.equals("y")){
                            r.setReviewReceived(true);

                            String grade = "";
                            do {
                                System.out.println("LetterGrade : (A, B, C, D) ");
                                grade = console.next();
                            } while (!grade.equals("A") && !grade.equals("B")&& !grade.equals("C") && !grade.equals("D"));
                            r.setResultGrade(grade);

                            int percent = 0;
                            do {
                                System.out.println("PercentageGrade : ( 0~100 ) ");
                                percent = console.nextInt();
                            } while (percent < 0 || percent > 100);
                            r.setResultNumber(percent);

                            System.out.println("CompletedDate : (DD/MM) ");
                            r.setCompletedDate(console.next());


                            answer = "";
                            do {
                                System.out.println("Donation : (y/n)");
                                answer = console.next();
                            } while (!answer.equals("y") && !answer.equals("n"));
                            if (answer.equals("y"))
                                r.setDonation(true);
                            else
                                r.setDonation(false);
                            System.out.println("");
                        }
                        break;
                    }
                    //in case review has already been received, print result
                    System.out.println(r.getName()+": "+r.getResultNumber()+" "+r.getResultGrade()+" - "+r.getCompletedDate());
                    System.out.println("");
                    break;
                case "g":
                case "G":
                    System.out.println("");
                    //print list of reviewers
                    i = 0;
                    for (i = 0; i < entry.getReviewers().size(); i++){
                        System.out.println(i+"\t"+entry.getReviewers().get(i));
                    }
                    if (entry.getReReviewer() != null) {
                        System.out.println(i + "\t" + "Re-reviewer: "+entry.getReReviewer());
                        i++;
                    }

                    //let article be chosen by user
                    j = -1;
                    do{
                        System.out.println("");
                        System.out.println("Choose between 0 and "+(i-1)+"  *must be number!!");
                        j = console.nextInt();
                    } while (j < 0 || j > i-1 );


                    Reviewer rr;
                    if (j < 3) {
                        rr = entry.getReviewers().get(j);
                    } else {
                        rr = entry.getReReviewer();
                    }

                    if (rr.isReviewReceived()){
                        rr.printThanks(); //if review received
                    } else {
                        if (!rr.requestSent()) //request not sent
                            rr.printRequest();
                        else {
                            if (rr.requestResponse()) { //reviewer responded, print reminder
                                rr.printReminder();
                            } else {                  //reviewer has not responded, print request again
                                rr.printRequest();
                            }
                        }
                    }
                    break;
                case "x":
                case "X":
                    System.out.println("");
                    System.out.println("Quiting...");
                    System.out.println("");
                    cont = false;
                    break;
                default:
                    break;
            }
        }

    }
}
