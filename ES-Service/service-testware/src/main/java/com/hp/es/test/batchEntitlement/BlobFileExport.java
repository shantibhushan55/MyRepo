package com.hp.es.test.batchEntitlement;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.zip.InflaterInputStream;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BlobFileExport {
	
	private static String saveFolder = "C:/ES/HanginglBlob";
	private static String PROVIDER_URL = "t3://d9t0208g.houston.hp.com:30068";
	//DVL : t3://d9t0208g.houston.hp.com:30068
	//PRODCUTION: t3://g1u0816c.austin.hp.com:30052
	//ITG: t3://g5u0301c.atlanta.hp.com:30054
	
	private static String Context_INITIAL_CONTEXT_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	private static String Context_JNDI_Name = "jdbc.writableMultiDS";
	
	
	public static void main(String[] args) {
		String querySQL = "select *"
				+ " from BATCH_REQUEST "
				+ " where BR_REQUEST_ID ="
				+ " (select min(BR_REQUEST_ID)"
				+ " from BATCH_REQUEST br2"
				+ " where (br2.BR_STATUS in ('waitForResend', 'processed', 'sending') or"
				+ " (br2.BR_STATUS = 'processing' and" + " (select count(*)"
				+ " from BATCH_SUB_REQUEST"
				+ " where BSR_REQUEST_ID = BR_REQUEST_ID"
				+ " and BSR_STATUS in ('new', 'processing')) = 0))"
				+ " and (br2.BR_EMAIL_NEXT_SEND_TIME IS NULL or"
				+ " br2.BR_EMAIL_NEXT_SEND_TIME < sysdate))";
		
//get hanging blob which set to status false by last baseline support
/*		String failedSQL = "select * from BATCH_REQUEST " +
				"where BR_REQUEST_ID = (select min(BR_REQUEST_ID) from BATCH_REQUEST br2 " +
				"where br2.br_status='failed' and br2.br_finish_date is null and br2.br_email_next_send_time is null)";*/
		System.out.println("querySQL:"+querySQL);
		if (saveFolder != null && !"".equals(saveFolder)) {
			new BlobFileExport().getMessage(saveFolder, querySQL);
		}
	}

	/**
	 * read blob from database
	 */
	public void getMessage(String directory, String querySQL) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = getWritableConnection();
			st = con.createStatement();
			rs = st.executeQuery(querySQL);
			File folder = new File(directory);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			while (rs.next()) {
				Integer requestId = (Integer) rs.getInt("br_request_id");
				System.out.println("requestId:"+requestId);
				InputStream brRequest = rs.getBinaryStream("br_request");
				File file = new File(folder, requestId + ".csv");
				OutputStream os = new FileOutputStream(file);		
				InflaterInputStream iis = new InflaterInputStream(
						new BufferedInputStream(brRequest));
				copyInputToOutput(iis, os);
				os.flush();
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * copyInputToOutput copied (copied from DbCdo)
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	private static void copyInputToOutput(InputStream in, OutputStream out)
			throws IOException {
		byte[] buffer = new byte[1024];
		int amount;

		while ((amount = in.read(buffer)) >= 0) {
			out.write(buffer, 0, amount);
		}
	}

	/**
	 * Gets a Local Writable Connection object which can be used to access the
	 * database.
	 */
	private Connection getWritableConnection() {
		Connection con = null;
		String jndiName = Context_JNDI_Name;
		try {
			Hashtable<String, String> ht = new Hashtable<String, String>();
			ht.put(Context.INITIAL_CONTEXT_FACTORY,Context_INITIAL_CONTEXT_FACTORY);
			ht.put(Context.PROVIDER_URL, PROVIDER_URL);
			Context ctx = new InitialContext(ht);
			DataSource ds = (DataSource) (ctx.lookup(jndiName));
			con = ds.getConnection();
			con.setReadOnly(false);
			con.setAutoCommit(false);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return con;
	}
}


