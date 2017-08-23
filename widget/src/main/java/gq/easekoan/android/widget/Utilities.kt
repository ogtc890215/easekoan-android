package gq.easekoan.android.widget


inline fun debug(handler: () -> Unit) {
    if (BuildConfig.DEBUG) {
        handler()
    }
}