package com.github.seqware.model.test;

import com.github.seqware.queryengine.factory.Factory;
import com.github.seqware.queryengine.factory.ModelManager;
import com.github.seqware.queryengine.model.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Let's create some features directly out of
 * http://www.sequenceontology.org/resources/gvf.html
 *
 * @author dyuen
 */
public class GVFFormatTest {

    private static FeatureSet fSet;

    @BeforeClass
    public static void setupTests() {
        ModelManager mManager = Factory.getModelManager();
        String pragma = "##gvf-version 1.06 ##genome-build NCBI B36.3 ##sequence-region chr16 1 88827254";
        fSet = mManager.buildFeatureSet().setDescription(pragma).setReference(mManager.buildReference().setName("source").build()).build();
        Set<Feature> testFeatures = new HashSet<Feature>();
        TagSpecSet stdTagSet = mManager.buildTagSpecSet().setName("Std_tags").build();
        TagSpec idSpec = mManager.buildTagSpec().setKey("ID").build();
        TagSpec variantSpec = mManager.buildTagSpec().setKey("Variant_seq").build();
        TagSpec referenceSpec = mManager.buildTagSpec().setKey("ReferenceSeq").build();
        stdTagSet.add(idSpec, variantSpec, referenceSpec);
        // have to make up scores, not present in example
        Feature f1 = mManager.buildFeature().setId("chr16").setSource("samtools").setType("SNV").setStart(49291141).setStop(49291141).setStrand(Feature.Strand.POSITIVE).build();
        f1.associateTag(idSpec.newTagBuilder().setValue("ID_1").build());
        f1.associateTag(variantSpec.newTagBuilder().setValue("A,G").build());
        f1.associateTag(referenceSpec.newTagBuilder().setValue("G").build());
        Feature f2 = mManager.buildFeature().setId("chr16").setSource("samtools").setType("SNV").setStart(49291360).setStop(49291360).setStrand(Feature.Strand.POSITIVE).build();
        f2.associateTag(idSpec.newTagBuilder().setValue("ID_2").build());
        f2.associateTag(variantSpec.newTagBuilder().setValue("G").build());
        f2.associateTag(referenceSpec.newTagBuilder().setValue("C").build());
        Feature f3 = mManager.buildFeature().setId("chr16").setSource("samtools").setType("SNV").setStart(49302125).setStop(49302125).setStrand(Feature.Strand.POSITIVE).build();
        f3.associateTag(idSpec.newTagBuilder().setValue("ID_3").build());
        f3.associateTag(variantSpec.newTagBuilder().setValue("T,C").build());
        f3.associateTag(referenceSpec.newTagBuilder().setValue("C").build());

        testFeatures.add(f1);
        testFeatures.add(f2);
        testFeatures.add(f3);
        fSet.add(testFeatures);
        mManager.close();
    }

    @Test
    public void testOutputAndStore() {
        FeatureSet targetSet = (FeatureSet) Factory.getFeatureStoreInterface().getAtomBySGID(FeatureSet.class, fSet.getSGID());
        Assert.assertTrue(targetSet.equals(fSet));
        String matchTarget = "##gvf-version 1.06 ##genome-build NCBI B36.3 ##sequence-region chr16 1 88827254\n" +
        "chr16 samtools SNV 49291360 49291360 . + . ID=ID_2;Variant_seq=G;Reference_seq=C;\n" +
        "chr16 samtools SNV 49302125 49302125 . + . ID=ID_3;Variant_seq=T,C;Reference_seq=C;\n" +
        "chr16 samtools SNV 49291141 49291141 . + . ID=ID_1;Variant_seq=A,G;Reference_seq=G;";
        StringBuilder buff = new StringBuilder();
        buff.append(targetSet.getDescription());    
        for (Feature f : targetSet) {
            buff.append('\n');
            buff.append(f.getId());
            buff.append(' ');
            buff.append(f.getSource());
            buff.append(' ');
            buff.append(f.getType());
            buff.append(' ');
            buff.append(f.getStart());
            buff.append(' ');
            buff.append(f.getStop());
            buff.append(' ');
            Assert.assertTrue(f.getScore() == null);
            buff.append(".");
            buff.append(' ');
            if (f.getStrand().name().equals(Feature.Strand.POSITIVE.name())) {
                buff.append("+");
            }
            buff.append(' ');
            buff.append(f.getPhase());
            buff.append(' ');
            for (Tag t : f.getTags()) {
                buff.append(t.getKey()).append(t.getPredicate()).append(t.getValue()).append(";");
            }
        }
        System.out.println(buff);
    }
}
