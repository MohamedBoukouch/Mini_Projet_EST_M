package com.boukouch.mini_projet.model


data class NewsItem(
    val date: String,
    val isNew: Boolean,
    val title: String,
    val pdfFileName: String // Nouvelle propriété pour stocker le nom du fichier PDF
)

