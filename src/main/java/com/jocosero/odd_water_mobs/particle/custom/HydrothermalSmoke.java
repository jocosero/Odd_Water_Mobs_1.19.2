package com.jocosero.odd_water_mobs.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HydrothermalSmoke extends TextureSheetParticle {

    protected HydrothermalSmoke(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z);
        this.scale(3.0F);
        this.setSize(0.4F, 0.4F);

        this.lifetime = 40;

        this.gravity = -0.0001f;
        this.xd = motionX;
        this.yd = motionY + (double) (this.random.nextFloat() / 500.0F);
        this.zd = motionZ;
    }

    @Override
    public ParticleRenderType getRenderType() {

        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime) {
            this.xd += this.random.nextFloat() / 5000.0F * (float) (this.random.nextBoolean() ? 1 : -1);
            this.zd += this.random.nextFloat() / 5000.0F * (float) (this.random.nextBoolean() ? 1 : -1);
            this.yd -= this.gravity;
            // Check if the particle is underwater
            if (this.level.getFluidState(new BlockPos(this.x, this.y + 1, this.z)).isEmpty()) {
                this.remove();
                return;
            }

            this.move(this.xd, this.yd, this.zd);
        } else {
            this.remove();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        @Override
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            HydrothermalSmoke particle = new HydrothermalSmoke(level, x, y, z, dx, dy, dz);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}
