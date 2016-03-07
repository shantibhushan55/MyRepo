<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.hp.ruc.db.*" %>
<%@ page import="com.hp.ruc.util.*" %>
<%@ page import="com.hp.ruc.config.*" %>
<%@ page import="com.hp.ruc.metrics.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.hp.es.constants.*" %>
<%@ page import="com.hp.es.service.util.*" %>
<%@ page import="com.hp.es.service.plumbing.*" %>

<%@ page import="com.hp.es.service.operations.OperationManager" %>
<%@ page import="com.hp.es.service.batchEntitlement.BatchRequestManager" %>



<%@page import="com.hp.es.service.db.DbConnectionManager"%><html>
<head>
    <title>ES instance information</title>
    <meta name="robots" content="nofollow">
</head>

<body>
<%
		String serverName = System.getProperty("SERVER_NAME", "Unknown");
    String buildInfo = "Unknown";
    try {
        ConfigFactory cf = ConfigFactory.getInstance();
        ReadOnlyProperties props = cf.getConfig("com/hp/es/service/version.properties");
        buildInfo = props.getProperty("es.release.build.info", buildInfo);
    } catch (Exception ex) {
        buildInfo = ex.toString();
    }
%>

<p>
<h2>Entitlement Services plumbing test results for server <%=serverName%></h2>
<p>Build information         : <strong><%=buildInfo%></strong>
<br>The current date & time is: <strong><%=new java.util.Date()%></strong>


<p><table border="1" cellspacing="0" cellpading="0">
	<!-- ----------------------
	ES_HOME Test
	---------------------- -->
	<tr>
		<td valign="top"><B>Testing ES_HOME and working directory</B></td>

		<td>
		<%
		    {
		        String es_home = System.getProperty("ES_HOME");
		        boolean isExist = true;
		        if (es_home == null || es_home == "" || es_home.length() == 0) {
		            isExist = false;
		            out.println("ES_HOME doesn't exist.<br>");
		        } else
		            out.println("ES_HOME is <strong>" + es_home + "</strong>.<br>");
		        if (isExist) {
		            try {
		                File file = new File(es_home);
		                if (file.isDirectory()) {
		                    out.println("ES_HOME is a working directory.");
		                } else {
		                    isExist = false;
		                    out.println("ES_HOME is not a working directory.");
		                }
		            } catch (Exception e) {
		                isExist = false;
		                out.println("ES_HOME is not a working directory.");
		            }
		        } else {
		            out.println("Working directory doesn't exist.");
		        }
		        if (isExist) {
		            out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>OK</strong> </td>");
		        } else {
		            out.println("<td width=70 bgcolor=#FF0000 align=center> <strong>ERROR</strong> </td>");
		        }
		    }
		%>
	</td>
	</tr>
<!-- ----------------------
    ES ODS Connection Test
    ---------------------- -->
