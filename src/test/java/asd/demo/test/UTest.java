/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.test;

import asd.demo.model.dao.MongoDBConnector;
import java.net.UnknownHostException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Calvin
 */

public class UTest {
    private static MongoDBConnector db;
    
    public UTest() {  }

    @BeforeClass //Create an instance of MongoDBConnector using admin credentials for mLab
    public static void setUpClass() throws UnknownHostException {
        System.out.println("\n<-- Starting Unit test -->");  
    }
    
    @Test
    public void testMongoDBConnect() throws UnknownHostException {
        Assert.assertNotNull("Cannot establish connection to MDB",db);        
        System.out.println("\n- Connecting to MongoDB ");
    }
    
    
}
