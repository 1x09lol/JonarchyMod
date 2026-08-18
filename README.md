# ServerUnblocker

<img width="235" height="235" alt="ChatGPT Image 18 août 2026, 23_46_43" src="https://github.com/user-attachments/assets/4b98330f-3744-477c-b516-e8e5c508cffc" />

ServerUnblocker is a Fabric client-side mod made for players who want an easy way to connect to `Jonarchy.com` if Minecraft's blocked-server system prevents the server from appearing or being joined normally.

The mod was created as a fallback in case Mojang blocks `Jonarchy.com` for any reason. Once installed, it bypasses the client-side blocked-server check and can automatically add `Jonarchy.com` to your multiplayer server list.

## Features

* Bypasses Minecraft's blocked-server check.
* Automatically adds `Jonarchy.com` to your multiplayer server list when it isn't already present.
* Works entirely on the client.
* Supports multiple Fabric/Minecraft versions.
* Requires no changes or installation on the Jonarchy server itself.

## Download

### <a href="https://github.com/1x09lol/JonarchyMod/releases">Download the latest release</a>

1. Download the `.jar` matching your Minecraft version from the GitHub Releases page.
2. Install [Fabric Loader](https://fabricmc.net/).
3. Install [Fabric API](https://modrinth.com/mod/fabric-api).
4. Move the downloaded `serverunblocker-mc-<version>.jar` into your `.minecraft/mods` directory.
5. Start Minecraft using your Fabric installation.

Once Minecraft launches, `Jonarchy.com` will be added to your multiplayer server list if it is not already there, and servers affected by the client-side blocklist can be joined.

## Privacy / Telemetry

ServerUnblocker is designed to run without collecting user information. The mod does **not** collect, store, or transmit personal or usage data.

Everything happens locally inside your Minecraft client. There are no analytics requests, tracking systems, or telemetry servers involved.

## Supported Versions

The project uses [Stonecutter](https://stonecutter.kikugie.dev/) to manage builds for different Minecraft and Fabric versions.

Individual version configurations can be found under:

`versions/<version>/gradle.properties`

## Contact

* Email: [contact@jonarchy.com](mailto:contact@jonarchy.com)
* Website: https://Jonarchy.com
* Discord: https://discord.jonarchy.com

## For Developers

A compatible JDK and an internet connection are required so Gradle can download Minecraft, mappings, Fabric Loader dependencies, and other required libraries.

```bash
# Build the currently selected version
gradle build

# Build all configured Minecraft versions
gradle chiseledBuild
```

Compiled jars are placed in:

`versions/<mc>/build/libs/`

## How It Works

ServerUnblocker makes two small client-side changes using Mixins:

| Mixin                 | Target                                                     | Effect                                                                              |
| --------------------- | ---------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `BlockedServersMixin` | `com.mojang.patchy.BlockedServers#isBlockedServerHostName` | Makes the client-side blocked-server check return `false`.                          |
| `ServerListMixin`     | `net.minecraft.client.multiplayer.ServerList#load`         | Inserts `Jonarchy.com` at the top of the server list when it isn't already present. |

Nothing needs to be installed on Jonarchy itself. The mod only changes the behavior of your local Minecraft client.

## License

MIT licensed.
