# Architecture (Initial)

## Modules
- `app`: Android entrypoint/UI shell
- `core`: models, logging, util
- `data`: database and repositories
- `feature:profiles`: profile flows
- `feature:packs`: pack flows
- `feature:launch`: preflight + launch
- `feature:diagnostics`: logs/export
- `feature:cosmetics`: cosmetic catalog and equip flows

## Key Data Types
- `Profile`: id, name, targetVersion, enabledPacks, graphicsPreset
- `Pack`: id, name, type, version, hash, path, status
- `CompatRule`: version, severity, ruleId, message, remediation
- `CosmeticItem`: id, slot, name, assetUri, rarity, entitlementId

## Initial Technical Stack
- Kotlin
- Jetpack Compose
- Room + DataStore
- Hilt
- WorkManager
