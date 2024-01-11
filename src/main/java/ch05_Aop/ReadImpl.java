package ch05_Aop;

public class ReadImpl {
	private ArticleDao dao;
	public ReadImpl(ArticleDao dao) {
		this.dao = dao;
	}
	public String read() {
		System.out.println("ReadImpi.read 메서드 호출됨");
		return dao.select();
	}
}
