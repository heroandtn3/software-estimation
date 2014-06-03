package vn.hust.se.client;

import java.util.List;

import vn.hust.se.shared.model.Phase;
import vn.hust.se.shared.model.Project;

public class AppUtils {
	
	public void calculate(Project project) {
		// calculate per phase
		int size = project.getPhases().size();
		for (int i = 0; i < size; i++) {
			calculate(project.getPhases().get(i), i);
		}
		
		// calculate total from phases
		float totalRevenue = 0;
		float totalPay = 0;
		float totalFv = 0;
		float totalPv = 0;
		for (Phase phase : project.getPhases()) {
			totalRevenue += phase.getRevenue();
			totalPay += phase.getPay();
			totalFv += phase.getFv();
			totalPv += phase.getPv();
		}
		project.setTotalRevenue(totalRevenue);
		project.setTotalPay(totalPay);
		project.setTotalFv(totalFv);
		project.setTotalPv(totalPv);
		project.setTotalRoi(calTotalRoi(project));
		
		// calculate other values
		if (size > 0) {
			//project.setIrr(calIrr(project));
		}
		project.setNpv(calNpv(project));
		project.setTienLaiTichLuy(calTienLaiTichLuy(project));
		if (size > 0) {
			project.setTimeHoanVon(calTimeHoanVon(project));
		}
	}

	private float calTotalRoi(Project project) {
		float ret = 0;
		float fwValue = project.getTotalFv();
		if (project.getTotalPay() != 0) {
			ret = Math.abs(fwValue) / Math.abs(project.getTotalPay());
		}
		
		return ret;
	}

	private void calculate(Phase phase, int i) {
		// tinh cac gia tri cua tung phase tai day
		float fv = phase.getRevenue() + phase.getPay();
		phase.setFv(fv);
		float roi = phase.getFv();
		phase.setRoi(roi);
		
		float r = phase.getR();
		float pv = (float) (fv / Math.pow((1+ r), i)); //Ci / (1+r)^i
		phase.setPv(pv);
		
	}

	private float calTienLaiTichLuy(Project project) {
		float ret = 0;
		ret = project.getTotalRevenue()+project.getTotalPay();
		return ret;
	}

	private float calTimeHoanVon(Project project) {
		float ret = 0;
		float lai = 0;
		List<Phase> phases = project.getPhases();
		lai = phases.get(0).getFv();
		if (lai > 0)
			return 0;
		for (int i = 1; i < phases.size(); i++){
			lai += phases.get(i).getFv();
			if (lai > 0){
				lai = lai - phases.get(i).getFv();
				ret = i + lai / phases.get(i).getFv();
				return ret;
			}
			
		}
		return ret;
	}

	private float calNpv(Project project) {
		float ret = 0;
		ret = project.getTotalPv(); // NPV = PV
		return ret;
	}

	private float calIrr(Project project) {
		float ret = 0;
		List<Phase> phases = project.getPhases();
		float irr = 0;
		float lirr = 0;
		float min = Math.abs(phases.get(0).getFv());
		float tong = 0;
		while (irr < 1){
			tong  = 0;
			for (int i = 0; i < phases.size(); i++){
				float ci = phases.get(i).getFv();
				tong += ci / Math.pow((1+ irr), i); //Ci / (1+r)^i
			}
			if (tong < min){ // cap nhap lai gia tri min
				min = tong;
				lirr = irr;
			}
		}
		//voi gia tri lirr tot nhat de irr gan bang 0
		ret = lirr;
		return ret;
	}

}
