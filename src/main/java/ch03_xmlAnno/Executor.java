package ch03_xmlAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Executor {
	@Autowired
	private Worker worker;
	
	public void addUnit(WorkUnit workunit) {
		worker.work(workunit);
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

}
