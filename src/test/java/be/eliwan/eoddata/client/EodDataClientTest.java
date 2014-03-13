/**
 * This file is part of synergetics competency analyzer
 * Copyright (c) synergetics nv, Belgium
 */

package be.eliwan.eoddata.client;

import com.eoddata.ws.data.DataSoap;
import com.eoddata.ws.data.LoginResult;
import com.eoddata.ws.data.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test the eoddata client.
 */
public class EodDataClientTest
{

    private DataSoap client;
    private String token;

    @Before
    public void setup() throws Exception {
        EodDataClient edc = new EodDataClient();
        client = edc.getDataSoap();

        Properties properties = new Properties();
        InputStream in = getClass().getResourceAsStream("/eoddata.client.properties");
        properties.load(in);
        in.close();

        System.out.println("+++++++++++++++++++++++++++++= [" + properties.get("eoddata.login") + ":" + properties.get("eoddata.password") + "]");
        LoginResult loginResult = client.login((String) properties.get("eoddata.login"), (String) properties.get("eoddata.password"));
        token = loginResult.getToken();
        System.out.println("token " + token);
        System.out.println(loginResult.getMessage());
        System.out.println(loginResult.getDataFormat());
    }

    @Test
    public void testMembership() throws Exception {

        Response membership = client.membership(token);

        System.out.println(membership.getMessage());
        System.out.println(membership.getMONTHS());
        System.out.println(membership.getMEMBERSHIP());
        assertThat(membership).isNotNull();
    }

}
