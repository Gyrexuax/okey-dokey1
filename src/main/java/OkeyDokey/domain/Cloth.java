package OkeyDokey.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Cloth {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cloth_id_seq")
    @SequenceGenerator(name = "cloth_id_seq", sequenceName = "cloth_id_seq", initialValue = 109, allocationSize = 1)
    private Long id;

    @Column(name = "cloth_title", nullable = false)
    private String clothTitle;

    @Column(name = "clother", nullable = false)
    private String clother;

    @Column(name = "cloth_type", nullable = false)
    private String clothType;

    @Column(name = "cloth_gender", nullable = false)
    private String clothGender;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "description")
    private String description;

    @Column(name = "filename")
    private String filename;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "type", nullable = false)
    private String type;
}