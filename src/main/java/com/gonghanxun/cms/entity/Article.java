package com.gonghanxun.cms.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 
 * @author hanxun
 *
 */
//制定索引库的名字和类型（表），注意，库名表明不能用大写，否则报错
@Document(indexName="cms_articles",type="article")
public class Article implements Serializable{
	@Id
	private Integer id              ;
	//  1.数据的分词方式是ik 2.是否建立索引   3.是否存储      4.搜索关键字的分词方式是ik       5.字段类型是text  
	@Field(analyzer="ik_smart",index=true,store=true,searchAnalyzer="ik_smart",type=FieldType.text)
	private String title           ;//标题
	@Field(analyzer="ik_smart",index=true,store=true,searchAnalyzer="ik_smart",type=FieldType.text)
	private String content         ;//文章的内容
	private String picture         ;//图片的url
	private int channelId      ;//栏目 频道
	private int categoryId     ; //分类
	private int userId         ;
	private int hits            ; //点击数量
	private int hot             ;//是否热门
	private int status          ;//文章的状态  0 ，待审核    1 审核通过   2 拒绝 
	private int deleted         ; // 是否被删除
	private Date created         ; //创建时间
	private Date updated         ;// 最后的修改时间
	private int commentCnt      ; // 评论数量
	private int articleType     ; // 文章的类型 文字0     图片  1  
	
	private Channel channel      ;//栏目 频道
	private Category  category     ; //分类
	private User user ;
	
	private int complainCnt;// 投诉的数量
	
	public int getComplainCnt() {
		return complainCnt;
	}

	public void setComplainCnt(int complainCnt) {
		this.complainCnt = complainCnt;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getArticleType() {
		return articleType;
	}
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", picture=" + picture
				+ ", channelId=" + channelId + ", categoryId=" + categoryId + ", userId=" + userId + ", hits=" + hits
				+ ", hot=" + hot + ", status=" + status + ", deleted=" + deleted + ", created=" + created + ", updated="
				+ updated + ", commentCnt=" + commentCnt + ", articleType=" + articleType + ", channel=" + channel
				+ ", category=" + category + ", user=" + user + ", complainCnt=" + complainCnt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
