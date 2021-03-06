package reptiles.common;

import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;

public class ModelLace extends ModelBase {
	
	public ModelRenderer laceBody;
	public ModelRenderer laceHead;
	public ModelRenderer laceLeg1;
	public ModelRenderer laceLeg2;
	public ModelRenderer laceLeg3;
	public ModelRenderer laceLeg4;
	ModelRenderer laceTail;
	
	public ModelLace() {
		float yPos = 19F;

		laceBody = new ModelRenderer(this, 21, 16);
		laceBody.addBox(-3F, -2F, -5F, 6, 4, 10);
		laceBody.setRotationPoint(0.0F, yPos, 0.0F);

		laceHead = new ModelRenderer(this, 0, 0);
		laceHead.addBox(-2F, -2F, -6F, 4, 4, 6);
		laceHead.setRotationPoint(0F, yPos, -5F);

		laceLeg1 = new ModelRenderer(this, 56, 1);
		laceLeg1.addBox(-1F, 0F, -1F, 2, 5, 2);
		laceLeg1.setRotationPoint(4F, yPos, -4F);

		laceLeg2 = new ModelRenderer(this, 56, 1);
		laceLeg2.addBox(-1F, 0F, -1F, 2, 5, 2);
		laceLeg2.setRotationPoint(4F, yPos, 4F);

		laceLeg3 = new ModelRenderer(this, 56, 1);
		laceLeg3.mirror = true;
		laceLeg3.addBox(-1F, 0F, -1F, 2, 5, 2);
		laceLeg3.setRotationPoint(-4F, yPos, -4F);

		laceLeg4 = new ModelRenderer(this, 56, 1);
		laceLeg4.mirror = true;
		laceLeg4.addBox(-1F, 0F, -1F, 2, 5, 2);
		laceLeg4.setRotationPoint(-4F, yPos, 4F);

		laceTail = new ModelRenderer(this, 17, 12);
		laceTail.addBox(-1F, -1F, 0F, 2, 2, 18);
		laceTail.setRotationPoint(0F, yPos, 4F);
		laceTail.rotateAngleX = 6.021385919380437F;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);

		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		if (this.isChild) {
			GL11.glPushMatrix();
			// GL11.glTranslatef(0.0F, field_40331_g * f5, field_40332_n * f5);
			// laceHead.render(f5);
			// GL11.glPopMatrix();
			// GL11.glPushMatrix();
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslatef(0.0F, 24F * f5, 0.0F);
			laceHead.render(f5);
			laceBody.render(f5);
			laceLeg1.render(f5);
			laceLeg2.render(f5);
			laceLeg3.render(f5);
			laceLeg4.render(f5);
			laceTail.render(f5);
			GL11.glPopMatrix();
		} else {
			laceBody.render(f5);
			laceHead.render(f5);
			laceLeg1.render(f5);
			laceLeg2.render(f5);
			laceLeg3.render(f5);
			laceLeg4.render(f5);
			laceTail.render(f5);
		}
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		laceHead.rotateAngleX = f4 / 57.29578F;
		laceHead.rotateAngleY = f3 / 57.29578F;

		// laceLeg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		// laceLeg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) *
		// 1.4F * f1;
		// laceLeg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) *
		// 1.4F * f1;
		// laceLeg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		// laceTail.rotateAngleY = MathHelper.cos(f * 0.6662F) * 0.4F * f1;
		// wag the tail
		laceTail.rotateAngleY = MathHelper.cos(f * 0.6662F) * 0.4F * f1;
	}

	public void setLivingAnimations(EntityLiving entityliving, float f, float f1, float f2) {
		EntityLace entitylace = (EntityLace) entityliving;

		if (entitylace.isSitting()) {
			float yPos = 21F;
			laceBody.setRotationPoint(0.0F, yPos, 0.0F);
			laceTail.setRotationPoint(0F, yPos + 1, 4F);
			laceTail.rotateAngleX = 0.0F;
			laceHead.setRotationPoint(0F, yPos, -5F);

			laceLeg1.setRotationPoint(4F, yPos + 1, -4F);
			laceLeg2.setRotationPoint(4F, yPos + 1, 4F);
			laceLeg3.setRotationPoint(-4F, yPos + 1, -4F);
			laceLeg4.setRotationPoint(-4F, yPos + 1, 4F);

			laceLeg1.rotateAngleX = 4.712389F;
			laceLeg2.rotateAngleX = 1.570799F;
			laceLeg3.rotateAngleX = 4.712389F;
			laceLeg4.rotateAngleX = 1.570799F;
		} else {
			float yPos = 19F;
			laceBody.setRotationPoint(0.0F, yPos, 0.0F);
			laceHead.setRotationPoint(0F, yPos, -5F);
			laceTail.setRotationPoint(0F, yPos, 4F);
			laceTail.rotateAngleX = 6.021385919380437F;

			laceLeg1.setRotationPoint(4F, yPos, -4F);
			laceLeg2.setRotationPoint(4F, yPos, 4F);
			laceLeg3.setRotationPoint(-4F, yPos, -4F);
			laceLeg4.setRotationPoint(-4F, yPos, 4F);

			laceLeg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
			laceLeg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
			laceLeg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
			laceLeg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		}
	}

}
