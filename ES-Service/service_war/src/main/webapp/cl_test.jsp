<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ClassLoader TEST</title>
</head>
<body>

<%
   final int NUM = 3;

   String pfilename = request.getParameter("PROP_FILENAME");
   if (pfilename == null || "".equals(pfilename)) pfilename = "test.properties";
   
   ClassLoader[] cl   = new ClassLoader[NUM];
   String[] cname     = new String[NUM];
   String[] detail    = new String[NUM];
   java.net.URL[] url = new java.net.URL[NUM];
   String[] fpath     = new String[NUM];
   String[] eform     = new String[NUM];
   String[] content   = new String[NUM];
   
   cl[0] = this.getClass().getClassLoader();
   cl[1] = Thread.currentThread().getContextClassLoader();
   cl[2] = ClassLoader.getSystemClassLoader();

   for (int i=0; i<NUM; i++) {
	   cname[i] = cl[i].getClass().getName();
	   detail[i] = cl[i].toString();
	   content[i] = "";
	   
	   try {
		   fpath[i] = null;
		   eform[i] = null;
		   url[i] = cl[i].getResource(pfilename);
		   if (url[i] != null) {
			   fpath[i] = url[i].getFile(); 
			   eform[i] = url[i].toExternalForm();
		   }
		   
	   } catch (Exception ex) {		   
		   content[i] = content[i] + "<BR>EXCEPTION (1): <BR>" + ex.toString();
	   }

	   try {
	       java.io.InputStream is = cl[i].getResourceAsStream(pfilename);
		   java.util.Properties props = new java.util.Properties();
	       StringBuffer b = new StringBuffer();
		   props.load(is);
	       java.util.Enumeration keys = props.keys();
	       while (keys.hasMoreElements()) {
	    	   String key = (String)keys.nextElement();
               b.append(key);
               b.append("=");
               b.append(props.getProperty(key));
               b.append("<BR>");
	       }
	       content[i] = b.toString();
	   } catch (Exception ex) {		   
		   content[i] = content[i] + "<BR>EXCEPTION (2): <BR>" + ex.toString();
	   }

   }
%>

<FORM>
Prop file name <input type="text" name="PROP_FILENAME"> <input type="SUBMIT" value="Go">
</FORM>
<HR>
Filename used: <B><%= pfilename %></B>
<HR>
<TABLE border="1" style="width:100%">

  <TR> 
    <TH style="width:10%">ClassLoader:</TH>
    <TH style="width:30%">this</TH>
    <TH style="width:30%">context</TH>
    <TH style="width:30%">system</TH>
  </TR>

  <TR> 
    <TD>Type</TD>
    <TD><%= cname[0] %></TD> 
    <TD><%= cname[1] %></TD> 
    <TD><%= cname[2] %></TD> 
  </TR>

  <TR> 
    <TD>ID</TD>
    <TD><%= detail[0] %></TD> 
    <TD><%= detail[1] %></TD> 
    <TD><%= detail[2] %></TD> 
  </TR>

  <TR> 
    <TD>File path</TD>
    <TD><%= fpath[0] %></TD> 
    <TD><%= fpath[1] %></TD> 
    <TD><%= fpath[2] %></TD> 
  </TR>

  <TR> 
    <TD>Ext form</TD>
    <TD><%= eform[0] %></TD> 
    <TD><%= eform[1] %></TD> 
    <TD><%= eform[2] %></TD> 
  </TR>

  <TR> 
    <TD>Content</TD>
    <TD><%= content[0] %></TD> 
    <TD><%= content[1] %></TD> 
    <TD><%= content[2] %></TD> 
  </TR>

</TABLE>
</body>
</html>



