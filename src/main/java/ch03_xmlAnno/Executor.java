package ch03_xmlAnno;

public class Executor {
	
	private Worker worker;
	
	public void addUnit(WorkUnit workunit) {
		worker.work(workunit);
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

}
