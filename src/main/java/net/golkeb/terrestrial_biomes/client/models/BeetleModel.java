package net.golkeb.terrestrial_biomes.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BeetleModel<T extends Entity> extends EntityModel<T> {

    private final ModelPart torso;
    private final ModelPart shellwingthree;
    private final ModelPart shellwingtwo;
    private final ModelPart head;
    private final ModelPart Horn;
    private final ModelPart leftarm;
    private final ModelPart rightarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final ModelPart middleleftleg;
    private final ModelPart middlerightleg;

    public BeetleModel(ModelPart modelPart) {
        this.torso = modelPart;
        this.torso.setRotation(0.0F, 21.0F, 0.0F);
        addBoxHelper(torso, 0, 0, -2.0F, -3.0F, -4.0F, 4, 3, 8, 0.0F, false);
        shellwingthree = new ModelPart(this);
        shellwingthree.setRotation(-2.0F, 0.0F, -3.0F);
        setRotationAngle(shellwingthree, 0.0F, -0.5236F, 0.0F);
        torso.addChild(shellwingthree);
        addBoxHelper(shellwingthree, 0, 11, -1.0F, -4.0F, -1.0F, 3, 2, 8, 0.0F, false);
        shellwingtwo = new ModelPart(this);
        shellwingtwo.setRotation(2.0F, 0.0F, -3.0F);
        setRotationAngle(shellwingtwo, 0.0F, 0.5236F, 0.0F);
        torso.addChild(shellwingtwo);
        addBoxHelper(shellwingtwo, 0, 11, -2.0F, -4.0F, -1.0F, 3, 2, 8, 0.0F, false);
        head = new ModelPart(this);
        head.setRotation(0.0F, 19.75F, -4.75F);
        addBoxHelper(head, 16, 0, -2.0F, -1.75F, -2.25F, 4, 3, 3, 0.0F, false);
        Horn = new ModelPart(this);
        Horn.setRotation(-0.5F, -1.25F, -1.75F);
        setRotationAngle(Horn, -0.7854F, 0.0F, 0.0F);
        head.addChild(Horn);
        addBoxHelper(Horn, 20, 7, -0.5F, -1.5F, -2.5F, 2, 2, 4, 0.0F, false);
        leftarm = new ModelPart(this);
        leftarm.setRotation(-3.0F, 18.0F, -3.0F);
        setRotationAngle(leftarm, -0.3491F, 0.0F, 0.3491F);
        addBoxHelper(leftarm, 0, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false);
        rightarm = new ModelPart(this);
        rightarm.setRotation(3.0F, 18.0F, -3.0F);
        setRotationAngle(rightarm, -0.3491F, 0.0F, -0.3491F);
        addBoxHelper(rightarm, 0, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false);
        rightleg = new ModelPart(this);
        rightleg.setRotation(3.0F, 18.0F, 3.0F);
        setRotationAngle(rightleg, 0.3491F, 0.0F, -0.3491F);
        addBoxHelper(rightleg, 0, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false);
        leftleg = new ModelPart(this);
        leftleg.setRotation(-3.0F, 18.0F, 3.0F);
        setRotationAngle(leftleg, 0.3491F, 0.0F, 0.3491F);
        addBoxHelper(leftleg, 0, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false);
        middleleftleg = new ModelPart(this);
        middleleftleg.setRotation(-3.0F, 18.0F, 0.0F);
        setRotationAngle(middleleftleg, 0.0F, 0.0F, 0.3491F);
        addBoxHelper(middleleftleg, 0, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false);
        middlerightleg = new ModelPart(this);
        middlerightleg.setRotation(3.0F, 18.0F, 0.0F);
        setRotationAngle(middlerightleg, 0.0F, 0.0F, -0.3491F);
        addBoxHelper(middlerightleg, 0, 0, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false);
    }

    public static LayerDefinition createBodyLayer() {

    }

    @Override
    public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
        torso.render(ms, vb, i1, i2, f1, f2, f3, f4);
        head.render(ms, vb, i1, i2, f1, f2, f3, f4);
        leftarm.render(ms, vb, i1, i2, f1, f2, f3, f4);
        rightarm.render(ms, vb, i1, i2, f1, f2, f3, f4);
        rightleg.render(ms, vb, i1, i2, f1, f2, f3, f4);
        leftleg.render(ms, vb, i1, i2, f1, f2, f3, f4);
        middleleftleg.render(ms, vb, i1, i2, f1, f2, f3, f4);
        middlerightleg.render(ms, vb, i1, i2, f1, f2, f3, f4);
    }

    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
        this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
        this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.Horn.rotateAngleY = f3 / (180F / (float) Math.PI);
        this.Horn.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.middleleftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.rightarm.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
        this.shellwingthree.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
        this.middlerightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.shellwingtwo.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
    }

    @OnlyIn(Dist.CLIENT)
    public static void addBoxHelper(ModelPart renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
        addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
    }

    @OnlyIn(Dist.CLIENT)
    public static void addBoxHelper(ModelPart renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
                                    boolean mirror) {
        renderer.mirror = mirror;
        renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
    }

    public void setupAnim(Entity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {}

    public void renderToBuffer(PoseStack p_103111_, VertexConsumer p_103112_, int p_103113_, int p_103114_, float p_103115_, float p_103116_, float p_103117_, float p_103118_) {}
}
