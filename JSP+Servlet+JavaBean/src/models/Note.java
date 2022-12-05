package models;

public class Note {
    private String username;
    private String Title;
    private String Content;
    private int Purview;

    public Note() {
    }

    public Note(String username, String title, String content) {
        this.username = username;
        Title = title;
        Content = content;
    }

    public Note(String username, String title) {
        this.username = username;
        Title = title;
    }

    public Note(String username, String title, String content, int purview) {
        this.username = username;
        Title = title;
        Content = content;
        Purview = purview;
    }

    public Note(String username) {
        this.username = username;
    }

    public Note(String username, String title, int purview) {
        this.username = username;
        Title = title;
        Purview = purview;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getPurview() {
        return Purview;
    }

    public void setPurview(int purview) {
        Purview = purview;
    }
}
