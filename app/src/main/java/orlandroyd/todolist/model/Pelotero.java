package orlandroyd.todolist.model;

public class Pelotero {
    private int imgAvatar;
    private String title;
    private String sub;

    public Pelotero(int imgAvatar, String title, String sub) {
        this.imgAvatar = imgAvatar;
        this.title = title;
        this.sub = sub;
    }

    public int getImgAvatar() {
        return imgAvatar;
    }

    public String getTitle() {
        return title;
    }

    public String getSub() {
        return sub;
    }

}
