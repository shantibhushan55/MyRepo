<!-- $Header: /ENTITLEMENT/src/jsp/hpse/es_instance_info.jsp 1.8 2004-05-08 04:35:26+02 entitlem Exp $ -->
<!-- BEGIN MAIN JSP CODE  -->
<%-- ES instance information page  --%>
<%-- This .jsp is meant to show various details about the instance of ES and its hosting JVM. --%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.hp.ruc.util.*" %>
<%@ page import="com.hp.ruc.config.*" %>
<%@ page import="com.hp.es.constants.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.hp.es.service.util.*" %>

<html>
<head>
	<title>ES instance information</title>
	<meta name="robots" content="nofollow">
</head>


<body>
<%
    String buildInfo ="Unknown";
    try {
	     ConfigFactory cf = ConfigFactory.getInstance();
	     ReadOnlyProperties props = cf.getConfig("com/hp/es/service/version.properties");
	     buildInfo = props.getProperty("es.release.build.info", buildInfo);
	  } catch (Exception ex) {
        buildInfo=ex.toString();
	  }
%>
<p><h2>Congratulations!  You have reached an instance of Entitlement Service web services.</h2>

<p><td valign=top colspan ="2">
<p>Build information         : <strong><%= buildInfo %></strong>
<br>The current date & time is: <strong><%=new java.util.Date()%></strong>


<p>The deployed wardir is (supported only in ES lab deployments):
<br><strong>_DEPLOY_HPSE_WARDIR_</strong>
<p>
<a href="es_plumbing_test.jsp"><strong>Click here to do a plumbing test</strong></a>
<p>
<a href="LoadBalancerHealthCheck"><strong>Click here to see the load balancer health check page</strong></a>

<p><table border="1" cellspacing="0" cellpading="0">

<!-- properties  -->

<tr>
	<td valign="top"><B>Formatted path properties </b></td>

	<td>
	<%
		String propertyReport = "";

		String        cpBefore = System.getProperty("java.class.path","property java.class.path not defined");
		String		    cpAfter  = "<b>java.class.path=</b><br>\n";
		StringTokenizer cpst = new StringTokenizer(cpBefore, System.getProperty("path.separator"));
		while (cpst.hasMoreTokens()) {
			cpAfter = cpAfter + cpst.nextToken() + "<br>\n";
		}

		String        lpBefore = System.getProperty("java.library.path","property java.library.path not defined");
		String		    lpAfter  = "<b>java.library.path=</b><br>\n";
		StringTokenizer lpst = new StringTokenizer(lpBefore, System.getProperty("path.separator"));
		while (lpst.hasMoreTokens()) {
			lpAfter = lpAfter + lpst.nextToken() + "<br>\n";
		}

		propertyReport = cpAfter + "<br>\n" + lpAfter;
	%>
	<p>
	<%=propertyReport%>
	</td>

</tr>

<tr>
	<td valign="top"><B>Sorted System.properties </b></td>

	<td>
	<%
		propertyReport = "";
		TreeSet ts = new TreeSet();		// used to build a sorted list of keys

		for (Enumeration e = System.getProperties().propertyNames() ; e.hasMoreElements() ;)
			ts.add(e.nextElement());

		Iterator i = ts.iterator();
		String key = null;
        while (i.hasNext()) {
			key = (String)i.next();
			propertyReport+="<b>"+key+"=</b> ";

			// if property name includes 'password' then mask it
			if (key.toLowerCase().indexOf("password") >= 0)
				propertyReport+="**********";
			else
				propertyReport+=System.getProperty(key);

			propertyReport+="<br>\n";
        }
	%>
	<p>
	<%=propertyReport%>
	</td>

</tr>

<tr>
	<td valign="top"><b>Sorted ES application properties </b></td>

	<td>
	<%
		propertyReport = "";
		ts = new TreeSet();		// used to build a sorted list of keys

		for (Enumeration e = Configuration.getInstance().getProperties().propertyNames() ; e.hasMoreElements() ;)
			ts.add(e.nextElement());

		i = ts.iterator();
		key = "";
        while (i.hasNext()) {
			key = (String)i.next();
			propertyReport+="<b>"+key+"=</b> ";

			// if property name includes 'password' then mask it
			if (key.toLowerCase().indexOf("password") >= 0)
				propertyReport+="**********";
			else
				propertyReport+=Configuration.getInstance().getProperties().getProperty(key);

			propertyReport+="<br>\n";
        }
	%>
	<%=propertyReport%>
	</td>
</tr>

<tr>
	<td valign="top"><b>Sorted ES db properties </b></td>

	<td>
	<%
		propertyReport = "";
		ts = new TreeSet();		// used to build a sorted list of keys

		for (Enumeration e = com.hp.ruc.config.ConfigFactory.getInstance().getConfig(EsConstants.DB_PROPERTIES_FILENAME).propertyNames(); e.hasMoreElements(); )
			ts.add(e.nextElement());

		i = ts.iterator();
		key = "";
        while (i.hasNext()) {
			key = (String)i.next();
			propertyReport+="<b>"+key+"=</b> ";

			// if property name includes 'password' then mask it
			if (key.toLowerCase().indexOf("password") >= 0)
				propertyReport+="**********";
			else
				propertyReport+=com.hp.ruc.config.ConfigFactory.getInstance().getConfig(EsConstants.DB_PROPERTIES_FILENAME).getProperty(key);

			propertyReport+="<br>\n";
        }
	%>
	<%=propertyReport%>
	</td>
</tr>


</table>
</body>
</html>
<!--  END MAIN JSP CODE  -->

