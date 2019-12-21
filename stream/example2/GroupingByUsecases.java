package stream.example2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByUsecases {
	public static void main(String[] args) {
		List<BlogPost> posts = Arrays.asList(new BlogPost("Java","Ayan",BlogPostType.REVIEW, 67),
											new BlogPost("Scala","Ayan",BlogPostType.REVIEW, 76),
											new BlogPost("Modi","Abhishek",BlogPostType.NEWS, 100),
											new BlogPost("Himalaya","Debarati",BlogPostType.GUIDE, 100),
											new BlogPost("DehraDun","Debarati",BlogPostType.GUIDE, 132));
		
		//single classification function. similar to groupBy blogType
		Map<BlogPostType, List<BlogPost>> groupByBlogPostType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType));
		System.out.println(groupByBlogPostType);
		
		//single classification function. similar to groupBy blogType and author
		Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
				  .collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
		System.out.println(postsPerTypeAndAuthor);
		
		//change returned map type to set. This is one application of downstream collector
		Map<BlogPostType, Set<BlogPost>> postsPerType = posts.stream()
				  .collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));
		System.out.println(postsPerType);
		
		//Another application of downstream collector is to used secondary grouping
		Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream()
				  .collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));
		System.out.println(map);
		
		Map<BlogPostType, String> postsPerType2 = posts.stream()
				  .collect(Collectors.groupingBy(BlogPost::getType, 
				  Collectors.mapping(BlogPost::getTitle, Collectors.joining(", ", "Post titles: [", "]"))));
		System.out.println(postsPerType2);
		
		
		
		
	}
}


class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;
	public BlogPost(String title, String author, BlogPostType type, int likes) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.likes = likes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BlogPostType getType() {
		return type;
	}
	public void setType(BlogPostType type) {
		this.type = type;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "BlogPost [title=" + title + ", author=" + author + ", type=" + type + ", likes=" + likes + "]";
	}
	
	
    
}

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}


class Tuple {
    BlogPostType type;
    String author;
	public Tuple(BlogPostType type, String author) {
		super();
		this.type = type;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Tuple [type=" + type + ", author=" + author + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Tuple other = (Tuple) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}