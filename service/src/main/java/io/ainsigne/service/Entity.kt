package io.ainsigne.service

data class Entity(val id: String,
                  val type: String,
                  val attributes: AttributesBase,
                  val relationships: Relationships)
