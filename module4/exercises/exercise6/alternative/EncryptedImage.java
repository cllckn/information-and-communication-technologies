package cc.ku.ict.module4.exercises.exercise6.alternative;

import cc.ku.ict.module4.exercises.exercise6.Image;

public class EncryptedImage extends Image {

    private String encryptionAlgorithm;
    private String encryptionKey;

    public EncryptedImage(int id, String url, String title, int size, String encryptionAlgorithm, String encryptionKey) {
        super(id, url, title, size);
        this.encryptionAlgorithm = encryptionAlgorithm;
        this.encryptionKey = encryptionKey;
    }

    @Override
    public String toString() {
        return "EncryptedImage{" +
                super.toString() +
                "encryptionAlgorithm='" + encryptionAlgorithm + '\'' +
                ", encryptionKey='" + encryptionKey + '\'' +
                '}';
    }
}
