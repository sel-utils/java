/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 */
package sul.protocol.java210;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import sul.utils.Packet;

public final class Packets {

	private Packets() {}

	public static final Map<Integer, Class<? extends Packet>> STATUS;

	public static final Map<Integer, Class<? extends Packet>> LOGIN;

	public static final Map<Integer, Class<? extends Packet>> CLIENTBOUND;

	public static final Map<Integer, Class<? extends Packet>> SERVERBOUND;

	static {

		HashMap<Integer, Class<? extends Packet>> status = new HashMap<Integer, Class<? extends Packet>>();
		status.put(0, sul.protocol.java210.status.Handshake.class);
		status.put(0, sul.protocol.java210.status.Request.class);
		status.put(0, sul.protocol.java210.status.Response.class);
		status.put(1, sul.protocol.java210.status.Latency.class);
		STATUS = Collections.unmodifiableMap(status);

		HashMap<Integer, Class<? extends Packet>> login = new HashMap<Integer, Class<? extends Packet>>();
		login.put(0, sul.protocol.java210.login.Disconnect.class);
		login.put(0, sul.protocol.java210.login.LoginStart.class);
		login.put(1, sul.protocol.java210.login.EncryptionRequest.class);
		login.put(1, sul.protocol.java210.login.EncryptionResponse.class);
		login.put(2, sul.protocol.java210.login.LoginSuccess.class);
		login.put(3, sul.protocol.java210.login.SetCompression.class);
		LOGIN = Collections.unmodifiableMap(login);

		HashMap<Integer, Class<? extends Packet>> clientbound = new HashMap<Integer, Class<? extends Packet>>();
		clientbound.put(0, sul.protocol.java210.clientbound.SpawnObject.class);
		clientbound.put(1, sul.protocol.java210.clientbound.SpawnExperienceOrb.class);
		clientbound.put(2, sul.protocol.java210.clientbound.SpawnGlobalEntity.class);
		clientbound.put(3, sul.protocol.java210.clientbound.SpawnMob.class);
		clientbound.put(4, sul.protocol.java210.clientbound.SpawnPainting.class);
		clientbound.put(5, sul.protocol.java210.clientbound.SpawnPlayer.class);
		clientbound.put(6, sul.protocol.java210.clientbound.Animation.class);
		clientbound.put(7, sul.protocol.java210.clientbound.Statistics.class);
		clientbound.put(8, sul.protocol.java210.clientbound.BlockBreakAnimation.class);
		clientbound.put(9, sul.protocol.java210.clientbound.UpdateBlockEntity.class);
		clientbound.put(10, sul.protocol.java210.clientbound.BlockAction.class);
		clientbound.put(11, sul.protocol.java210.clientbound.BlockChange.class);
		clientbound.put(12, sul.protocol.java210.clientbound.BossBar.class);
		clientbound.put(13, sul.protocol.java210.clientbound.ServerDifficulty.class);
		clientbound.put(14, sul.protocol.java210.clientbound.TabComplete.class);
		clientbound.put(15, sul.protocol.java210.clientbound.ChatMessage.class);
		clientbound.put(16, sul.protocol.java210.clientbound.MultiBlockChange.class);
		clientbound.put(17, sul.protocol.java210.clientbound.ConfirmTransaction.class);
		clientbound.put(18, sul.protocol.java210.clientbound.CloseWindow.class);
		clientbound.put(19, sul.protocol.java210.clientbound.OpenWindow.class);
		clientbound.put(20, sul.protocol.java210.clientbound.WindowItems.class);
		clientbound.put(21, sul.protocol.java210.clientbound.WindowProperty.class);
		clientbound.put(22, sul.protocol.java210.clientbound.SetSlot.class);
		clientbound.put(23, sul.protocol.java210.clientbound.SetCooldown.class);
		clientbound.put(24, sul.protocol.java210.clientbound.PluginMessage.class);
		clientbound.put(25, sul.protocol.java210.clientbound.NamedSoundEffect.class);
		clientbound.put(26, sul.protocol.java210.clientbound.Disconnect.class);
		clientbound.put(27, sul.protocol.java210.clientbound.EntityStatus.class);
		clientbound.put(28, sul.protocol.java210.clientbound.Explosion.class);
		clientbound.put(29, sul.protocol.java210.clientbound.UnloadChunk.class);
		clientbound.put(30, sul.protocol.java210.clientbound.ChangeGameState.class);
		clientbound.put(31, sul.protocol.java210.clientbound.KeepAlive.class);
		clientbound.put(32, sul.protocol.java210.clientbound.ChunkData.class);
		clientbound.put(33, sul.protocol.java210.clientbound.Effect.class);
		clientbound.put(34, sul.protocol.java210.clientbound.Particle.class);
		clientbound.put(35, sul.protocol.java210.clientbound.JoinGame.class);
		clientbound.put(36, sul.protocol.java210.clientbound.Map.class);
		clientbound.put(37, sul.protocol.java210.clientbound.EntityRelativeMove.class);
		clientbound.put(38, sul.protocol.java210.clientbound.EntityLookAndRelativeMove.class);
		clientbound.put(39, sul.protocol.java210.clientbound.EntityLook.class);
		clientbound.put(40, sul.protocol.java210.clientbound.Entity.class);
		clientbound.put(41, sul.protocol.java210.clientbound.VehicleMove.class);
		clientbound.put(42, sul.protocol.java210.clientbound.OpenSignEditor.class);
		clientbound.put(43, sul.protocol.java210.clientbound.PlayerAbilities.class);
		clientbound.put(44, sul.protocol.java210.clientbound.CombatEvent.class);
		clientbound.put(45, sul.protocol.java210.clientbound.PlayerListItem.class);
		clientbound.put(46, sul.protocol.java210.clientbound.PlayerPositionAndLook.class);
		clientbound.put(47, sul.protocol.java210.clientbound.UseBed.class);
		clientbound.put(48, sul.protocol.java210.clientbound.DestroyEntities.class);
		clientbound.put(49, sul.protocol.java210.clientbound.RemoveEntityEffect.class);
		clientbound.put(50, sul.protocol.java210.clientbound.ResourcePackSend.class);
		clientbound.put(51, sul.protocol.java210.clientbound.Respawn.class);
		clientbound.put(52, sul.protocol.java210.clientbound.EntityHeadLook.class);
		clientbound.put(53, sul.protocol.java210.clientbound.WorldBorder.class);
		clientbound.put(54, sul.protocol.java210.clientbound.Camera.class);
		clientbound.put(55, sul.protocol.java210.clientbound.HeldItemChange.class);
		clientbound.put(56, sul.protocol.java210.clientbound.DisplayScoreboard.class);
		clientbound.put(57, sul.protocol.java210.clientbound.EntityMetadata.class);
		clientbound.put(58, sul.protocol.java210.clientbound.AttachEntity.class);
		clientbound.put(59, sul.protocol.java210.clientbound.EntityVelocity.class);
		clientbound.put(60, sul.protocol.java210.clientbound.EntityEquipment.class);
		clientbound.put(61, sul.protocol.java210.clientbound.SetExperience.class);
		clientbound.put(62, sul.protocol.java210.clientbound.UpdateHealth.class);
		clientbound.put(63, sul.protocol.java210.clientbound.ScoreboardObjective.class);
		clientbound.put(64, sul.protocol.java210.clientbound.SetPassengers.class);
		clientbound.put(65, sul.protocol.java210.clientbound.Teams.class);
		clientbound.put(66, sul.protocol.java210.clientbound.UpdateScore.class);
		clientbound.put(67, sul.protocol.java210.clientbound.SpawnPosition.class);
		clientbound.put(68, sul.protocol.java210.clientbound.TimeUpdate.class);
		clientbound.put(69, sul.protocol.java210.clientbound.Title.class);
		clientbound.put(70, sul.protocol.java210.clientbound.SoundEffect.class);
		clientbound.put(71, sul.protocol.java210.clientbound.PlayerListHeaderAndFooter.class);
		clientbound.put(72, sul.protocol.java210.clientbound.CollectItem.class);
		clientbound.put(73, sul.protocol.java210.clientbound.EntityTeleport.class);
		clientbound.put(74, sul.protocol.java210.clientbound.EntityProperties.class);
		clientbound.put(75, sul.protocol.java210.clientbound.EntityEffect.class);
		CLIENTBOUND = Collections.unmodifiableMap(clientbound);

		HashMap<Integer, Class<? extends Packet>> serverbound = new HashMap<Integer, Class<? extends Packet>>();
		serverbound.put(0, sul.protocol.java210.serverbound.TeleportConfirm.class);
		serverbound.put(1, sul.protocol.java210.serverbound.TabComplete.class);
		serverbound.put(2, sul.protocol.java210.serverbound.ChatMessage.class);
		serverbound.put(3, sul.protocol.java210.serverbound.ClientStatus.class);
		serverbound.put(4, sul.protocol.java210.serverbound.ClientSettings.class);
		serverbound.put(5, sul.protocol.java210.serverbound.ConfirmTransaction.class);
		serverbound.put(6, sul.protocol.java210.serverbound.EnchantItem.class);
		serverbound.put(7, sul.protocol.java210.serverbound.ClickWindow.class);
		serverbound.put(8, sul.protocol.java210.serverbound.CloseWindow.class);
		serverbound.put(9, sul.protocol.java210.serverbound.PluginMessage.class);
		serverbound.put(10, sul.protocol.java210.serverbound.UseEntity.class);
		serverbound.put(11, sul.protocol.java210.serverbound.KeepAlive.class);
		serverbound.put(12, sul.protocol.java210.serverbound.PlayerPosition.class);
		serverbound.put(13, sul.protocol.java210.serverbound.PlayerPositionAndLook.class);
		serverbound.put(14, sul.protocol.java210.serverbound.PlayerLook.class);
		serverbound.put(15, sul.protocol.java210.serverbound.Player.class);
		serverbound.put(16, sul.protocol.java210.serverbound.VehicleMove.class);
		serverbound.put(17, sul.protocol.java210.serverbound.SteerBoat.class);
		serverbound.put(18, sul.protocol.java210.serverbound.PlayerAbilities.class);
		serverbound.put(19, sul.protocol.java210.serverbound.PlayerDigging.class);
		serverbound.put(20, sul.protocol.java210.serverbound.EntityAction.class);
		serverbound.put(21, sul.protocol.java210.serverbound.SteerVehicle.class);
		serverbound.put(22, sul.protocol.java210.serverbound.ResourcePackStatus.class);
		serverbound.put(23, sul.protocol.java210.serverbound.HeldItemChange.class);
		serverbound.put(24, sul.protocol.java210.serverbound.CreativeInventoryAction.class);
		serverbound.put(25, sul.protocol.java210.serverbound.UpdateSign.class);
		serverbound.put(26, sul.protocol.java210.serverbound.Animation.class);
		serverbound.put(27, sul.protocol.java210.serverbound.Spectate.class);
		serverbound.put(28, sul.protocol.java210.serverbound.PlayerBlockPlacement.class);
		serverbound.put(29, sul.protocol.java210.serverbound.UseItem.class);
		SERVERBOUND = Collections.unmodifiableMap(serverbound);

	}

}