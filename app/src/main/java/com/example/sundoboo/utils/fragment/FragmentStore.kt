package com.example.sundoboo.utils.fragment

import androidx.fragment.app.Fragment

class FragmentStore<KEY : Any>(
    private var fragments: Map<KEY, FragmentItem> = mapOf()
) {

    val size: Int
        get() = fragments.size

    fun findFragmentByKey(key: KEY): FragmentItem {
        return fragments[key]
            ?: throw Exception("Fragment with key $key not found!")
    }

    fun changeFragments(creator : () -> Map<KEY, FragmentItem>) {
        fragments = creator()
    }

}

data class FragmentItem(
    val tag: String,
    val fragment: Fragment,
    val shouldAddBackStack: Boolean = false
)