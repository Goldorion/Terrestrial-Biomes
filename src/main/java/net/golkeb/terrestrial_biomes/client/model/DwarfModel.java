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

public class DwarfModel<T extends Entity> extends EntityModel<T> {

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart RTarm;
    private final ModelPart LTarm;
    private final ModelPart RTleg;
    private final ModelPart LTleg;

    public DwarfModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.RTarm = root.getChild("RTarm");
        this.LTarm = root.getChild("LTarm");
        this.RTleg = root.getChild("RTleg");
        this.LTleg = root.getChild("LTleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 1).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.3F))
                .texOffs(26, 11).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.5F))
                .texOffs(0, 77).addBox(-7.0F, -7.6F, -7.0F, 14.0F, -1.0F, 14.0F, new CubeDeformation(0.5F))
                .texOffs(0, 19).addBox(1.0F, -5.0F, -5.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(-1.0F, -6.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -5.0F, -5.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 1.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(50, 2).addBox(-5.0F, -12.0F, -4.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(48, 25).addBox(-5.0F, -12.0F, -4.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.2F))
                .texOffs(0, 35).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

        PartDefinition RTarm = partdefinition.addOrReplaceChild("RTarm", CubeListBuilder.create().texOffs(32, 27).mirror().addBox(-3.0F, -2.0F, -2.5F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(42, 43).mirror().addBox(-3.0F, -2.0F, -2.5F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(-5.0F, 9.0F, 0.5F));

        PartDefinition LTarm = partdefinition.addOrReplaceChild("LTarm", CubeListBuilder.create().texOffs(32, 27).addBox(0.0F, -2.0F, -2.5F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(42, 43).addBox(0.0F, -2.0F, -2.5F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(5.0F, 9.0F, 0.5F));

        PartDefinition RTleg = partdefinition.addOrReplaceChild("RTleg", CubeListBuilder.create().texOffs(18, 52).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(-0.1F))
                .texOffs(0, 69).addBox(-2.0F, 2.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.5F))
                .texOffs(0, 63).mirror().addBox(-2.0F, 4.0F, -6.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 18.0F, 0.5F));

        PartDefinition LTleg = partdefinition.addOrReplaceChild("LTleg", CubeListBuilder.create().texOffs(18, 52).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(-0.1F))
                .texOffs(0, 69).mirror().addBox(-2.0F, 2.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.5F)).mirror(false)
                .texOffs(0, 63).addBox(-2.0F, 4.0F, -6.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, 0.5F));

        return LayerDefinition.create(meshdefinition, 96, 96);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, buffer, packedLight, packedOverlay);
        body.render(poseStack, buffer, packedLight, packedOverlay);
        RTarm.render(poseStack, buffer, packedLight, packedOverlay);
        LTarm.render(poseStack, buffer, packedLight, packedOverlay);
        RTleg.render(poseStack, buffer, packedLight, packedOverlay);
        LTleg.render(poseStack, buffer, packedLight, packedOverlay);
    }
}