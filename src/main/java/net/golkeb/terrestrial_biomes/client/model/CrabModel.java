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

public class CrabModel<T extends Entity> extends EntityModel<T> {

    private final ModelPart body;
    private final ModelPart RTlegBack;
    private final ModelPart LTlegBack;
    private final ModelPart LTlegMiddle;
    private final ModelPart RTlegMiddle;
    private final ModelPart RTlegFront;
    private final ModelPart LTlegFront;
    private final ModelPart LTarm;
    private final ModelPart RTarm;

    public CrabModel(ModelPart root) {
        this.body = root.getChild("body");
        this.RTlegBack = root.getChild("RTlegBack");
        this.LTlegBack = root.getChild("LTlegBack");
        this.LTlegMiddle = root.getChild("LTlegMiddle");
        this.RTlegMiddle = root.getChild("RTlegMiddle");
        this.RTlegFront = root.getChild("RTlegFront");
        this.LTlegFront = root.getChild("LTlegFront");
        this.LTarm = root.getChild("LTarm");
        this.RTarm = root.getChild("RTarm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 0.0F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(10, 19).addBox(-3.0F, -4.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 19).addBox(1.0F, -4.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-3.0F, -3.0F, 0.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, -3.0F));

        PartDefinition RTlegBack = partdefinition.addOrReplaceChild("RTlegBack", CubeListBuilder.create().texOffs(17, 13).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 23.0F, 3.0F, 0.0F, 0.3491F, -0.3491F));

        PartDefinition LTlegBack = partdefinition.addOrReplaceChild("LTlegBack", CubeListBuilder.create().texOffs(10, 17).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.0F, 3.0F, 0.0F, -0.3491F, 0.3491F));

        PartDefinition LTlegMiddle = partdefinition.addOrReplaceChild("LTlegMiddle", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition RTlegMiddle = partdefinition.addOrReplaceChild("RTlegMiddle", CubeListBuilder.create().texOffs(16, 10).addBox(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 23.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition RTlegFront = partdefinition.addOrReplaceChild("RTlegFront", CubeListBuilder.create().texOffs(16, 8).addBox(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 23.0F, -2.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition LTlegFront = partdefinition.addOrReplaceChild("LTlegFront", CubeListBuilder.create().texOffs(16, 6).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.0F, -2.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition LTarm = partdefinition.addOrReplaceChild("LTarm", CubeListBuilder.create().texOffs(10, 13).addBox(-1.0F, -0.9F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.0F, -2.0F, 0.0F, -0.6981F, 0.0F));

        PartDefinition LThand = LTarm.addOrReplaceChild("LThand", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(-1.5F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 1.2217F, 0.0F));

        PartDefinition RTarm = partdefinition.addOrReplaceChild("RTarm", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -0.9F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 23.0F, -2.0F, 0.0F, 0.6981F, 0.0F));

        PartDefinition RThand = RTarm.addOrReplaceChild("RThand", CubeListBuilder.create().texOffs(7, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(0.5F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, -1.2217F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, buffer, packedLight, packedOverlay);
        RTlegBack.render(poseStack, buffer, packedLight, packedOverlay);
        LTlegBack.render(poseStack, buffer, packedLight, packedOverlay);
        LTlegMiddle.render(poseStack, buffer, packedLight, packedOverlay);
        RTlegMiddle.render(poseStack, buffer, packedLight, packedOverlay);
        RTlegFront.render(poseStack, buffer, packedLight, packedOverlay);
        LTlegFront.render(poseStack, buffer, packedLight, packedOverlay);
        LTarm.render(poseStack, buffer, packedLight, packedOverlay);
        RTarm.render(poseStack, buffer, packedLight, packedOverlay);
    }
}