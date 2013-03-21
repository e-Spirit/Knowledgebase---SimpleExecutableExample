package com.espirit.moddev.knowledgebase.simpleExecutableExample;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simpleExecutableExample
 */
public class simpleExecutableExampleIT {

    String MODULE_DESCRIPTOR = "META-INF/module.xml";

    /**
     * Check if FSM is valid
     */
    @Test
    public void testisFSMValid() {
        try {
            File directory = new File("target");
            Collection files = FileUtils.listFiles(directory, new WildcardFileFilter("*.fsm"), null);
            assertTrue("FSM doesn't contain any files",files.iterator().hasNext());
            if(files.iterator().hasNext()) {
                ZipFile _fsmZip = new ZipFile((File) files.iterator().next());
                ZipEntry fsmEntry = _fsmZip.getEntry(MODULE_DESCRIPTOR);
                assertNotNull("Couldn't find module descriptior (module.xml) in fsm file",fsmEntry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
