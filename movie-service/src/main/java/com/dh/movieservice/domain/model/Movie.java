package com.dh.movieservice.domain.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Movie")
public class Movie implements Serializable {



    @Serial
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "novieSecuence")
    @SequenceGenerator(name = "novieSecuence", sequenceName = "novieSecuence", allocationSize = 1)

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Column(name = "id", nullable = false)
    @NotNull
    private Long id;


    private String name;

    @Basic(fetch = FetchType.LAZY)
    private String genre;

    @Basic(fetch = FetchType.LAZY)
    private String urlStream;

}


