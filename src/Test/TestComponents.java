package Test;

import Components.ArticleEntry;
import Components.Journal;
import Components.Reviewer;

public class TestComponents {

    public static void main(String[] args) {

        //create journal
        Journal vol314 = new Journal("31-4");

        //create article entries
        ArticleEntry entry1 = new ArticleEntry(vol314, "Author1", "University1", "Article1", "EN", "December 1st");
        ArticleEntry entry2 = new ArticleEntry(vol314, "Author2", "University2", "Article2", "EN", "December 2nd");
        ArticleEntry entry3 = new ArticleEntry(vol314, "Author3", "University3", "Article3", "EN", "December 3rd");
        ArticleEntry entry4 = new ArticleEntry(vol314, "Author4", "University4", "Article4", "EN", "December 4th");
        ArticleEntry entry5 = new ArticleEntry(vol314, "Author5", "University5", "Article5", "EN", "December 5th");
        ArticleEntry entry6 = new ArticleEntry(vol314, "Author6", "University6", "Article6", "EN", "December 6th");


        //create reviewers
        Reviewer rev1 = new Reviewer("Reviewer1", "University1", entry1, "Thursday, March 5th");
        Reviewer rev2 = new Reviewer("Reviewer2", "University2", entry1, "Thursday, March 5th");
        Reviewer rev3 = new Reviewer("Reviewer3", "University3", entry1, "Thursday, March 5th");
        Reviewer rev4 = new Reviewer("Reviewer4", "University4", entry2, "Monday, March 5th");
        Reviewer rev5 = new Reviewer("Reviewer5", "University5", entry2, "Monday, March 5th");
        Reviewer rev6 = new Reviewer("Reviewer6", "University6", entry2, "Monday, March 5th");
        Reviewer rev7 = new Reviewer("Reviewer7", "University7", entry3, "Wednesday, March 5th");
        Reviewer rev8 = new Reviewer("Reviewer8", "University8", entry3, "Wednesday, March 5th");
        Reviewer rev9 = new Reviewer("Reviewer9", "University9", entry3, "Wednesday, March 5th");
        Reviewer rev10 = new Reviewer("Reviewer10", "University10", entry4, "Thursday, March 5th");
        Reviewer rev11 = new Reviewer("Reviewer11", "University11", entry4, "Thursday, March 5th");
        Reviewer rev12 = new Reviewer("Reviewer12", "University12", entry4, "Thursday, March 5th");
        Reviewer rev13 = new Reviewer("Reviewer13", "University13", entry5, "Monday, March 5th");
        Reviewer rev14 = new Reviewer("Reviewer14", "University14", entry5, "Monday, March 5th");
        Reviewer rev15 = new Reviewer("Reviewer15", "University15", entry5, "Monday, March 5th");
        Reviewer rev16 = new Reviewer("Reviewer16", "University16", entry6, "Wednesday, March 5th");
        Reviewer rev17 = new Reviewer("Reviewer17", "University17", entry6, "Wednesday, March 5th");
        Reviewer rev18 = new Reviewer("Reviewer18", "University18", entry6, "Wednesday, March 5th");
        rev1.setDonation(true);
        rev2.setDonation(false);
        rev3.setDonation(true);
        rev4.setDonation(false);
        rev5.setDonation(true);
        rev6.setDonation(true);
        rev7.setDonation(false);
        rev8.setDonation(true);
        rev9.setDonation(true);
        rev10.setDonation(true);
        rev11.setDonation(true);
        rev12.setDonation(true);
        rev13.setDonation(true);
        rev14.setDonation(true);
        rev15.setDonation(true);
        rev16.setDonation(false);
        rev17.setDonation(true);
        rev18.setDonation(true);



//        /*test Reviewer prints */
//        rev1.printRequest();
//        rev1.printReminder();
//        rev1.printThanks();
//        rev1.printLate();

//        /* test ArticleEntry prints */
//        entry1.requestSubmissionForm();
//        entry1.articleReceived();
//        entry1.acceptance();
//        entry1.acceptanceWithRevision();
//        entry1.reviseAndResubmit();
//        entry1.reject();
//        entry1.rejectWithoutReview();

//        /* test Journal prints */
//        entry3.setStatus("Accepted");
//        entry4.setStatus("Accepted");
//        entry5.setStatus("Rejected");
//        entry6.setStatus("Rejected");
//        vol314.reviewingArticles();
//        System.out.println("");
//        vol314.rejectedArticles();
//        System.out.println("");
//        vol314.acceptedArticles();
//
//        vol314.makeEditorialReport();
        vol314.makeFinancialReport();

    }
}
