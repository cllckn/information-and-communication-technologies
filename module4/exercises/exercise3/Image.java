package cc.ku.ict.module4.exercises.exercise3;

public class Image {

    private int id;
    private String url;
    private String title;
    private int size;

    public Image(int id, String url, String title, int size) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
