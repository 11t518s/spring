package com.example.demo.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    var name: String = "",

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    val scores: List<Score> = listOf()
)