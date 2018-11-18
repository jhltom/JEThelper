package Components;

import java.util.ArrayList;

public class ArticleEntry {

    private Journal volume;
    private String authorName;
    private String authorInstitution;
    private String title;
    private String language;
    private String submittedDate;
    private String status; // Accepted, Rejected, Reviewing, WaitingForRevisedVersion, Re-reviewing, WaitingForRerevisedVersion
    private String result; // Accepted, AcceptedWithRevision, ReviseAndResubmit, Rejected, n/a
    private String newDueDate;
    private boolean revisedArticleReceived;
    private boolean RerevisedArticleReceived;
    private String overallResult; // Accepted, Rejected, n/a

    private ArrayList<Reviewer> reviewers;
    private Reviewer reReviewer;


    //constructor
    public ArticleEntry(Journal volume, String authorName, String authorInstitution, String title, String language, String submittedDate){
        this.volume = volume;
        volume.addArticle(this);
        this.authorName =authorName;
        this.authorInstitution = authorInstitution;
        this.title = title;
        this.language = language;
        this.submittedDate = submittedDate;
        status = "Reviewing";
        result = "n/a";
        newDueDate = "n/a";
        revisedArticleReceived = false;
        RerevisedArticleReceived = false;
        overallResult = "n/a";

        reviewers = new ArrayList<Reviewer>();
        reReviewer = null;

    }


    //Methods related to removers
    public void addReviewer(Reviewer reviewer){
        reviewers.add(reviewer);
    }
    public void removeReviewer(Reviewer reviewer){
        reviewers.remove(reviewer);
    }