<tr>
    <td valign="top"><B>Testing JDBC connection to ES ODS</b></td>

    <td>
    <%
        // preventing that one of these hacky entries affects another...
        {
            boolean status = false;
            boolean uncriticalFailure = false;
            Connection conn = null;
            try {
                conn = DbConnectionManager.getInstance().getReadonlyConnection();
                DatabaseMetaData meta = conn.getMetaData();
                out.println("JDBC driver version is " + meta.getDriverVersion() + "<BR>");

                status = true;
								Statement st = null;
								ResultSet rs = null;
                try {
                    st = conn.createStatement();
                    rs = st
                            .executeQuery("select CONCAT(DB_SID,CONCAT('|',CONCAT(DB_VERSION ,CONCAT('|',DB_REGION_NAME)))) from version_info");
                    rs.next();
                    out.println("Database is <strong>" + rs.getString(1) + "</strong> <br>");
                } catch (Exception ex) {
                    out.println("<strong>Failed to load version info</strong> <br>");
                    uncriticalFailure = true;
                }finally {
		            		if (st != null)
											st.close();
										if (rs != null)
		                	rs.close();

		            }
		            
                try {
                    st = conn.createStatement();
                    rs = st.executeQuery("select OHDR_SOURCE_OBLIGATION_ID from OBLIGATION_HEADER where rownum =1");
                    rs.next();
                    out.println("OBLIGATION_HEADER table can be accessed, first obligation id<strong>" + rs.getString(1) + "</strong><br>");
                } catch (Exception ex) {
                    out.println("<strong>Failed to retrieve number of rows from OBLIGATION_HEADER</strong><br>");
                    uncriticalFailure = true;
                }finally {
		            		if (st != null)
											st.close();
										if (rs != null)
		              	  rs.close();

		            }


                if (!uncriticalFailure) {
                    out.println("<strong>JDBC connect to ES ODS succeeded!</strong>");
                } else {
                    out.println("<strong>JDBC connect to ES ODS succeeded, but certain information is missing.</strong>");
                }

            } catch (java.lang.Throwable t) {
                t.printStackTrace();
                out.println("<strong>ERROR: JDBC connect to ES ODS failed; error message=" + t.getMessage() + "</strong>");
                status = false;
            } finally {
                try {
                    conn.close();
                } catch (Exception ex) {
                }
            }
            if (status == true) {
                if (!uncriticalFailure) {
                    out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>OK</strong> </td>");
                } else {
                    out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>WARNING</strong> </td>");
                }
            } else {
                out.println("<td width=70 bgcolor=#FF0000 align=center> <strong>ERROR</strong> </td>");
            }
        }
    %>
    </td>
</tr>


