package subaraki.umbralux.item;

import static lib.item.ItemRegistry.registerItem;
import static lib.item.ItemRegistry.registerRender;
import static lib.item.ItemRegistry.registerVanillaRender;

import lib.item.ItemRegistry;
import lib.item.shield.ItemCustomShield;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import subaraki.umbralux.config.ConfigurationHandler;
import subaraki.umbralux.item.armor.ItemNecromancerArmor;
import subaraki.umbralux.item.armor.ItemPaladinArmor;
import subaraki.umbralux.item.weapon.ItemPaladinSword;
import subaraki.umbralux.item.weapon.ItemSkull;
import subaraki.umbralux.mod.AddonUmbraLux;

public class UmbraLuxItems {

	public static ItemNecromancerArmor necro_head, necro_chest, necro_legs, necro_feet;
	public static final String NECROMANCER_CLASS = "necromancer";
	public static ItemSkull skull;
	public static ItemCustomShield necromancer_shield;

	public static ItemPaladinArmor paladin_head, paladin_chest, paladin_legs, paladin_feet;
	public static final String PALADIN_CLASS = "paladin";
	public static ItemCustomShield paladin_shield;
	public static ItemPaladinSword paladin_sword;

	public static ItemCraftLeather craftLeather;

	public static Item necro_plate, paladin_plate;

	private static final String modid = AddonUmbraLux.MODID;
	
	public static final CreativeTabs tab =  new CreativeTabs("addon_umbralux") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(necro_head);
		}
	};

	public static void loadItems(){

		necro_head = (ItemNecromancerArmor) new ItemNecromancerArmor(EntityEquipmentSlot.HEAD).setCreativeTab(tab);
		necro_chest = (ItemNecromancerArmor) new ItemNecromancerArmor(EntityEquipmentSlot.CHEST).setCreativeTab(tab);
		necro_legs = (ItemNecromancerArmor) new ItemNecromancerArmor(EntityEquipmentSlot.LEGS).setCreativeTab(tab);
		necro_feet = (ItemNecromancerArmor) new ItemNecromancerArmor(EntityEquipmentSlot.FEET).setCreativeTab(tab);
		skull = (ItemSkull) new ItemSkull().setCreativeTab(tab).setUnlocalizedName(modid + ".necromancerskull").setRegistryName("necromancerskull");
		necro_plate = new Item().setCreativeTab(tab).setUnlocalizedName(AddonUmbraLux.MODID+".necro_plate").setRegistryName("necro_plate");
		necromancer_shield = (ItemCustomShield) new ItemCustomShield(){
			@Override
			public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
				return repair.getItem().equals(Blocks.BONE_BLOCK) ? true : super.getIsRepairable(toRepair, repair);
			}	
		}.setCreativeTab(tab).setUnlocalizedName(modid+".necromancer_shield").setRegistryName("necromancer_shield").setMaxDamage(ConfigurationHandler.instance.shield_uses);

		paladin_head = (ItemPaladinArmor) new ItemPaladinArmor(EntityEquipmentSlot.HEAD).setCreativeTab(tab);
		paladin_chest = (ItemPaladinArmor) new ItemPaladinArmor(EntityEquipmentSlot.CHEST).setCreativeTab(tab);
		paladin_legs = (ItemPaladinArmor) new ItemPaladinArmor(EntityEquipmentSlot.LEGS).setCreativeTab(tab);
		paladin_feet = (ItemPaladinArmor) new ItemPaladinArmor(EntityEquipmentSlot.FEET).setCreativeTab(tab);
		paladin_sword = (ItemPaladinSword) new ItemPaladinSword().setCreativeTab(tab).setUnlocalizedName(modid+".paladin_sword").setRegistryName("paladin_sword");
		paladin_plate = new Item().setCreativeTab(tab).setUnlocalizedName(AddonUmbraLux.MODID+".paladin_plate").setRegistryName("paladin_plate");
		paladin_shield = (ItemCustomShield) new ItemCustomShield(){
			@Override
			public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
				return repair.getItem().equals(Blocks.GOLD_BLOCK) ? true : super.getIsRepairable(toRepair, repair);
			}	
		}.setCreativeTab(tab).setUnlocalizedName(modid+".paladin_shield").setRegistryName("paladin_shield").setMaxDamage(ConfigurationHandler.instance.shield_uses);

		craftLeather = (ItemCraftLeather) new ItemCraftLeather().setCreativeTab(tab);

		register();
		
		OreDictionary.registerOre("ingot", new ItemStack(craftLeather,1,1));
		OreDictionary.registerOre("plate", necro_plate);
		OreDictionary.registerOre("plate", paladin_plate);
	}

	private static void register(){
		registerItem(necro_head);
		registerItem(necro_chest);
		registerItem(necro_legs);
		registerItem(necro_feet);
		registerItem(necromancer_shield);
		registerItem(skull);
		registerItem(necro_plate);

		registerItem(paladin_head);
		registerItem(paladin_chest);
		registerItem(paladin_legs);
		registerItem(paladin_feet);
		registerItem(paladin_shield);
		registerItem(paladin_sword);
		registerItem(paladin_plate);

		registerItem(craftLeather);
	}

	public static void registerRenders(){

		registerRender(necro_head, necro_head.getModeltextureLocation(), modid);
		registerRender(necro_chest, necro_chest.getModeltextureLocation(), modid);
		registerRender(necro_legs, necro_legs.getModeltextureLocation(), modid);
		registerRender(necro_feet, necro_feet.getModeltextureLocation(), modid);
		registerRender(necromancer_shield, "necromancer_shield", modid);
		registerRender(skull, "weapon/skull", modid);

		registerRender(paladin_head, paladin_head.getModeltextureLocation(), modid);
		registerRender(paladin_chest, paladin_chest.getModeltextureLocation(), modid);
		registerRender(paladin_legs, paladin_legs.getModeltextureLocation(), modid);
		registerRender(paladin_feet, paladin_feet.getModeltextureLocation(), modid);
		registerRender(paladin_shield, "paladin_shield", modid);
		registerRender(paladin_sword, "weapon/paladin_sword", modid);

		registerVanillaRender(craftLeather, "leather", 0);
		registerVanillaRender(craftLeather, "iron_ingot", 1);
		
		registerRender(necro_plate, "plate_necro", modid);
		registerRender(paladin_plate, "plate_paladin", modid);

	}
}
