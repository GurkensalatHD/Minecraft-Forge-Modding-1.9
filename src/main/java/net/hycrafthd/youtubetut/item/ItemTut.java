package net.hycrafthd.youtubetut.item;

import net.hycrafthd.youtubetut.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemTut extends Item {

	public ItemTut() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(500);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.jump();
		playerIn.fallDistance = 0.0F;
		itemStackIn.damageItem(1, playerIn);
		playerIn.addStat(TutorialAchievements.tutuseitem);
		playerIn.playSound(TutorialSounds.greeting, 1.0F, 1.0F);
		TutorialConfig.updateGreeting(TutorialConfig.greeting + System.currentTimeMillis());
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}

}