<!-- ----------------------
    Batch Entitlement
    ---------------------- -->
	<tr>
		<td valign="top" rowspan="7"><b>Batch Entitlement status</b></td>
		<td>
		<%
		    // preventing that one of these hacky entries affects another...
		    {
		        boolean status = false;
		        boolean uncriticalFailure = false;
		        out.println("Testing JDBC connection for Batch Entitlement<br>");
		        Connection conn = null;
		        Statement st = null;
						ResultSet rs = null;
		        try {

		            conn = DbConnectionManager.getInstance().getWritableConnection();
		            DatabaseMetaData meta = conn.getMetaData();
		            out.println("JDBC driver version is " + meta.getDriverVersion() + "<BR>");

		            status = true;

		            try {
		                st = conn.createStatement();
		                rs = st.executeQuery("select count(*) from batch_request");
		                rs.next();
		                out.println("Database BATCH  request  table contain <strong>" + rs.getString(1) + "</strong>rows<br>");
		            } catch (Exception ex) {
		                out.println("<strong>Failed to load version info</strong> <br>");
		                uncriticalFailure = true;
		            }finally {
		            		if (st != null)
											st.close();
										if (rs != null)
		                rs.close();

		            }
		            if (!uncriticalFailure) {
		                out.println("<strong>JDBC connect to Batch Entitlement database succeeded!</strong>");
		            } else {
		                out
		                        .println("<strong>JDBC connect to Batch Entitlement database succeeded, but certain information is missing.</strong>");
		            }

		        } catch (java.lang.Throwable t) {
		            t.printStackTrace();
		            out.println("<strong>ERROR: JDBC connect to Batch Entitlement database failed; error message=" + t.getMessage()
		                    + "</strong>");
		            status = false;
		        } finally {
		            try {
		                conn.close();
		            } catch (Exception ex) {
		            }
		        }

		        out.println("</td>");
		        if (status == true) {
		            if (!uncriticalFailure) {
		                out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>OK</strong> </td>");
		            } else {
		                out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>WARNING</strong> </td>");
		            }
		        } else {
		            out.println("<td width=70 bgcolor=#FF0000 align=center> <strong>ERROR</strong> </td>");
		        }
		    }
		%>
		
	</tr>
	<tr>
		<td>
		<%
		    ReadOnlyProperties prop = null;
		    DynConfigFactory configFactory = DynConfigFactory.getDynInstance();
		    try {
		        prop = configFactory.getConfig(EsConstants.ES_PROPERTIES_FILENAME);
		    } catch (IOException e) {
		    }
		    boolean beEnabled = true;
		    if (prop != null) {
		        beEnabled = prop.getBooleanProperty("batchEntitlement.enabled", Boolean.TRUE).booleanValue();
		    }
		    {
		        // getting running threads of batch entitlement
		        int threadCount = 0;
		        threadCount = BatchRequestManager.getInstance().getThreadCount();
		        out.println("Running threads");
		        out.println("</td>");
		        // getting configuration of batch entitlement

		        if (!beEnabled) {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>" + threadCount + "</strong> </td>");
		        } else {
		            out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>" + threadCount + "</strong> </td>");
		        }
		    }
		%>
		
	</tr>
	<tr>
		<td>
		<%
		    {
		        out.println("Batch Entitlement enabled</td>");
		        if (beEnabled) {
		            out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>YES</strong> </td>");
		        } else {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>NO</strong> </td>");
		        }
		    }
		%>
		
	</tr>
	<tr>
		<td>
		<%
		    {
		        boolean emailEnabled = true;
		        if (prop != null) {
		            emailEnabled = prop.getBooleanProperty("batchEntitlement.email.enable", Boolean.TRUE).booleanValue();
		        }
		        out.println("Sending Email enabled</td>");
		        if (beEnabled && emailEnabled) {
		            out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>YES</strong> </td>");
		        } else if (!beEnabled && emailEnabled) {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>YES</strong> </td>");
		        } else {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>NO</strong> </td>");
		        }
		    }
		%>
		
	</tr>
	<tr>
		<td>
		<%
		    {
		        boolean prEnabled = true;
		        if (prop != null) {
		            prEnabled = prop.getBooleanProperty("batchEntitlement.processRequests.enable", Boolean.TRUE).booleanValue();
		        }
		        out.println("Processing Request enabled</td>");
		        if (beEnabled && prEnabled) {
		            out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>YES</strong> </td>");
		        } else if (!beEnabled && prEnabled) {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>YES</strong> </td>");
		        } else {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>NO</strong> </td>");
		        }
		    }
		%>
		
	</tr>
	<tr>
		<td>
		<%
		    {
		        boolean erEnabled = true;
		        if (prop != null) {
		            erEnabled = prop.getBooleanProperty("batchEntitlement.extractRequests.enable", Boolean.TRUE).booleanValue();
		        }
		        out.println("Extracting Request enabled</td>");
		        if (beEnabled && erEnabled) {
		            out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>YES</strong> </td>");
		        } else if (!beEnabled && erEnabled) {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>YES</strong> </td>");
		        } else {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>NO</strong> </td>");
		        }
		    }
		%>
		
	</tr>
	<tr>
		<td>
		<%
		    {
		        boolean drEnabled = true;
		        if (prop != null) {
		            drEnabled = prop.getBooleanProperty("batchEntitlement.deleteRequests.enable", Boolean.TRUE).booleanValue();
		        }
		        out.println("Deleting Request enabled</td>");
		        if (beEnabled && drEnabled) {
		            out.println("<td width=70 bgcolor=#00FF00 align=center> <strong>YES</strong> </td>");
		        } else if (!beEnabled && drEnabled) {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>YES</strong> </td>");
		        } else {
		            out.println("<td width=70 bgcolor=#FFFF00 align=center> <strong>NO</strong> </td>");
		        }
		    }
		%>
		
	</tr>
<!-- ----------------------
    ES connectivity
    ---------------------- -->
<tr>
    <td valign="top" colspan="2">
        <b>ES connectivity</b>        
    </td>
    <%
        int esStatus = EsServiceConnectivity.getServiceStatus();
        if (esStatus == EsServiceConnectivity.SUCCESS)
            out.println("<td bgcolor=\"##00FF00\" align=\"center\"><strong>OK</strong>");
        else
            out.println("<td bgcolor=\"#FF0000\" align=\"center\"><strong>ERROR</strong>");
    %>
</tr>

<!-- ----------------------
    SAP connectivity
    ---------------------- -->
<tr>
    <td valign="top" rowspan="7">
    	<b>SAP connectivity</b><p>
    	<b>Local SAP Region is:<%
    	    out.println(SAPConnectivity.getLocalRegionName());
    	%></b>
    </td>
