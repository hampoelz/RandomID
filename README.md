# Random ID
This plugin generates random IDs and UUIDs via placeholders or via commands. It can also display the UUID of a player via placeholder or via command.

If you have problems with the new update, please contact me. I did not completely test the update because I do not have that much time.

## Features:
- Generate random IDs via Command or via Placeholder
- Generate random UUIDs via Command or via Placeholder
- Get your own UUID via Command or via Placeholder
- Get the UUID of a player via Command
- PlaceHolderAPI Support
- Config
- Messages are completely editable
- Permissions
- In-game commands
- Multi-version support
- Open-Source
- Support

## Commands:
- `/id`
	- Get your Personal ID (if enabled)
- `/id <player>`
	- Get the Personal ID of a player (if enabled)
- `/uuid`
	- Get your own UUID
- `/uuid <player>`
	- Get the UUID of a player
- `/randomid`
	- Get a random ID
- `/randomid <length>`
	- Get a random ID in a certain length
- `/randomid reload`
	- Reload the config file
- `/randomuuid`
	- Get a random UUID

## Placeholders (with PlaceholderAPI):
- Get a random ID
	- `%RandomID_id%`
- Get a random ID with Chat Message
	- `%RandomID_id-msg%`
- Get a random ID in a certain length
	- `%RandomID_id-<length>%`
- Get a random ID in a certain length with Chat Message
	- `%RandomID_id-<length>-msg%`
- Get a random UUID
	- `%RandomID_uuid%`
- Get a random UUID with Chat Message
	- `%RandomID_uuid-msg%`
- Get your Personal ID
	- `%RandomID_personal_id%`
- Get your Personal ID with Chat Message
	- `%RandomID_personal_id-msg%`
- Get the Personal ID of a player
	- `%RandomID_personal_id-<player>%`
- Get the Personal ID of a player with Chat Message
	- `%RandomID_personal_id-<player>-msg%`
- Get your own UUID
	- `%RandomID_player_uuid%`
- Get your own UUID with Chat Message
	- `%RandomID_player_uuid-msg%`
- Get the UUID of a player
	- `%RandomID_player_uuid-<player>%`
- Get the UUID of a player with Chat Message
	- `%RandomID_player_uuid-<player>-msg%`
	
## Permissions:
- `RandomID.reload`
	- `/randomid reload`
- `RandomID.ID.random`
	- `/randomid`
	- `/randomid <length>`
- `RandomID.UUID.self`
	- `/uuid`
- `RandomID.UUID.other`
	- `/uuid player`
- `RandomID.UUID.random`
	- `/randomuuid`
- `RandomID.PersonalID.self`
	- `/id`
- `RandomID.PersonalID.other`
	- `/id <player>`

## Links:
- Sites: [>> GitHub <<](https://github.com/hampoelz/RandomID)
- Support: [>> GitHub <<](https://github.com/hampoelz/RandomID/issues)
- Releases: [>> GitHub <<](https://github.com/hampoelz/RandomID/releases)
- License: [>> MIT License <<](https://github.com/hampoelz/RandomID/blob/master/LICENSE)
