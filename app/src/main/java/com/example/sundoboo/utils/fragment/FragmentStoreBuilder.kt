package com.example.sundoboo.utils.fragment

class FragmentStoreBuilder<KEY : Any> {
    private lateinit var fragments: Map<KEY, FragmentItem>

    fun with(newFragments : Map<KEY, FragmentItem>) : FragmentStoreBuilder<KEY> {
        fragments = newFragments
        return this
    }

    fun build() : FragmentStore<KEY> {
        return FragmentStore(
            fragments = this.fragments.toMutableMap()
        )
    }
}