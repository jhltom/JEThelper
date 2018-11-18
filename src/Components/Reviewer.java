package Components;

public class Reviewer {

    private String name; //
    private String institution; //
    private ArticleEntry article; //
    private String dueDate;  //

    private boolean requestSent;
    private boolean requestResponse;

    private String resultGrade;
    private int resultNumber;
    private String completedDate;



    private boolean reviewReceived;
    private boolean donation;


    //constructor
    public Reviewer(String name, String institution, ArticleEntry article, String dueDate){
        this.name = name;
        this.institution = institution;
        this.article = article;
        article.addReviewer(this);
        this.dueDate = dueDate;
        requestSent = false;
        requestResponse = false;
        resultGrade = "n/a";
        resultNumber = -1;
        completedDate = "n/a";
        reviewReceived = false;
        donation = false;
    }
    public Reviewer(String name, String institution, ArticleEntry article, String dueDate, String string){
        this.name = name;
        this.institution = institution;
        this.article = article;
        article.setReReviewer(this);
        this.dueDate = dueDate;
        requestSent = false;
        requestResponse = false;
        resultGrade = "n/a";
        resultNumber = -1;
        completedDate = "n/a";
        reviewReceived = false;
        donation = false;
    }


    //generate emails
    public void printRequest(){
        System.out.println("");
        System.out.println("Dear Dr. "+name);
        System.out.println("");
        System.out.println("We would like to ask a favor of reviewing a paper submitted to our journal, Asian Journal of Latin American Studies. The title of the article is “"+article.getTitle()+".”");
        System.out.println("");
        System.out.println("If you would be able to review the article using your expertise in the field, we will be greatly appreciate it. The due date for the review is "+dueDate);
        System.out.println("");
        System.out.println("Please use the attached form to review the article and send it back to us once you finish the review. And, if you could let us know whether you can review the article, it will expedite the review process.");
        System.out.println("");
        System.out.println("Thanks again in advance for your efforts. I look forward to reading your review.");
        System.out.println("");
        System.out.println("Very best wishes,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void printReminder() {
        System.out.println("");
        System.out.println("Dear Dr. " + name);
        System.out.println("");
        System.out.println("This is a friendly reminder of the deadline for the review of the article “"  + article.getTitle() + ",” which is " + dueDate+".");
        System.out.println("");
        System.out.println("Thank you again for reviewing the article and we look forward to reading your review.");
        System.out.println("");
        System.out.println("Very best wishes,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void printLate(){
        System.out.println("");
        System.out.println("Dear Dr. " + name);
        System.out.println("");
        System.out.println("This is a friendly reminder of the deadline for the review of the article “"  + article.getTitle() + ",” which was " + dueDate+". If you could send us the review as soon as possible, it will help expedite our review process.");
        System.out.println("");
        System.out.println("Thank you again for reviewing the article and we look forward to reading your review.");
        System.out.println("");
        System.out.println("Very best wishes,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void printThanks(){
        System.out.println("");
        System.out.println("Dear Dr. " + name);
        System.out.println("");
        System.out.println("This note is to confirm the receipt of your review. Thank you very much for your efforts.");
        System.out.println("");
        System.out.println("Very best wishes,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }







    //getter and setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }
    public boolean requestSent() { return requestSent; }
    public void setRequestSent(boolean requestSent) { this.requestSent = requestSent; }
    public boolean requestResponse() { return requestResponse; }
    public void setRequestResponse(boolean requestResponse) { this.requestResponse = requestResponse; }
    public String getResultGrade() { return resultGrade; }
    public void setResultGrade(String resultGrade) { this.resultGrade = resultGrade; }
    public int getResultNumber() { return resultNumber; }
    public void setResultNumber(int resultNumber) { this.resultNumber = resultNumber; }
    public String getCompletedDate() { return completedDate; }
    public void setCompletedDate(String completedDate) { this.completedDate = completedDate; }
    public boolean isDonation() { return donation; }
    public void setDonation(boolean donation) { this.donation = donation; }
    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public boolean isReviewReceived() { return reviewReceived; }
    public void setReviewReceived(boolean reviewReceived) { this.reviewReceived = reviewReceived; }


    @Override
    public String toString() {
        return name;
    }
}