</tr>
    <%
        ArrayList listOfRegionName = SAPConnectivity.getAvailableRegionNames();
            for (int i = 0; i < listOfRegionName.size(); i++) {
        String regionName = (String) listOfRegionName.get(i);
        int regionStatus = SAPConnectivity.getRegionStatus(regionName);
        boolean regionFailoverStatus = SAPConnectivity.getRegionFailoverStatus(regionName);
    %>
		
        <tr><td>
        <!-- ---------------------- MAIN REGION <%=regionName%>  ---------------------- -->
        <TABLE border="0" cellspacing="0" cellpadding="6"><TR><TD bgcolor="#DDDDDD" VALIGN=TOP colspan="2">
        <B>Main Region <%=regionName%></B></TD></TR>
        <TR><TD VALIGN=TOP>
	        <B>Configuration:</B><BR>
    	        <%
    	            try {
    	                    String strConfig = SAPConnectivity.getMainConfig(regionName);
    	                    if (strConfig.toLowerCase().indexOf("password") >= 0) {

    	                        int idx = strConfig.indexOf("Password:");
    	                        int idx2 = strConfig.indexOf("\n", strConfig.indexOf("Password:"));
    	                        int intPWStart = 0;
    	                        String subStr = strConfig.substring(strConfig.indexOf("Password:") + 9, idx2);

    	                        for (int ij = 0; ij < subStr.length(); ij++) {
    	                            if (subStr.charAt(ij) != ' ') {
    	                                intPWStart = ij;
    	                                break;
    	                            }
    	                        }
    	                        String strSubPW1 = strConfig.substring(0, idx);
    	                        String strSubPW3 = strConfig.substring(idx2, strConfig.length());

    	                        String strSubPW2 = "Password:";

    	                        for (int j = 0; j < intPWStart; j++) {
    	                            strSubPW2 = strSubPW2 + " ";
    	                        }

    	                        for (int k = 9; k <= subStr.length() + 2; k++) {
    	                            strSubPW2 = strSubPW2 + "*";
    	                        }
    	                        //strSubPW2 = strSubPW2 + "\r\n";
    	                        String allStr = strSubPW1 + strSubPW2 + strSubPW3;
    	                        allStr = allStr.trim();
    	        %><PRE><%
    	            out.print(allStr);
    	        %></PRE><%
    	            } else {
    	        %><PRE><%
    	            out.print(SAPConnectivity.getMainConfig(regionName));
    	        %></PRE><%
    	            }
    	                } catch (Exception ex) {
    	        %><PRE><%
    	            out.print(ex.toString());
    	        %></PRE><%
    	            }
    	        %>
        </TD>
		<TD valign=TOP>
	        <B>Pool state/usage information:</B>
			<PRE><%
			    out.print(SAPConnectivity.getMainState(regionName));
			%></PRE>
		</TD></TR>
		</TABLE>
        </td>
		<%
		    if (regionStatus == SAPConnectivity.OK)
		            out.println("<td bgcolor=\"##00FF00\" rowspan=\"2\" align=\"center\"><strong>OK</strong>");
		        else if (regionStatus == SAPConnectivity.FAILOVER)
		            out.println("<td bgcolor=\"#FFFF00\" rowspan=\"2\" align=\"center\"><strong>FAILOVER</strong>");
		        else
		            out.println("<td bgcolor=\"#FF0000\" rowspan=\"2\" align=\"center\"><strong>ERROR</strong>");
		%>
		</td></tr>

        <tr><td>
		<!-- ---------------------- FAILOVER REGION <%=regionName%>  ------------------ -->
        <TABLE border="0" cellspacing="0" cellpadding="6"><TR><TD bgcolor="#EEEEEE" VALIGN=TOP colspan="2">
        <B>Failover Region <%=regionName%> Enabled <%=regionFailoverStatus%></B></TD></TR>
        <TR><TD VALIGN=TOP>
    	    <B>Configuration:</B><B>
	        <%
	            try {
	                    String strConfig = SAPConnectivity.getFailoverConfig(regionName);
	                    if (strConfig.toLowerCase().indexOf("password") >= 0) {

	                        int idx = strConfig.indexOf("Password:");
	                        int idx2 = strConfig.indexOf("\n", strConfig.indexOf("Password:"));
	                        int intPWStart = 0;
	                        String subStr = strConfig.substring(strConfig.indexOf("Password:") + 9, idx2);

	                        for (int ii = 0; ii < subStr.length(); ii++) {
	                            if (subStr.charAt(ii) != ' ') {
	                                intPWStart = ii;
	                                break;
	                            }
	                        }
	                        String strSubPW1 = strConfig.substring(0, idx);
	                        String strSubPW3 = strConfig.substring(idx2, strConfig.length());

	                        String strSubPW2 = "Password:";
	                        for (int jj = 0; jj < intPWStart; jj++) {
	                            strSubPW2 = strSubPW2 + " ";
	                        }

	                        for (int kk = 9; kk <= subStr.length() + 2; kk++) {
	                            strSubPW2 = strSubPW2 + "*";
	                        }

	                        //strSubPW2 = strSubPW2 + "\r\n";
	                        String allStr = strSubPW1 + strSubPW2 + strSubPW3;
	                        allStr = allStr.trim();
	        %><PRE><%
	            out.print(allStr);
	        %></PRE><%
	            } else {
	        %><PRE><%
	            out.print(SAPConnectivity.getFailoverConfig(regionName));
	        %></PRE><%
	            }
	                } catch (Exception ex) {
	        %><PRE><%
	            out.print(ex.toString());
	        %></PRE><%
	            }
	        %>
	       
        </TD>
		<TD valign=TOP>
	        <B>Pool state/usage information:</B>
    	    <PRE><%
    	        out.print(SAPConnectivity.getFailoverState(regionName));
    	    %></PRE>
        </TD></TR>
        </TABLE>
		</td></tr>
	<%
	    }
	%>

