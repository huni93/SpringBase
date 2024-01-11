package ch06_Aop;

public interface ReadArticleService {
 Article getArticleAndReadCnt(int id) throws ArticleNotFoundException;
}
