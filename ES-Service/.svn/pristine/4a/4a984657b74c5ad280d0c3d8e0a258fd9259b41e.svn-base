package com.hp.es.service.batchEntitlement.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.hp.es.service.db.DbConnectionManager;
import com.hp.ruc.db.BlobUtils;

public class BatchRequestUploadTest {
    private static final String INSERT_STATEMENT = "begin INSERT INTO BATCH_REQUEST"
            + "(BR_INCLUDE_CONTRACTS, BR_INCLUDE_OFFERS, BR_USER_FIRST_NAME, "
            + "BR_USER_LAST_NAME, BR_USER_EMAIL, BR_FILE_NAME, BR_REQUEST) " + "VALUES (?, ?, ?, ?, ?, ?, empty_blob()) "
            + "RETURNING BR_REQUEST_ID, BR_REQUEST INTO ?, ?; end;";

    public static void main(String[] args) {
        BatchRequestUploadTest.upload();
    }
    public static void upload() {
        byte[] fileBytes;
        try {
            fileBytes = readFile("C:/home/entitlem/st/trunk/service/test/functional/batch/batch6_tm_capture.csv");
            insertIntoDB(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream is = new FileInputStream(file);
        long length = file.length();
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        is.close();
        return bytes;
    }

    private static void insertIntoDB(byte[] fileBytes) throws Exception {

        Connection conn = null;
        CallableStatement cs = null;
        @SuppressWarnings("unused")
		ResultSet rs = null;
        try {
            conn = DbConnectionManager.getInstance().getWritableConnection();
            conn.setAutoCommit(false);
            // Prepare the insert statement
            cs = conn.prepareCall(INSERT_STATEMENT);
            // Set the parameters to the prepared statement

            cs.setString(1, "N");
            cs.setString(2, "N");
            cs.setString(3, "Chunyang");
            cs.setString(4, "Wang");
            cs.setString(5, "chun-yang.wang@hp.com");
            cs.setString(6, "batch6_tm_capture.csv");
            cs.registerOutParameter(7, Types.INTEGER);
            cs.registerOutParameter(8, Types.BLOB);
            // Execute the insert statement and fetch the seq back
            cs.execute();
            Blob blob = cs.getBlob(8);
            BlobUtils.writeCompressedBlob(blob, fileBytes);
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
            throw ex;
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                // conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
}
