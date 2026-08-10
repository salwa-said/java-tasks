package TASK411;

public class Magazine implements LibraryItem {
    private  String name;
    private  Integer issueNumber;
    private  String month;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            System.out.println("Name cannot be empty.");
            // keep old value
        } else {
            this.name = name;
        }
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber) {
        if (issueNumber >= 1 && issueNumber <= 500) {
            this.issueNumber = issueNumber;
        } else {
            System.out.println("Invalid issue number.");
        }
    }

    @Override
    public void printAllInfo() {

    }

    @Override
    public String getLabel() {
        return "";
    }

    @Override
    public String getShelfCode() {
        return "";
    }
}
