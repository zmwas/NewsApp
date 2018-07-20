package com.zack.newsapp.presentation;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;

import com.zack.newsapp.AppComponent;
import com.zack.newsapp.NewsApplication;
import com.zack.newsapp.R;
import com.zack.newsapp.adapters.NewsAdapter;
import com.zack.newsapp.adapters.RecyclerClickListener;
import com.zack.newsapp.data.entities.NewsArticle;
import com.zack.newsapp.data.entities.NewsArticleResponse;
import com.zack.newsapp.databinding.NewsListBinding;
import com.zack.newsapp.presentation.injection.DaggerNewsPresenterComponent;
import com.zack.newsapp.presentation.injection.NewsPresenterModule;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by zack on 7/20/18.
 */

public class NewsListFragment extends Fragment implements NewsInterface, RecyclerClickListener{
    NewsListBinding binding;
    RecyclerView recyclerView;

    @Inject
    NewsPresenter newsPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent = ((NewsApplication)getActivity()
                .getApplication())
                .getAppComponent();
        DaggerNewsPresenterComponent.builder()
                .appComponent(appComponent)
                .newsPresenterModule(new NewsPresenterModule())
                .build().inject(this);
        System.out.print(newsPresenter);
        newsPresenter.attachView(this);
        newsPresenter.getNewsArticles();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.news_list,container, false);
        recyclerView = binding.newsArticles;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return binding.getRoot();
    }

    @Override
    public void displayArticles(NewsArticleResponse response) {
        List<NewsArticle> articles = response.articles;
        NewsAdapter newsAdapter = new NewsAdapter(getActivity(), articles, this);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void OnItemClicked(int Position, NewsArticle article, View v) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("article", article);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(bundle);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
