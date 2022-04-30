package net.golkeb.terrestrial_biomes.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

/**
 * Made with Blockbench 4.2.2
 * Exported for Minecraft version 1.18.2 with Mojang mappings
 * Paste this class into your mod and generate all required imports
 */

public class WhaleModel<T extends Entity> extends EntityModel<T> {

    private final ModelPart body;
    private final ModelPart mouth;
    private final ModelPart bodyRotation3;
    private final ModelPart RTfin;
    private final ModelPart LTfin;

    public WhaleModel(ModelPart root) {
        this.body = root.getChild("body");
        this.mouth = root.getChild("mouth");
        this.bodyRotation3 = root.getChild("bodyRotation3");
        this.RTfin = root.getChild("RTfin");
        this.LTfin = root.getChild("LTfin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(185, 201).addBox(-4.0F, -32.0F, -49.0F, 52.0F, 32.0F, 79.0F, new CubeDeformation(0.0F))
                .texOffs(0, 143).addBox(7.0F, -45.0F, -51.0F, 30.0F, 35.0F, 102.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -47.0F, -84.0F, 48.0F, 27.0F, 116.0F, new CubeDeformation(0.0F))
                .texOffs(308, 109).addBox(0.0F, -24.0F, 30.0F, 44.0F, 21.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(-20.0F, 24.0F, 0.0F));

        PartDefinition bodyRotation1 = body.addOrReplaceChild("bodyRotation1", CubeListBuilder.create().texOffs(212, 0).addBox(-22.0F, -8.0F, -6.0F, 42.0F, 23.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.0F, -35.0F, 50.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition bodyRotation2 = body.addOrReplaceChild("bodyRotation2", CubeListBuilder.create().texOffs(0, 280).addBox(-19.0F, -11.3486F, -21.9848F, 36.0F, 21.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.0F, -16.0F, 84.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition mouth = partdefinition.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 197).addBox(-24.0F, -10.0F, -52.0F, 48.0F, 25.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(162, 143).addBox(-24.0F, 10.0F, -50.0F, 48.0F, 5.0F, 50.0F, new CubeDeformation(0.0F))
                .texOffs(100, 289).addBox(-27.0F, -10.0F, -52.0F, 3.0F, 25.0F, 52.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(24.0F, -10.0F, -52.0F, 3.0F, 25.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 14.0F, -34.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition bodyRotation3 = partdefinition.addOrReplaceChild("bodyRotation3", CubeListBuilder.create().texOffs(210, 312).addBox(-16.0F, -8.0F, 0.0F, 32.0F, 14.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 98.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition tail = bodyRotation3.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 170).addBox(2.0F, -2.4196F, 0.1824F, 30.0F, 6.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(0, 342).addBox(7.0F, -0.4196F, 3.1824F, 32.0F, 3.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(0, 77).addBox(-39.0F, -0.4196F, 3.1824F, 32.0F, 3.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(187, 357).addBox(16.0F, 1.5804F, 6.1824F, 32.0F, 3.0F, 23.0F, new CubeDeformation(0.0F))
                .texOffs(344, 0).addBox(-48.0F, 1.5804F, 6.1824F, 32.0F, 3.0F, 23.0F, new CubeDeformation(0.0F))
                .texOffs(0, 143).addBox(-32.0F, -2.4196F, 0.1824F, 30.0F, 6.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0F, -4.4196F, 0.1824F, 4.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 28.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition RTfin = partdefinition.addOrReplaceChild("RTfin", CubeListBuilder.create().texOffs(310, 331).addBox(0.0F, -3.0F, -13.0F, 37.0F, 7.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(308, 164).addBox(0.0F, -2.0F, -8.0F, 48.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.0F, 4.0F, -12.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition LTfin = partdefinition.addOrReplaceChild("LTfin", CubeListBuilder.create().texOffs(330, 74).addBox(-37.0F, -3.0F, -13.0F, 37.0F, 7.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(212, 71).addBox(-48.0F, -2.0F, -8.0F, 48.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 4.0F, -12.0F, 0.0F, 0.0F, -0.1745F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        mouth.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bodyRotation3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RTfin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LTfin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}