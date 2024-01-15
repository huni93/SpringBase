package ch05_Aop;

public class ReadImpl {
	private ArticleDao dao;
	public ReadImpl(ArticleDao dao) {
		this.dao = dao;
	}
	public String read() {
		System.out.println("ReadImpl.read 메서드 요청");
		return dao.select();
	}

}
