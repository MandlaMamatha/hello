package net.thrymr.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "image")
public class FileData {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    private byte[] inputStream;
  //  private long fileSize;
    @Lob
    @Column(name = "fileData")
    private byte[] fileData;

    public FileData(String name, String type, byte[] inputStream) {
        this.name = name;
        this.type = type;
        this.inputStream = inputStream;
    }
}