    //generate emails
    public void requestSubmissionForm(){
        System.out.println("");
        System.out.println("Dear Dr. "+authorName);
        System.out.println("");
        System.out.println("This email is to inform you that we have not yet received your submission form. Would you please fill the attached form and send it back to us as soon as possible? It will greatly expedite our review process.");
        System.out.println("");
        System.out.println("We thank you again for giving us the opportunity to review your article. ");
        System.out.println();
        System.out.println("Very best wishes,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void articleReceived(){
        System.out.println("");
        System.out.println("Dear Dr. "+authorName);
        System.out.println("");
        System.out.println("Thank you very much for giving us an opportunity to review your article. We will let you know once we have results from our review process.");
        System.out.println("");
        System.out.println("Sincerely,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void acceptance(){
        System.out.println("");
        System.out.println("Dear Dr. "+authorName);
        System.out.println("");
        System.out.println("We highly appreciate that you took the time to submit your manuscript “"+ title+"” to Asian Journal of Latin American Studies. ");
        System.out.println("");
        System.out.println("I am happy to let you know that the reviewers recommended to publish your article at our journal. Please find detailed information regarding the reviewers' opinion in the attached documents. If there are any changes you would like to make, please send us the revised article by "+newDueDate+ " to be published in Vol. "+volume.getVolume() +".");
        System.out.println("");
        System.out.println("Again, thank you for your interest in the journal, and please note that it is critical to meet the deadline for the publication due to the tight schedule.");
        System.out.println("");
        System.out.println("Sincerely,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void acceptanceWithRevision(){
        System.out.println("");
        System.out.println("Dear Dr. "+authorName);
        System.out.println("");
        System.out.println("We highly appreciate that you took the time to submit your manuscript “"+ title+"” to Asian Journal of Latin American Studies. ");
        System.out.println("");
        System.out.println("This is to inform you that the review committee’s official decision is ‘acceptance with minor revisions’. Please find detailed information regarding the reviewers' opinion in the attached documents. If you agree with the reviewers and are willing to make recommended revisions, please send us the revised article and the revision report back to us by "+newDueDate+" in order to give the reviewers enough time to reconsider your article to be published in Vol. "+volume.getVolume() +". ");
        System.out.println("");
        System.out.println("Again, thank you for your interest in the journal, and please note that it is critical to meet the deadline for the publication due to the tight schedule.");
        System.out.println("");
        System.out.println("Sincerely,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void reviseAndResubmit(){
        System.out.println("");
        System.out.println("Dear Dr. "+authorName);
        System.out.println("");
        System.out.println("We highly appreciate that you took the time to submit your manuscript “"+ title+"” to Asian Journal of Latin American Studies. ");
        System.out.println("");
        System.out.println("By the blind review of three referees, the committee’s official decision on your paper is ‘revise and resubmit.’ Our editorial committee have decided that the current version of the your paper is not acceptable for publication in the AJLAS, and that it needs major revisions. If you send us a revised version of your paper referring to attached reviews, we will gladly reconsider your manuscript for future issue.");
        System.out.println("");
        System.out.println("Again, thank you for your interest in the journal, and we regret that the outcome could not have been more favorable. ");
        System.out.println("");
        System.out.println("Sincerely,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void reject(){
        System.out.println("");
        System.out.println("Dear Dr. "+authorName);
        System.out.println("");
        System.out.println("We highly appreciate that you took the time to submit your manuscript “"+ title+"” to Asian Journal of Latin American Studies. ");
        System.out.println("");
        System.out.println("The editorial committee have evaluated your manuscript and three reviewers have reviewed your article. We regret to inform you that it will not be possible to further consider your manuscript for publication in AJLAS. Attached are the reviews from our reviewers ");
        System.out.println("");
        System.out.println("Again, thank you for your interest in the journal, and I regret that the outcome could not have been more favorable. We sincerely hope you to submit another article for review in the near future.");
        System.out.println("");
        System.out.println("Sincerely,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }
    public void rejectWithoutReview(){
        System.out.println("");
        System.out.println("Dear Dr. "+authorName);
        System.out.println("");
        System.out.println("We highly appreciate that you took the time to submit your manuscript “"+ title+"” to Asian Journal of Latin American Studies. ");
        System.out.println("");
        System.out.println("The editorial committee have evaluated your manuscript and we regret to inform you that it will not be possible to further consider your manuscript for publication in AJLAS. After careful consideration by our editors, we found that the topic of your manuscript lies outside the stated aims and scope of the journal.");
        System.out.println("");
        System.out.println("Again, thank you for your interest in the journal, and I regret that the outcome could not have been more favorable. We sincerely hope you to submit another article for review in the near future.");
        System.out.println("");
        System.out.println("Sincerely,");
        System.out.println("");
        System.out.println("AJLAS Editorial Board");
        System.out.println("");
    }








    //getter and setter
    public Journal getVolume() { return volume; }
    public String getAuthorName() { return authorName; }
    public String getAuthorInstitution() { return authorInstitution; }
    public String getTitle() { return title; }
    public String getLanguage() { return language; }
    public String getSubmittedDate() { return submittedDate; }
    public ArrayList<Reviewer> getReviewers() { return reviewers; }
    public String getOverallResult() { return overallResult; }
    public String getStatus() { return status; }
    public void setVolume(Journal volume) { this.volume = volume; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
    public void setAuthorInstitution(String authorInstitution) { this.authorInstitution = authorInstitution; }
    public void setTitle(String title) { this.title = title; }
    public void setLanguage(String language) { this.language = language; }
    public void setSubmittedDate(String submittedDate) { this.submittedDate = submittedDate; }
    public void setReviewers(ArrayList<Reviewer> reviewers) { this.reviewers = reviewers; }
    public void setOverallResult(String overallResult) { this.overallResult = overallResult; }
    public void setStatus(String status) { this.status = status; }
    public boolean getRevisedArticleReceived() { return revisedArticleReceived; }
    public void setRevisedArticleReceived(boolean revisedArticleReceived) { this.revisedArticleReceived = revisedArticleReceived; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public boolean isRevisedArticleReceived() { return revisedArticleReceived; }
    public Reviewer getReReviewer() { return reReviewer; }
    public void setReReviewer(Reviewer reReviewer) { this.reReviewer = reReviewer; }
    public boolean getReRerevisedArticleReceived() { return RerevisedArticleReceived; }
    public void setReRevisedArticleReceived(boolean rerevisedArticleReceived) { RerevisedArticleReceived = rerevisedArticleReceived; }

    public String getNewDueDate() {        return newDueDate; }

    public void setNewDueDate(String newDueDate) { this.newDueDate = newDueDate; }

    public boolean isRerevisedArticleReceived() { return RerevisedArticleReceived; }

    public void setRerevisedArticleReceived(boolean rerevisedArticleReceived) { RerevisedArticleReceived = rerevisedArticleReceived; }
}



