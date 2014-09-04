 
 /*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensoc.parsing.test;

import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.opensoc.parsing.parsers.BasicIseParser;

import junit.framework.TestCase;

 /**
 * <ul>
 * <li>Title: Basic ISE Parser </li>
 * <li>Description: Junit Test Case for BasicISE Parser</li>
 * <li>Created: AUG 25, 2014 by: spiddapa</li>
 * </ul>
 * @author $Author: spiddapa $
 * @version $Revision: 1.1 $
 */
public class BasicIseParserTest extends TestCase {
    private  static String rawMessage = "";

    private static BasicIseParser iseParser=null;   

    /**
     * Constructs a new <code>BasicIseParserTest</code> instance.
     * @param name
     */

    public BasicIseParserTest(String name) {
        super(name);
    }

    /**
     
     * @throws java.lang.Exception
     */
    protected static void setUpBeforeClass() throws Exception {
        setRawMessage("Aug  6 17:26:31 10.34.84.145 Aug  7 00:45:43 stage-pdp01 CISE_Profiler 0000024855 1 0 2014-08-07 00:45:43.741 -07:00 0000288542 80002 INFO  Profiler: Profiler EndPoint profiling event occurred, ConfigVersionId=113, EndpointCertainityMetric=10, EndpointIPAddress=10.56.111.14, EndpointMacAddress=3C:97:0E:C3:F8:F1, EndpointMatchedPolicy=Nortel-Device, EndpointNADAddress=10.56.72.127, EndpointOUI=Wistron InfoComm(Kunshan)Co.\\,Ltd., EndpointPolicy=Nortel-Device, EndpointProperty=StaticAssignment=false\\,PostureApplicable=Yes\\,PolicyVersion=402\\,IdentityGroupID=0c1d9270-68a6-11e1-bc72-0050568e013c\\,Total Certainty Factor=10\\,BYODRegistration=Unknown\\,FeedService=false\\,EndPointPolicyID=49054ed0-68a6-11e1-bc72-0050568e013c\\,FirstCollection=1407397543718\\,MatchedPolicyID=49054ed0-68a6-11e1-bc72-0050568e013c\\,TimeToProfile=19\\,StaticGroupAssignment=false\\,NmapSubnetScanID=0\\,DeviceRegistrationStatus=NotRegistered\\,PortalUser=, EndpointSourceEvent=SNMPQuery Probe, EndpointIdentityGroup=Profiled, ProfilerServer=stage-pdp01.cisco.com,");
        
    }

    /**
     
     * @throws java.lang.Exception
     */
    protected static void tearDownAfterClass() throws Exception {
        setRawMessage("");
    }
    

    /* 
     * (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */

    protected void setUp() throws Exception {
        super.setUp();
        assertNotNull(getRawMessage());
        BasicIseParserTest.setIseParser(new BasicIseParser());       
    }

    /* 
     * (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test method for {@link com.opensoc.parsing.parsers.BasicIseParser#parse(byte[])}.
     */
    public void testParse() throws ParseException {
        JSONObject parsed = iseParser.parse(getRawMessage().getBytes());
        assertNotNull(parsed);
        
        System.out.println(parsed);
        JSONParser parser = new JSONParser();
        
        Map json=null;
        try {
            json = (Map) parser.parse(parsed.toJSONString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Iterator iter = json.entrySet().iterator();
            

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String value = (String) json.get("message").toString();
            assertNotNull(value);
        }        
    }

    /**
     * Returns the rawMessage.
     * @return the rawMessage.
     */
    
    public static String getRawMessage() {
        return rawMessage;
    }

    /**
     * Sets the rawMessage.
     * @param rawMessage the rawMessage.
     */
    
    public static void setRawMessage(String rawMessage) {
    
        BasicIseParserTest.rawMessage = rawMessage;
    }
    
    /**
     * Returns the iseParser.
     * @return the iseParser.
     */
    
    public BasicIseParser getIseParser() {
        return iseParser;
    }

    /**
     * Sets the iseParser.
     * @param iseParser the iseParser.
     */
    
    public static void setIseParser(BasicIseParser iseParser) {
    
        BasicIseParserTest.iseParser = iseParser;
    }    
 }

