package ch05_Aop;

public class OracleArticleDao implements ArticleDao{
	
	@Override
	public void insert() {
		System.out.println("OracleAritcleDao.insert() 메서드 호출");
		
	}
	
	@Override
	public String select() {
		System.out.println("OracleAriticleDao.select() 메서드 호출");
		return "홍길동의 글";
	}

}
