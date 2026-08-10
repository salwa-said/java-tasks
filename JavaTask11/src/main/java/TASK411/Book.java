
package TASK411;

public class Book implements LibraryItem {
    private String title;
    private  String author;
    private  Integer pages;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.equals("")) {
            System.out.println("Title cannot be empty.");
            // keep old value
        } else {
            this.title = title;
        }
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        if(pages>0){
        this.pages = pages;}
        else {
            this.pages= 0;
            IO.println("Pages must be above 0.");
        }
    }

    @Override
    public void printAllInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);


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
