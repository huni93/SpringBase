package ch06_Aop;

public interface ArticleDao {
	void insert(Article article);
	void updateReadCount(int id, int i);

}