<!-- Remove ASTRO2 connectivity -->
<%-- 
<!-- ----------------------
    ASTRO2 connectivity
    ---------------------- -->
<tr>
    <td valign="top">
        <b>ASTRO2 connectivity</b>        
    </td>
    <td valign="top">
          <B>Configuration:</B>
          <PRE><%
              out.print(Astro2Connectivity.getConfig());
          %></PRE>
    </td>
    
    <%
            int astro2Status = Astro2Connectivity.getAstro2Status();
            if (astro2Status == Astro2Connectivity.SUCCESS)
                out.println("<td bgcolor=\"##00FF00\" align=\"center\"><strong>OK</strong>");
            else
                out.println("<td bgcolor=\"#FF0000\" align=\"center\"><strong>ERROR</strong>");
        %>
</tr>
--%>

<!-- ----------------------
    SNR connectivity
    ---------------------- -->
<tr>
    <td valign="top">
        <b>SNR connectivity</b>        
    </td>
    <td valign="top">
          <B>Configuration:</B>
          <PRE><%
              out.print(SnrConnectivity.getConfig());
          %></PRE>
    </td>
    
    <%
            int snrStatus = SnrConnectivity.getSnrStatus();
            if (snrStatus == SnrConnectivity.SUCCESS)
                out.println("<td bgcolor=\"##00FF00\" align=\"center\"><strong>OK</strong>");
            else
                out.println("<td bgcolor=\"#FF0000\" align=\"center\"><strong>ERROR</strong>");
        %>
</tr>

<!-- ----------------------
    CVS connectivity
    ---------------------- -->
<tr>
    <td valign="top">
        <b>CVS connectivity</b>        
    </td>
    <td valign="top">
          <B>Configuration:</B>
          <PRE><%
              out.print(CVSConnectivity.getConfig());
          %></PRE>
    </td>
    <%
            int cvsStatus = CVSConnectivity.getStatus();
            if (cvsStatus == CVSConnectivity.SUCCESS)
                out.println("<td bgcolor=\"##00FF00\" align=\"center\"><strong>OK</strong></td>");
            else
                out.println("<td bgcolor=\"#FF0000\" align=\"center\"><strong>ERROR</strong></td>");
        %>
</tr>


</table>
</body>
</html>
<!--  END MAIN JSP CODE  -->

