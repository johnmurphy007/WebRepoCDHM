package ie.cit.group3.utility;

import ie.cit.group3.domain.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
/**
 * @author John Murphy
 * Student ID: R00131347
 * Date: 	31 March 2015
 * 
 * This class provides the mapping from a SQL resultset to an object. It returns the populated object when complete. 
 * The SQL table attributes are extracted using the rs.getString(<table attribute name here>)
 * 
 * In this case the object is a Role
 */
public class RolesRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int index) throws SQLException {
		
		Role role = new Role();
		
		role.setRole_display_name(rs.getString("role_display_name"));
		role.setRole_id(rs.getString("role_id"));
		role.setRole_name(rs.getString("role_name"));
		role.setRole_url(rs.getString("role_url"));
		
		return role;
	}
}
