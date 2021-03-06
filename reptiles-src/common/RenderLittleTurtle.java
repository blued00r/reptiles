package reptiles.common;

import net.minecraft.src.*;

//
// Copyright 2011 Michael Sheppard (crackedEgg)
//
import org.lwjgl.opengl.GL11;

public class RenderLittleTurtle extends RenderLiving
{
  public RenderLittleTurtle(ModelBase modelbase, float shadowSize) {
    super(modelbase, shadowSize);
  }
  
  public void renderLittleTurtle(EntityLittleTurtle entitytortoise, double d, double d1, double d2, float f, float f1) {
    super.doRenderLiving(entitytortoise, d, d1, d2, f, f1);
  }

  public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
    renderLittleTurtle((EntityLittleTurtle)entity, d, d1, d2, f, f1);
  }
  
  protected void scaleEntity(EntityLittleTurtle entityturtle, float f) {
    GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
  }
  
  protected void preRenderCallback(EntityLiving entityliving, float f) {
  	scaleEntity((EntityLittleTurtle)entityliving, f);
  }
  
  private final float scaleFactor = 0.5F;
}
