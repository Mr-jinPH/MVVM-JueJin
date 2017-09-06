package com.fashare.mvvm_juejin.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.annotation.DrawableRes
import com.fashare.mvvm_juejin.R
import me.tatarka.bindingcollectionadapter.ItemView
import java.util.*

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail : jinliangshan@chexiang.com
 *     desc   :
 * </pre>
 */
class TabVM{
    var text = "haha"
    var itemView: ItemView = ItemView.of(com.fashare.mvvm_juejin.BR.viewModel, R.layout.item_main_tab)
    var itemList: ObservableList<Any> = ObservableArrayList<Any>().apply{
        this.addAll(Arrays.asList(
                ItemVM(R.mipmap.ic_launcher),
                ItemVM(R.mipmap.ic_launcher),
                ItemVM(R.mipmap.ic_launcher),
                ItemVM(R.mipmap.ic_launcher)
        ))
    }

    class ItemVM(@DrawableRes var iconRes: Int)
}