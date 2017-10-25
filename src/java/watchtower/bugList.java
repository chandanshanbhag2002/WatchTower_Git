/*
 * Author:Chandan Shanbhag
 * 
 * 
 */
package watchtower;

/**
 *
 * @author chandan.shanbhag
 */
public class bugList {
    
    
    String Issue_Type,Issue_key,Project_name,Priority,Severity,Resolution,Status,Summary;

    public bugList(String Issue_Type, String Issue_key, String Project_name, String Priority, String Severity, String Resolution, String Status, String Summary) {
        this.Issue_Type = Issue_Type;
        this.Issue_key = Issue_key;
        this.Project_name = Project_name;
        this.Priority = Priority;
        this.Severity = Severity;
        this.Resolution = Resolution;
        this.Status = Status;
        this.Summary = Summary;
    }

    

    public String getIssue_Type() {
        return Issue_Type;
    }

    public String getIssue_key() {
        return Issue_key;
    }

    public String getProject_name() {
        return Project_name;
    }

    public String getPriority() {
        return Priority;
    }

    public String getSeverity() {
        return Severity;
    }

    public String getResolution() {
        return Resolution;
    }

    public String getStatus() {
        return Status;
    }

    public String getSummary() {
        return Summary;
    }

    public void setIssue_Type(String Issue_Type) {
        this.Issue_Type = Issue_Type;
    }

    public void setIssue_key(String Issue_key) {
        this.Issue_key = Issue_key;
    }

    public void setProject_name(String Project_name) {
        this.Project_name = Project_name;
    }

    public void setPriority(String Priority) {
        this.Priority = Priority;
    }

    public void setSeverity(String Severity) {
        this.Severity = Severity;
    }

    public void setResolution(String Resolution) {
        this.Resolution = Resolution;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

    
    
}
