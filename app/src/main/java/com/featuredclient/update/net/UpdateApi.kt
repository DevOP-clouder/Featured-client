package com.featuredclient.update.net

import com.featuredclient.update.model.UpdateManifest

/**
 * Abstraction for fetching update metadata.
 *
 * Implementation can use Retrofit/Ktor. Kept as an interface for testability.
 */
interface UpdateApi {
    suspend fun fetchManifest(): UpdateManifest
}
