package com.zack.newsapp.presentation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.*;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.zack.newsapp.R;
import com.zack.newsapp.data.entities.NewsArticle;
import com.zack.newsapp.databinding.NewsDetailFragmentBinding;

/**
 * Created by zack on 7/20/18.
 */

public class NewsDetailFragment extends Fragment {
    NewsDetailFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.news_detail_fragment,container, false);
        bindDetails();
        return binding.getRoot();

    }

    public void bindDetails(){
        NewsArticle article = (NewsArticle) getArguments().getSerializable("article");
        Picasso.get().load(article.getUrlToImage()).fit()
                .into(binding.articleImage);
        binding.articleTitle.setText(article.getTitle());
        binding.articleContent.setText(article.getDescription());
    }

}
