package com.fashare.mvvm_juejin.viewmodel

import android.databinding.ObservableArrayList
import com.fashare.mvvm_juejin.BR
import com.fashare.mvvm_juejin.R
import com.fashare.mvvm_juejin.model.HotRecomment
import me.tatarka.bindingcollectionadapter.ItemView
import me.tatarka.bindingcollectionadapter.ItemViewArg

/**
 * <pre>
 * author : jinliangshan
 * e-mail : jinliangshan@chexiang.com
 * desc   :
</pre> *
 */
class HomeListVM{
    var itemView = ItemViewArg.of<HotRecomment.EntryBean.EntrylistBean>(ItemView.of(BR.item, R.layout.item_home_list))
    var viewModels = ObservableArrayList<HotRecomment.EntryBean.EntrylistBean>()
}