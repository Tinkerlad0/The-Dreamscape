package com.tinkerlad.dimension.effects.potion;

import com.tinkerlad.dimension.reference.PotionInfo;
import net.minecraft.potion.Potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Potions {

	public static Potion immobilise;

	public static void preInit() {
		Potion[] potionTypes = null;

		for (Field field : Potion.class.getDeclaredFields()) {
			field.setAccessible(true);
			try {
				if (field.getName().equals("potionTypes") || field.getName().equals("field_76425_a")) {
					Field modifiers = Field.class.getDeclaredField("modifiers");
					modifiers.setAccessible(true);
					modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[]) field.get(null);

					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					field.set(null, newPotionTypes);
				}
			} catch (Exception ex) {
				System.err.println("Severe error, please report this to the Dreamscape mod author:");
				System.err.println(ex);
			}
		}
	}

	public static void init() {

		immobilise = (new DreamscapePotion((int) PotionInfo.IMMOBILISE[0],
				                                  (boolean) PotionInfo.IMMOBILISE[1],
				                                  (int) PotionInfo.IMMOBILISE[2]).setIconIndex(0, 0).setPotionName((String) PotionInfo.IMMOBILISE[3]));
	}

	public static class DreamscapePotion extends Potion {

		public DreamscapePotion(int par1, boolean par2, int par3) {
			super(par1, par2, par3);
		}

		public Potion setIconIndex(int par1, int par2) {
			super.setIconIndex(par1, par2);
			return this;
		}
	}
}
