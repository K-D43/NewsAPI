package com.example.newsapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapi.Models.Article
import com.example.newsapi.R
import kotlinx.android.synthetic.main.list_article_preview.view.*

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.ArticlaViewHolder>() {
    class ArticlaViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


    }
    
    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlaViewHolder {
        return ArticlaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_article_preview,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ArticlaViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvSource.text=article.source.name
            tvTitle.text=article.title
            tvDescription.text=article.description
            tvPublishedAt.text=article.publishedAt
            setOnClickListener {
                onItemClickedListener?.let { it(article) }
            }
        }
    }

    private var onItemClickedListener:((Article)->Unit)?=null

    fun setOnItemClickListener(listener:(Article)->Unit) {
        onItemClickedListener=listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}