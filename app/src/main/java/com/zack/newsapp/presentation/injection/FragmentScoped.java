package com.zack.newsapp.presentation.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by zack on 7/20/18.
 */
@Scope @Retention(RetentionPolicy.RUNTIME)
@interface FragmentScoped {
}
