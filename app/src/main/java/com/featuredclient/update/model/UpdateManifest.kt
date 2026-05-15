package com.featuredclient.update.model

/**
 * Update metadata pulled from a remote endpoint controlled by Featured Client releases.
 */
data class UpdateManifest(
    val versionCode: Int,
    val versionName: String,
    val apkUrl: String,
    val sha256: String,
    val mandatory: Boolean,
    val notes: String,
)
