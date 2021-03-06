package reptiles.common;

import net.minecraft.src.*;

//
// Copyright 2011 Michael Sheppard (crackedEgg)
//

public class RenderKomodo extends RenderLiving {
	public RenderKomodo(ModelBase modelbase, float shadowSize) {
		super(modelbase, shadowSize);
	}

	public void renderKomodo(EntityKomodo entitykomodo, double d, double d1, double d2, float f, float f1) {
		super.doRenderLiving(entitykomodo, d, d1, d2, f, f1);
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
		super.doRenderLiving((EntityKomodo) entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
		super.doRenderLiving((EntityKomodo) entity, d, d1, d2, f, f1);
	}
}
