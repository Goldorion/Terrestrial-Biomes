package net.golkeb.terrestrial_biomes.client.model;

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

public class StarfishModel<T extends Entity> extends EntityModel<T> {

    private final ModelPart starfish;

    public StarfishModel(ModelPart root) {
        this.starfish = root.getChild("starfish");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition starfish = partdefinition.addOrReplaceChild("starfish", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition starfishLeg1 = starfish.addOrReplaceChild("starfishLeg1", CubeListBuilder.create().texOffs(6, 7).addBox(1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(12, 4).addBox(3.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition starfishLegs = starfish.addOrReplaceChild("starfishLegs", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition starfishLegs4 = starfishLegs.addOrReplaceChild("starfishLegs4", CubeListBuilder.create().texOffs(12, 0).addBox(-4.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 4).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition starfishLegs3 = starfishLegs.addOrReplaceChild("starfishLegs3", CubeListBuilder.create().texOffs(6, 1).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 11).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.5236F, 0.0F));

        PartDefinition starfishLegs1 = starfishLegs.addOrReplaceChild("starfishLegs1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12).addBox(2.0F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition starfishLegs2 = starfishLegs.addOrReplaceChild("starfishLegs2", CubeListBuilder.create().texOffs(6, 10).addBox(-0.5F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        starfish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}