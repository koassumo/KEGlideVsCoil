package com.example.keglidevscoil.model

interface IGladeImageLoader <T>{
    fun loadInto (url: String, container: T)
}