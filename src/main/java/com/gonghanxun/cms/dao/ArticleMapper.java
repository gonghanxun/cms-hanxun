package com.gonghanxun.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gonghanxun.cms.entity.Article;
import com.gonghanxun.cms.entity.Category;
import com.gonghanxun.cms.entity.Channel;
import com.gonghanxun.cms.entity.Comment;

public interface ArticleMapper {

	/**
	 * 根据用户获取文章的列表
	 * @param id
	 * @return
	 */
	
	List<Article> listByUser(Integer id);

	@Update("UPDATE cms_article SET deleted=#{status} WHERE id=#{id}")
	int updateStatus(@Param("id")int id, @Param("status") int status);

	/**
	 * 获取所有栏目的方法
	 * @return
	 */
	@Select("SELECT id,name FROM cms_channel")
	List<Channel> getAllChannels();
	

	/**
	 * 根据栏目id 获取分类
	 * @cid  ： 栏目的id
	 * @return
	 */
	@Select("SELECT id,name FROM cms_category WHERE channel_id = #{value}")
	List<Category> getCategorisByCid(int cid);

	
	@Insert("INSERT INTO cms_article(title,content,picture,channel_id,category_id,user_id,hits,hot,status,deleted,created,updated,commentCnt,articleType)"
			+ " VALUES(#{title},#{content},#{picture},#{channelId},#{categoryId},#{userId},0,0,0,0,now(),now(),0,#{articleType})")
	int add(Article article);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Article findById(int id);
	
	@Update("UPDATE cms_article SET title=#{title},content=#{content},picture=#{picture},channel_id=#{channelId},"
			+ " category_id=#{categoryId},status=0,"
			+ "updated=now() WHERE id=#{id} ")
	int update(Article article);

	/**
	 * 文章列表
	 * @param status  文章状态
	 */
	List<Article> list(int status);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT id,title,channel_id channelId , category_id categoryId,status ,hot "
			+ " FROM cms_article WHERE id = #{value} ")
	Article getInfoById(int id);

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@Update("UPDATE cms_article SET hot=#{hot} WHERE id=#{myid}")
	int setHot(@Param("myid") int id, @Param("hot") int status);

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@Update("UPDATE cms_article SET status=#{myStatus} WHERE id=#{myid}")
	int CheckStatus(@Param("myid") int id, @Param("myStatus") int status);

	
	List<Article> hostList();

	List<Article> lastList(int pageSize);

	/**
	 * 根据分类和栏目获取文章
	 * @param channleId
	 * @param catId
	 * @return
	 */
	List<Article> getArticles(@Param("channelId")  int channleId, @Param("catId") int catId);

	/**
	 * 
	 * @param channleId
	 * @return
	 */
	@Select("SELECT id,name FROM cms_category where channel_id=#{value}")
	@ResultType(Category.class)
	List<Category> getCategoriesByChannelId(int channleId);

	@Insert("INSERT INTO cms_comment(articleId,userId,content,created)"
			+ " VALUES(#{articleId},#{userId},#{content},NOW())")
	int addComment(Comment comment);
	
	/**
	 * 增加文章的评论数量
	 * @param id
	 * @return
	 */
	@Update("UPDATE cms_article SET commentCnt=commentCnt+1 WHERE id=#{value}")
	int increaseCommentCnt(int id);

	/**
	 * 
	 * @param articleId
	 * @return
	 */
	@Select("SELECT c.id,c.articleId,c.userId,u.username as userName,c.content,c.created FROM cms_comment as c "
			+ " LEFT JOIN cms_user as u ON u.id=c.userId "
			+ " WHERE articleId=#{value} ORDER BY c.created DESC")
	List<Comment> getComments(int articleId);
	
	
	
}
