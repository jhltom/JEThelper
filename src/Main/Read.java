package Main;

import Components.ArticleEntry;
import Components.Journal;
import Components.Reviewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {


    /*
     * Open the corresponding journal file and reads Journal
     * Returns the Journal
     * */
    public static String readJournals (Scanner console) throws FileNotFoundException {

        File journalsFile = new File("volumes.txt");
        Scanner scanJournals = new Scanner(journalsFile);
        ArrayList<String> journals = new ArrayList<>();

        while (scanJournals.hasNext()) {
            journals.add(scanJournals.next());
        }

        //print out journal volume list
        System.out.println("Select Volume");
        System.out.println("");
        for (int i = 0; i < journals.size(); i++) {
            System.out.println(i + "\t\t" + journals.get(i));
        }
        System.out.println("");

        //receive user input for journal volume
        int journalIndex = 0;
        do {
            journalIndex = console.nextInt();
        } while ((journalIndex < -1 || journalIndex >= journals.size()));

        scanJournals.close();

        //return the corresponding journal volume
        return journals.get(journalIndex);

    }

    /*
     * Open the corresponding journal file and reads Journal
     * Returns the Journal
     * */
    public static Journal readJournal(String volume) throws FileNotFoundException{

        File journalFile = new File("journal" + volume + ".txt");
        Scanner scanJournal = new Scanner(journalFile);
        int numberArticles;
        if (!scanJournal.hasNext()){
            numberArticles = -1;
        } else {
            numberArticles = scanJournal.nextInt();  // first line is number of articles

        }


        Journal journal = new Journal(volume);
        for (int i = 0; i < numberArticles; i++) {
            String authorName = scanJournal.next();
            String authorInstitution = scanJournal.next();
            String title = scanJournal.next();
            String language = scanJournal.next();
            String submittedDate = scanJournal.next();
            ArticleEntry entry = new ArticleEntry(journal, authorName, authorInstitution, title, language, submittedDate);
            entry.setStatus(scanJournal.next());
            entry.setResult(scanJournal.next());
            entry.setNewDueDate(scanJournal.next());
            String b = scanJournal.next();
            if (b.equals("1"))
                entry.setRevisedArticleReceived(true);
            else
                entry.setRevisedArticleReceived(false);
            b = scanJournal.next();
            if (b.equals("1"))
                entry.setReRevisedArticleReceived(true);
            else
                entry.setReRevisedArticleReceived(false);
            entry.setOverallResult(scanJournal.next());

            //read reviewers
            int numberReviewers = scanJournal.nextInt();
            ArrayList<Reviewer> reviewers = new ArrayList<Reviewer>();
            Reviewer reReviewer;

            if (numberReviewers < 4) {
                for (int j = 0; j < numberReviewers; j++) {
                    String name = scanJournal.next();
                    String institution = scanJournal.next();
                    String dueDate = scanJournal.next();
                    String requestSent = scanJournal.next();
                    String requestResponse = scanJournal.next();
                    String resultGrade = scanJournal.next();
                    String resultNumber = scanJournal.next();
                    String completedDate = scanJournal.next();
                    String reviewReceived = scanJournal.next();
                    String donation = scanJournal.next();

                    Reviewer newReviewer = new Reviewer(name, institution, entry, dueDate);
                    if (requestSent.equals("1")) newReviewer.setRequestSent(true);else newReviewer.setRequestSent(false);
                    if (requestResponse.equals("1")) newReviewer.setRequestResponse(true);else newReviewer.setRequestResponse(false);
                    newReviewer.setResultGrade(resultGrade);
                    newReviewer.setResultNumber(Integer.valueOf(resultNumber));
                    newReviewer.setCompletedDate(completedDate);
                    if (reviewReceived.equals("1")) newReviewer.setReviewReceived(true); else newReviewer.setReviewReceived(false);
                    if (donation.equals("1")) newReviewer.setDonation(true);else newReviewer.setDonation(false);

                    reviewers.add(newReviewer);

                }
            } else {
                for (int j = 0; j < numberReviewers - 1; j++) {
                    String name = scanJournal.next();
                    String institution = scanJournal.next();
                    String dueDate = scanJournal.next();
                    String requestSent = scanJournal.next();
                    String requestResponse = scanJournal.next();
                    String resultGrade = scanJournal.next();
                    String resultNumber = scanJournal.next();
                    String completedDate = scanJournal.next();
                    String reviewReceived = scanJournal.next();
                    String donation = scanJournal.next();

                    Reviewer newReviewer = new Reviewer(name, institution, entry, dueDate);
                    if (requestSent.equals("1")) newReviewer.setRequestSent(true);else newReviewer.setRequestSent(false);
                    if (requestResponse.equals("1")) newReviewer.setRequestResponse(true);else newReviewer.setRequestResponse(false);
                    newReviewer.setResultGrade(resultGrade);
                    newReviewer.setResultNumber(Integer.valueOf(resultNumber));
                    newReviewer.setCompletedDate(completedDate);
                    if (reviewReceived.equals("1")) newReviewer.setReviewReceived(true); else newReviewer.setReviewReceived(false);
                    if (donation.equals("1")) newReviewer.setDonation(true);else newReviewer.setDonation(false);

                    reviewers.add(newReviewer);
                }
                String name = scanJournal.next();
                String institution = scanJournal.next();
                String dueDate = scanJournal.next();
                String requestSent = scanJournal.next();
                String requestResponse = scanJournal.next();
                String resultGrade = scanJournal.next();
                String resultNumber = scanJournal.next();
                String completedDate = scanJournal.next();
                String reviewReceived = scanJournal.next();
                String donation = scanJournal.next();

                Reviewer newReviewer = new Reviewer(name, institution, entry, dueDate);
                if (requestSent.equals("1")) newReviewer.setRequestSent(true);else newReviewer.setRequestSent(false);
                if (requestResponse.equals("1")) newReviewer.setRequestResponse(true);else newReviewer.setRequestResponse(false);
                newReviewer.setResultGrade(resultGrade);
                newReviewer.setResultNumber(Integer.valueOf(resultNumber));
                newReviewer.setCompletedDate(completedDate);
                if (reviewReceived.equals("1")) newReviewer.setReviewReceived(true); else newReviewer.setReviewReceived(false);
                if (donation.equals("1")) newReviewer.setDonation(true);else newReviewer.setDonation(false);

                entry.setReReviewer(newReviewer);
            }
            entry.setReviewers(reviewers);
        }
        scanJournal.close();
        return journal;
    }
}
