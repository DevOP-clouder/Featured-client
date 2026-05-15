package com.featuredclient.update

/**
 * Placeholder scheduler contract.
 *
 * In Android runtime this should be implemented with WorkManager periodic work.
 */
interface UpdateScheduler {
    fun scheduleAutomaticChecks()
}
