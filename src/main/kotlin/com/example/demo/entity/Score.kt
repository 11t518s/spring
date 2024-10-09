package com.example.demo.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "score")
class Score(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(optional = false)
    @JoinColumn(name = "uid", updatable = false)
    @JsonBackReference
    val user: User,

    val score: Int = 0
) {
    constructor() : this(user = User(), score = 0)
}