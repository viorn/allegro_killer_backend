package com.allergo_killer.backend.entities

import javax.persistence.*

@Entity
@Table(indexes = [Index(columnList = "hotbed_id, parent_id")])
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1,
    val body: String,
    @ManyToMany(fetch = FetchType.EAGER)
    val images: List<Image>,
    val hotbed_id: Long,
    @Column(nullable = true)
    val parent_id: Long?
)