package in.jt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ARNumberSequenceGenerator implements IdentifierGenerator {

	String prefix = "AR-";
	String arNumber = "";
	@Override
	public Serializable generate(SharedSessionContractImplementor driver, Object entity) throws HibernateException {

		try {
			Connection con = driver.connection();
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT AR_NUMBER_SEQUENCE.NEXTVAL FROM DUAL");
			resultSet.next();
			int suffix = resultSet.getInt(1);
			arNumber = prefix+suffix;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arNumber;
	}

}
