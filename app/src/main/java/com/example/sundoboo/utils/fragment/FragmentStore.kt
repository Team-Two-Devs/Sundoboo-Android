package com.example.sundoboo.utils.fragment

import androidx.fragment.app.Fragment

class FragmentStore<KEY : Any>(
    private val fragments: MutableMap<KEY, FragmentItem> = mutableMapOf()
) {

    val size: Int
        get() = fragments.size

    fun findFragmentByKey(key: KEY): FragmentItem {
        return fragments[key]
            ?: throw Exception("Fragment with key $key not found!")
    }

    fun changeFragments(newFragments: Map<KEY, FragmentItem>) {
        fragments.forEach {
            if (!newFragments.containsKey(it.key)) fragments.remove(it.key)
        }
        fragments.putAll(newFragments.filter {
            !fragments.containsKey(it.key)
        })
    }

}

data class FragmentItem(
    val tag: String,
    val fragment: Fragment,
    val shouldAddBackStack: Boolean = false
)