package com.featuredclient.update

import com.featuredclient.update.model.UpdateManifest

/**
 * Coordinates the app update pipeline:
 * 1) Check remote manifest
 * 2) Download APK
 * 3) Verify checksum
 * 4) Trigger Android installer intent
 */
class UpdateCoordinator(
    private val updateRepository: UpdateRepository,
) {
    suspend fun poll(currentVersionCode: Int): UpdateManifest? {
        return updateRepository.checkForUpdate(currentVersionCode)
    }
}
