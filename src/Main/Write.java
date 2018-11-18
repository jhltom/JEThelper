package Main;

import Components.ArticleEntry;
import Components.Journal;
import Components.Reviewer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {


    public static void writeJournal(String volumeName, Journal volume ) throws IOException {

        File journalFile = new File("journal" + volumeName + ".txt");
        FileWriter fw = new FileWriter(journalFile);
        BufferedWriter writer = new BufferedWriter(fw);

        //number of articles in journal
        int numberArticles = volume.getSubmittedArticles().size();
        writer.write(String.valueOf(numberArticles)); writer.newLine();

        for (int i = 0; i < numberArticles; i++){
            ArticleEntry entry =volume.getSubmittedArticles().get(i);

            writer.write(entry.getAuthorName()); writer.newLine();
            writer.write(entry.getAuthorInstitution()); writer.newLine();
            writer.write(entry.getTitle()); writer.newLine();
            writer.write(entry.getLanguage()); writer.newLine();
            writer.write(entry.getSubmittedDate()); writer.newLine();
            writer.write(entry.getStatus()); writer.newLine();
            writer.write(entry.getResult()); writer.newLine();
            writer.write(entry.getNewDueDate()); writer.newLine();
            if (entry.getRevisedArticleReceived()) { writer.write("1");writer.newLine(); }
            else { writer.write("0");writer.newLine(); }
            if (entry.isRerevisedArticleReceived()) { writer.write("1");writer.newLine(); }
            else { writer.write("0");writer.newLine(); }
            writer.write(entry.getOverallResult()); writer.newLine();

            //get number of reviewers and write the number
            int numberReviewers = 0;
            if (entry.getReReviewer() == null){
                numberReviewers = entry.getReviewers().size();
            } else {
                numberReviewers = (entry.getReviewers().size() + 1);
            }
            writer.write(String.valueOf(numberReviewers));writer.newLine();

            if (numberReviewers < 4){
                for (int j = 0; j < numberReviewers; j++){
                    Reviewer r = entry.getReviewers().get(j);

                    writer.write(r.getName()); writer.newLine();
                    writer.write(r.getInstitution()); writer.newLine();
                    writer.write(r.getDueDate()); writer.newLine();
                    if (r.requestSent()) writer.write("1");else writer.write("0");writer.newLine();
                    if (r.requestResponse()) writer.write("1");else writer.write("0");writer.newLine();
                    writer.write(r.getResultGrade()); writer.newLine();
                    writer.write(String.valueOf(r.getResultNumber())); writer.newLine();
                    writer.write(r.getCompletedDate()); writer.newLine();
                    if (r.isReviewReceived()) writer.write("1");else writer.write("0");writer.newLine();
                    if (r.isDonation()) writer.write("1");else writer.write("0");writer.newLine();

                }
            } else {
                for (int j = 0; j < numberReviewers - 1; j++){
                    Reviewer r = entry.getReviewers().get(j);

                    writer.write(r.getName()); writer.newLine();
                    writer.write(r.getInstitution()); writer.newLine();
                    writer.write(r.getDueDate()); writer.newLine();
                    if (r.requestSent()) writer.write("1");else writer.write("0");writer.newLine();
                    if (r.requestResponse()) writer.write("1");else writer.write("0");writer.newLine();
                    writer.write(r.getResultGrade()); writer.newLine();
                    writer.write(String.valueOf(r.getResultNumber())); writer.newLine();
                    writer.write(r.getCompletedDate()); writer.newLine();
                    if (r.isReviewReceived()) writer.write("1");else writer.write("0");writer.newLine();
                    if (r.isDonation()) writer.write("1");else writer.write("0");writer.newLine();

                }
                Reviewer r = entry.getReReviewer();
                writer.write(r.getName()); writer.newLine();
                writer.write(r.getInstitution()); writer.newLine();
                writer.write(r.getDueDate()); writer.newLine();
                if (r.requestSent()) writer.write("1");else writer.write("0");writer.newLine();
                if (r.requestResponse()) writer.write("1");else writer.write("0");writer.newLine();
                writer.write(r.getResultGrade()); writer.newLine();
                writer.write(String.valueOf(r.getResultNumber())); writer.newLine();
                writer.write(r.getCompletedDate()); writer.newLine();
                if (r.isReviewReceived()) writer.write("1");else writer.write("0");writer.newLine();
                if (r.isDonation()) writer.write("1");else writer.write("0");writer.newLine();
            }
        }
        writer.close();
        fw.close();

    }

}
