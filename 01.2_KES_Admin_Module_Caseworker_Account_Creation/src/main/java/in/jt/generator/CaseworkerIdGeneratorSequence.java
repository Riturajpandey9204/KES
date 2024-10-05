package in.jt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CaseworkerIdGeneratorSequence implements IdentifierGenerator {
	String prefix="CW";
	
	String center="_KES_";
	
	String uniqueId="";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor obj1, Object obj2) throws HibernateException {
		System.out.println("************"+obj1+"  >>>  "+obj2);
		
		
		try {
			Connection connection = obj1.connection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT CASE_WORKERS_IDS_SEQUENCE.NEXTVAL FROM DUAL");
			resultSet.next();
			int suffix = resultSet.getInt(1); //CW_KES_1001
			uniqueId=prefix+center+suffix;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return uniqueId;
	}

}
