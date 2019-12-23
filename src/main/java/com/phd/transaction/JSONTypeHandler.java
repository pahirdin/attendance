package com.phd.transaction;

import com.phd.utils.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author pahaied
 * @date 2019/12/4 21:36
 */
public abstract class JSONTypeHandler<T> implements TypeHandler<T> {

    /**
     * json数据和类名的分隔符号
     */
    protected Class<T> jsonClass = null;

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        // TODO Auto-generated method stub
        if (parameter == null) {
            ps.setString(i, "");
            return;
        }
        String json = JSONUtils.jsonToJSONStr(parameter);
        PGobject pGobject = new PGobject();
        pGobject.setType("json");
        pGobject.setValue(json);
//      ps.setString(i, json);
        ps.setObject(i, pGobject);
    }

    @Override
    public T getResult(ResultSet rs, String columnName) throws SQLException {
        // TODO Auto-generated method stub
        String json = rs.getString(columnName);
        return jsonToObject(json);
    }

    @Override
    public T getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        String json = cs.getString(columnIndex);
        return jsonToObject(json);
    }

    @Override
    public T getResult(ResultSet rs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        String json = rs.getString(columnIndex);
        return jsonToObject(json);
    }
    /**
     * json 转换成对象
     */
    protected T jsonToObject(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        T ob = JSONUtils.jsonStrToJSON(json, jsonClass);
        return ob;
    }
}
