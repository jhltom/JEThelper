package Components;
import java.util.ArrayList;

public class Journal {

    private String volume;
    private ArrayList<ArticleEntry> submittedArticles;

    //construct empty journal
    public Journal(String volume){
        submittedArticles = new ArrayList<ArticleEntry>();
        this.volume = volume;
    };

    //add & remove articles
    public void addArticle(ArticleEntry article){
        submittedArticles.add(article);
    }
    public void removeArticle(ArticleEntry article){
        submittedArticles.remove(article);
    }


    //print methods
    public void rejectedArticles(){
        for(ArticleEntry entry: submittedArticles){
            if(entry.getStatus().equals("Rejected"))
                System.out.println("“"+entry.getTitle()+"” - "+entry.getAuthorName());
        }
    }
    public void acceptedArticles(){
        for(ArticleEntry entry: submittedArticles){
            if(entry.getStatus().equals("Accepted"))
                System.out.println("“"+entry.getTitle()+"” - "+entry.getAuthorName());
        }
    }
    public void reviewingArticles(){
        for(ArticleEntry entry: submittedArticles){
            if(entry.getStatus().equals("Reviewing") || entry.getStatus().equals("WaitingForRevisedVersion") || entry.getStatus().equals("Re-reviewing") || entry.getStatus().equals("WaitingForRerevisedVersion"))
                System.out.println("“"+entry.getTitle()+"” - "+entry.getAuthorName());

        }
    }

    //generate report methods

    public void makeEditorialReport(){
        for(int i = 0; i<submittedArticles.size(); i++){
            System.out.println("");
            System.out.println("#"+(i+1)+" -------------------------------------------- ");
            System.out.println("Author : \t\t\t"+submittedArticles.get(i).getAuthorName());
            System.out.println("Title : \t\t\t"+submittedArticles.get(i).getTitle());
            System.out.println("Date of Sumission : \t\t"+submittedArticles.get(i).getSubmittedDate());
            System.out.println("");

            int rN = submittedArticles.get(i).getReviewers().size();
            System.out.println("Reviewers : \t\t\t"+submittedArticles.get(i).getReviewers());


            if (rN == 0){
                System.out.println("Acceptance : \t\t\t - ");
                System.out.println("Grades : \t\t\t - ");
                System.out.println("Review Completed Date : \t\t\t - ");
            } else if (rN == 1){
                System.out.println("Acceptance : \t\t\t"+"[ "+submittedArticles.get(i).getReviewers().get(0).requestResponse()+" ]");
                System.out.println("Grades : \t\t\t"+"[ "+submittedArticles.get(i).getReviewers().get(0).getResultNumber()+" ]");
                System.out.println("Review Completed Date : \t"+"[ "+submittedArticles.get(i).getReviewers().get(0).getCompletedDate()+" ]");
            } else if (rN == 2){
                System.out.println("Acceptance : \t\t\t"+"[ "+submittedArticles.get(i).getReviewers().get(0).requestResponse()+" ,"+" "+submittedArticles.get(i).getReviewers().get(1).requestResponse()+" ]");
                System.out.println("Grades : \t\t\t"+"[ "+submittedArticles.get(i).getReviewers().get(0).getResultNumber()+" ,"+" "+submittedArticles.get(i).getReviewers().get(1).getResultNumber()+" ]");
                System.out.println("Review Completed Date : \t"+"[ "+submittedArticles.get(i).getReviewers().get(0).getCompletedDate()+" ,"+" "+submittedArticles.get(i).getReviewers().get(1).getCompletedDate()+" ]");
            } else if (rN == 3){
                System.out.println("Acceptance : \t\t\t"+"[ "+submittedArticles.get(i).getReviewers().get(0).requestResponse()+" ,"+" "+submittedArticles.get(i).getReviewers().get(1).requestResponse()+" ,"+" "+submittedArticles.get(i).getReviewers().get(2).requestResponse()+"]");
                System.out.println("Grades : \t\t\t"+"[ "+submittedArticles.get(i).getReviewers().get(0).getResultNumber()+" ,"+" "+submittedArticles.get(i).getReviewers().get(1).getResultNumber()+" ,"+" "+submittedArticles.get(i).getReviewers().get(2).getResultNumber()+"]");
                System.out.println("Review Completed Date : \t"+"[ "+submittedArticles.get(i).getReviewers().get(0).getCompletedDate()+" ,"+" "+submittedArticles.get(i).getReviewers().get(1).getCompletedDate()+" ,"+" "+submittedArticles.get(i).getReviewers().get(2).getCompletedDate()+"]");
            }
            System.out.println("");
            System.out.println("First Result : \t\t\t"+submittedArticles.get(i).getResult());
            System.out.println("Revised Article Received : \t"+submittedArticles.get(i).getRevisedArticleReceived());
            System.out.println("Re-reviewer : \t\t\t"+submittedArticles.get(i).getReReviewer());
            System.out.println("Re-revised Article Received : \t"+submittedArticles.get(i).getReRerevisedArticleReceived());
            System.out.println("");
            System.out.println("Final Result : \t\t\t"+submittedArticles.get(i).getOverallResult());
            System.out.println("");
        }
    }

    public void makeFinancialReport(){
        int sum = 0;
        System.out.println("");
        System.out.println("Reviewers\tDonation\tCost");
        System.out.println("----------------------------------------");
        for(ArticleEntry e: submittedArticles){
            for (Reviewer r: e.getReviewers()){
                System.out.print(r.getName()+"\t"+r.isDonation()+"\t");
                if (r.isDonation())
                    System.out.println("\t0");
                else {
                    System.out.println("50,000");
                    sum += 50000;
                }
            }
        }
        System.out.println("");
        System.out.println("Total Cost : "+sum);
        System.out.println("");
    };


    //getters and setters
    public ArrayList<ArticleEntry> getSubmittedArticles() { return submittedArticles; }
    public void setSubmittedArticles(ArrayList<ArticleEntry> submittedArticles) { this.submittedArticles = submittedArticles; }
    public String getVolume() { return volume; }
    public void setVolume(String volume) { this.volume = volume; }



}


