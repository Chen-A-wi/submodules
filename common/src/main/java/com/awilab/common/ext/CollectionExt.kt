package com.awilab.common.ext

inline fun <E : Any, T : Collection<E>> T?.withNotNullAndEmpty(func: T.() -> Unit) {
    if (!this.isNullOrEmpty()) {
        with(this) { func() }
    }
}

inline fun <E : Any, T : Collection<E>> T?.whenNotNullAndEmpty(func: (T) -> Unit) {
    if (!this.isNullOrEmpty()) {
        func(this)
    }
}