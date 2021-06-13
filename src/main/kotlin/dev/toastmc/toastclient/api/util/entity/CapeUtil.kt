package dev.toastmc.toastclient.api.util.entity

import com.google.gson.reflect.TypeToken
import dev.toastmc.toastclient.IToastClient
import dev.toastmc.toastclient.api.util.network.ConnectionUtil
import net.minecraft.util.Identifier
import java.lang.reflect.Type
import java.util.*

object CapeUtil : IToastClient {

    private val users = hashMapOf<UUID, String>()

    private val capes = arrayListOf(
        Identifier("toastclient", "capes/old_mojang.png"),
        Identifier("toastclient", "capes/toast.png"),
        Identifier("toastclient", "capes/minecon_2013.png"),
    )

    private val capeTypeStrings = arrayListOf(
        "NONE",
        "CONTRIBUTOR",
        "PLUS"
    )

    fun getIdentifierFromString(string: String): Identifier {
        for(capeType in capeTypeStrings) {
            if(capeType == string) {
                return capes[capeTypeStrings.indexOf(capeType)]
            }
        }
        return capes[0]
    }

    fun getCapeType(uuid: UUID): String? {
        return users.get(uuid)
    }

    fun init() {
        val type: Type = object : TypeToken<Map<UUID, String>>(){}.getType()
        if(ConnectionUtil.getJsonFromUrl("https://raw.githubusercontent.com/SkiddyToast/ToastClient/dev/capes.json") != "") {
            val cachedUsers: Map<UUID, String> =
                gson.fromJson<Map<UUID, String>>(ConnectionUtil.getJsonFromUrl("https://raw.githubusercontent.com/SkiddyToast/ToastClient/dev/capes.json"), type)
            for (entry in cachedUsers.entries) {
                users.put(entry.key, entry.value)
            }
            logger.info(users.entries.toString())
        } else {
            logger.error("Failed to get capes.")
        }
    }

    fun getCapeUtil(): CapeUtil {
        return this
    }

}