package Test;

import Components.ArticleEntry;
import Components.Journal;
import Components.Reviewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestJournalReader {

    public static void main(String[] args) throws FileNotFoundException {
        String volume = readJournals();
        Journal journal = readJournal(volume);



        /*
        Now create the user input console!
         */
        ArticleEntry entry = journal.getSubmittedArticles().get(0);

        System.out.println(entry.getAuthorName());
        System.out.println(entry.getAuthorInstitution());
        System.out.println(entry.getTitle());
        System.out.println(entry.getLanguage());
        System.out.println(entry.getSubmittedDate());
        System.out.println(entry.getStatus());
        System.out.println(entry.getResult());
        System.out.println(entry.getNewDueDate());
        System.out.println(entry.getRevisedArticleReceived());
        System.out.println(entry.getReRerevisedArticleReceived());
        System.out.println(entry.getOverallResult());

        System.out.println(entry.getReviewers().get(0).getName());
        System.out.println(entry.getReviewers().get(0).getInstitution());
        System.out.println(entry.getReviewers().get(0).getDueDate());
        System.out.println(entry.getReviewers().get(0).requestSent());
        System.out.println(entry.getReviewers().get(0).requestResponse());
        System.out.println(entry.getReviewers().get(0).getResultGrade());
        System.out.println(entry.getReviewers().get(0).getResultNumber());
        System.out.println(entry.getReviewers().get(0).getCompletedDate());
        System.out.println(entry.getReviewers().get(0).isDonation());




    }

    /*
     * Opens journals.txt
     * Returns the Journal volume that user chooses
     * */
    private static String readJournals () throws FileNotFoundException {

        File journalsFile = new File("journals.txt");
        Scanner console = new Scanner(System.in);
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
        } while ((journalIndex < 0 || journalIndex >= journals.size()));

        console.close();
        scanJournals.close();

        //return the corresponding journal volume
        return journals.get(journalIndex);

    }

    /*
     * Open the corresponding journal file and reads Journal
     * Returns the Journal
     * */
    private static Journal readJournal(String volume) throws FileNotFoundException{

        File journalFile = new File("journal" + volume + ".txt");
        Scanner scanJournal = new Scanner(journalFile);
        int numberArticles = scanJournal.nextInt();  // first line is number of articles

        Journal journal = new Journal(volume);
        for (int i = 0; i < numberArticles; i++) {
            String authorName = scanJournal.next();
            String authorInstitution = scanJournal.next();
            int titleLetters = scanJournal.nextInt();
            String title = "";
            for (int t=0; t<titleLetters; t++)
                title += (scanJournal.next()+" ");
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
                    String donation = scanJournal.next();

                    Reviewer newReviewer = new Reviewer(name, institution, entry, dueDate);
                    if (requestSent.equals("1")) newReviewer.setRequestSent(true);else newReviewer.setRequestSent(false);
                    if (requestResponse.equals("1")) newReviewer.setRequestResponse(true);else newReviewer.setRequestResponse(false);
                    newReviewer.setResultGrade(resultGrade);
                    newReviewer.setResultNumber(Integer.valueOf(resultNumber));
                    newReviewer.setCompletedDate(completedDate);
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
                    String donation = scanJournal.next();

                    Reviewer newReviewer = new Reviewer(name, institution, entry, dueDate);
                    if (requestSent.equals("1")) newReviewer.setRequestSent(true);else newReviewer.setRequestSent(false);
                    if (requestResponse.equals("1")) newReviewer.setRequestResponse(true);else newReviewer.setRequestResponse(false);
                    newReviewer.setResultGrade(resultGrade);
                    newReviewer.setResultNumber(Integer.valueOf(resultNumber));
                    newReviewer.setCompletedDate(completedDate);
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
                String donation = scanJournal.next();

                Reviewer newReviewer = new Reviewer(name, institution, entry, dueDate);
                if (requestSent.equals("1")) newReviewer.setRequestSent(true);else newReviewer.setRequestSent(false);
                if (requestResponse.equals("1")) newReviewer.setRequestResponse(true);else newReviewer.setRequestResponse(false);
                newReviewer.setResultGrade(resultGrade);
                newReviewer.setResultNumber(Integer.valueOf(resultNumber));
                newReviewer.setCompletedDate(completedDate);
                if (donation.equals("1")) newReviewer.setDonation(true);else newReviewer.setDonation(false);

                entry.setReReviewer(newReviewer);
            }
            entry.setReviewers(reviewers);
        }
        scanJournal.close();
        return journal;
    }

}
