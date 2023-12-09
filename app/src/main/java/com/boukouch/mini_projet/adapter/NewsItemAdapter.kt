package com.boukouch.mini_projet.adapter

import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.boukouch.mini_projet.R
import com.boukouch.mini_projet.model.NewsItem

class NewsItemAdapter(private val newsList: List<NewsItem>) : RecyclerView.Adapter<NewsItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)
        val newTextView: TextView = itemView.findViewById(R.id.textViewNew)
        val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        val attachmentsTextView: TextView = itemView.findViewById(R.id.textViewAttachments)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = newsList[position]

        holder.dateTextView.text = currentItem.date
        holder.newTextView.text = if (currentItem.isNew) "Nouveau" else ""
        holder.titleTextView.text = currentItem.title

        // Utilisez la nouvelle propriété pdfFileName pour personnaliser le texte de textViewAttachments
        val attachmentsText = "Pièces jointes : ${currentItem.pdfFileName}"
        holder.attachmentsTextView.text = getClickableText(attachmentsText, currentItem.pdfFileName)
    }

    override fun getItemCount() = newsList.size

    private fun getClickableText(fullText: String, clickablePart: String): SpannableString {
        val spannableString = SpannableString(fullText)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Mettez ici le code que vous souhaitez exécuter lors du clic sur le lien
                // Par exemple, ouvrir le lien PDF
                // openPdfLink(currentItem.pdfFileName)
            }
        }
        val startIndex = fullText.indexOf(clickablePart)
        val endIndex = startIndex + clickablePart.length
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }
}
