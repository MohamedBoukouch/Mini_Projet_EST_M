
package com.boukouch.mini_projet.adapter

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.boukouch.mini_projet.R
import com.boukouch.mini_projet.model.NewsItem

class NewsItemAdapter(private val context: Context, private val newsList: List<NewsItem>) : RecyclerView.Adapter<NewsItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)
        val newTextView: TextView = itemView.findViewById(R.id.textViewNew)
        val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        val attachmentsTextView: TextView = itemView.findViewById(R.id.textViewAttachments)

        var pdfFileName: String? = null
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

        // Utilize the new property pdfFileName to customize the text of textViewAttachments
        val attachmentsText = "Pièces jointes : ${currentItem.pdfFileName}"

        // Pass the holder to getClickableText
        holder.attachmentsTextView.text = getClickableText(holder, attachmentsText, currentItem.pdfFileName)

        // Store the PDF file name in the ViewHolder
        holder.pdfFileName = currentItem.pdfFileName
    }

    override fun getItemCount() = newsList.size

    private fun getClickableText(holder: ViewHolder, fullText: String, clickablePart: String): SpannableString {
        val spannableString = SpannableString(fullText)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Handle the click event by opening the PDF file
                holder.pdfFileName?.let { openPdfLink(holder, it) }
            }
        }
        val startIndex = fullText.indexOf(clickablePart)
        val endIndex = startIndex + clickablePart.length
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }

    private fun openPdfLink(holder: ViewHolder, pdfFileName: String) {
        try {
            // Load the PDF file from the assets folder
            val uri = Uri.parse("file:///android_asset/$pdfFileName")
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(uri, "application/pdf")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            // Check if there's an app to handle the intent
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                Log.d("OpenPdf", "No app found to open PDF files.")
                // You might want to display a message to the user or take an alternative action.
            }
        } catch (e: ActivityNotFoundException) {
            Log.e("OpenPdf", "Error opening PDF file.", e)
            // Handle the exception if no activity is found to handle the intent.
        }
    }
}
