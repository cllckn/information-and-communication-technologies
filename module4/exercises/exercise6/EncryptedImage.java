package cc.ku.ict.module4.exercises.exercise6;

public class EncryptedImage implements IImage {

    private int id;
    private String url;
    private String title;
    private int size;
    private String encryptionAlgorithm;
    private String encryptionKey;

    public EncryptedImage(int id, String url, String title, int size, String encryptionAlgorithm, String encryptionKey) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.size = size;
        this.encryptionAlgorithm = encryptionAlgorithm;
        this.encryptionKey = encryptionKey;
    }

    @Override
    public String toString() {
        return "EncryptedImage{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", encryptionAlgorithm='" + encryptionAlgorithm + '\'' +
                ", encryptionKey='" + encryptionKey + '\'' +
                '}';
    }
}
