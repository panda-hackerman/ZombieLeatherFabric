package dev.michaud.zombieleather;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZombieLeather implements ModInitializer {

  public static final String MOD_ID = "zombieleather";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  public static final Item SMOKED_ROTTEN_FLESH = Registry.register(
      Registries.ITEM, SmokedRottenFlesh.KEY,
      new SmokedRottenFlesh(new Item.Settings()
          .registryKey(SmokedRottenFlesh.KEY))
  );

  @Override
  public void onInitialize() {

    PolymerResourcePackUtils.addModAssets(MOD_ID);

    // Register trades
    TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 2,
        factories -> factories.add((entity, random) -> new TradeOffer(
            new TradedItem(SMOKED_ROTTEN_FLESH, 16),
            new ItemStack(Items.EMERALD, 1),
            12, 20, 0.05f
        ))
    );

    // Add to creative menu
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> {
      itemGroup.addAfter(Items.RABBIT_HIDE, SMOKED_ROTTEN_FLESH);
    });

    LOGGER.info("Zombie Leather initialized !");
  }
}