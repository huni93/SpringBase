package ch05_Aop;

public class WriteImpl {
private ArticleDao articleDao;
public WriteImpl(ArticleDao articleDao) {
	this.articleDao = articleDao;
}
public void write() {
	System.out.println("writeImpi.write() 메서드 호출됨");
	articleDao.insert();
}
}
