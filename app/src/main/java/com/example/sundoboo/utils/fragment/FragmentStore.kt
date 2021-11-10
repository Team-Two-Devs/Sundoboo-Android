package com.example.sundoboo.utils.fragment

import androidx.fragment.app.Fragment

class FragmentStore<KEY : Any>(
    private val fragments: Map<KEY, FragmentItem>
) {

    val size: Int
        get() = fragments.size

    fun getFragmentMatchesMenuId(key: KEY): FragmentItem {
        return fragments[key]
            ?: throw Exception("Fragment with menuId $key not found!")
    }

}

data class FragmentItem(
    val tag: String,
    val fragment: Fragment,
    val shouldAddBackStack: Boolean
)