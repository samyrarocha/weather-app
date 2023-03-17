package com.samyrarocha.core.data.mappers

interface DomainMapper<E, D> {
    fun mapToDomain(apiEntity: E): D
}