package oracle.jdbc;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import oracle.jdbc.dcn.DatabaseChangeRegistration;

/**
 * A mocking class used as a placeholder for the real Oracle JDBC drivers to prevent build errors.
 */
public class OracleConnection implements Connection {

    public static String DCN_NOTIFY_ROWIDS;
    public static String DCN_QUERY_CHANGE_NOTIFICATION;

    @Override
    public <T> T unwrap(Class<T> iface) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) {
        //  Auto-generated method stub
        return false;
    }

    @Override
    public Statement createStatement() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public String nativeSQL(String sql) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void setAutoCommit(boolean autoCommit) {
        //  Auto-generated method stub

    }

    @Override
    public boolean getAutoCommit() {
        //  Auto-generated method stub
        return false;
    }

    @Override
    public void commit() {
        //  Auto-generated method stub

    }

    @Override
    public void rollback() {
        //  Auto-generated method stub

    }

    @Override
    public void close() {
        //  Auto-generated method stub

    }

    @Override
    public boolean isClosed() {
        //  Auto-generated method stub
        return false;
    }

    @Override
    public DatabaseMetaData getMetaData() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        //  Auto-generated method stub

    }

    @Override
    public boolean isReadOnly() {
        //  Auto-generated method stub
        return false;
    }

    @Override
    public void setCatalog(String catalog) {
        //  Auto-generated method stub

    }

    @Override
    public String getCatalog() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void setTransactionIsolation(int level) {
        //  Auto-generated method stub

    }

    @Override
    public int getTransactionIsolation() {
        //  Auto-generated method stub
        return 0;
    }

    @Override
    public SQLWarning getWarnings() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void clearWarnings() {
        //  Auto-generated method stub

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) {
        //  Auto-generated method stub

    }

    @Override
    public void setHoldability(int holdability) {
        //  Auto-generated method stub

    }

    @Override
    public int getHoldability() {
        //  Auto-generated method stub
        return 0;
    }

    @Override
    public Savepoint setSavepoint() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public Savepoint setSavepoint(String name) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void rollback(Savepoint savepoint) {
        //  Auto-generated method stub

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) {
        //  Auto-generated method stub

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public Clob createClob() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public Blob createBlob() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public NClob createNClob() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public SQLXML createSQLXML() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public boolean isValid(int timeout) {
        //  Auto-generated method stub
        return false;
    }

    @Override
    public void setClientInfo(String name, String value) {
        //  Auto-generated method stub

    }

    @Override
    public void setClientInfo(Properties properties) {
        //  Auto-generated method stub

    }

    @Override
    public String getClientInfo(String name) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public Properties getClientInfo() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void setSchema(String schema) {
        //  Auto-generated method stub

    }

    @Override
    public String getSchema() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    public void abort(Executor executor) {
        //  Auto-generated method stub

    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) {
        //  Auto-generated method stub

    }

    @Override
    public int getNetworkTimeout() {
        //  Auto-generated method stub
        return 0;
    }

    public DatabaseChangeRegistration registerDatabaseChangeNotification(@SuppressWarnings("unused") Properties properties) {
        return new DatabaseChangeRegistration();
    }

    public void unregisterDatabaseChangeNotification(@SuppressWarnings("unused") DatabaseChangeRegistration databaseChangeRegistration) {
        // do nothing
    }
}
