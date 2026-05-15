# Featured Client Auto Update System

This document defines an automatic update pipeline for Featured Client.

## Important Android Constraint
Android apps cannot silently replace themselves in real-time like web apps unless they are distributed through privileged enterprise channels or system-level device owner setups.

For normal Play Store / sideload distributions, the safe/standard behavior is:
1. Detect updates automatically in background.
2. Download update package automatically.
3. Prompt user to approve installation (required by Android).

## Architecture

### 1) Source of truth (GitHub)
- Every merge/release in GitHub Actions publishes:
  - APK artifact
  - `update-manifest.json`
- Manifest should be served from a stable URL (GitHub Pages / Releases asset URL).

### 2) In-app update loop
- `UpdateWorker` runs on a schedule (e.g. every 15 minutes for internal builds, every 6-12h in production).
- Worker fetches `update-manifest.json` and compares current version with remote version.
- If newer version exists, app downloads APK to app-private storage.
- App posts a high-priority notification with one-tap install action.

### 3) Integrity and authenticity
- Manifest includes SHA-256 for APK.
- App verifies SHA-256 before offering install.
- Optional: add detached signature for manifest.

## Manifest schema example

```json
{
  "versionCode": 12,
  "versionName": "1.2.0",
  "apkUrl": "https://example.com/FeaturedClient-1.2.0.apk",
  "sha256": "...",
  "mandatory": false,
  "notes": "Profile sync and update channel improvements"
}
```

## Release automation suggestion
- On git tag push:
  - Build signed release APK
  - Compute SHA-256
  - Generate manifest
  - Upload both to release assets
  - (Optional) publish manifest to GitHub Pages stable endpoint
