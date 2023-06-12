package com.captsone.pantura.network.repository

interface RemoteResources<in T> {
    fun createData(data: T)
    fun readData(data: T)
    fun updateData(data: T)
    fun deleteData(data: T)
}