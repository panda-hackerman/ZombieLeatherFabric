package dev.michaud.zombieleather;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xyz.nucleoid.packettweaker.PacketContext;

public class SmokedRottenFlesh extends Item implements PolymerItem {

  public static final RegistryKey<Item> KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(
      ZombieLeather.MOD_ID, "smoked_rotten_flesh"));

  public SmokedRottenFlesh(Item.Settings settings) {
    super(settings);
  }

  @Override
  public Item getPolymerItem(ItemStack itemStack, PacketContext packetContext) {
    return Items.RABBIT_HIDE;
  }

  @Override
  public @Nullable Identifier getPolymerItemModel(ItemStack stack, PacketContext context) {
    if (PolymerResourcePackUtils.hasMainPack(context)) {
      return Identifier.of("greenpanda", "smoked_rotten_flesh");
    } else {
      return Identifier.of("minecraft", "rabbit_hide");
    }
  }
}