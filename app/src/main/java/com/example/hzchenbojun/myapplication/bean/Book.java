package com.example.hzchenbojun.myapplication.bean;

/**
 * Created by hzchenbojun on 2016/3/9.
 */


        import java.util.ArrayList;
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("author")
    @Expose
    private List<String> author = new ArrayList<String>();
    @SerializedName("pubdate")
    @Expose
    private String pubdate;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("origin_title")
    @Expose
    private String originTitle;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("binding")
    @Expose
    private String binding;
    @SerializedName("translator")
    @Expose
    private List<String> translator = new ArrayList<String>();
    @SerializedName("catalog")
    @Expose
    private String catalog;
    @SerializedName("pages")
    @Expose
    private String pages;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("isbn10")
    @Expose
    private String isbn10;
    @SerializedName("isbn13")
    @Expose
    private String isbn13;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("alt_title")
    @Expose
    private String altTitle;
    @SerializedName("author_intro")
    @Expose
    private String authorIntro;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("price")
    @Expose
    private String price;

    /**
     *
     * @return
     * The rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     *
     * @param subtitle
     * The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     *
     * @return
     * The author
     */
    public List<String> getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(List<String> author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The pubdate
     */
    public String getPubdate() {
        return pubdate;
    }

    /**
     *
     * @param pubdate
     * The pubdate
     */
    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    /**
     *
     * @return
     * The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     * The originTitle
     */
    public String getOriginTitle() {
        return originTitle;
    }

    /**
     *
     * @param originTitle
     * The origin_title
     */
    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     * The binding
     */
    public String getBinding() {
        return binding;
    }

    /**
     *
     * @param binding
     * The binding
     */
    public void setBinding(String binding) {
        this.binding = binding;
    }

    /**
     *
     * @return
     * The translator
     */
    public List<String> getTranslator() {
        return translator;
    }

    /**
     *
     * @param translator
     * The translator
     */
    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    /**
     *
     * @return
     * The catalog
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     *
     * @param catalog
     * The catalog
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    /**
     *
     * @return
     * The pages
     */
    public String getPages() {
        return pages;
    }

    /**
     *
     * @param pages
     * The pages
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     * The images
     */
    public Images getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     *
     * @return
     * The alt
     */
    public String getAlt() {
        return alt;
    }

    /**
     *
     * @param alt
     * The alt
     */
    public void setAlt(String alt) {
        this.alt = alt;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher
     * The publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return
     * The isbn10
     */
    public String getIsbn10() {
        return isbn10;
    }

    /**
     *
     * @param isbn10
     * The isbn10
     */
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    /**
     *
     * @return
     * The isbn13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     *
     * @param isbn13
     * The isbn13
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The altTitle
     */
    public String getAltTitle() {
        return altTitle;
    }

    /**
     *
     * @param altTitle
     * The alt_title
     */
    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
    }

    /**
     *
     * @return
     * The authorIntro
     */
    public String getAuthorIntro() {
        return authorIntro;
    }

    /**
     *
     * @param authorIntro
     * The author_intro
     */
    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    /**
     *
     * @return
     * The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     *
     * @param summary
     * The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     *
     * @return
     * The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

}




