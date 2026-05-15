package com.featuredclient.update

import com.featuredclient.update.model.UpdateManifest

object VersionComparator {
    fun hasUpdate(currentVersionCode: Int, remote: UpdateManifest): Boolean {
        return remote.versionCode > currentVersionCode
    }
}
