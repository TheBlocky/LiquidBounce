/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */

package net.ccbluex.liquidbounce.api.minecraft.client.entity.player

import com.mojang.authlib.GameProfile
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP
import net.ccbluex.liquidbounce.api.minecraft.client.entity.projectile.IEntityFishHook
import net.ccbluex.liquidbounce.api.minecraft.entity.player.IInventoryPlayer
import net.ccbluex.liquidbounce.api.minecraft.entity.player.IPlayerCapabilities
import net.ccbluex.liquidbounce.api.minecraft.inventory.IContainer
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack
import net.ccbluex.liquidbounce.api.minecraft.stats.IStatList
import net.ccbluex.liquidbounce.api.minecraft.util.IFoodStats

@Suppress("INAPPLICABLE_JVM_NAME")
interface IEntityPlayer : IEntityLivingBase {
    val gameProfile: GameProfile
    val fishEntity: IEntityFishHook?
    val foodStats: IFoodStats
    val prevChasingPosY: Double
    var sleepTimer: Int
    var sleeping: Boolean
    val isPlayerSleeping: Boolean
    var speedInAir: Float

    @get:JvmName("isBlocking")
    val isBlocking: Boolean
    var itemInUseCount: Int
    val itemInUse: IItemStack?
    val capabilities: IPlayerCapabilities
    val heldItem: IItemStack?
    val isUsingItem: Boolean
    val inventoryContainer: IContainer
    val inventory: IInventoryPlayer
    val openContainer: IContainer?
    val itemInUseDuration: Float
    val displayNameString: String

    @get:JvmName("isSpectator")
    val spectator: Boolean


    fun stopUsingItem()
    fun onCriticalHit(entity: IEntity)
    fun onEnchantmentCritical(entity: IEntityLivingBase)
    fun attackTargetEntityWithCurrentItem(entity: IEntity)
    fun fall(distance: Float, damageMultiplier: Float)
    fun triggerAchievement(stat: IStatList)
    fun clonePlayer(player: IEntityPlayerSP, respawnFromEnd: Boolean)
}