package com.zack.newsapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.*;

import com.squareup.picasso.Picasso;
import com.zack.newsapp.data.entities.NewsArticle;
import com.zack.newsapp.databinding.NewsItemBinding;

import java.util.List;

/**
 * Created by zack on 7/20/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private List<NewsArticle> articles;
    private RecyclerClickListener recyclerClickListener;


    public NewsAdapter(Context context, List<NewsArticle> articles, RecyclerClickListener recyclerClickListener) {
        this.context = context;
        this.articles = articles;
        this.recyclerClickListener = recyclerClickListener;

    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater,parent,false);
        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsArticle article = articles.get(position);
        holder.bind(article);
        holder.binding.getRoot().setOnClickListener(view ->
                recyclerClickListener.OnItemClicked(position,article,view));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private NewsItemBinding binding;
        public NewsViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(NewsArticle article){
            Picasso.get().load(article.getUrlToImage()).fit().into(binding.newsImage);
            binding.newsTitle.setText(article.getTitle());
        }
    }
}
