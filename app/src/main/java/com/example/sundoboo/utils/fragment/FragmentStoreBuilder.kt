package com.example.sundoboo.utils.fragment

class FragmentStoreBuilder<KEY : Any> {
    private lateinit var fragments: Map<KEY, FragmentItem>

    fun insertFragments(creator : () -> Map<KEY, FragmentItem>) : FragmentStoreBuilder<KEY> {
        fragments = creator()
        return this
    }

    fun build() : FragmentStore<KEY> {
        return FragmentStore(
            fragments = this.fragments
        )
    }
}