package com.admin.scnadmin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CommentConsult", schema = "scn_appointments")
public class CommentConsult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IdConsult")
    private long idConsult;

    @Column(name = "DescriptionComment")
    private String descriptionComment;

    @Column(name = "Author")
    private int author;

    @Column(name = "DateComment")
    private String dateComment;
}
