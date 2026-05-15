package com.featuredclient.update

import com.featuredclient.update.model.UpdateManifest
import com.featuredclient.update.net.UpdateApi

class UpdateRepository(private val api: UpdateApi) {
    suspend fun checkForUpdate(currentVersionCode: Int): UpdateManifest? {
        val remote = api.fetchManifest()
        return if (VersionComparator.hasUpdate(currentVersionCode, remote)) remote else null
    }
}
