package com.cg.payroll.daoservices;

import java.io.File;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.cg.payroll.beans.*;
import com.cg.payroll.util.PayrollUtil;
public class AssociateDAOImpl implements AssociateDAO{
	@Override
	public Associate save(Associate associate) {
		associate.setAssociateID(PayrollUtil.getASSOCIATE_ID_COUNTER());
		PayrollUtil.associates.put(associate.getAssociateID(), associate);
		File file = new File("d:\\tanukuma_tanuj_kumar\\fromdemo.txt");
		try(ObjectOutputStream destWriter = new ObjectOutputStream(new FileOutputStream(file))){
			destWriter.writeObject(PayrollUtil.associates);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return associate;
	}
	@Override
	public boolean update(Associate associate) {
		PayrollUtil.associates.put(associate.getAssociateID(), associate);
		return true;
	}
	@Override
	public Associate findOne(int associateId) {
		return PayrollUtil.associates.get(associateId);
	}
	@Override
	public List<Associate> findAll() {
		return new ArrayList<>(PayrollUtil.associates.values());
	}

}
