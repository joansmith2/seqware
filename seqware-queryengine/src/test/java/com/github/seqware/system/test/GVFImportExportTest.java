package com.github.seqware.system.test;

import com.github.seqware.queryengine.factory.Factory;
import com.github.seqware.queryengine.factory.ModelManager;
import com.github.seqware.queryengine.model.Group;
import com.github.seqware.queryengine.model.User;
import com.github.seqware.queryengine.system.exporters.VCFDumper;
import com.github.seqware.queryengine.system.importers.FeatureImporter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * System tests for importing and exporting GVF files.
 *
 * @author dyuen
 */
public class GVFImportExportTest {

    private static File testGVFFile = null;
    private static String randomRef= null; 
    
    @BeforeClass
    public static void setupTests() {
        String curDir = System.getProperty("user.dir");
        testGVFFile = new File(curDir + "/src/test/resources/com/github/seqware/queryengine/system/FeatureImporter/test.gvf");
        SecureRandom random = new SecureRandom();
        randomRef = "Random_ref_" + new BigInteger(20, random).toString(32);
    }
    
    @Test
    public void testGVFImport() throws IOException{
        File createTempFile = File.createTempFile("output", "txt");
        Assert.assertTrue("Cannot read GVF file for test", testGVFFile.exists() && testGVFFile.canRead());
        FeatureImporter.main(new String[]{"GFF3VariantImportWorker", "1", "false", randomRef, testGVFFile.getAbsolutePath()});       
        // do some output comparisons, we may need to sort the results
        VCFDumper.main(new String[]{randomRef, createTempFile.getAbsolutePath()});
        BufferedReader in = new BufferedReader(new FileReader(createTempFile));
        List<String> output = new ArrayList<String>();
        while (in.ready()){
            output.add(in.readLine());
        }
        Collections.sort(output);
        // can compare only #CHROM and POS for now
        
        Assert.assertTrue(output.size() == 10);
        String[] arr = output.get(1).split("\t");
        Assert.assertTrue(output.get(1).split("\t")[0].equals("chr16") && output.get(1).split("\t")[1].equals("49291141"));
        Assert.assertTrue(output.get(2).split("\t")[0].equals("chr16") && output.get(2).split("\t")[1].equals("49291360"));
        Assert.assertTrue(output.get(5).split("\t")[0].equals("chr16") && output.get(5).split("\t")[1].equals("49302700"));
        Assert.assertTrue(output.get(8).split("\t")[0].equals("chr16") && output.get(8).split("\t")[1].equals("49303427"));
        Assert.assertTrue(output.get(9).split("\t")[0].equals("chr16") && output.get(9).split("\t")[1].equals("49303596"));
        
    }
}